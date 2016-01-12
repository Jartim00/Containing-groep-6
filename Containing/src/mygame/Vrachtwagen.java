/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mygame;

import com.jme3.asset.AssetManager;
import com.jme3.cinematic.MotionPath;
import com.jme3.cinematic.events.MotionEvent;
import com.jme3.material.Material;
import com.jme3.math.ColorRGBA;
import com.jme3.math.FastMath;
import com.jme3.math.Vector3f;
import com.jme3.scene.Geometry;
import com.jme3.scene.Node;
import com.jme3.scene.Spatial;
import com.jme3.scene.shape.Box;


/**
 *
 * @author Sjoerd
 */
public class Vrachtwagen extends Node {
    
    
    private float breedteA = Container.containerBreedte; // Grootte parkeerplekken
    private float lengteA = Container.containerLengte;    
    public Vector3f translation;          
    public boolean bezet;   
    
    AssetManager assetManager;
    
    public Vrachtwagen(AssetManager assetManager){
        
        VrachtwagenKraan kraan = new VrachtwagenKraan(assetManager);
        Box parkeerplaats = new Box(lengteA,0.01f,breedteA);
        Geometry agv = new Geometry("agv parkeerplaats",parkeerplaats);
        Geometry vrachtwagen = new Geometry("vrachtwagen parkeerplaats",parkeerplaats);
        Material matP = new Material(assetManager, "Common/MatDefs/Misc/Unshaded.j3md");
        Material matQ = new Material(assetManager, "Common/MatDefs/Misc/Unshaded.j3md");
        matP.setColor("Color", ColorRGBA.Pink);
        matQ.setColor("Color", ColorRGBA.Cyan);
        agv.setMaterial(matP);
        vrachtwagen.setMaterial(matQ);
        kraan.setLocalTranslation(0, 1, 0);
        agv.setLocalTranslation(-lengteA, 0.01f, 0);
        vrachtwagen.setLocalTranslation(lengteA,0.01f,0);
        attachChild(kraan);
        attachChild(agv);
        attachChild(vrachtwagen);
      
    }

   
    public void storeContainer(Container container)
    {   
        
        attachChild(container);
        container.setLocalTranslation( (lengteA),    // container word op de plaats van de vrachtwagen gezet
                                       (0.2f), 
                                       (0));
    }
}