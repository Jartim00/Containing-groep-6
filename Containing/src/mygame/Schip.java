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
/**
 *
 * @author seventhflame
 */
public /*abstract*/ class Schip extends Node {
    
    private static AssetManager assetManager;
    
    public static int xContainers; 
    public static int yContainers;    
    public static int zContainers;
    
    private Container[][][] containerOpslag = new Container[xContainers][yContainers][zContainers];
    
    public Schip(AssetManager manager){
        
        this.xContainers = xContainers;
        this.yContainers = yContainers;
        this.zContainers = zContainers;
        this.assetManager = manager;
        
        Box containerBox = new Box(zContainers*Container.containerBreedte,0,xContainers*Container.containerLengte);
        Geometry containerPlaats = new Geometry("containerplaats", containerBox); 
        Material matA = new Material(assetManager, "Common/MatDefs/Misc/Unshaded.j3md");
        matA.setColor("Color", ColorRGBA.Orange);
        containerPlaats.setMaterial(matA);
        attachChild(containerPlaats);
        
        
        for (int x = 0; x < xContainers; x++) {
            for (int y = 0; y < yContainers; y++) {
                for (int z = 0; z < zContainers; z++) {
                    containerOpslag[x][y][z] = null;                       
                } 
            }
        }
        
    }
    
    public void storeContainer(Container container, int x, int y, int z){

        if(containerOpslag[x][y][z] == null)
            containerOpslag[x][y][z] = container;        
        
        attachChild(container);
        container.rotate(0,FastMath.HALF_PI, 0);
        container.setLocalTranslation( (zContainers*Container.containerBreedte - Container.containerBreedte - z*2*Container.containerBreedte), 
                                       (Container.containerHoogte + y*2*Container.containerHoogte), 
                                       (-xContainers*Container.containerLengte + Container.containerLengte + x*2*Container.containerLengte));
    }  
}

