package mygame;

import com.bulletphysics.collision.shapes.CollisionShape;
import com.jme3.app.SimpleApplication;
import com.jme3.bullet.control.RigidBodyControl;
import com.jme3.bullet.util.CollisionShapeFactory;
import com.jme3.cinematic.Cinematic;
import com.jme3.cinematic.MotionPath;
import com.jme3.cinematic.MotionPathListener;
import com.jme3.cinematic.events.MotionEvent;
import com.jme3.cinematic.events.MotionTrack;
import com.jme3.input.KeyInput;
import com.jme3.input.controls.ActionListener;
import com.jme3.input.controls.KeyTrigger;
import com.jme3.light.DirectionalLight;
import com.jme3.material.Material;
import com.jme3.math.ColorRGBA;
import com.jme3.math.FastMath;
import com.jme3.math.Quaternion;
import com.jme3.math.Spline.SplineType;
import com.jme3.math.Vector3f;
import com.jme3.renderer.RenderManager;
import com.jme3.scene.Geometry;
import com.jme3.scene.Node;
import com.jme3.scene.Spatial;
import com.jme3.scene.shape.Box;
import com.jme3.util.SkyFactory;
import com.jme3.water.SimpleWaterProcessor;
import java.util.ArrayList;
import java.io.IOException;
import java.net.InetAddress;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import static mygame.AGV.vrijeParkeerplaatsL;
import static mygame.AGV.vrijeParkeerplaatsR;
import static mygame.ZeeschipPlatform.zeeschipNode;


public class Main extends SimpleApplication{    

    //Material mat;
    Spatial waterPlane;
    Geometry lightSphere;
    SimpleWaterProcessor waterProcessor;
    Node sceneNode;
    Node opslagNode;
    Node treinPlatformNode;
    Node VrachtwagenplatformNode;
    Node zeeschipPlatformNode;
    
    public float snelheid = 1f;
    
    public static float opslagLengte = 154;
    public static float opslagBreedte = 60;
    public static float wegBreedte = 1.2f;
    
    private final float terreinLengte = 154 + 2.4f + 8;
    private final float terreinBreedte = 60 + 2.4f + 8;
    
    boolean useWater = true;
    private Vector3f lightPos =  new Vector3f(33,12,-29);
    
    ArrayList<Container> containers = new ArrayList();
    Opslagstrook[] opslagstroken = new Opslagstrook[77];
    ArrayList<AGV> agvs = new ArrayList<AGV>();

    Schip zeeschip1;
    Schip zeeschip2;
    
    //socketdeclaratie
    private static ClientSocket s1;
    private static int port = 49876;
    
    private boolean testrun;
    
    private List<Vector3f> waypoints;
    
    public static void main(String[] args) {
        Main app = new Main();
        app.start();
    }

