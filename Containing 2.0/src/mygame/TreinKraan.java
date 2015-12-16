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
public class TreinKraan extends Node {
    
    private AssetManager assetManager;
    
    public TreinKraan(AssetManager assetManager)
    {
        this.assetManager = assetManager;
        
        Box poot = new Box(0.2f,1,0.2f);
        Box top = new Box(0.2f,0.2f,2);
        Box haak = new Box(1.2f,0.1f,0.25f);
        
        Geometry treinKraanPoot1 = new Geometry("Box", poot);
        Geometry treinKraanPoot2 = new Geometry("Box", poot);
        Geometry treinKraanTop = new Geometry("Box", top);
        Geometry treinKraanHaak = new Geometry("Box", haak);
        
        Material matKraan = new Material(assetManager, "Common/MatDefs/Misc/Unshaded.j3md");
        Material matHaak = new Material(assetManager, "Common/MatDefs/Misc/Unshaded.j3md");
        
        matKraan.setColor("Color", ColorRGBA.Yellow);
        matHaak.setColor("Color", ColorRGBA.Black);
        
        treinKraanPoot1.setMaterial(matKraan);
        treinKraanPoot2.setMaterial(matKraan);
        treinKraanTop.setMaterial(matKraan);
        treinKraanHaak.setMaterial(matHaak);
        
        treinKraanPoot1.setLocalTranslation(0, 0, 1.8f);
        treinKraanPoot2.setLocalTranslation(0, 0, -1.8f);
        treinKraanTop.setLocalTranslation(0, 1, 0);
        treinKraanHaak.setLocalTranslation(0, 0.8f, 0);
        
        attachChild(treinKraanPoot1);
        attachChild(treinKraanPoot2);
        attachChild(treinKraanTop);
        attachChild(treinKraanHaak);
    }
}
