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
    
    private static AssetManager assetManager;
    private Main app;
    
    static Node zeeschipNode;
    
    Node zeeschipPlatformNode;
    
    //opslag voor containers op het zeeschip
    public static int breedteContainerPlaatsen = 16; 
    public static int lengteContainerPlaatsen = 20;
    public static int hoogteContainerPlaatsen = 6;
    
    // platform afmetingen
    public static float platformBreedte = 4f; 
    public static float platformLengte = 70.4f;
    
    public ZeeschipPlatform(AssetManager manager)
    {
        this.assetManager = manager;
        
        zeeschipNode = new Node("zeeschip");
        zeeschipPlatformNode = new Node("zeeschipPlatform");
        zeeschipPlatformNode.attachChild(zeeschipNode);
        zeeschipNode.setLocalTranslation(-(breedteContainerPlaatsen*Container.containerBreedte + platformBreedte) - 1, 0, 0); //hoever het schip van de kade af staat
        zeeschipPlatformNode.setLocalTranslation(-platformBreedte, 0, 0);
        // schip zeeschip containeropslag
        Box schip = new Box(breedteContainerPlaatsen,0,lengteContainerPlaatsen);
        // platform complete strook 
        Box platform = new Box(platformBreedte,0,platformLengte);
        Geometry zeeschipPlatform = new Geometry("zeeschipPlatform", platform);

        Material matB = new Material(assetManager, "Common/MatDefs/Misc/Unshaded.j3md");
        matB.setColor("Color", ColorRGBA.Brown);
        zeeschipPlatform.setMaterial(matB);
        zeeschipPlatformNode.attachChild(zeeschipPlatform);
        
        
        
        ZeeschipKraan[] zeeschipKranen = new ZeeschipKraan[10];     //zeeschipkranen aanmaken op het platform
        
        for (int i = 0; i < zeeschipKranen.length; i++){
            zeeschipKranen[i] = new ZeeschipKraan(assetManager);
            zeeschipPlatformNode.attachChild(zeeschipKranen[i]);  
            zeeschipKranen[i].setLocalTranslation(-platformBreedte + 1.7f, 2.5f,platformLengte - platformLengte/10 -platformLengte/5 * i);      //zeeschipkranen positioneren op het platform
        }

        
        
        rotate(0,FastMath.HALF_PI, 0);
        attachChild(zeeschipPlatformNode);
        
        
    }
    
    
    
    
        
}