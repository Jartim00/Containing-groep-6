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
    Node parkerenRechts;
    Node parkerenLinks;
    
    private final AssetManager assetManager;
    
    private float breedteA = 6*Container.containerBreedte; // A = opslag voor containers
    private float lengteA = 47*Container.containerLengte;    
    private float breedteB = 2.0f; // B = complete strook inclusief parkeerplekken en ruimte voor kraan
    private float lengteB = Main.opslagBreedte;
       
    
    // 3d array om de container objecten in op te slaan
    Container[][][] containerOpslag = new Container[47][6][6];
    
    public Opslagstrook(AssetManager manager){
        this.assetManager = manager;
        
        // A voor containers
        Box A = new Box(lengteA,0.01f,breedteA);
        // B complete strook 
        Box B = new Box(lengteB,0.001f,breedteB);
        // parkeerplaatsen
        
        Geometry opslag = new Geometry("opslag", A); 
        Geometry opslagTerrein = new Geometry("opslagTerrein", B);
        
        Material matA = new Material(assetManager, "Common/MatDefs/Misc/Unshaded.j3md");
        matA.setColor("Color", ColorRGBA.Gray);
        Material matB = new Material(assetManager, "Common/MatDefs/Misc/Unshaded.j3md");
        matB.setColor("Color", ColorRGBA.Black);
        Material matC = new Material(assetManager, "Common/MatDefs/Misc/Unshaded.j3md");
        opslag.setMaterial(matA);
        opslagTerrein.setMaterial(matB);
        Geometry[] parkArrRechts = new Geometry[6];
        Geometry[] parkArrLinks = new Geometry[6];
        parkerenRechts = new Node();
        parkerenLinks = new Node();
        for(int i =0; i < 6; i++){
            parkArrRechts[i] = new Geometry("Box number " + Integer.toString(i), new Box(Container.containerLengte, 0.02f,Container.containerBreedte));
            parkArrLinks[i] = new Geometry("Box number " + Integer.toString(i), new Box(Container.containerLengte, 0.02f,Container.containerBreedte));
            parkArrRechts[i].setMaterial(matC);
            parkArrLinks[i].setMaterial(matC);
            parkArrRechts[i].setLocalTranslation(0,0,breedteA - Container.containerBreedte - i*2*Container.containerBreedte);
            parkArrLinks[i].setLocalTranslation(0,0,breedteA - Container.containerBreedte - i*2*Container.containerBreedte);
            matC.setColor("Color", ColorRGBA.Blue);
            //matC.getAdditionalRenderState().setWireframe(true);
            parkerenRechts.attachChild(parkArrRechts[i]);
            parkerenLinks.attachChild(parkArrLinks[i]);
        }
        attachChild(parkerenRechts);
        attachChild(parkerenLinks);
        
        parkerenLinks.setLocalTranslation(-lengteA + Container.containerLengte,0,0);
        parkerenRechts.setLocalTranslation(lengteA + Container.containerLengte,0,0);
        attachChild(opslagTerrein);
        attachChild(opslag);
        
        
        OpslagKraan opslagKraan = new OpslagKraan(assetManager);
        attachChild(opslagKraan);
        
        for (int x = 0; x < 47; x++) {
            for (int y = 0; y < 6; y++) {
                for (int z = 0; z < 6; z++) {
                    containerOpslag[x][y][z] = null;                       
                } 
            }
        }
        
    }
    
    public void storeContainer(Container container, int x, int y, int z){
        if (x < 45 && y < 6 && z < 6){ //deze if is tijdelijke om de methode te testen
        if(containerOpslag[x][y][z] == null)
            containerOpslag[x][y][z] = container;        
        
        attachChild(container);
        container.setLocalTranslation( (-lengteA + Container.containerLengte + x*2*Container.containerLengte), 
                                       (Container.containerHoogte + y*2*Container.containerHoogte), 
                                       (breedteA - Container.containerBreedte - z*2*Container.containerBreedte));
        }
    }
    
    public Container[][][] getContainers(){
        return containerOpslag;
    }
}
