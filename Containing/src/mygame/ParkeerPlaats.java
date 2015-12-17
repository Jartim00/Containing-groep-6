/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mygame;

import com.jme3.asset.AssetManager;
import com.jme3.math.Vector3f;

/**
 *
 * @author Sjoerd
 */
public class ParkeerPlaats {
    
    public Vector3f translation;          
    public boolean bezet;         
    AssetManager assetManager;
    
    public ParkeerPlaats(Vector3f translation){
        this.translation = translation;        
        this.bezet = false;        
      
    }
}
