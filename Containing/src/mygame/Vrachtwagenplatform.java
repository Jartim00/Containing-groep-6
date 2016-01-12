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
        
        Vrachtwagen[] vrachtwagenPlaatsen = new Vrachtwagen[20];

       
        
//            treinKranen[i] = new TreinKraan(assetManager);
//            attachChild(treinKranen[i]);  
//            treinKranen[i].setLocalTranslation((i * 4f), 1, 0);
        
        for(int i = 0; i < vrachtwagenPlaatsen.length;i++){
            vrachtwagenPlaatsen[i] = new Vrachtwagen(assetManager);
            vrachtwagenPlaatsen[i].setLocalTranslation(0, 0, 4*i);
            park.attachChild(vrachtwagenPlaatsen[i]);
            
        }
        park.setLocalTranslation(-platformBreedte + 2*Container.containerLengte, 0, -1.8f);
        platform.attachChild(geom);
        platform.attachChild(park);
        platform.setLocalTranslation(platformBreedte,0,0);
        attachChild(platform);
        
    }
        
        
    }
