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
public class OpslagKraan extends Node 
{
    private AssetManager assetManager;
    
    private final float kraanDikte = 0.25f;
    private final float kraanHoogte = 2.5f;
    private final float kraanBreedte = 2;
    
    
    

    //maak opslagkraan
    public OpslagKraan(AssetManager assetManager) 
    {
        this.assetManager = assetManager;
        Box poot = new Box(kraanDikte,kraanHoogte,kraanDikte);
        Box top = new Box(kraanBreedte,kraanDikte,kraanDikte);
        Box haak = new Box(Container.containerBreedte,0.1f,Container.containerLengte);
        
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
        
        kraanPoot1.setLocalTranslation(-(kraanBreedte -kraanDikte), 0, 0);
        kraanPoot2.setLocalTranslation(kraanBreedte - kraanDikte, 0, 0);
        topKraan.setLocalTranslation(0, kraanHoogte - kraanDikte, 0);
        kraanHaak.setLocalTranslation(0, kraanHoogte - 2* kraanDikte, 0);
        
        attachChild(kraanPoot1);
        attachChild(kraanPoot2);
        attachChild(topKraan);
        attachChild(kraanHaak);
        
        rotate(0,FastMath.HALF_PI,0);
        setLocalTranslation(0,kraanHoogte,0);
    }

}
    
