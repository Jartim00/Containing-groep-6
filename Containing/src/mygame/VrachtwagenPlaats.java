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


public class VrachtwagenPlaats extends Node {  
    
    private static AssetManager assetManager;
    Spatial vrachtwagenModel;
    Container cont;
    
    public Vector3f translation;          
    public boolean bezet;   
    
    
    public VrachtwagenPlaats(AssetManager manager){
        
        this.assetManager = manager;
        
        VrachtwagenKraan kraan = new VrachtwagenKraan(assetManager);
        Box parkeerplaats = new Box(Container.containerLengte,0.01f,Container.containerBreedte);
        Geometry agv = new Geometry("agv parkeerplaats",parkeerplaats);
        Geometry vrachtwagen = new Geometry("vrachtwagen parkeerplaats",parkeerplaats);
        Material matP = new Material(assetManager, "Common/MatDefs/Misc/Unshaded.j3md");
        Material matQ = new Material(assetManager, "Common/MatDefs/Misc/Unshaded.j3md");
        matP.setColor("Color", ColorRGBA.Pink);
        matQ.setColor("Color", ColorRGBA.Cyan);
        agv.setMaterial(matP);
        vrachtwagen.setMaterial(matQ);
        agv.setLocalTranslation(-Container.containerLengte, 0.01f, 0);
        vrachtwagen.setLocalTranslation(Container.containerLengte,0.01f,0);
        attachChild(kraan);
        attachChild(agv);
        attachChild(vrachtwagen);
        
        
        
      
    }

    public void storeContainer(Container container)
    {   
        cont = container;
        attachChild(cont);
        container.setLocalTranslation( (Container.containerLengte),    // container word op de plaats van de vrachtwagen gezet
                                       (0.5f), 
                                       (0));
    }
   
    
    public void komtAan()
    {
        vrachtwagenModel = assetManager.loadModel("Models/medium/truck.j3o");
        vrachtwagenModel.scale(0.2f);
        vrachtwagenModel.rotate(0,FastMath.HALF_PI, 0);
        vrachtwagenModel.setLocalTranslation(1.25f, 0, 0);
        attachChild(vrachtwagenModel);
    }
    public void vertrekt()
    {
        detachChild(vrachtwagenModel);
        detachChild(cont);
    }
}