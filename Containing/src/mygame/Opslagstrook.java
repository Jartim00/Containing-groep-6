/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mygame;

import com.jme3.asset.AssetManager;
import com.jme3.cinematic.MotionPath;
import com.jme3.cinematic.events.MotionEvent;
import com.jme3.material.Material;
import com.jme3.math.ColorRGBA;
import com.jme3.math.FastMath;
import com.jme3.math.Vector3f;
import com.jme3.scene.Geometry;
import com.jme3.scene.Node;
import com.jme3.scene.Spatial;
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
       
    private Spatial kraan;
    // 3d array om de container objecten in op te slaan
    Container[][][] containerOpslag = new Container[47][6][6];
    ParkeerPlaats[] parkeerPlaatsL = new ParkeerPlaats[6];
    ParkeerPlaats[] parkeerPlaatsR = new ParkeerPlaats[6];
    
    public static MotionEvent motionControl;
    public MotionPath path;
    
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
        opslag.setMaterial(matA);
        opslagTerrein.setMaterial(matB);
        attachChild(opslagTerrein);
        attachChild(opslag);
        
        for (int x = 0; x < 47; x++) {
            for (int y = 0; y < 6; y++) {
                for (int z = 0; z < 6; z++) {
                    containerOpslag[x][y][z] = null;                       
                } 
            }
        }
        
    }
    
    public void maakParkeerPlaatsen(Vector3f locatie){
        parkeerPlaatsL = new ParkeerPlaats[6];
        parkeerPlaatsR = new ParkeerPlaats[6];
        locatie.z = locatie.z + breedteA + Container.containerBreedte;
        
        for (int i = 0; i < parkeerPlaatsL.length; i++){            
            parkeerPlaatsL[i] = new ParkeerPlaats(new Vector3f(locatie.x - lengteA - 1.5f*Container.containerLengte, 0.13f, locatie.z - (i * 2.2f*Container.containerBreedte)));
        }
        for (int i = 0; i < parkeerPlaatsR.length; i++){           
            parkeerPlaatsR[i] = new ParkeerPlaats(new Vector3f(locatie.x + lengteA + 1.5f*Container.containerLengte, 0.13f, locatie.z + (i *-2.2f*Container.containerBreedte)));
        }
    }       
    
    public void storeContainer(Container container, int x, int y, int z){
        if (x < 45 && y < 6 && z < 6){ //deze if is tijdelijk om de methode te testen
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
