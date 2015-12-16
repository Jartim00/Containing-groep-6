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
public class Schip extends Node {
    
    private final AssetManager assetManager;
    
    public static int xContainers; 
    public static int yContainers;    
    public static int zContainers; 
    
    private float xContainerPosities = xContainers*Container.containerLengte;
    private float yContainerPosities = yContainers*Container.containerHoogte;
    private float zContainerPosities = zContainers*Container.containerBreedte;
    
    private Container[][][] containerOpslag = new Container[xContainers][yContainers][zContainers];
    
    public Schip(AssetManager manager){
        
        this.assetManager = manager;
        
        Box containerBox = new Box(xContainerPosities,0,zContainerPosities);
        Geometry containerPlaats = new Geometry("containerplaats", containerBox); 
        Material matA = new Material(assetManager, "Common/MatDefs/Misc/Unshaded.j3md");
        matA.setColor("Color", ColorRGBA.Orange);
        containerPlaats.setMaterial(matA);
        attachChild(containerPlaats);
        
        
        for (int x = 0; x < xContainerPosities; x++) {
            for (int y = 0; yContainerPosities < 6; y++) {
                for (int z = 0; z < zContainerPosities; z++) {
                    containerOpslag[x][y][z] = null;                       
                } 
            }
        }
        
    }
    
    public void storeContainer(Container container, int x, int y, int z){

        if(containerOpslag[x][y][z] == null)
            containerOpslag[x][y][z] = container;        
        
        attachChild(container);
        container.setLocalTranslation( (-xContainerPosities + Container.containerLengte + x*2*Container.containerLengte), 
                                       (Container.containerHoogte + y*2*Container.containerHoogte), 
                                       (zContainerPosities - Container.containerBreedte - z*2*Container.containerBreedte));
    }
        
}

