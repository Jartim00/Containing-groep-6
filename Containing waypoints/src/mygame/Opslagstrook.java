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
 * @author Sjoerd
 */
public class Opslagstrook extends Node {
    
    private final AssetManager assetManager;
    
    private float breedteA = 1.5f; // A = opslag voor containers
    private float lengteA = 56.4f;    
    private float breedteB = 2.0f; // B = complete strook inclusief parkeerplekken en ruimte voor kraan
    private float lengteB = 60.0f;
    
    private final float containerLengte = 1.2f;
    private final float containerBreedte = 0.25f;
    private final float containerHoogte = 0.26f;    
    
    // 3d array om de container objecten in op te slaan
    Container[][][] containerOpslag = new Container[47][6][6];
    
    public Opslagstrook(AssetManager manager){
        this.assetManager = manager;
        
        // A voor containers
        Box A = new Box(lengteA,0.01f,breedteA);
        // B complete strook 
        Box B = new Box(lengteB,0.001f,breedteB);
        Geometry opslag = new Geometry("opslag", A); 
        Geometry opslagTerrein = new Geometry("opslagTerrein", B);
        Material matA = new Material(assetManager, "Common/MatDefs/Misc/Unshaded.j3md");
        matA.setColor("Color", ColorRGBA.Gray);
        Material matB = new Material(assetManager, "Common/MatDefs/Misc/Unshaded.j3md");
        matB.setColor("Color", ColorRGBA.Black);
        opslag.setMaterial(matA);
        opslagTerrein.setMaterial(matB);
        attachChild(opslagTerrein);
        attachChild(opslag);
        
        OpslagKraan opslagKraan = new OpslagKraan(assetManager);
        attachChild(opslagKraan);
        
        for (int x = 0; x < 46; x++) {
            for (int y = 0; y < 6; y++) {
                for (int z = 0; z < 6; z++) {
                    containerOpslag[x][y][z] = null;                       
                } 
            }
        }
        
    }
    
    public void storeContainer(Container container, int x, int y, int z){

        if(containerOpslag[x][y][z] == null)
            containerOpslag[x][y][z] = container;        
        
        attachChild(container);
        container.setLocalTranslation( (-lengteA + 2*containerLengte + x*2*containerLengte), 
                                       (containerHoogte + y*2*containerHoogte), 
                                       (breedteA - containerBreedte - z*2*containerBreedte));
    }
    
    public Container[][][] getContainers(){
        return containerOpslag;
    }
}
