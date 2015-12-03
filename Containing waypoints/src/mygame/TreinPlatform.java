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
/**
 *
 * @author Robin
 */
public class TreinPlatform extends Node 
{
    private AssetManager assetManager;
    
    Node treinRailsNode;
    private float breedteA = 0.25f; // A = opslag voor containers
    private float lengteA = 125.3f;    
    private float breedteB = 4f; // B = complete strook inclusief parkeerplekken en ruimte voor kraan
    private float lengteB = 157.4f;
    
    private final float containerLengte = 2.5f;
    private final float containerBreedte = 0.25f;
    private final float containerHoogte = 0.26f;  
    
    Container[][][] containerTrein = new Container[50][1][1];

    //maak opslagkraan
    public TreinPlatform(AssetManager assetManager) 
{
            this.assetManager = assetManager;
            treinRailsNode = new Node("trein");
            
            // A voor treinrails
        Box A = new Box(lengteB,0.01f,breedteA);
            // B complete treinplatform 
        Box B = new Box(lengteB,0.001f,breedteB);
        Geometry treinRails = new Geometry("trein", A); 
        Geometry treinPlatform = new Geometry("treinPlatform", B);
        Material matA = new Material(assetManager, "Common/MatDefs/Misc/Unshaded.j3md");
        matA.setColor("Color", ColorRGBA.Gray);
        Material matB = new Material(assetManager, "Common/MatDefs/Misc/Unshaded.j3md");
        matB.setColor("Color", ColorRGBA.Black);
        treinRails.setMaterial(matA);
        treinPlatform.setMaterial(matB);
        
        attachChild(treinPlatform);
        treinRailsNode.attachChild(treinRails);
        
        
        TreinKraan[] treinKranen = new TreinKraan[4];
        
        
        
        for (int i = 0; i < treinKranen.length; i++){
            treinKranen[i] = new TreinKraan(assetManager);
            attachChild(treinKranen[i]);  
            treinKranen[i].setLocalTranslation((i * 4f), 1, 0);
        }
        
        treinRailsNode.setLocalTranslation(0, 0, -1);
        attachChild(treinRailsNode);
                
        
        rotate(0,FastMath.HALF_PI, 0);
}            
    public void treinKomtAan()
    {
        Trein containerTrein = new Trein(assetManager);
        treinRailsNode.attachChild(containerTrein);
        
    }
    public void storeContainer(Container container, int x)
    {

        if(containerTrein[x] == null)
            containerTrein[x][0][0] = container;        
        
        treinRailsNode.attachChild(container);
        container.setLocalTranslation( (-lengteA + x*containerLengte), 
                                       (0.5f), 
                                       (0));
    }
}

