package mygame;

import com.jme3.app.SimpleApplication;
import com.jme3.light.DirectionalLight;
import com.jme3.material.Material;
import com.jme3.math.ColorRGBA;
import com.jme3.math.FastMath;
import com.jme3.math.Plane;
import com.jme3.math.Quaternion;
import com.jme3.math.Vector2f;
import com.jme3.math.Vector3f;
import com.jme3.renderer.RenderManager;
import com.jme3.renderer.queue.RenderQueue.ShadowMode;
import com.jme3.scene.Geometry;
import com.jme3.scene.Node;
import com.jme3.scene.Spatial;
import com.jme3.scene.shape.Box;
import com.jme3.scene.shape.Quad;
import com.jme3.util.SkyFactory;
import com.jme3.water.SimpleWaterProcessor;

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
    boolean useWater = true;
    private Vector3f lightPos =  new Vector3f(33,12,-29);
    
    public static void main(String[] args) {
        Main app = new Main();
        app.start();
    }

    @Override
    public void simpleInitApp() {
        initScene();
        
        OpslagKraan opslagKraan1 = new OpslagKraan(assetManager);
        ZeeschipKraan zeeschipKraan1 = new ZeeschipKraan(assetManager);
        BinnenvaartKraan binnenvaartKraan1 = new BinnenvaartKraan(assetManager);
        VrachtwagenKraan vrachtwagenKraan1 = new VrachtwagenKraan(assetManager);
        TreinKraan treinKraan1 = new TreinKraan(assetManager);
        //create terrain
        Box opslagBox = new Box(155, 0.01f, 60);
        Box wegBox = new Box(157.4f, 0, 62.4f);
        Box vrachtwagenBinnenvaart = new Box(78.7f, 0, 3);
        Box treinBox = new Box(157.4f, 0, 3);
        Box zeevaartBox = new Box(-3, 0, 68.4f);
        
        Geometry Opslag = new Geometry("Box",opslagBox);
        Geometry weg = new Geometry("Box",wegBox);
        Geometry vrachtwagenvervoer = new Geometry("Box",vrachtwagenBinnenvaart);
        Geometry binnenvaart = new Geometry("Box",vrachtwagenBinnenvaart);
        Geometry treinplatform = new Geometry("Box",treinBox);
        Geometry zeevaart = new Geometry("Box",zeevaartBox);
        
        Material matb = new Material(assetManager, "Common/MatDefs/Misc/Unshaded.j3md");
        Material matc = new Material(assetManager, "Common/MatDefs/Misc/Unshaded.j3md");
        Material matd = new Material(assetManager, "Common/MatDefs/Misc/Unshaded.j3md");
        Material mate = new Material(assetManager, "Common/MatDefs/Misc/Unshaded.j3md");
        Material matf = new Material(assetManager, "Common/MatDefs/Misc/Unshaded.j3md");
        Material matg = new Material(assetManager, "Common/MatDefs/Misc/Unshaded.j3md");
        
        
        matb.setColor("Color", ColorRGBA.Blue);
        matc.setColor("Color", ColorRGBA.DarkGray);
        matd.setColor("Color", ColorRGBA.Green);
        mate.setColor("Color", ColorRGBA.Red);
        matf.setColor("Color", ColorRGBA.Yellow);
        matg.setColor("Color", ColorRGBA.Orange);
        
        matb.getAdditionalRenderState().setWireframe(false);
        matf.getAdditionalRenderState().setWireframe(false);
        
        Opslag.setMaterial(matb);
        weg.setMaterial(matc);
        vrachtwagenvervoer.setMaterial(matd);
        binnenvaart.setMaterial(mate);
        treinplatform.setMaterial(matf);
        zeevaart.setMaterial(matg);
        
        vrachtwagenvervoer.setLocalTranslation(78.7f, 0, 65.4f);
        binnenvaart.setLocalTranslation(-78.7f, 0, 65.4f);
        treinplatform.setLocalTranslation(0, 0, -65.4f);
        zeevaart.setLocalTranslation(-160.4f, 0, 0);
        opslagKraan1.setLocalTranslation(0, 2, 0);
        zeeschipKraan1.setLocalTranslation(-160, 2, 0);
        binnenvaartKraan1.setLocalTranslation(-78, 2, 65);
        vrachtwagenKraan1.setLocalTranslation(78, 1, 65);
        treinKraan1.setLocalTranslation(0, 1, -65);
        
        rootNode.attachChild(Opslag);
        rootNode.attachChild(weg);
        rootNode.attachChild(vrachtwagenvervoer);
        rootNode.attachChild(binnenvaart);
        rootNode.attachChild(treinplatform);
        rootNode.attachChild(zeevaart);
        rootNode.attachChild(opslagKraan1);
        rootNode.attachChild(zeeschipKraan1);
        rootNode.attachChild(binnenvaartKraan1);
        rootNode.attachChild(vrachtwagenKraan1);
        rootNode.attachChild(treinKraan1);
        
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
    

    public void initScene(){
        flyCam.setMoveSpeed(20.0f);
        
        sceneNode = new Node("Scene");
        
        // load sky
        sceneNode.attachChild(SkyFactory.createSky(assetManager, "Textures/Sky/Bright/BrightSky.dds", false));
        rootNode.attachChild(sceneNode);
        
           
        /** A white, directional light source */ 
        DirectionalLight sun = new DirectionalLight();
        sun.setDirection((new Vector3f(-0.5f, -0.5f, -0.5f)).normalizeLocal());
        sun.setColor(ColorRGBA.White);
        rootNode.addLight(sun); 
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
