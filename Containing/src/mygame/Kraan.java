/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mygame;

import com.jme3.animation.LoopMode;
import com.jme3.asset.AssetManager;
import com.jme3.cinematic.MotionPath;
import com.jme3.cinematic.MotionPathListener;
import com.jme3.cinematic.events.MotionEvent;
import com.jme3.math.Spline;
import com.jme3.math.Vector3f;
import com.jme3.scene.Node;
import com.jme3.scene.Spatial;

/**
 *
 * @author Sjoerd
 */
public abstract class Kraan extends Node implements MotionPathListener{
    //private String kraanID;
    private Vector3f positie;
    private MotionPath basePath = new MotionPath();//path of the base of the crane
    private MotionPath haakPath = new MotionPath();//path of the hook of the crane
    private MotionPath sliderPath = new MotionPath();//path of the slider of the crane
    private MotionEvent baseControl; //Controls the path of the base
    private MotionEvent haakControl; //Controls the path of the hook
    private MotionEvent sliderControl; //Control the path of the slider
    private Vector3f defPosBase; //default position of the base
    //private Vector3f doel;
    float Speed = 3f;
    AssetManager assetManager;
    Node rootNode;
    public MotionPath path;
    public MotionEvent motionControl;
    /**
     * Base spatial
     */
    protected Spatial basis;
    /**
     * Hook spatial
     */
    protected Spatial haak;
    /**
     * Slider spatial
     */
    protected Spatial slider;
    /**
     * Slider node
     */
    protected Node sNode = new Node();
    /**
     * Hook node
     */
    protected Node hNode = new Node(); 
    /**
     * Base duration
     */
    protected float baseDur = 2f;
    /**
     * Hook duration
     */
    protected float hookDur = 2f;
    /**
     * Slider duration
     */
    protected float sliDur = 2f;
     /**
     * Target position
     */
    protected Vector3f doel = null;
    /**
     * Container
     */
    protected Container cont = null;
    
    protected int hoogte;
    
    public Kraan(Spatial base, Spatial slider, Spatial hook, Vector3f positie, Node rootNode, AssetManager assetManager){
        this.positie = positie;
        this.basis = base.clone();
        this.slider = slider.clone();
        this.haak = hook.clone();
        this.rootNode = rootNode;
        this.assetManager = assetManager;
        this.doel = null;
        
        this.attachChild(this.basis);
        
        hNode.attachChild(this.haak);        
        sNode.attachChild(hNode);        
        sNode.attachChild(this.slider);
         
        this.attachChild(this.sNode);
        
        baseControl = new MotionEvent(this, basePath, baseDur / Speed, LoopMode.DontLoop);
        haakControl = new MotionEvent(this.hNode, haakPath, hookDur / Speed, LoopMode.DontLoop);
        sliderControl = new MotionEvent(this.sNode, sliderPath, sliDur / Speed, LoopMode.DontLoop);
        
        basePath.addListener(this);
        haakPath.addListener(this);
        sliderPath.addListener(this);
        
        basePath.setPathSplineType(Spline.SplineType.Linear);
        sliderPath.setPathSplineType(Spline.SplineType.Linear);
        haakPath.setPathSplineType(Spline.SplineType.Linear);
    }
    
    public void update(float tpf){
         
        
    }
        public void verplaatsKraanX(Vector3f target, int hoogte, Container c){   
        this.hoogte = hoogte;
        this.cont =  c;
        Vector3f start = new Vector3f(this.getLocalTranslation());       
        doel = new Vector3f(target);
        Vector3f bestemming = new Vector3f(target.x,0,0);
        maakBeweging(baseControl, basePath, baseDur, start, bestemming);       
    }
    
    // Verplaats de slider van de kraan. (Z-richting)
    public void verplaatsSliderZ(Vector3f target){
        Vector3f start = new Vector3f(sNode.getLocalTranslation());           
        Vector3f bestemming = new Vector3f(-target.z*9,0,0);
        //Vector3f bestemming = new Vector3f(new Vector3f(0, 0, target.x));
        maakBeweging(sliderControl, sliderPath, sliDur, start, bestemming);

        System.out.println("doel" +doel); 
        System.out.println("start"+start);
        System.out.println("bestemming"+bestemming);
    }
    
    public void verplaatsHaakY(Vector3f target){
        //CollisionResults results = new CollisionResults();
        //cont.collideWith(hNode, results);
        
        Vector3f start = hNode.getLocalTranslation();
        System.out.println(start);
        Vector3f bestemming = new Vector3f(0, ((-23.5f)+3.2f*hoogte),0);
        maakBeweging(haakControl, haakPath, sliDur, start, bestemming);
        System.out.println("hNOde" + hNode.getLocalTranslation());
        System.out.println("doel haak"+doel); 
        System.out.println("target haak"+target);
        System.out.println("bestemming haaky:" + bestemming);
        if(hNode.getLocalTranslation() == doel){
            System.out.println("NICE");
        }
        
        
        
            //CollisionResult closest  = results.getClosestCollision();
            //System.out.println("Distance? " + closest.getDistance() );
        
            //maakBeweging(haakControl, haakPath, sliDur, start, test);
        
    }
    public void maakBeweging(MotionEvent mC, MotionPath mP, Float duration, Vector3f start, Vector3f bestemming) {
        
        if(start.distance(bestemming)>0) {//if spatial nog niet op gewenste positie        
       //     mP.clearWayPoints();
            mP.addWayPoint(start);
            mP.addWayPoint(bestemming);
            mP.enableDebugShape(assetManager, rootNode);
            setEventDuration(mC, mP, duration);
            mC.play(); 
            System.out.println("huidige positie"+sNode.getLocalTranslation());
        }
        else {       
      //      niks
            System.out.println("niks");
        }
    }
    
    private void setEventDuration(MotionEvent event, MotionPath path, float defDur){
        if(path.getNbWayPoints()>1) {
            event.setInitialDuration(path.getLength()/(defDur*Speed));
        }
    } 

 
    @Override
    public void onWayPointReach(MotionEvent motionControl, int wayPointIndex){ 
        
        if(wayPointIndex == 1){
            
            if(motionControl.equals(baseControl)){
                verplaatsSliderZ(new Vector3f(doel));                
            }
            else if(motionControl.equals(sliderControl)){
                verplaatsHaakY(doel);               
                doel = null;
            }
            else if(motionControl.equals(haakControl)){
                System.out.println("klaar");
                System.out.println("dinges: " + hNode.getLocalTranslation());
                Vector3f xs = new Vector3f(hNode.getLocalTranslation().x,hNode.getLocalTranslation().y,hNode.getLocalTranslation().z);
                System.out.println(xs);
                //if(doel)
                
                hNode.attachChild(cont);
                
            }
        }
    }
}
