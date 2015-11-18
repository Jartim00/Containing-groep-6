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

public class Zeeschipkraan extends Node 
{
    private AssetManager assetManager;
    
public Zeeschipkraan(AssetManager assetmanager) {
    
        this.assetManager = assetManager;
        Box poot1 = new Box(0.1f,2,0.1f);
        
    
    }
}
