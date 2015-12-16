/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mygame;

import com.jme3.math.Vector3f;
import java.util.ArrayList;
/**
 *
 * @author Robin
 */
public class Waypoint{
   public static ArrayList<Vector3f> waypoints = new ArrayList<Vector3f>();
    public static ArrayList<Vector3f> WaypointMaken(){
    // vierbaans linkerkant.
        // vierde rij               
        for (int i = 0; i < 77; i++) {
            waypoints.add(new Vector3f(-60.25f, 0.13f, 152f - (i*4)));
        }        
        // derde rij               
        for (int i = 0; i < 77; i++) {
            waypoints.add(new Vector3f(-60.89f, 0.13f, 152f - (i*4)));  
        }        
        // tweede rij              
        for (int i = 0; i < 77; i++) {
            waypoints.add(new Vector3f(-61.52f, 0.13f, 152f - (i*4))); 
        }       
        // eerste rij          
        for (int i = 0; i < 77; i++) {
            waypoints.add(new Vector3f(-62.15f, 0.13f, 152f - (4*i)));
        }        
        // vierbaans rechterkant
        //vierde rij
        for (int i = 0; i < 77; i++) {
            waypoints.add(new Vector3f(60.25f, 0.13f, 152f - (4*i)));    
        }        
        //derde rij       
        for (int i = 0; i < 77; i++) {
            waypoints.add(new Vector3f(60.89f, 0.13f, 152f - (4*i)));   
        }       
        //tweede rij              
        for (int i = 0; i < 77; i++) {
            waypoints.add(new Vector3f(61.52f, 0.13f, 152f - (4*i)));   
        }        
        //eerste rij       
        for (int i = 0; i < 77; i++) {
            waypoints.add(new Vector3f(62.15f, 0.13f, 152f - (4*i)));   
        }
        //links beneden hoekpunten
        waypoints.add(new Vector3f(-60.25f, 0.13f, 154.25f)); // hoek beneden binnenste
        waypoints.add(new Vector3f(-60.89f, 0.13f, 154.89f)); // hoek beneden 1 naar links
        waypoints.add(new Vector3f(-61.52f, 0.13f, 155.52f)); // hoek beneden 1 naar links
        waypoints.add(new Vector3f(-62.15f, 0.13f, 156.15f)); // hoek beneden buitenste links
        //links boven hoekpunten
        waypoints.add(new Vector3f(-60.25f, 0.13f, -154.25f)); // hoek boven binnenste
        waypoints.add(new Vector3f(-60.89f, 0.13f, -154.89f)); //hoek boven 1 naar links
        waypoints.add(new Vector3f(-61.52f, 0.13f, -155.52f)); // hoek boven 1 naar links
        waypoints.add(new Vector3f(-62.15f, 0.13f, -156.15f)); // hoek boven buitenste
        // rechts beneden hoekpunten
        waypoints.add(new Vector3f(60.25f, 0.13f, 154.25f)); // hoek beneden binnenste
        waypoints.add(new Vector3f(60.89f, 0.13f, 154.89f)); // hoek beneden 1 naar rechts
        waypoints.add(new Vector3f(61.52f, 0.13f, 155.52f)); // hoek beneden  1 naar rechts
        waypoints.add(new Vector3f(62.15f, 0.13f, 156.15f)); // hoek beneden buitenste
        // rechts boven hoekpunten
        waypoints.add(new Vector3f(60.25f, 0.13f, -154.25f)); // hoek boven binnenste
        waypoints.add(new Vector3f(60.89f, 0.13f, -154.89f)); // hoek boven 1 naar rechts
        waypoints.add(new Vector3f(61.52f, 0.13f, -155.52f)); // hoek boven 1 naar rechts
        waypoints.add(new Vector3f(62.15f, 0.13f, -156.15f)); // hoek boven buitenste
        //treinplatform beneden.
        waypoints.add(new Vector3f(-60.25f, 0.13f, 153f)); // uitgang
        waypoints.add(new Vector3f(-60.89f, 0.13f, 153f));
        waypoints.add(new Vector3f(-61.52f, 0.13f, 153f));
        waypoints.add(new Vector3f(-62.15f, 0.13f, 153f));
        waypoints.add(new Vector3f(-60.25f, 0.13f, 154f)); // ingang
        waypoints.add(new Vector3f(-60.89f, 0.13f, 154f));
        waypoints.add(new Vector3f(-61.52f, 0.13f, 154f));
        waypoints.add(new Vector3f(-62.15f, 0.13f, 154f));
        waypoints.add(new Vector3f(-66f, 0.13f, 153f)); // ingang bocht
        waypoints.add(new Vector3f(-66.7f, 0.13f, 154f));// uitgang bocht
        //treinplatform boven
        waypoints.add(new Vector3f(-60.25f, 0.13f, -153f));//ingang
        waypoints.add(new Vector3f(-60.89f, 0.13f, -153f));
        waypoints.add(new Vector3f(-61.52f, 0.13f, -153f));
        waypoints.add(new Vector3f(-62.15f, 0.13f, -153f));
        waypoints.add(new Vector3f(-60.25f, 0.13f, -154f));//uitgang
        waypoints.add(new Vector3f(-60.89f, 0.13f, -154f));
        waypoints.add(new Vector3f(-61.52f, 0.13f, -154f));
        waypoints.add(new Vector3f(-62.15f, 0.13f, -154f));
        waypoints.add(new Vector3f(-66f, 0.13f, -153f)); // ingang bocht
        waypoints.add(new Vector3f(-66.7f, 0.13f, -154f)); // uitgang bocht
        //treinrails rechterkant
        for (int i = 0; i < 30; i++) {
            waypoints.add(new Vector3f(-66f, 0.13f, 2.8f + (i*2.495f)));
        }
        //treinrails linkerkant
        for (int i = 0; i < 30; i++) {
            waypoints.add(new Vector3f(-66.7f, 0.13f, 2.8f + (i*2.495f)));
        }
        waypoints.add(new Vector3f(0,0,0));waypoints.add(new Vector3f(0,0,0)); // lege waypoints want ricardo.
        //zeeschip platform hoekpuntenlinks
        waypoints.add(new Vector3f(-60.89f, 0.13f, 162.2f));//ingang
        waypoints.add(new Vector3f(-61.52f, 0.13f, 162.9f));//uitgang
        //zeeschip platform hoekpunten rechts
        waypoints.add(new Vector3f(60.89f, 0.13f, 162.2f));//ingang
        waypoints.add(new Vector3f(61.52f, 0.13f, 162.9f));//uitgang
        for (int i = 0; i < 20; i++) {
            waypoints.add(new Vector3f(-58.2f + (i*2.4f), 0.13f, 162.2f)); // linkerzeeschip van links naar rechts, onderste baan            
        }
        for (int i = 0; i < 20; i++) {
            waypoints.add(new Vector3f(12.5f + (i*2.4f), 0.13f, 162.2f)); // rechter zeeschip van links naar rechts, onderste baan
        }
        for (int i = 0; i < 20; i++) {
            waypoints.add(new Vector3f(-58.2f + (i*2.4f), 0.13f, 162.9f)); // linkerzeeschip van links naar rechts, bovenste baan            
        }
        for (int i = 0; i < 20; i++) {
            waypoints.add(new Vector3f(12.5f + (i*2.4f), 0.13f, 162.9f)); // rechter zeeschip van links naar rechts, bovenste baan
        } waypoints.add(new Vector3f(0,0,0)); // lege waypoints want ricardo.
        //binnenvaarplatform, beneden
        waypoints.add(new Vector3f(60.25f, 0.13f, 153f)); // binnenbocht, ingang
        waypoints.add(new Vector3f(60.89f, 0.13f, 153f));
        waypoints.add(new Vector3f(61.52f, 0.13f, 153f));
        waypoints.add(new Vector3f(62.15f, 0.13f, 153f));
        waypoints.add(new Vector3f(60.25f, 0.13f, 154f)); // buitenbocht, uitgang
        waypoints.add(new Vector3f(60.89f, 0.13f, 154f));
        waypoints.add(new Vector3f(61.52f, 0.13f, 154f));
        waypoints.add(new Vector3f(62.15f, 0.13f, 154f));
        //hoekpunten beneden
        waypoints.add(new Vector3f(68.3f, 0.13f, 153f));// binnenbocht, ingang
        waypoints.add(new Vector3f(69f, 0.13f, 154f));// buitenbocht, uitgang
        //hoekpunten boven
        waypoints.add(new Vector3f(68.3f, 0.13f, 2f));// binnenbocht, ingang
        waypoints.add(new Vector3f(69f, 0.13f, 1f));// buitenbocht, uitgang
        //boven ingang, uitgang
        waypoints.add(new Vector3f(60.25f, 0.13f, 2f)); // binnenbocht, uitgang
        waypoints.add(new Vector3f(60.89f, 0.13f, 2f));
        waypoints.add(new Vector3f(61.52f, 0.13f, 2f));
        waypoints.add(new Vector3f(62.15f, 0.13f, 2f));
        waypoints.add(new Vector3f(60.25f, 0.13f, 1f)); // buitenbocht, ingang
        waypoints.add(new Vector3f(60.89f, 0.13f, 1f));
        waypoints.add(new Vector3f(61.52f, 0.13f, 1f));
        waypoints.add(new Vector3f(62.15f, 0.13f, 1f));
        //onderste binnenvaartschip buitenbaan
        for (int i = 0; i < 6; i++) {
            waypoints.add(new Vector3f(69f, 0.13f, 123.2f-(2.4f*i)));
        }
        //bovenste binnenvaartschip buitenbaan
        for (int i = 0; i < 6; i++) {
            waypoints.add(new Vector3f(69f, 0.13f, 45f-(2.4f*i)));
        }
        //onderste binnenvaartschip binnenbaan
        for (int i = 0; i < 6; i++) {
            waypoints.add(new Vector3f(68.3f, 0.13f, 123.2f-(2.4f*i)));
        }
        //bovenste binnenvaartschip binnenbaan
        for (int i = 0; i < 6; i++) {
            waypoints.add(new Vector3f(68.3f, 0.13f, 45f-(2.4f*i)));
        }
        // vrachtwagenplatform van beneden naar boven
        for (int i = 0; i < 20; i++) {
            waypoints.add(new Vector3f(69.1f, 0.13f, -8-(4*i)));
        }
        return waypoints;
    }
}

