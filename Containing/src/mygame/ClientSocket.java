/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mygame;

import java.net.*;
import java.io.*;
import java.util.Arrays;

class ClientSocket extends Socket
{
  public ClientSocket(InetAddress ip, int port) throws Exception
  {
    super(ip, port);
    in  = getInputStream();
    out = getOutputStream();
  }
  
  private InputStream in;
  private OutputStream out;
  private final int bufsize = 4096;
  
  public void write(String text) throws Exception
  {
    if(text.length() > bufsize - 1) throw new Exception("ClientSocket::write - argument too large");
    out.write((text+"\n").getBytes());
  }
  
  public String read() throws Exception
  {
    byte[] b = new byte[bufsize];
    int count = in.read(b, 0, bufsize-1);
    
    //int count2 = in.r
    if(count > 0 && b[count-1] == '\n') count--;
    {
    b[count] = '\0';
    }
    return new String(Arrays.copyOfRange(b, 0, count));
  }
}