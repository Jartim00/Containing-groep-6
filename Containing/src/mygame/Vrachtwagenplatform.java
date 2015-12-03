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
    private float platformLengte = Main.opslagLengte/2;
    
    
//    private float parkeerLengte;
//    private float parkeerHoogte;
//    private float perkeerBreedte;
    Node platform;
    Node park;
    Node kranenNode;
    
    public Vrachtwagenplatform(AssetManager assetManager) {
        Geometry[] geomArr = new Geometry[20];
        Geometry[] geomArr2 = new Geometry[20];
        Geometry[] geomArr3 = new Geometry[20];
        this.assetManager = assetManager;
        Box b = new Box(platformBreedte,platformHoogte,platformLengte);
        Geometry geom = new Geometry("Box", b);
        Material matA = new Material(assetManager, "Common/MatDefs/Misc/Unshaded.j3md");
        matA.setColor("Color", ColorRGBA.Red);
        geom.setMaterial(matA);
        platform = new Node();
        park = new Node();
        
        VrachtwagenKraan[] kraan = new VrachtwagenKraan[20];
        
        
//            treinKranen[i] = new TreinKraan(assetManager);
//            attachChild(treinKranen[i]);  
//            treinKranen[i].setLocalTranslation((i * 4f), 1, 0);
        
        for(int i = 0; i < geomArr.length;i++){
            kraan[i] = new VrachtwagenKraan(assetManager);
            kraan[i].setLocalTranslation(1f,0.01f,(platformLengte/20) * i);
            park.attachChild(kraan[i]);
            Material matP = new Material(assetManager, "Common/MatDefs/Misc/Unshaded.j3md");
            Material matQ = new Material(assetManager, "Common/MatDefs/Misc/Unshaded.j3md");
            matP.setColor("Color", ColorRGBA.Pink);
            matQ.setColor("Color", ColorRGBA.Cyan);
            geomArr[i] = new Geometry("Box number " + Integer.toString(i), new Box(Container.containerLengte,0,Container.containerBreedte));
            geomArr2[i] = new Geometry("Box number " + Integer.toString(i), new Box(Container.containerLengte,0,Container.containerBreedte));
            geomArr[i].setMaterial(matP);
            geomArr2[i].setMaterial(matQ);
            geomArr[i].setLocalTranslation(0f, 0.01f,(platformLengte/40) * i);
            geomArr2[i].setLocalTranslation(3f, 0.01f,(platformLengte/40) * i);
            park.attachChild(geomArr[i]);
            park.attachChild(geomArr2[i]);
            
        }
        
        platform.attachChild(geom);
        attachChild(park);
        attachChild(platform);
    }
}