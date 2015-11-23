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
import java.util.Date;
import javax.vecmath.Point3d;

/**
 *
 * @author Sjoerd
 */
public class Container extends Node {
    //private String record_id;
    private int container_nr;
    private Date aankomstDatum;
    private Date vertrekDatum;
    private String binnenkomstVervoer;
    private String vertrekVervoer;
    private String eigenaar;
    private String aanvoerMaatschappij;
    private String afvoerMaatschappij;
    private String inhoud;
    private int gewicht;
    private Point3d locatie;
    private final AssetManager assetManager;
    
    private final float lengte = 1.2f;
    private final float breedte = 0.25f;
    private final float hoogte = 0.26f;    
    
    public Container(AssetManager manager){
        this.assetManager = manager;
        Box b = new Box(lengte, hoogte, breedte); 
        //Box b = new Box(0.25f,0.26f,1.22f);        
        Geometry cont = new Geometry("cont", b);        
        Material contMat = new Material(assetManager, "Common/MatDefs/Misc/Unshaded.j3md");
        contMat.setColor("Color", ColorRGBA.randomColor());
        cont.setMaterial(contMat);
        attachChild(cont);        
    }
    
   
}
