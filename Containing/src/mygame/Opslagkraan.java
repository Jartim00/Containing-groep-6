/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mygame;

import com.jme3.asset.AssetManager;
import com.jme3.math.FastMath;
import com.jme3.math.Vector3f;
import com.jme3.scene.Node;
import com.jme3.scene.Spatial;

/**
 *
 * @author seventhflame
 */
public class Opslagkraan extends Kraan {    
    
    //private MotionPath path;
    //private MotionEvent MotionControl;
    
    //maak opslagkraan
    public Opslagkraan(Spatial base, Spatial slider, Spatial hook, Vector3f positie, Node rootNode, AssetManager assetManager) {
        super(base, slider, hook, positie, rootNode, assetManager);        
        setLocalScale(0.12f, 0.16f, 0.2f);
        rotate(0, FastMath.HALF_PI ,0);  
    }
    
    
    

}
