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

public class Zeeschipkraan extends Node 
{
    private AssetManager assetManager;
    
    public Zeeschipkraan(AssetManager assetManager) 
    {
    
        this.assetManager = assetManager;
        Box poot = new Box(0.2f,2.5f,0.2f);
        Box xBalk = new Box(1.2f,0.2f,0.2f);
        Box zBalk = new Box(0.2f,0.2f,1.2f);
        Box ballast = new Box(1.5f,0.5f,1.5f);
        Box arm = new Box(5,0.2f,0.2f);
        Box haak = new Box(0.25f,0.1f,1.2f);
        
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
        
        zeeschipKraanPoot1.setLocalTranslation(-1.4f, 0, -1.4f);
        zeeschipKraanPoot2.setLocalTranslation(1.4f, 0, 1.4f);
        zeeschipKraanPoot3.setLocalTranslation(-1.4f, 0, 1.4f);
        zeeschipKraanPoot4.setLocalTranslation(1.4f, 0, -1.4f);
        zeeschipKraanXBalk1.setLocalTranslation(0, 1, -1.4f);
        zeeschipKraanXBalk2.setLocalTranslation(0, 1, 1.4f);
        zeeschipKraanZBalk1.setLocalTranslation(1.4f, 1, 0);
        zeeschipKraanZBalk2.setLocalTranslation(-1.4f, 1, 0);
        zeeschipKraanArm1.setLocalTranslation(-2.5f, 2.5f, 1.4f);
        zeeschipKraanArm2.setLocalTranslation(-2.5f, 2.5f, -1.4f);
        zeeschipKraanBallast.setLocalTranslation(3, 2.5f, 0);
        zeeschipKraanHaak.setLocalTranslation(0, 2.5f, 0); 
        
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
