/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mygame;

import com.jme3.asset.AssetManager;
import com.jme3.material.Material;
import com.jme3.math.ColorRGBA;
import com.jme3.math.FastMath;
import com.jme3.scene.Geometry;
import com.jme3.scene.Node;
import com.jme3.scene.shape.Box;
/**
 *
 * @author seventhflame
 */
public class ZeeschipPlatform extends Node {
    
    private final AssetManager assetManager;
    
    Node zeeschipNode;
    Node zeeschipPlatformNode;
    private float breedteContainerPlaatsen = 16*Container.containerBreedte; // A = opslag voor containers op het zeeschip
    private float lengteContainerPlaatsen = 20*Container.containerLengte;    
    private float breedteZeeschipPlatform = 4f; // B = complete platform zonder schip
    private float lengteZeeschipPlatform = 70.4f;
       
    
    // 3d array om de container objecten in op te slaan
    Container[][][] containerOpslag = new Container[20][6][16];
    
    public ZeeschipPlatform(AssetManager manager)
    {
        this.assetManager = manager;
        
        zeeschipNode = new Node("zeeschip");
        zeeschipPlatformNode = new Node("zeeschipPlatform");
        zeeschipPlatformNode.attachChild(zeeschipNode);
        zeeschipNode.setLocalTranslation(-(breedteContainerPlaatsen + breedteZeeschipPlatform), 0, 0);
        zeeschipPlatformNode.setLocalTranslation(-breedteZeeschipPlatform, 0, 0);
        // A zeeschip containeropslag
        Box A = new Box(breedteContainerPlaatsen,0,lengteContainerPlaatsen);
        // B complete strook 
        Box B = new Box(breedteZeeschipPlatform,0,lengteZeeschipPlatform);
        Geometry zeeschipOpslag = new Geometry("ZeeschipOpslag", A); 
        Geometry zeeschipPlatform = new Geometry("zeeschipPlatform", B);
        Material matA = new Material(assetManager, "Common/MatDefs/Misc/Unshaded.j3md");
        matA.setColor("Color", ColorRGBA.Orange);
        Material matB = new Material(assetManager, "Common/MatDefs/Misc/Unshaded.j3md");
        matB.setColor("Color", ColorRGBA.Brown);
        zeeschipOpslag.setMaterial(matA);
        zeeschipPlatform.setMaterial(matB);
        zeeschipPlatformNode.attachChild(zeeschipPlatform);
        zeeschipNode.attachChild(zeeschipOpslag);
        
        ZeeschipKraan[] zeeschipKranen = new ZeeschipKraan[10];     //zeeschipkranen aanmaken op het platform
        
        for (int i = 0; i < zeeschipKranen.length; i++){
            zeeschipKranen[i] = new ZeeschipKraan(assetManager);
            zeeschipPlatformNode.attachChild(zeeschipKranen[i]);  
            zeeschipKranen[i].setLocalTranslation(-breedteZeeschipPlatform/2, 2.5f, -lengteZeeschipPlatform/2 + i * (lengteZeeschipPlatform/10 +1.6f));      //zeeschipkranen positioneren op het platform
        }
        
        for (int x = 0; x < 20; x++) {
            for (int y = 0; y < 6; y++) {
                for (int z = 0; z < 16; z++) {
                    containerOpslag[x][y][z] = null;                       
                } 
            }
        }
        rotate(0,FastMath.HALF_PI, 0);
        attachChild(zeeschipPlatformNode);
    }
    
}