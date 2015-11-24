package mygame;

import com.jme3.app.SimpleApplication;
import com.jme3.material.Material;
import com.jme3.math.ColorRGBA;
import com.jme3.math.FastMath;
import com.jme3.renderer.RenderManager;
import com.jme3.scene.Geometry;
import com.jme3.scene.Node;
import com.jme3.scene.shape.Box;
import com.jme3.scene.shape.Cylinder;

/**
 * test
 * @author normenhansen
 */
public class Main extends SimpleApplication {

    public static void main(String[] args) {
        Main app = new Main();
        app.start();
    }
    
    Node vrachtauto;
    
    @Override
    public void simpleInitApp() {
        Box b = new Box(1, 1, 1);
        Box c = new Box(1, 0.2f, 1);
        Cylinder d = new Cylinder(10, 25, 0.4f, 0.5f, true);
        Cylinder e = new Cylinder(10, 25, 0.4f, 0.5f, true);
        Cylinder f = new Cylinder(10, 25, 0.4f, 0.5f, true);
        Cylinder g = new Cylinder(10, 25, 0.4f, 0.5f, true);
        
        Geometry geom = new Geometry("Box", b);
        Geometry geom2 = new Geometry("Box", c);
        Geometry geom3 = new Geometry("Cylinder", d);
        Geometry geom4 = new Geometry("Cylinder", e);
        Geometry geom5 = new Geometry("Cylinder", f);
        Geometry geom6 = new Geometry("Cylinder", g);

        Material mat = new Material(assetManager, "Common/MatDefs/Misc/Unshaded.j3md");
        mat.setColor("Color", ColorRGBA.Blue);
        //mat.getAdditionalRenderState().setWireframe(true);
        //set Materials
        geom.setMaterial(mat);
        geom2.setMaterial(mat);
        geom3.setMaterial(mat);
        geom4.setMaterial(mat);
        geom5.setMaterial(mat);
        geom6.setMaterial(mat);
        //translations
        geom2.move(0, -0.8f, 1.9f);
        float r = FastMath.DEG_TO_RAD * 90f; //90 graden draaien
        //rechter voorwiel
        geom3.rotate(0,r,0);
        geom3.move(1,-1,0);
        //linker voorwiel
        geom4.rotate(0,r,0);
        geom4.move(-1, -1, 0);
        //rechter achterwiel
        geom5.rotate(0,r,0);
        geom5.move(1,-1,2);
        //linker achterwiel
        geom6.rotate(0,r,0);
        geom6.move(-1,-1,2);
        //alles op de rootnode flikkeren
        vrachtauto = new Node();
        vrachtauto.attachChild(geom);
        vrachtauto.attachChild(geom2);
        vrachtauto.attachChild(geom3);
        vrachtauto.attachChild(geom4);
        vrachtauto.attachChild(geom5);
        vrachtauto.attachChild(geom6);
        rootNode.attachChild(vrachtauto);
        
    }

    @Override
    public void simpleUpdate(float tpf) {
        //vrachtauto.rotate(0, 0, tpf);
    }

    @Override
    public void simpleRender(RenderManager rm) {
        //TODO: add render code
    }
}
