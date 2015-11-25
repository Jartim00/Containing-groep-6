/*
 * Java socketluisteraartest.
 * verwacht input in vorm van ints tussen 0 en 5, stopt bij 4 en "exit"
 */
package testservercon;
 
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author 54
 */
public class Testservercon {

    //static ServerSocket variable
    private static ServerSocket server;
    //socket server port on which it will listen
    private static int port = 49876;
     
    public static void main(String args[]) throws IOException, ClassNotFoundException{
        //create the socket server object
        server = new ServerSocket(port, 0, InetAddress.getByName(null));
        //keep listens indefinitely until receives 'exit' call or program terminates
        while(true){
            System.out.println("Waiting for client request");
            //creating socket and waiting for client connection
            Socket socket = server.accept();
                        if (socket.isConnected()) { // Test om te zien of connectie gemaakt is
                System.out.println("Connection established");
            }
            InputStream is = socket.getInputStream();
            InputStreamReader isr = new InputStreamReader(is);
            BufferedReader br = new BufferedReader(isr);
            OutputStream os  = socket.getOutputStream();
            String a = "atest\n";
            os.write("test\n".getBytes());
            //os.write(a.getBytes(), 0, a.length());
            //os.flush();
            
            //hoezo werkt dit niet goed?
            
            int recv = br.read(); // <- deze int bepaalt of er output komt 2 regels hieronder
            String charLine = br.readLine();
            System.out.print(charLine);

            socket.close();
            //terminate the server if client sends exit request
            if(br.readLine().equalsIgnoreCase("exit")) break;
        }
        System.out.println("Shutting down Socket server!!");
        //close the ServerSocket object
        server.close();
    }  
}
