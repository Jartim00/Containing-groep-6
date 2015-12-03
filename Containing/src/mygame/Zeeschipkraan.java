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

public class ZeeschipKraan extends Node 
{
    private AssetManager assetManager;
    
    private final float kraanDikte = 0.25f;
    private final float kraanHoogte = 2.5f;
    private final float kraanBreedte = 1.7f;
    
    private final float kraanArm = 5f;
    
    public ZeeschipKraan(AssetManager assetManager) 
    {
    
        this.assetManager = assetManager;
        
        Box poot = new Box(kraanDikte,kraanHoogte,kraanDikte);
        Box xBalk = new Box(kraanBreedte,kraanDikte,kraanDikte);
        Box zBalk = new Box(kraanDikte,kraanDikte,kraanBreedte);
        Box ballast = new Box(1.5f,0.5f,1.5f);
        Box arm = new Box(kraanArm + kraanBreedte,kraanDikte,kraanDikte);
        Box haak = new Box(Container.containerBreedte,0.1f,Container.containerLengte);
        
        Geometry zeeschipKraanPoot1 = new Geometry("Box", poot);
        Geometry zeeschipKraanPoot2 = new Geometry("Box", poot);
        Geometry zeeschipKraanPoot3 = new Geometry("Box", poot);
        Geometry zeeschipKraanPoot4 = new Geometry("Box", poot);
        Geometry zeeschipKraanXBalk1 = new Geometry("Box", xBalk);
        Geometry zeeschipKraanXBalk2 = new Geometry("Box", xBalk);
        Geometry zeeschipKraanZBalk1 = new Geometry("Box", zBalk);
        Geometry zeeschipKraanZBalk2 = new Geometry("Box", zBalk);
        Geometry zeeschipKraanArm1 = new Geometry("Box", arm);
        Geometry zeeschipKraanArm2 = new Geometry("Box", arm);
        Geometry zeeschipKraanBallast = new Geometry("Box", ballast);
        Geometry zeeschipKraanHaak = new Geometry("Box", haak);
        
        Material matZeeschipKraan = new Material(assetManager, "Common/MatDefs/Misc/Unshaded.j3md");
        Material matZeeschipHaak = new Material(assetManager, "Common/MatDefs/Misc/Unshaded.j3md");
        
        matZeeschipKraan.setColor("Color", ColorRGBA.Yellow);
        matZeeschipHaak.setColor("Color", ColorRGBA.Black);
        
        zeeschipKraanPoot1.setMaterial(matZeeschipKraan);
        zeeschipKraanPoot2.setMaterial(matZeeschipKraan);
        zeeschipKraanPoot3.setMaterial(matZeeschipKraan);
        zeeschipKraanPoot4.setMaterial(matZeeschipKraan);
        zeeschipKraanXBalk1.setMaterial(matZeeschipKraan);
        zeeschipKraanXBalk2.setMaterial(matZeeschipKraan);
        zeeschipKraanZBalk1.setMaterial(matZeeschipKraan);
        zeeschipKraanZBalk2.setMaterial(matZeeschipKraan);
        zeeschipKraanArm1.setMaterial(matZeeschipKraan);
        zeeschipKraanArm2.setMaterial(matZeeschipKraan);
        zeeschipKraanBallast.setMaterial(matZeeschipKraan);
        zeeschipKraanHaak.setMaterial(matZeeschipHaak);
        
        zeeschipKraanPoot1.setLocalTranslation(-(kraanBreedte - kraanDikte), 0, -(kraanBreedte - kraanDikte));
        zeeschipKraanPoot2.setLocalTranslation(kraanBreedte - kraanDikte, 0, kraanBreedte - kraanDikte);
        zeeschipKraanPoot3.setLocalTranslation(-(kraanBreedte - kraanDikte), 0, kraanBreedte - kraanDikte);
        zeeschipKraanPoot4.setLocalTranslation(kraanBreedte - kraanDikte, 0, -(kraanBreedte - kraanDikte));
        zeeschipKraanXBalk1.setLocalTranslation(0, 1, -(kraanBreedte - kraanDikte));
        zeeschipKraanXBalk2.setLocalTranslation(0, 1, kraanBreedte - kraanDikte);
        zeeschipKraanZBalk1.setLocalTranslation(kraanBreedte - kraanDikte, 1, 0);
        zeeschipKraanZBalk2.setLocalTranslation(-(kraanBreedte - kraanDikte), 1, 0);
        zeeschipKraanArm1.setLocalTranslation(-(kraanArm/2 + kraanBreedte/2), kraanHoogte, kraanBreedte - kraanDikte);
        zeeschipKraanArm2.setLocalTranslation(-(kraanArm/2 + kraanBreedte/2), kraanHoogte, -(kraanBreedte - kraanDikte));
        zeeschipKraanBallast.setLocalTranslation(3, kraanHoogte, 0);
        zeeschipKraanHaak.setLocalTranslation(0, kraanHoogte, 0); 
        
        attachChild(zeeschipKraanPoot1);
        attachChild(zeeschipKraanPoot2);
        attachChild(zeeschipKraanPoot3);
        attachChild(zeeschipKraanPoot4);
        attachChild(zeeschipKraanXBalk1);
        attachChild(zeeschipKraanXBalk2);
        attachChild(zeeschipKraanZBalk1);
        attachChild(zeeschipKraanZBalk2);
        attachChild(zeeschipKraanArm1);
        attachChild(zeeschipKraanArm2);
        attachChild(zeeschipKraanBallast);
        attachChild(zeeschipKraanHaak);
    
    }
}
