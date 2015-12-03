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

public class BinnenvaartKraan extends Node 
{
    private AssetManager assetManager;
    
    private final float kraanDikte = 0.25f;
    private final float kraanHoogte = 2.5f;
    private final float kraanBreedte = 1.7f;
    
    public BinnenvaartKraan(AssetManager assetManager) 
    {
    
        this.assetManager = assetManager;
        
        Box poot = new Box(kraanDikte,kraanHoogte,kraanDikte);
        Box xBalk = new Box(kraanBreedte,kraanDikte,kraanDikte);
        Box zBalk = new Box(kraanDikte,kraanDikte,kraanBreedte);
        Box ballast = new Box(1.5f,0.5f,1.5f);
        Box arm = new Box(kraanDikte,kraanDikte,5);
        Box haak = new Box(Container.containerLengte,0.1f,Container.containerBreedte);
        
        Geometry binnenvaartKraanPoot1 = new Geometry("Box", poot);
        Geometry binnenvaartKraanPoot2 = new Geometry("Box", poot);
        Geometry binnenvaartKraanPoot3 = new Geometry("Box", poot);
        Geometry binnenvaartKraanPoot4 = new Geometry("Box", poot);
        Geometry binnenvaartKraanXBalk1 = new Geometry("Box", xBalk);
        Geometry binnenvaartKraanXBalk2 = new Geometry("Box", xBalk);
        Geometry binnenvaartKraanZBalk1 = new Geometry("Box", zBalk);
        Geometry binnenvaartKraanZBalk2 = new Geometry("Box", zBalk);
        Geometry binnenvaartKraanArm1 = new Geometry("Box", arm);
        Geometry binnenvaartKraanArm2 = new Geometry("Box", arm);
        Geometry binnenvaartKraanBallast = new Geometry("Box", ballast);
        Geometry binnenvaartKraanHaak = new Geometry("Box", haak);
        
        Material matBinnenvaartKraan = new Material(assetManager, "Common/MatDefs/Misc/Unshaded.j3md");
        Material matBinnenvaartHaak = new Material(assetManager, "Common/MatDefs/Misc/Unshaded.j3md");
        
        matBinnenvaartKraan.setColor("Color", ColorRGBA.Yellow);
        matBinnenvaartHaak.setColor("Color", ColorRGBA.Black);
        
        binnenvaartKraanPoot1.setMaterial(matBinnenvaartKraan);
        binnenvaartKraanPoot2.setMaterial(matBinnenvaartKraan);
        binnenvaartKraanPoot3.setMaterial(matBinnenvaartKraan);
        binnenvaartKraanPoot4.setMaterial(matBinnenvaartKraan);
        binnenvaartKraanXBalk1.setMaterial(matBinnenvaartKraan);
        binnenvaartKraanXBalk2.setMaterial(matBinnenvaartKraan);
        binnenvaartKraanZBalk1.setMaterial(matBinnenvaartKraan);
        binnenvaartKraanZBalk2.setMaterial(matBinnenvaartKraan);
        binnenvaartKraanArm1.setMaterial(matBinnenvaartKraan);
        binnenvaartKraanArm2.setMaterial(matBinnenvaartKraan);
        binnenvaartKraanBallast.setMaterial(matBinnenvaartKraan);
        binnenvaartKraanHaak.setMaterial(matBinnenvaartHaak);
        
        binnenvaartKraanPoot1.setLocalTranslation(-(kraanBreedte - kraanDikte), 0, -(kraanBreedte - kraanDikte));
        binnenvaartKraanPoot2.setLocalTranslation(kraanBreedte - kraanDikte, 0, kraanBreedte - kraanDikte);
        binnenvaartKraanPoot3.setLocalTranslation(-(kraanBreedte - kraanDikte), 0, kraanBreedte - kraanDikte);
        binnenvaartKraanPoot4.setLocalTranslation(kraanBreedte - kraanDikte, 0, -(kraanBreedte - kraanDikte));
        binnenvaartKraanXBalk1.setLocalTranslation(0, 1, -(kraanBreedte - kraanDikte));
        binnenvaartKraanXBalk2.setLocalTranslation(0, 1, kraanBreedte - kraanDikte);
        binnenvaartKraanZBalk1.setLocalTranslation(kraanBreedte - kraanDikte, 1, 0);
        binnenvaartKraanZBalk2.setLocalTranslation(-(kraanBreedte - kraanDikte), 1, 0);
        binnenvaartKraanArm1.setLocalTranslation(kraanBreedte - kraanDikte, kraanHoogte, 8*Container.containerBreedte + kraanBreedte/2);
        binnenvaartKraanArm2.setLocalTranslation(-(kraanBreedte - kraanDikte), kraanHoogte, 8*Container.containerBreedte + kraanBreedte/2);
        binnenvaartKraanBallast.setLocalTranslation(0, kraanHoogte, -3);
        binnenvaartKraanHaak.setLocalTranslation(0, kraanHoogte, 0); 
        
        attachChild(binnenvaartKraanPoot1);
        attachChild(binnenvaartKraanPoot2);
        attachChild(binnenvaartKraanPoot3);
        attachChild(binnenvaartKraanPoot4);
        attachChild(binnenvaartKraanXBalk1);
        attachChild(binnenvaartKraanXBalk2);
        attachChild(binnenvaartKraanZBalk1);
        attachChild(binnenvaartKraanZBalk2);
        attachChild(binnenvaartKraanArm1);
        attachChild(binnenvaartKraanArm2);
        attachChild(binnenvaartKraanBallast);
        attachChild(binnenvaartKraanHaak);
        
    
    }
}