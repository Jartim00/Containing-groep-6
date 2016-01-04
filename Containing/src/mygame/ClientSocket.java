/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mygame;

import com.jme3.asset.AssetManager;
import java.net.*;
import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.logging.Level;
import java.util.logging.Logger;

class ClientSocket extends Socket {
    
    private AssetManager assetManager;
    private Main app;
    private InputStream in;
    private OutputStream out;
    private final int bufsize = 4096;
    private String input = "";
    private List<String> opdrachten;
    private String response = "start";
    
    public ClientSocket(Main app, InetAddress ip, int port) throws Exception {
        super(ip, port);
        this.app = app;
        in = getInputStream();
        out = getOutputStream();
        opdrachten = new ArrayList<String>();
    }
    
    public ClientSocket() {
    }
    
    public void threadConnectie() {
        Thread clientThread = new Thread(new Runnable() {
            public void run() {
                ClientSocket.this.run();
            }
        });
        clientThread.start();
    }
    
    public List<String> getOpdrachten() {
        ArrayList huidigeOpdrachten = new ArrayList<String>(opdrachten);
        opdrachten.clear();
        return huidigeOpdrachten;
    }
    
    public void run() {
        int count = 0;
        
        System.out.println("thread is running...");
        for (;;) {
            count++;
            System.out.println("count = " + count + "\n");
            try {
                write(response);
                System.out.println("\nMessage sent\n");
                input = read();
                System.out.println(input);
                System.out.println("Message received\n");
                this.opdrachten.add(input);
            } catch (Exception ex) {
                //Logger.getLogger(ClientSocket.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    public void write(String text) throws Exception {
        if (text.length() > bufsize - 1) {
            throw new Exception("ClientSocket::write - argument too large");
        }
        out.write((text + "\n").getBytes());
    }
    
    public String read() throws Exception {
        byte[] b = new byte[bufsize];
        int count = in.read(b, 0, bufsize - 1);
        return new String(Arrays.copyOfRange(b, 0, count - 1));
    }
    
    public String opdrachtInterpretatie() {
        List<String> opdrachten = this.getOpdrachten();
        if (opdrachten.size() > 0) {
            for (int i = 0; i < opdrachten.size(); i++) {
                System.out.println("opdracht interpretatie loopt");
                String opdracht = opdrachten.get(i);
                char eerste = opdracht.charAt(0);
                String[] splitInput;
                splitInput = opdracht.split("/");
                switch (eerste) {
                    case 'a':                    
                    case 'b':
                    case 'c':
                    case 'd':
                    case 'e':
                    case 'f':
                    case 'h':
                    case 'z':
                        System.out.println("case 'z' wordt aangesproken");
                        Container zschipcontainer = new Container(assetManager);
                        app.zeeschip1.storeContainer(zschipcontainer, Integer.parseInt(splitInput[2]), Integer.parseInt(splitInput[3]), Integer.parseInt(splitInput[4]));
                }
                return opdracht;
            }
        }
        return "niks";
    }
}