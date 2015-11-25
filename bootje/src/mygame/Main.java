package mygame;

import com.jme3.app.SimpleApplication;
import com.jme3.material.Material;
import com.jme3.math.ColorRGBA;
import com.jme3.math.FastMath;
import com.jme3.math.Vector3f;
import com.jme3.renderer.RenderManager;
import com.jme3.scene.Geometry;
import com.jme3.scene.Node;
import com.jme3.scene.shape.Box;
import com.jme3.scene.shape.Cylinder;
import com.jme3.scene.shape.Dome;
import com.jme3.scene.shape.Sphere;

/**
 * test
 * @author normenhansen
 */
public class Main extends SimpleApplication {

    public static void main(String[] args) {
        Main app = new Main();
        app.start();
    }
    Node Boot;
    @Override
    public void simpleInitApp() {
        //vormen
        Box b = new Box(1, 0.5f, 3);
        Cylinder c = new Cylinder(10, 25, 1f, 6f, true);
        Sphere d = new Sphere(10,50,1,false,false);
        Sphere e = new Sphere(10,50,1,false,false);
        //geometries
        Geometry geom = new Geometry("Box", b);
        Geometry geom2 = new Geometry("Cylinder", c);
        Geometry geom3 = new Geometry("Sphere", d);
        Geometry geom4 = new Geometry("Sphere", e);
        //materialen aanmaken
        Material mat = new Material(assetManager, "Common/MatDefs/Misc/Unshaded.j3md");
        mat.setColor("Color", ColorRGBA.Blue);
        //mat.getAdditionalRenderState().setWireframe(true);
        //geometries vastmaken aan materialen
        geom.setMaterial(mat);
        geom2.setMaterial(mat);
        geom3.setMaterial(mat);
        geom4.setMaterial(mat);
        //translations
        geom2.move(0,-0.5f,0);
        geom3.move(0,-0.5f,3);
        geom4.move(0,-0.5f,-3);

        Boot = new Node();
        Boot.attachChild(geom);
        Boot.attachChild(geom2);
        Boot.attachChild(geom3);
        Boot.attachChild(geom4);
        rootNode.attachChild(Boot);
    }

    @Override
    public void simpleUpdate(float tpf) {
        //TODO: add update code
    }

    @Override
    public void simpleRender(RenderManager rm) {
        //TODO: add render code
    }
}
