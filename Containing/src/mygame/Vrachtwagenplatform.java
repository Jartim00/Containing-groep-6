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
    
    Node platformNode;
    static Node parkeerNode;
    Node kranenNode;
    
    
    public Vrachtwagenplatform(AssetManager assetManager) {
        
        this.assetManager = assetManager;
        Box b = new Box(platformBreedte,platformHoogte,platformLengte);
        Geometry platform = new Geometry("Box", b);
        Material matA = new Material(assetManager, "Common/MatDefs/Misc/Unshaded.j3md");
        matA.setColor("Color", ColorRGBA.Black);
        platform.setMaterial(matA);
        platformNode = new Node();
        parkeerNode = new Node();
        
        //VrachtwagenPlaats[] vrachtwagenPlaatsen = new VrachtwagenPlaats[20];

        //vrachtwagenplaatsen aanmaken met kranen en parkeerplaatsen voor agvs en vrachtwagens
        
        
        
        parkeerNode.setLocalTranslation(-platformBreedte + 2*Container.containerLengte, 0, -1.8f);
        platformNode.attachChild(platform);
        platformNode.attachChild(parkeerNode);
        platformNode.setLocalTranslation(platformBreedte,0,0);
        attachChild(platformNode);
        
        
    }
    
        }
