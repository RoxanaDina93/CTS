/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.simpleframework.xml.Serializer;
import org.simpleframework.xml.core.Persister;
import protocol.Message;

/**
 *
 * @author Roxana
 */
public class ClientThread implements Runnable {
    public PrintWriter out;
    public BufferedReader in;
    
    public ClientThread(PrintWriter out, BufferedReader in) {
       this.out = out;
       this.in = in;
    }
    
    @Override
    public void run() {
        
        
        String inputLine="", outputLine = "";
            
        // Initiate conversation with client
        KnockKnockProtocol kkp = new KnockKnockProtocol();
        
        out.println("asdsadasdasdasdsadasdasdasdasadasdasdaswqe123123");

        Serializer serializer = new Persister();
        Message imsg,omsg;
        
        try {
            while ((imsg = serializer.read(Message.class, in)) != null) {
                omsg = kkp.processInput(imsg);
                serializer.write(omsg, out);

            }   
        } catch (IOException ex) {
           System.out.print( "Error executing command: '" + inputLine+"' "+ex.getMessage());
        } catch (Exception ex) {
            System.out.print( "Error executing command: '" + inputLine+"' "+ex.getMessage());
        }

        
        
    }
    
}