    @Override
    public void simpleInitApp(){        
        
        initScene();
        initWater();
        initLight();
        initOpslag();
        initTreinPlatform();
	initVrachtwagenplatform();
        initZeeschipPlatform();
        initBinnenvaartPlatform();
        Waypoint.WaypointMaken();
        initInputs();
        
        //Init AGVs
          initAGVs();
//        OpslagKraan opslagKraan1 = new OpslagKraan(assetManager);
//        ZeeschipKraan zeeschipKraan1 = new ZeeschipKraan(assetManager);
//        BinnenvaartKraan binnenvaartKraan1 = new BinnenvaartKraan(assetManager);
//        VrachtwagenKraan vrachtwagenKraan1 = new VrachtwagenKraan(assetManager);
//        TreinKraan treinKraan1 = new TreinKraan(assetManager);
        //create terrain
//        Box opslagBox = new Box(155, 0.01f, 60);
//        Box wegBox = new Box(157.4f, 0, 62.4f);
//        Box vrachtwagenBinnenvaart = new Box(78.7f, 0, 3);
//        Box treinBox = new Box(157.4f, 0, 3);
//        Box zeevaartBox = new Box(-3, 0, 68.4f);
//        
//        Geometry Opslag = new Geometry("Box",opslagBox);
//        Geometry weg = new Geometry("Box",wegBox);
//        Geometry vrachtwagenvervoer = new Geometry("Box",vrachtwagenBinnenvaart);
//        Geometry binnenvaart = new Geometry("Box",vrachtwagenBinnenvaart);
//        Geometry treinplatform = new Geometry("Box",treinBox);
//        Geometry zeevaart = new Geometry("Box",zeevaartBox);
//        
//        Material matb = new Material(assetManager, "Common/MatDefs/Misc/Unshaded.j3md");
//        Material matc = new Material(assetManager, "Common/MatDefs/Misc/Unshaded.j3md");
//        Material matd = new Material(assetManager, "Common/MatDefs/Misc/Unshaded.j3md");
//        Material mate = new Material(assetManager, "Common/MatDefs/Misc/Unshaded.j3md");
//        Material matf = new Material(assetManager, "Common/MatDefs/Misc/Unshaded.j3md");
//        Material matg = new Material(assetManager, "Common/MatDefs/Misc/Unshaded.j3md");
//        
//        
//        matb.setColor("Color", ColorRGBA.Blue);
//        matc.setColor("Color", ColorRGBA.DarkGray);
//        matd.setColor("Color", ColorRGBA.Green);
//        mate.setColor("Color", ColorRGBA.Red);
//        matf.setColor("Color", ColorRGBA.Yellow);
//        matg.setColor("Color", ColorRGBA.Orange);
//        
//        matb.getAdditionalRenderState().setWireframe(false);
//        matf.getAdditionalRenderState().setWireframe(false);
//        
//        Opslag.setMaterial(matb);
//        weg.setMaterial(matc);
//        vrachtwagenvervoer.setMaterial(matd);
//        binnenvaart.setMaterial(mate);
//        treinplatform.setMaterial(matf);
//        zeevaart.setMaterial(matg);
//        
//        vrachtwagenvervoer.setLocalTranslation(78.7f, 0, 65.4f);
//        binnenvaart.setLocalTranslation(-78.7f, 0, 65.4f);
//        treinplatform.setLocalTranslation(0, 0, -65.4f);
//        zeevaart.setLocalTranslation(-160.4f, 0, 0);
//        opslagKraan1.setLocalTranslation(0, 2, 0);
//        zeeschipKraan1.setLocalTranslation(-160, 2, 0);
//        binnenvaartKraan1.setLocalTranslation(-78, 2, 65);
//        vrachtwagenKraan1.setLocalTranslation(78, 1, 65);
//        treinKraan1.setLocalTranslation(0, 1, -65);
//        
//        rootNode.attachChild(Opslag);
//        rootNode.attachChild(weg);
//        rootNode.attachChild(vrachtwagenvervoer);
//        rootNode.attachChild(binnenvaart);
//        rootNode.attachChild(treinplatform);
//        rootNode.attachChild(zeevaart);
//        rootNode.attachChild(opslagKraan1);
//        rootNode.attachChild(zeeschipKraan1);
//        rootNode.attachChild(binnenvaartKraan1);
//        rootNode.attachChild(vrachtwagenKraan1);
//        rootNode.attachChild(treinKraan1);
        

//=======
        // plaatst op elke strook 1 container
//        for (int i = 0; i < opslagstroken.length; i++) {
//            containers.add(new Container(assetManager));
//            containers.get(i).setLocalTranslation(0,0.24f,0);
//            opslagstroken[i].attachChild(containers.get(i));
//            //opslagstroken[0].storeContainer(containers.get(i));            
//        }
//>>>>>>> refs/remotes/origin/SjoerdCode
        
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
        
        Container c1000 = new Container(assetManager);
        zeeschip1.storeContainer(c1000, 19, 0, 15);
        
        
        
        

        for (int x = 0; x < 46; x++) {
            Container container = new Container(assetManager);
            opslagstroken[0].storeContainer(container, x, 0, 0);
        }
                while (true) {
            try {
                s1 = new ClientSocket(this, InetAddress.getByName("localhost"), port);
                break;
            } catch (Exception e) {
                e.printStackTrace();
                System.out.println("Server not responding");
                continue;
            }
        }
//        Thread thread1 = new Thread(s1);
//        thread1.start();
//        this.enqueue(s1.run());
        s1.threadConnectie();
        
    }

public void initAgvAansturen(final MotionPath pad, final int id, final int laannummer)
    {
        pad.enableDebugShape(assetManager, rootNode);
        MotionEvent event = new MotionEvent (agvs.get(id), pad);
        event.setDirectionType(MotionEvent.Direction.Path);
        pad.setPathSplineType(SplineType.Linear);
        Cinematic cinematic = new Cinematic(agvs.get(id), 999999999); // aantal seconden dat de animatie maximaal duurt, dus maar hoog getal.
        cinematic.addCinematicEvent(0, event);
        stateManager.attach(cinematic);
        event.setInitialDuration(pad.getLength() / 11f / snelheid); //11 meter per seconde.

        cinematic.play();
        
        pad.addListener( new MotionPathListener() {
           public void onWayPointReach(MotionEvent motionControl, int wayPointIndex){
            if (pad.getNbWayPoints() == wayPointIndex + 1) {
            int laannr = -1;
            int vp = AGV.vrijeParkeerplek(laannummer);
            if(laannummer > 307 && laannummer < 385){
                laannr = laannummer-308;
            }
            else{
                laannr = laannummer;
            }
            if(laannummer > 307 && laannummer < 385){
              agvs.get(id).parkeerAGV(opslagstroken[laannr].parkeerPlaatsR[vp]); 
              AGV.vrijeParkeerplaatsR[laannr][vp] = 1;
            }
             else{
               agvs.get(id).parkeerAGV(opslagstroken[laannr].parkeerPlaatsL[vp]);  
               AGV.vrijeParkeerplaatsL[laannr][vp] = 1;
             }  
            }   
        }
      });
    }
    public void initScene(){

        flyCam.setMoveSpeed(50.0f);
        cam.setLocation(new Vector3f(-5f, 59f, 234f));
        cam.setRotation(new Quaternion (0f, 1f, -0.2f, 0f));
        sceneNode = new Node("Scene");
        
        // load sky
        sceneNode.attachChild(SkyFactory.createSky(assetManager, "Textures/Sky/Bright/BrightSky.dds", false));
        rootNode.attachChild(sceneNode);        

        Box b = new Box(opslagBreedte + 2*wegBreedte, 0.0f, opslagLengte + 2*wegBreedte);
        Geometry weg = new Geometry("floor", b);
        Material wegMat = new Material(assetManager, "Common/MatDefs/Misc/Unshaded.j3md");
        wegMat.setColor("Color", ColorRGBA.DarkGray);
        weg.setMaterial(wegMat);
        weg.setLocalTranslation(0.0f,0.0f,0.0f);
        sceneNode.attachChild(weg);   
        
        Box b1 = new Box(terreinBreedte, 20.0f, terreinLengte);
        Geometry floor = new Geometry("floor", b1);
        Material floorMat = new Material(assetManager, "Common/MatDefs/Misc/Unshaded.j3md");
        floorMat.setColor("Color", ColorRGBA.DarkGray);
        floor.setMaterial(floorMat);
        floor.setLocalTranslation(0.0f,-20.0f,0.0f);
        sceneNode.attachChild(floor);     
 
        Spatial S = assetManager.loadModel("Models/Ninja/Ninja.mesh.xml");
        S.scale(0.05f);
        S.rotate(0.0f, -3.0f, 0.0f);
        S.setLocalTranslation(0.0f, 0.0f, opslagLengte + 2*wegBreedte);
        rootNode.attachChild(S);    

    }
    
