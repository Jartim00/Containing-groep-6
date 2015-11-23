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
public class OpslagKraan extends Node 
{
    private AssetManager assetManager;

    //maak opslagkraan
    public OpslagKraan(AssetManager assetManager) 
    {
        this.assetManager = assetManager;
        Box poot = new Box(0.2f,2.5f,0.2f);
        Box top = new Box(2,0.2f,0.2f);
        Box haak = new Box(0.25f,0.1f,1.2f);
        
        Geometry kraanPoot1 = new Geometry("Box", poot);
        Geometry kraanPoot2 = new Geometry("Box", poot);
        Geometry topKraan = new Geometry("Box", top);
        Geometry kraanHaak = new Geometry("Box", haak);
        
        Material matKraan = new Material(assetManager, "Common/MatDefs/Misc/Unshaded.j3md");
        Material matHaak = new Material(assetManager, "Common/MatDefs/Misc/Unshaded.j3md");
        
        matKraan.setColor("Color", ColorRGBA.Yellow);
        matHaak.setColor("Color", ColorRGBA.Black);
        
        kraanPoot1.setMaterial(matKraan);
        kraanPoot2.setMaterial(matKraan);
        topKraan.setMaterial(matKraan);
        kraanHaak.setMaterial(matHaak);
        
        kraanPoot1.setLocalTranslation(-2, 0, 0);
        kraanPoot2.setLocalTranslation(2, 0, 0);
        topKraan.setLocalTranslation(0, 2.3f, 0);
        kraanHaak.setLocalTranslation(0, 2.1f, 0);
        
        attachChild(kraanPoot1);
        attachChild(kraanPoot2);
        attachChild(topKraan);
        attachChild(kraanHaak);
    }

}
    
