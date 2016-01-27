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
    static Node schepenNode;    //Deze node is static zodat de schepen die in de main worden aangemaakt eraan vast gemaakt kunnen worden.
    
    // De containers die op het schip moeten passen
    public static int opslagBreedte = 4; 
    public static int opslagLengte = 6;
    public static int opslagHoogte = 3; // aantal containers die op het schip moeten
    
    // De afmetingen van het binnenvaartPlatform
    public static float platformBreedte = 4f; 
    public static float platformLengte = Main.opslagLengte/2 + Main.wegBreedte; //dimensies van het platform
    
    private AssetManager assetManager;
    
    public BinnenVaartPlatform(AssetManager assetManager) 
    {
        platformNode = new Node("binnenvaartPlatform");
        schepenNode = new Node("schepen");
        
        this.assetManager = assetManager;
        
        // Het aanmaken van het binnenvaartplatform
        Box platform = new Box(platformLengte, 0.001f, platformBreedte);
        Box containers = new Box(opslagLengte*Container.containerLengte,0.201f, opslagBreedte*Container.containerBreedte);
        Geometry binnenvaartPlatform = new Geometry("Box", platform);
        Material mat = new Material(assetManager, "Common/MatDefs/Misc/Unshaded.j3md");
        mat.setColor("Color", ColorRGBA.Blue);
        binnenvaartPlatform.setMaterial(mat);
        //72 meter lang, 6.8 meter hoog en 10 meter breed
        BinnenvaartKraan[] kranen = new BinnenvaartKraan[8];
        
        //forloop voor het plaatsen van de zeeschipkranen
        for(int i = 0; i<kranen.length; i++)
        {
            kranen[i] = new BinnenvaartKraan(assetManager);
            platformNode.attachChild(kranen[i]);
            kranen[i].setLocalTranslation((-platformLengte + platformLengte/8 + platformLengte/4 *i)/1.5f, (2.5f)/2,platformBreedte - 1.2f);
        }
        
        platformNode.attachChild(schepenNode);
        schepenNode.setLocalTranslation(0, 0, opslagBreedte*Container.containerBreedte + platformBreedte + 1);
        platformNode.attachChild(binnenvaartPlatform);
        platformNode.setLocalTranslation(0, 0, platformBreedte);
        attachChild(platformNode);
        rotate(0,FastMath.HALF_PI, 0);
        
        
}
}