    public void initBinnenvaartPlatform()
    {
        BinnenVaartPlatform binnenvaartplatform = new BinnenVaartPlatform(assetManager);
        binnenvaartplatform.setLocalTranslation(opslagBreedte + 2*wegBreedte,0,opslagLengte/2 + wegBreedte);
        rootNode.attachChild(binnenvaartplatform);
    }
    
    public void initTreinPlatform()
    {
        treinPlatformNode = new Node("treinplatform");
        TreinPlatform treinPlatform = new TreinPlatform(assetManager);
        treinPlatformNode.attachChild(treinPlatform);
        treinPlatform.setLocalTranslation(-(opslagBreedte + 2*wegBreedte), 0, 0);
        sceneNode.attachChild(treinPlatformNode);
        treinPlatform.treinKomtAan(20);
        Container c2 = new Container(assetManager);
        treinPlatform.storeContainer(c2, 49);
        
    }
    public void initZeeschipPlatform()
    {
        zeeschipPlatformNode = new Node("zeeschipPlatform");
        ZeeschipPlatform zeeschipPlatform = new ZeeschipPlatform(assetManager);
        zeeschipPlatformNode.attachChild(zeeschipPlatform);
        zeeschip1KomtAan();
        zeeschip2KomtAan();
        zeeschipPlatform.setLocalTranslation(0, 0, opslagLengte + 2*wegBreedte); //opslagPlatform + zeeschipPlatform/2 + wegBreedte
        System.out.println(zeeschipPlatform.getLocalTranslation().toString());
        sceneNode.attachChild(zeeschipPlatformNode);
    }
	
