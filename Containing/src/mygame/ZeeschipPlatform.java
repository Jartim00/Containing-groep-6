/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mygame;

import com.jme3.asset.AssetManager;
import com.jme3.material.Material;
import com.jme3.math.ColorRGBA;
import com.jme3.scene.Geometry;
import com.jme3.scene.Node;
import com.jme3.scene.shape.Box;
/**
 *
 * @author seventhflame
 */
public class ZeeschipPlatform extends Node {
    
    private final AssetManager assetManager;
    
    private float breedteA = 1.5f; // A = opslag voor containers
    private float lengteA = 56.4f;    
    private float breedteB = 2.0f; // B = complete strook inclusief parkeerplekken en ruimte voor kraan
    private float lengteB = 60.0f;
    
    private final float containerLengte = 1.2f;
    private final float containerBreedte = 0.25f;
    private final float containerHoogte = 0.26f;    
    
    // 3d array om de container objecten in op te slaan
    Container[][][] containerOpslag = new Container[20][6][6];
    
    public ZeeschipPlatform(AssetManager manager)
    {
        this.assetManager = manager;
    }
    
}
