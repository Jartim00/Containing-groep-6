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
    private float breedteContainerPlaatsen = 16*Container.containerBreedte; // schip = opslag voor containers op het zeeschip
    private float lengteContainerPlaatsen = 20*Container.containerLengte;    
    private float platformBreedte = 4f; // platform = complete platform zonder schip
    private float platformLengte = 70.4f;
       
    
    // 3d array om de container objecten in op te slaan
    Container[][][] containerOpslag = new Container[20][6][16];
    
    public ZeeschipPlatform(AssetManager manager)
    {
        this.assetManager = manager;
        
        zeeschipNode = new Node("zeeschip");
        zeeschipPlatformNode = new Node("zeeschipPlatform");
        zeeschipPlatformNode.attachChild(zeeschipNode);
        zeeschipNode.setLocalTranslation(-(breedteContainerPlaatsen + platformBreedte), 0, 0);
        zeeschipPlatformNode.setLocalTranslation(-platformBreedte, 0, 0);
        // schip zeeschip containeropslag
        Box schip = new Box(breedteContainerPlaatsen,0,lengteContainerPlaatsen);
        // platform complete strook 
        Box platform = new Box(platformBreedte,0,platformLengte);
        Geometry zeeschip1 = new Geometry("Zeeschip1", schip); 
        Geometry zeeschip2 = new Geometry("Zeeschip2", schip); 
        Geometry zeeschipPlatform = new Geometry("zeeschipPlatform", platform);
        Material matA = new Material(assetManager, "Common/MatDefs/Misc/Unshaded.j3md");
        matA.setColor("Color", ColorRGBA.Orange);
        Material matB = new Material(assetManager, "Common/MatDefs/Misc/Unshaded.j3md");
        matB.setColor("Color", ColorRGBA.Brown);
        zeeschip1.setMaterial(matA);
        zeeschip2.setMaterial(matA);
        zeeschipPlatform.setMaterial(matB);
        zeeschip1.setLocalTranslation(0, 0, platformLengte/2);
        zeeschip2.setLocalTranslation(0,0,-platformLengte/2);
        zeeschipPlatformNode.attachChild(zeeschipPlatform);
        zeeschipNode.attachChild(zeeschip1);
        zeeschipNode.attachChild(zeeschip2);
        
        ZeeschipKraan[] zeeschipKranen = new ZeeschipKraan[10];     //zeeschipkranen aanmaken op het platform
        
        for (int i = 0; i < zeeschipKranen.length; i++){
            zeeschipKranen[i] = new ZeeschipKraan(assetManager);
            zeeschipPlatformNode.attachChild(zeeschipKranen[i]);  
            zeeschipKranen[i].setLocalTranslation(-platformBreedte + 1.7f, 2.5f,platformLengte - platformLengte/10 -platformLengte/5 * i);      //zeeschipkranen positioneren op het platform
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