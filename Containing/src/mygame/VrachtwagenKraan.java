/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mygame;

import com.jme3.asset.AssetManager;
import com.jme3.material.Material;
import com.jme3.math.ColorRGBA;
import com.jme3.math.FastMath;
import com.jme3.scene.Geometry;
import com.jme3.scene.Node;
import com.jme3.scene.shape.Box;

/**
 *
 * @author seventhflame
 */
public class VrachtwagenKraan extends Node {
    
    private AssetManager assetManager;
    
    //afmetingen van de kraan
    private final float kraanHoogte = 1;
    private final float kraanDikte = 0.2f;
    private final float kraanBreedte = 0.7f;
    
    public VrachtwagenKraan(AssetManager assetManager)
    {
        this.assetManager = assetManager;
        
        Box poot = new Box(kraanDikte,kraanHoogte,kraanDikte);
        Box top = new Box(kraanDikte,kraanDikte,kraanBreedte);
        Box haak = new Box(Container.containerLengte,0.1f,Container.containerBreedte);
        
        Geometry vrachtwagenKraanPoot1 = new Geometry("Box", poot);
        Geometry vrachtwagenKraanPoot2 = new Geometry("Box", poot);
        Geometry vrachtwagenKraanTop = new Geometry("Box", top);
        Geometry vrachtwagenKraanHaak = new Geometry("Box", haak);
        
        Material matKraan = new Material(assetManager, "Common/MatDefs/Misc/Unshaded.j3md");
        Material matHaak = new Material(assetManager, "Common/MatDefs/Misc/Unshaded.j3md");
        
        matKraan.setColor("Color", ColorRGBA.Yellow);
        matHaak.setColor("Color", ColorRGBA.Black);
        
        vrachtwagenKraanPoot1.setMaterial(matKraan);
        vrachtwagenKraanPoot2.setMaterial(matKraan);
        vrachtwagenKraanTop.setMaterial(matKraan);
        vrachtwagenKraanHaak.setMaterial(matHaak);
        
        vrachtwagenKraanPoot1.setLocalTranslation(0, 0, 0.5f);
        vrachtwagenKraanPoot2.setLocalTranslation(0, 0, -0.5f);
        vrachtwagenKraanTop.setLocalTranslation(0, 1, 0);
        vrachtwagenKraanHaak.setLocalTranslation(0, 0.8f, 0);
        
        attachChild(vrachtwagenKraanPoot1);
        attachChild(vrachtwagenKraanPoot2);
        attachChild(vrachtwagenKraanTop);
        attachChild(vrachtwagenKraanHaak);
        setLocalTranslation(0,kraanHoogte,0);
    }
}
