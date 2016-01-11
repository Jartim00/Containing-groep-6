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
public class AGV extends Node {
   
    private AssetManager assetManager;
    public ParkeerPlaats plaats;
   public static int[][] vrijeParkeerplaatsL = new int[77][6]; // list met 6x77 vrije parkeerplaatsen voor de linkerkant
    public static int[][] vrijeParkeerplaatsR = new int [77][6]; // list met 6x77 vrije parkeerplaatsen voor de rechterkant
    public AGV(AssetManager assetManager) 
    {        
        this.assetManager = assetManager;
    
        Cylinder a = new Cylinder(20, 50, 0.1f, 0.05f, true); // de cylinder die het wiel moet voorstellen

        Box b = new Box(0.25f, 0.05f, 1.4f); // de box die de body van de agv voorstelt
        Geometry geom = new Geometry("Box", b); // deze box wordt hier aan een geometry vastgezet
        Geometry geom2 = new Geometry("Cylinder", a); // 4 keer wordt de cylinder/wiel aan een geometry vastgezet
        Geometry geom3 = new Geometry("Cylinder", a);
        Geometry geom4 = new Geometry("Cylinder", a);
        Geometry geom5 = new Geometry("Cylinder", a);

        Material mat = new Material(assetManager, "Common/MatDefs/Misc/Unshaded.j3md");
        mat.setColor("Color",new ColorRGBA(1,1,1,1)); // hier wordt het materiaal gemaakt voor de body van de agv
        Material mat2 = new Material(assetManager, "Common/MatDefs/Misc/Unshaded.j3md");
        mat2.setColor("Color", ColorRGBA.Black); // hier wordt het materiaal gemaakt voor de wielen van de agv.
        geom.setMaterial(mat); // hier wordt het agvmateriaal aan de geometry vastgezet
        geom2.setMaterial(mat2); // hier wordt het wielmateriaal aan de geometry vastgezet
        geom3.setMaterial(mat2);
        geom4.setMaterial(mat2);
        geom5.setMaterial(mat2);

        geom2.setLocalTranslation(0.28f, -0.05f,1f); // hier worden de posities van de wielen aangegeven
        geom3.setLocalTranslation(0.28f, -0.05f,-1);
        geom4.setLocalTranslation(-0.28f, -0.05f,1f);
        geom5.setLocalTranslation(-0.28f, -0.05f,-1f);
        float r = FastMath.DEG_TO_RAD * 90f; // variabele voor de rotatie van de wielen
        geom2.rotate(0,r,0); // hier worden de wielen 90 graden gedraaid zodat ze goed staan ten op zichte van 
        geom3.rotate(0,r,0); // de body van de agv
        geom4.rotate(0,r,0);
        geom5.rotate(0,r,0);
        attachChild(geom); // hier worden alle geometry's vastgemaakt aan de node en elkaar,
        attachChild(geom2);// zodat het een geheel wordt.
        attachChild(geom3);
        attachChild(geom4);
        attachChild(geom5);
        rotate(0,FastMath.HALF_PI, 0); // en hier wordt de hele agv nog 90 graden gedraaid zodat
                                       // de agv goed het motionpath volgt, word deze niet gedraaid dan
                                       // rijd de agv niet rechtuit maar loopt hij als een krab.
    }
    
        public void parkeerAGV(ParkeerPlaats plaats) {
        this.setLocalTranslation(plaats.translation);        
        this.plaats = plaats;
//        plaats.bezet = true;
    }
        public static int vrijeParkeerplek(int laannummer){
        int laannr = -1;
        if(laannummer > 307 && laannummer < 385){
            laannr = laannummer-308;
        }
        for (int i = 0; i < 6; i++) {
            if(laannummer > 307 && laannummer < 385){
                if(vrijeParkeerplaatsR[laannr][i] == 0){
                     return i;
                 }
             }
             else{
                 if(vrijeParkeerplaatsL[laannummer][i] == 0){
                     return i;
                 }
             }
         }
        return -1;
    }
}
