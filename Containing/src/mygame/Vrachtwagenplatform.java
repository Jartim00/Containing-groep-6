package mygame;

import com.jme3.asset.AssetManager;
import com.jme3.material.Material;
import com.jme3.math.ColorRGBA;
import com.jme3.math.FastMath;
import com.jme3.scene.Geometry;
import com.jme3.scene.Node;
import com.jme3.scene.shape.Box;

public class Vrachtwagenplatform extends Node {
    private AssetManager assetManager;
    private float platformBreedte = 4f;
    private float platformHoogte = 0.001f;
    private float platformLengte = Main.opslagLengte/2 + Main.wegBreedte;
    
    
//    private float parkeerLengte;
//    private float parkeerHoogte;
//    private float perkeerBreedte;
    Node platform;
    Node park;
    Node kranenNode;
    
    public Vrachtwagenplatform(AssetManager assetManager) {
        
        this.assetManager = assetManager;
        Box b = new Box(platformBreedte,platformHoogte,platformLengte);
        Geometry geom = new Geometry("Box", b);
        Material matA = new Material(assetManager, "Common/MatDefs/Misc/Unshaded.j3md");
        matA.setColor("Color", ColorRGBA.Black);
        geom.setMaterial(matA);
        platform = new Node();
        park = new Node();
        
        VrachtwagenKraan[] kraan = new VrachtwagenKraan[20];
        Geometry[] parkeerplaatsAGV = new Geometry[20];
        Geometry[] parkeerplaatsVrachtwagen = new Geometry[20];
        
        
        Material matP = new Material(assetManager, "Common/MatDefs/Misc/Unshaded.j3md");
        Material matQ = new Material(assetManager, "Common/MatDefs/Misc/Unshaded.j3md");
        matP.setColor("Color", ColorRGBA.Pink);
        matQ.setColor("Color", ColorRGBA.Cyan);
       
        
//            treinKranen[i] = new TreinKraan(assetManager);
//            attachChild(treinKranen[i]);  
//            treinKranen[i].setLocalTranslation((i * 4f), 1, 0);
        
        for(int i = 0; i < parkeerplaatsAGV.length;i++){
            kraan[i] = new VrachtwagenKraan(assetManager);
            kraan[i].setLocalTranslation(0,1, 4 * i);     // kraanpositie
            park.attachChild(kraan[i]);
            parkeerplaatsAGV[i] = new Geometry("Box number " + Integer.toString(i), new Box(Container.containerLengte,0,Container.containerBreedte));
            parkeerplaatsVrachtwagen[i] = new Geometry("Box number " + Integer.toString(i), new Box(Container.containerLengte,0,Container.containerBreedte));
            parkeerplaatsAGV[i].setMaterial(matP);
            parkeerplaatsVrachtwagen[i].setMaterial(matQ);
            parkeerplaatsAGV[i].setLocalTranslation(Container.containerLengte, -0.99f,0);  // AGV Parkeerplaats
            parkeerplaatsVrachtwagen[i].setLocalTranslation(-Container.containerLengte, -0.99f,0); // Vrachtwagen Parkeerplaats
            kraan[i].attachChild(parkeerplaatsAGV[i]);
            kraan[i].attachChild(parkeerplaatsVrachtwagen[i]);
            
        }
        park.setLocalTranslation(-platformBreedte + 2*Container.containerLengte, 0, -1.8f);
        platform.attachChild(geom);
        platform.attachChild(park);
        platform.setLocalTranslation(platformBreedte,0,0);
        attachChild(platform);
        
    }
        
        
    }