	public void initVrachtwagenplatform()
        {
        VrachtwagenplatformNode = new Node();
        Vrachtwagenplatform vrachtwagenplatform = new Vrachtwagenplatform(assetManager);
        VrachtwagenplatformNode.attachChild(vrachtwagenplatform);
        vrachtwagenplatform.setLocalTranslation(opslagBreedte + 2*wegBreedte, 0, -opslagLengte/2 - wegBreedte);
        sceneNode.attachChild(VrachtwagenplatformNode);
        //treinPlatform.treinKomtAan();
        //Container c2 = new Container(assetManager);
        //treinPlatform.storeContainer(c2, 49);
        }
    

        
    public void initOpslag(){        
        
        opslagNode = new Node("Opslag");
        
        for (int i = 0; i < opslagstroken.length; i++) {
            opslagstroken[i] = new Opslagstrook(assetManager);
            opslagNode.attachChild(opslagstroken[i]);  
            opslagstroken[i].setLocalTranslation(0, 0, ((opslagLengte-2) + i * -4f));
            opslagstroken[i].maakParkeerPlaatsen(opslagstroken[i].getLocalTranslation().clone());
        }
        
        sceneNode.attachChild(opslagNode);
       
    }
    
    public void initAGVs(){
        int laannummer = 0;
        int parkcount = 0;
        for (int i = 0; i < 77; i++) {
            for (int j = 0; j < 6; j++) {
                AGV.vrijeParkeerplaatsL[i][j] = 0;
                AGV.vrijeParkeerplaatsR[i][j] = 0;
            }
        }
        for (int f = 0; f < 100; f++) {
            int id = f;
            if(parkcount < 6){
                parkcount++;
            }
            if (parkcount == 6){
                laannummer++;
                parkcount = 0;
            }
            
            AGV agv = new AGV(assetManager);
            agvs.add(agv);
            rootNode.attachChild(agv);
            int laannr = -1;
            int vp = AGV.vrijeParkeerplek(laannummer);
            if(laannummer > 307 && laannummer < 385){
                laannr = laannummer-308;
            }
            else{
                laannr = laannummer;
            }
            if(laannummer > 307 && laannummer < 385){
              agvs.get(id).parkeerAGV(opslagstroken[laannr].parkeerPlaatsR[vp]); 
              AGV.vrijeParkeerplaatsR[laannr][vp] = 1;
            }
             else{
               agvs.get(id).parkeerAGV(opslagstroken[laannr].parkeerPlaatsL[vp]);  
               AGV.vrijeParkeerplaatsL[laannr][vp] = 1;
             }     
        }
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
    
    public void initLight(){
        /** A white, directional light source */ 
        DirectionalLight sun = new DirectionalLight();
        sun.setDirection((new Vector3f(-0.5f, -0.5f, -0.5f)).normalizeLocal());
        sun.setColor(ColorRGBA.White);
        rootNode.addLight(sun);  
    }
    
    void zeeschip1KomtAan()
    {
        Schip.xContainers = ZeeschipPlatform.lengteContainerPlaatsen;
        Schip.yContainers = ZeeschipPlatform.hoogteContainerPlaatsen;
        Schip.zContainers = ZeeschipPlatform.breedteContainerPlaatsen;
        zeeschip1 = new Schip(assetManager);
        zeeschip1.setLocalTranslation(0, 0, ZeeschipPlatform.platformLengte/2);
        zeeschipNode.attachChild(zeeschip1);
        
    }
    
    void zeeschip2KomtAan()
    {
        Schip.xContainers = ZeeschipPlatform.lengteContainerPlaatsen;
        Schip.yContainers = ZeeschipPlatform.hoogteContainerPlaatsen;
        Schip.zContainers = ZeeschipPlatform.breedteContainerPlaatsen;
        zeeschip2 = new Schip(assetManager);
        zeeschip2.setLocalTranslation(0,0,-ZeeschipPlatform.platformLengte/2);
        zeeschipNode.attachChild(zeeschip2);
    }
        
    
    
    @Override 
    public void simpleUpdate(float tpf) {
        //TODO: add update code
        //Container container = new Container(assetManager);
        //zeeschip2.storeContainer(container, 5, 2, 9);
        
//    public void initClientSocket()throws Exception, IOException, ClassNotFoundException{
//        try {
//            s1 = new ClientSocket(InetAddress.getByName("localhost"), port);
//        }
//        catch (IOException e) {e.printStackTrace();}
//        if (s1.isConnected()) { //geen write acties tot connected, test, bug, etc.
//        s1.write("start?");   
//        }
//        System.out.print("\n" + s1.read());
//    }
//    
        //TODO: add update code
                String[] splitInput;
                List<Integer> inputToInt = new ArrayList<Integer>();
          //if (s1.getOpdrachten().size() > 0) {
            for (String opdracht : s1.getOpdrachten()) {
                System.out.println(opdracht);
                System.out.println("test");
                splitInput = opdracht.split("/");
                if(!"".equals(opdracht)){
                    if (opdracht.charAt(0) == 'c') {
                        for (int i = 2; i < splitInput.length; i++) {
                            System.out.println("splitinput lengte = " + splitInput.length);
                            inputToInt.add(Integer.parseInt(splitInput[i])); 
                            System.out.println(splitInput[i]);
                        }
                        MotionPath pad = new MotionPath();
                        for(Integer x : inputToInt){
                            pad.addWayPoint(Waypoint.waypoints.get(x));
                        }
                        initAgvAansturen(pad, opdracht.charAt(2), inputToInt.get(inputToInt.size() - 1));
                        inputToInt.clear();;
                    }
                }
//                int x = Integer.parseInt(splitInput[1]); //dit moet bepaald worden vanaf de achterkant
//                int y = Integer.parseInt(splitInput[2]);
//                int z = Integer.parseInt(splitInput[3]);
//                //System.out.println("x = " + x + " y = " + y + " z = " + z);
//                int[] xyzarray = {x,y,z};
//                this.opslagstroken[5].storeContainer(new Container(this.getAssetManager()), x, y, z);
                testrun = false;
           
          }
        //treinPlatform.storeContainer(c2, 5);
    }
    
    private boolean playing = false;
    //public MotionEvent motionControl;    
    
    private void initInputs(){
        inputManager.addMapping("play_stop", new KeyTrigger(KeyInput.KEY_SPACE));
        ActionListener acl = new ActionListener() {
            
            public void onAction(String name, boolean keyPressed, float tpf) {
          
                if (name.equals("play_stop") && keyPressed) {
                    if (playing) {
                        playing = false;
                        opslagstroken[1].motionControl.stop();
//                        for (int i = 0; i < opslagstroken.length; i=i+2) {
//                            opslagstroken[i].motionControl.stop();
//                        }
                    } else {
                        playing = true;
                        opslagstroken[1].motionControl.play();
//                        for (int i = 0; i < opslagstroken.length; i++) {
//                            opslagstroken[1].motionControl.play();
//                        }
                        
                    }
                } 
            }
        };
        inputManager.addListener(acl, "play_stop");
    }
    
    public void logCameraPosition(){
        System.out.println("X Position: " + cam.getLocation().x);
        System.out.println("Y Position: " + cam.getLocation().y);
        System.out.println("Z Position: " + cam.getLocation().z);
    }
    
    public void logCameraRotation(){
        System.out.println("X Rotation: " + cam.getRotation().getX());
        System.out.println("Y Rotation: " + cam.getRotation().getY());
        System.out.println("Z Rotation: " + cam.getRotation().getZ());
    }

    @Override
    public void simpleRender(RenderManager rm) {
        //TODO: add render code
    }
}