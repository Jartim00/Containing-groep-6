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
import com.jme3.scene.Spatial;
import com.jme3.scene.shape.Box;
import static mygame.Schip.xContainers;
import static mygame.Schip.yContainers;
import static mygame.Schip.zContainers;
/**
 *
 * @author seventhflame
 * 
 * 
 */
public class ZeeSchip extends Node {
    
    private static AssetManager assetManager;
    
    public static int xContainers = 20; 
    public static int yContainers = 6;    
    public static int zContainers = 16;
    
    private Container[][][] containerOpslag = new Container[xContainers][yContainers][zContainers];
    
    public ZeeSchip(AssetManager manager){
        
        // afmetingen van het schip
        
        this.assetManager = manager;
        
        //Een box die aangeeft waar de containers geplaatst moeten worden voornamelijk gebruiken voor testen.
        Box containerBox = new Box(zContainers*Container.containerBreedte,0,xContainers*Container.containerLengte);
        Geometry containerPlaats = new Geometry("containerplaats", containerBox); 
        Material matA = new Material(assetManager, "Common/MatDefs/Misc/Unshaded.j3md");
        matA.setColor("Color", ColorRGBA.Orange);
        containerPlaats.setMaterial(matA);
        attachChild(containerPlaats);
        
        // Het inladen van het zeeschip op de juiste plaats
        
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
     void komtAan()
    {
        Spatial schip = assetManager.loadModel("Models/medium/ship/seaship.j3o");
        schip.setLocalScale(0.15f,0.2f,0.1f);
        schip.setLocalTranslation(0,0,-5);  //zet het schip in het midden van de containerplaatsen
        attachChild(schip);
    } 
}

