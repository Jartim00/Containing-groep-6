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

/**
 * test
 * @author normenhansen
 */
public class Main extends SimpleApplication {

    public static void main(String[] args) {
        Main app = new Main();
        app.start();
    }
    Node AGV;
    
    @Override
    public void simpleInitApp() {
        Cylinder a = new Cylinder(10, 25, 0.4f, 0.5f, true);
        Cylinder c = new Cylinder(10, 25, 0.4f, 0.5f, true);
        Cylinder d = new Cylinder(10, 25, 0.4f, 0.5f, true);
        Cylinder e = new Cylinder(10, 25, 0.4f, 0.5f, true);
        Box b = new Box(1, 0.25f, 1);
        Geometry geom = new Geometry("Box", b);
        Geometry geom2 = new Geometry("Cylinder", a);
        Geometry geom3 = new Geometry("Cylinder", c);
        Geometry geom4 = new Geometry("Cylinder", d);
        Geometry geom5 = new Geometry("Cylinder", e);

        Material mat = new Material(assetManager, "Common/MatDefs/Misc/Unshaded.j3md");
        mat.setColor("Color", ColorRGBA.Blue);
        mat.getAdditionalRenderState().setWireframe(true);
        geom.setMaterial(mat);
        geom2.setMaterial(mat);
        geom3.setMaterial(mat);
        geom4.setMaterial(mat);
        geom5.setMaterial(mat);
        float r = FastMath.DEG_TO_RAD * 90f;
        
        geom2.move(1,0,1);
        geom2.rotate(0,r,0);
        
        geom3.move(-1,0,1);
        geom3.rotate(0,r,0);
        
        geom4.move(1,0,-1);
        geom4.rotate(0,r,0);
        
        geom5.move(-1,0,-1);
        geom5.rotate(0,r,0);
        
        AGV = new Node();
        AGV.attachChild(geom);
        AGV.attachChild(geom2);
        AGV.attachChild(geom3);
        AGV.attachChild(geom4);
        AGV.attachChild(geom5);
        rootNode.attachChild(AGV);
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
