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
import com.jme3.scene.shape.Cylinder;
import static mygame.TreinPlatform.treinNode;
/**
 *
 * @author Robin
 */
public class TreinPlatform extends Node 
{
    private AssetManager assetManager;
    
    static Node treinNode;
    Node treinPlatformNode;
    static float containerOpslagBreedte = 0.25f; // A = opslag voor containers
    static float containerOpslagLengte = 125.3f;    
    static float TreinPlatformBreedte = 4f; // B = complete strook inclusief parkeerplekken en ruimte voor kraan
    static float treinPlatformLengte = Main.opslagLengte + 2*Main.wegBreedte; 
    

    //maak opslagkraan
    public TreinPlatform(AssetManager assetManager) 
{
            this.assetManager = assetManager;
            treinNode = new Node("trein");
            treinPlatformNode = new Node("treinplatform");
            
            // A voor treinrails
        Box A = new Box(treinPlatformLengte,0.01f,containerOpslagBreedte);
            // B complete treinplatform 
        Box B = new Box(treinPlatformLengte,0.001f,TreinPlatformBreedte);
        Geometry treinRails = new Geometry("trein", A); 
        Geometry treinPlatform = new Geometry("treinPlatform", B);
        Material matA = new Material(assetManager, "Common/MatDefs/Misc/Unshaded.j3md");
        matA.setColor("Color", ColorRGBA.Gray);
        Material matB = new Material(assetManager, "Common/MatDefs/Misc/Unshaded.j3md");
        matB.setColor("Color", ColorRGBA.Black);
        treinRails.setMaterial(matA);
        treinPlatform.setMaterial(matB);
        
        treinPlatformNode.attachChild(treinPlatform);
        treinNode.attachChild(treinRails);
        
        
        TreinKraan[] treinKranen = new TreinKraan[4];
        
        
        
        for (int i = 0; i < treinKranen.length; i++){
            treinKranen[i] = new TreinKraan(assetManager);
            treinPlatformNode.attachChild(treinKranen[i]);  
            treinKranen[i].setLocalTranslation(i * 20f - treinPlatformLengte/2, 1, 0);
        }
        
        treinNode.setLocalTranslation(0, 0, -1);
        treinPlatformNode.attachChild(treinNode);
                
        treinPlatformNode.setLocalTranslation(0,0,-TreinPlatformBreedte);
        rotate(0,FastMath.HALF_PI, 0);
        attachChild(treinPlatformNode);
}            
    
    
    
}

