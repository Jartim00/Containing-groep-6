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
import com.jme3.scene.shape.Box;
import com.jme3.scene.Node;


/**
 *
 * @author Robin
 */
public class BinnenVaartPlatform extends Node 
{
    
    Node platformNode;
    static Node schepenNode;
    public static int opslagBreedte = 4; 
    public static int opslagLengte = 6;
    public static int opslagHoogte = 3; // aantal containers die op het schip moeten
    public static float platformBreedte = 4f; 
    public static float platformLengte = Main.opslagLengte/2 + Main.wegBreedte; //dimensies van het platform
    
    private AssetManager assetManager;
    
    public BinnenVaartPlatform(AssetManager assetManager) 
    {
        platformNode = new Node("binnenvaartPlatform");
        schepenNode = new Node("schepen");
        this.assetManager = assetManager;
        Box platform = new Box(platformLengte, 0.001f, platformBreedte);
        Box containers = new Box(opslagLengte*Container.containerLengte,0.201f, opslagBreedte*Container.containerBreedte);
        Geometry binnenvaartPlatform = new Geometry("Box", platform);
        Geometry containerPlaats1 = new Geometry("Box", containers);
        Geometry containerPlaats2 = new Geometry("Box", containers);
        
        Material mat = new Material(assetManager, "Common/MatDefs/Misc/Unshaded.j3md");
        mat.setColor("Color", ColorRGBA.Blue);
        Material mat2 = new Material(assetManager, "Common/MatDefs/Misc/Unshaded.j3md");
        mat2.setColor("Color", ColorRGBA.Orange);
        
        binnenvaartPlatform.setMaterial(mat);
        containerPlaats1.setMaterial(mat2);
        containerPlaats2.setMaterial(mat2);
        containerPlaats1.setLocalTranslation(platformLengte/2 ,0.001f,0);
        containerPlaats2.setLocalTranslation(-platformLengte/2 ,0.001f,0);
        //schepenNode.attachChild(containerPlaats1);
        //schepenNode.attachChild(containerPlaats2);
        
        
        //72 meter lang, 6.8 meter hoog en 10 meter breed
        BinnenvaartKraan[] kranen = new BinnenvaartKraan[8];
        
        for(int i = 0; i<kranen.length; i++)
        {
            kranen[i] = new BinnenvaartKraan(assetManager);
            platformNode.attachChild(kranen[i]);
            kranen[i].setLocalTranslation(-platformLengte + platformLengte/8 + platformLengte/4 *i, 2.5f,platformBreedte - 1.7f);
        }
        
        platformNode.attachChild(schepenNode);
        schepenNode.setLocalTranslation(0, 0, opslagBreedte*Container.containerBreedte + platformBreedte);
        platformNode.attachChild(binnenvaartPlatform);
        platformNode.setLocalTranslation(0, 0, platformBreedte);
        attachChild(platformNode);
        rotate(0,FastMath.HALF_PI, 0);
        
        
}
}