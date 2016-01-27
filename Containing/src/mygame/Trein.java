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
import static mygame.TreinPlatform.treinNode;
/**
 *
 * @author Robin
 */
public class Trein extends Node 
{
    private AssetManager assetManager;
    
    static int containerPlaatsen;
    
    Container[][][] containerOpslag = new Container[containerPlaatsen][1][1];

    //maak opslagkraan
    public Trein(AssetManager assetManager) 
{
            this.assetManager = assetManager;
            
            
            Box trein = new Box(1.5f,0.36f,0.3f);
            Box wagon = new Box(1.2f, 0.1f, 0.3f);
            Box kop = new Box(0.3f, 0.05f, 0.05f);
            Cylinder wiel = new Cylinder(20, 50, 0.1f, 0.05f, true);
    
            Geometry treinModel = new Geometry("Box", trein);
            Geometry wiel1 = new Geometry("Cylinder", wiel);
            Geometry wiel2 = new Geometry("Cylinder", wiel);
            Geometry wiel3 = new Geometry("Cylinder", wiel);
            Geometry wiel4 = new Geometry("Cylinder", wiel);
            Geometry wiel5 = new Geometry("Cylinder", wiel);
            Geometry wiel6 = new Geometry("Cylinder", wiel);
            Geometry wiel7 = new Geometry("Cylinder", wiel);
            Geometry wiel8 = new Geometry("Cylinder", wiel);
            Geometry wiel9 = new Geometry("Cylinder", wiel);
            Geometry wiel10 = new Geometry("Cylinder", wiel);
            Geometry wiel11 = new Geometry("Cylinder", wiel);
            Geometry wiel12 = new Geometry("Cylinder", wiel);
            Geometry koppel = new Geometry("Box", kop);
            Geometry wagonModel = new Geometry("Box", wagon);
            
            Geometry wielw1 = new Geometry("Cylinder", wiel);
            Geometry wielw2 = new Geometry("Cylinder", wiel);
            Geometry wielw3 = new Geometry("Cylinder", wiel);
            Geometry wielw4 = new Geometry("Cylinder", wiel);

            
            Material matTrein = new Material(assetManager, "Common/MatDefs/Misc/Unshaded.j3md");
            Material matWiel = new Material(assetManager, "Common/MatDefs/Misc/Unshaded.j3md");
            Material matWagon = new Material(assetManager, "Common/MatDefs/Misc/Unshaded.j3md");
            
            matTrein.setColor("Color", ColorRGBA.Brown);            
            matWiel.setColor("Color", ColorRGBA.Black);
            matWagon.setColor("Color", ColorRGBA.Brown);
            
            treinModel.setMaterial(matTrein);
            
            wagonModel.setMaterial(matWagon);
                        
            wiel1.setMaterial(matWiel);
            wiel2.setMaterial(matWiel);
            wiel3.setMaterial(matWiel);
            wiel4.setMaterial(matWiel);
            wiel5.setMaterial(matWiel);
            wiel6.setMaterial(matWiel);
            wiel7.setMaterial(matWiel);
            wiel8.setMaterial(matWiel);
            wiel9.setMaterial(matWiel);
            wiel10.setMaterial(matWiel);
            wiel11.setMaterial(matWiel);
            wiel12.setMaterial(matWiel);
            koppel.setMaterial(matWiel);
            wielw1.setMaterial(matWiel);
            wielw2.setMaterial(matWiel);
            wielw3.setMaterial(matWiel);
            wielw4.setMaterial(matWiel);
            
            wagonModel.setLocalTranslation(-2.8f, -0.25f, 0);
            koppel.setLocalTranslation(-1.4f, -0.3f, 0);
            wiel1.setLocalTranslation(1.3f, -0.33f, 0.31f);
            wiel2.setLocalTranslation(1, -0.33f, 0.31f);
            wiel11.setLocalTranslation(0.7f, -0.33f, 0.31f);
            wiel3.setLocalTranslation(-0.6f, -0.33f, 0.31f);
            wiel4.setLocalTranslation(-0.9f, -0.33f, 0.31f);
            wiel5.setLocalTranslation(-1.2f, -0.33f, 0.31f);
            wiel6.setLocalTranslation(1.3f, -0.33f, -.31f);
            wiel7.setLocalTranslation(1, -0.33f, -.31f);
            wiel12.setLocalTranslation(0.7f, -0.33f, -.31f);
            wiel8.setLocalTranslation(-0.6f, -0.33f, -.31f);
            wiel9.setLocalTranslation(-0.9f, -0.33f, -.31f);
            wiel10.setLocalTranslation(-1.2f, -0.33f, -.31f);
            
            wielw1.setLocalTranslation(-2f, -0.33f, 0.31f);
            wielw2.setLocalTranslation(-3.5f, -0.33f, 0.31f);
            wielw3.setLocalTranslation(-2f, -0.33f, -0.31f);
            wielw4.setLocalTranslation(-3.5f, -0.33f, -0.31f);
            
            attachChild(treinModel);
            
            attachChild(wagonModel);
            
            attachChild(wiel1);
            attachChild(wiel2);
            attachChild(wiel3);
            attachChild(wiel4);
            attachChild(wiel5);
            attachChild(wiel6);
            attachChild(wiel7);
            attachChild(wiel8);
            attachChild(wiel9);
            attachChild(wiel10);
            attachChild(wiel11);
            attachChild(wiel12);
            attachChild(koppel);
            attachChild(wielw1);
            attachChild(wielw2);
            attachChild(wielw3);
            attachChild(wielw4);
            
            float a = 2.5f; //grootte van de wagon(2.4) + de koppeling(0.1) 
            float b = 2.4f;
            
            // forloop waarmee het aantal wagons worden aangemaakt waar de trein uitbestaat
            for(int i=1; i<containerPlaatsen; i++){

            Geometry wielw5 = new Geometry("Cylinder", wiel);
            Geometry wielw6 = new Geometry("Cylinder", wiel);
            Geometry wielw7 = new Geometry("Cylinder", wiel);
            Geometry wielw8 = new Geometry("Cylinder", wiel);
            Geometry koppel2 = new Geometry("Box", kop);
            Geometry wagonModel2 = new Geometry("Box", wagon);

            wagonModel2.setMaterial(matWagon);
            
            wielw5.setMaterial(matWiel);
            wielw6.setMaterial(matWiel);
            wielw7.setMaterial(matWiel);
            wielw8.setMaterial(matWiel);
            koppel2.setMaterial(matWiel);

            wagonModel2.setLocalTranslation(-2.8f - a, -0.25f, 0);
            koppel2.setLocalTranslation(-1.4f - a, -0.3f, 0);
            wielw5.setLocalTranslation(-2f - a, -0.33f, 0.31f);
            wielw6.setLocalTranslation(-3.5f - b, -0.33f, 0.31f);
            wielw7.setLocalTranslation(-2f - a, -0.33f, -0.31f);
            wielw8.setLocalTranslation(-3.5f - b, -0.33f, -0.31f);
            a = a + 2.5f;   //De hoeveelheid waarmee iedere wagon van de andere wagon word afgezet  
            b = b + 2.5f;

            attachChild(wagonModel2);
            
            attachChild(wielw5);
            attachChild(wielw6);
            attachChild(wielw7);
            attachChild(wielw8);
            attachChild(koppel2);
            
            
            }
            for (int x = 0; x < containerPlaatsen; x++) {
                containerOpslag[x][0][0] = null;
            }
            
            setLocalTranslation(0,0.5f,0);
} 
    //Zelfde methode als bij de opslagstrook en de andere vervoersvoertuigen alleen dan word hier maar gebruik gemaakt van 1 variabele.
    public void storeContainer(Container container, int x)
    {

        if(containerOpslag[x][0][0] == null)
            containerOpslag[x][0][0] = container;        
        
        attachChild(container);
        container.setLocalTranslation( (-2.8f - x*(2*Container.containerLengte + 0.1f)),    // -trein lengte -containerpositie * (2* containerlengte + afstand tussen wagons)
                                       (0.1f), 
                                       (0));
    }
    
}