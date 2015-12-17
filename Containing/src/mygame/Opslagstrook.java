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
    ParkeerPlaats[] parkeerPlaats = new ParkeerPlaats[12];
    
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
        //Material matC = new Material(assetManager, "Common/MatDefs/Misc/Unshaded.j3md");
        opslag.setMaterial(matA);
        opslagTerrein.setMaterial(matB);
        //Geometry[] parkArrRechts = new Geometry[6];
        //Geometry[] parkArrLinks = new Geometry[6];
        //parkerenRechts = new Node();
        //parkerenLinks = new Node();
        //for(int i =0; i < 6; i++){
            //parkArrRechts[i] = new Geometry("Box number " + Integer.toString(i), new Box(Container.containerLengte, 0.02f,Container.containerBreedte));
            //parkArrLinks[i] = new Geometry("Box number " + Integer.toString(i), new Box(Container.containerLengte, 0.02f,Container.containerBreedte));
            //parkArrRechts[i].setMaterial(matC);
            //parkArrLinks[i].setMaterial(matC);
           //parkArrRechts[i].setLocalTranslation(0,0,breedteA - Container.containerBreedte - i*2*Container.containerBreedte);
            //parkArrLinks[i].setLocalTranslation(0,0,breedteA - Container.containerBreedte - i*2*Container.containerBreedte);
            //matC.setColor("Color", ColorRGBA.Blue);
            //matC.getAdditionalRenderState().setWireframe(true);
            //parkerenRechts.attachChild(parkArrRechts[i]);
            //parkerenLinks.attachChild(parkArrLinks[i]);
        //}
        //attachChild(parkerenRechts);
        //attachChild(parkerenLinks);
        
        //parkerenLinks.setLocalTranslation(-lengteA + Container.containerLengte,0,0);
        //parkerenRechts.setLocalTranslation(lengteA + Container.containerLengte,0,0);
        attachChild(opslagTerrein);
        attachChild(opslag);
        //createMotionPath();
        //createMotionControl();
        
        //kraan = assetManager.loadModel("Scenes/OpslagKraan.j3o");   
        kraan = assetManager.loadModel("Models/high/crane/storagecrane/crane.j3o");        
        kraan.setLocalScale(0.12f, 0.16f, 0.2f);
        kraan.rotate(0, FastMath.HALF_PI ,0);        
        attachChild(kraan);
        
        for (int x = 0; x < 47; x++) {
            for (int y = 0; y < 6; y++) {
                for (int z = 0; z < 6; z++) {
                    containerOpslag[x][y][z] = null;                       
                } 
            }
        }
        
    }
    
    public void maakParkeerPlaatsen(Vector3f locatie){
        parkeerPlaats = new ParkeerPlaats[12];
        locatie.z = locatie.z + breedteA + Container.containerBreedte;
        for(int i = 0; i < parkeerPlaats.length; i++){
            if(i < 6){  //links                
                parkeerPlaats[i] = new ParkeerPlaats(new Vector3f(locatie.x - lengteA - 1.5f*Container.containerLengte, 0, locatie.z - (i * 3*Container.containerBreedte)));
                
            } else{     //rechts
                parkeerPlaats[i] = new ParkeerPlaats(new Vector3f(locatie.x + lengteA + 1.5f*Container.containerLengte, 0, locatie.z + (i * 3*Container.containerBreedte)));
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
    
    
    
    
    private void createMotionPath(){        
        
        path = new MotionPath();    
        
//        path.addWayPoint(new Vector3f(0, 2.5f, 0));
          
          
//        path.addWayPoint(new Vector3f(-lengteA - 2*containerLengte, 2.5f, 0));
//        path.addWayPoint(new Vector3f(lengteA + 2*containerLengte, 2.5f, 0));        
//        path.addWayPoint(new Vector3f(0, 2.5f, 0));
        path.addWayPoint(new Vector3f(-lengteA - Container.containerLengte, 0, 0));
        for (int x = 0; x < 47; x++){
            path.addWayPoint(new Vector3f((-lengteA + 2*Container.containerLengte + x*2*Container.containerLengte),0,0));
        }
        
        path.addWayPoint(new Vector3f(lengteA + Container.containerLengte, 0, 0));
        
       
        
//        for (int x = 0; x < 46; x++) {
//            for (int y = 0; y < 6; y++) {
//                for (int z = 0; z < 6; z++) {
//                    path.addWayPoint(new Vector3f((-lengteA + 2*containerLengte + x*2*containerLengte), 
//                                                  (containerHoogte + y*2*containerHoogte), 
//                                                  (breedteA - containerBreedte - z*2*containerBreedte)));
//                    
//                }
//            }
//        }
        //path.enableDebugShape(assetManager, this);
        
     
    }
    
    private void createMotionControl(){
        motionControl = new MotionEvent(kraan,path);
        motionControl.setDirectionType(MotionEvent.Direction.Path);
        motionControl.setInitialDuration(40f);
        motionControl.setSpeed(4f);  
    }
}
