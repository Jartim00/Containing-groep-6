package mygame;

import com.bulletphysics.collision.shapes.CollisionShape;
import com.jme3.app.SimpleApplication;
import com.jme3.bullet.BulletAppState;
import com.jme3.bullet.control.RigidBodyControl;
import com.jme3.bullet.util.CollisionShapeFactory;
import com.jme3.light.DirectionalLight;
import com.jme3.material.Material;
import com.jme3.math.ColorRGBA;
import com.jme3.math.Vector3f;
import com.jme3.renderer.RenderManager;
import com.jme3.scene.Geometry;
import com.jme3.scene.Node;
import com.jme3.scene.Spatial;
import com.jme3.scene.shape.Box;
import com.jme3.util.SkyFactory;
import com.jme3.water.SimpleWaterProcessor;
import java.util.ArrayList;

/**
 * test
 * @author normenhansen
 */
public class Main extends SimpleApplication {    

    //Material mat;
    Spatial waterPlane;
    Geometry lightSphere;
    SimpleWaterProcessor waterProcessor;
    Node sceneNode;
    Node opslagNode;
    boolean useWater = true;
    private Vector3f lightPos =  new Vector3f(33,12,-29);
    
    ArrayList<Container> containers = new ArrayList();
    Opslagstrook[] opslagstroken = new Opslagstrook[77];
    
    public static void main(String[] args) {
        Main app = new Main();
        app.start();
    }

    @Override
    public void simpleInitApp() {        
        
        initScene();
        initWater();
        initOpslag();
        
        // plaatst op elke strook 1 container
//        for (int i = 0; i < opslagstroken.length; i++) {
//            containers.add(new Container(assetManager));
//            containers.get(i).setLocalTranslation(0,0.24f,0);
//            opslagstroken[i].attachChild(containers.get(i));
//            //opslagstroken[0].storeContainer(containers.get(i));            
//        }
        
//        // Maximale opslag 0-2 fps!!
//        for (int i = 0; i < opslagstroken.length; i++) {
//            for (int x = 0; x < 46; x++) {
//                for (int y = 0; y < 6; y++) {
//                    for (int z = 0; z < 6; z++) {
//                        Container container = new Container(assetManager);
//                        opslagstroken[i].storeContainer(container, x, y, z);
//                    }     
//                }
//            
//            }                   
//        }
        
        Container c1 = new Container(assetManager);
        opslagstroken[2].storeContainer(c1, 0, 0, 0);
        
        for (int x = 0; x < 46; x++) {
            Container container = new Container(assetManager);
            opslagstroken[0].storeContainer(container, x, 0, 0);
        }
        
        for (int x = 0; x < 46; x++) {
            for (int y = 0; y < 6; y++) {
                for (int z = 0; z < 6; z++) {
                    Container container = new Container(assetManager);
                    opslagstroken[1].storeContainer(container, x, y, z);
                }     
            }
            
        }        
        
    }

    public void initScene(){
        flyCam.setMoveSpeed(150.0f);
        
        sceneNode = new Node("Scene");
        
        // load sky
        sceneNode.attachChild(SkyFactory.createSky(assetManager, "Textures/Sky/Bright/BrightSky.dds", false));
        rootNode.attachChild(sceneNode);
        
        Box b = new Box(80.0f, 20.0f, 175.0f);
        Geometry floor = new Geometry("floor", b);
        Material floorMat = new Material(assetManager, "Common/MatDefs/Misc/Unshaded.j3md");
        floorMat.setColor("Color", ColorRGBA.DarkGray);
        floor.setMaterial(floorMat);
        floor.setLocalTranslation(0.0f,-20.0f,0.0f);
        sceneNode.attachChild(floor);       
        
//        Box b1 = new Box(60.0f, 0.0001f, 155.0f);
//        Geometry opslag = new Geometry("opslag", b1);
//        Material mat = new Material(assetManager, "Common/MatDefs/Misc/Unshaded.j3md");
//        mat.setColor("Color", ColorRGBA.Gray);
//        opslag.setMaterial(mat);


        Spatial S = assetManager.loadModel("Models/Ninja/Ninja.mesh.xml");
        S.scale(0.05f);
        S.rotate(0.0f, -3.0f, 0.0f);
        S.setLocalTranslation(0.0f, 0.0f, 0.0f);
        rootNode.attachChild(S);
           
        /** A white, directional light source */ 
        DirectionalLight sun = new DirectionalLight();
        sun.setDirection((new Vector3f(-0.5f, -0.5f, -0.5f)).normalizeLocal());
        sun.setColor(ColorRGBA.White);
        rootNode.addLight(sun);  

    }
    
    public void initOpslag(){        
        
        opslagNode = new Node("Opslag");
        
        for (int i = 0; i < opslagstroken.length; i++) {
            opslagstroken[i] = new Opslagstrook(assetManager);
            opslagNode.attachChild(opslagstroken[i]);  
            opslagstroken[i].setLocalTranslation(0, 0, (155.0f + i * -4f));
        }
        
        sceneNode.attachChild(opslagNode);
       
    }
    
    public void initWater(){
        //create processor
        waterProcessor = new SimpleWaterProcessor(assetManager);
        waterProcessor.setReflectionScene(sceneNode);
        waterProcessor.setDebug(true);
        viewPort.addProcessor(waterProcessor);
        
        //create water quad
        //waterPlane = waterProcessor.createWaterGeometry(100, 100);
        waterPlane=(Spatial)  assetManager.loadModel("Models/WaterTest/WaterTest.mesh.xml");
        waterPlane.setMaterial(waterProcessor.getMaterial());
        waterPlane.setLocalScale(2000);
        waterPlane.setLocalTranslation(-5, -10, 5);
        
        rootNode.attachChild(waterPlane);
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
