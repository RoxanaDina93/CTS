package client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import ui.ClientForm;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Roxana
 */
public class Client {

    static ServerObject svo;
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        int portNumber = 9991;
        String hostName = "localhost";
        
        
        
        //String hostName = args[0];
        //int portNumber = Integer.parseInt(args[1]);

        try {
            Socket kkSocket = new Socket(hostName, portNumber);
            PrintWriter out = new PrintWriter(kkSocket.getOutputStream(), true);
            BufferedReader in = new BufferedReader(new InputStreamReader(kkSocket.getInputStream()));
            String initRead = in.readLine();
            String correctResp = "asdsadasdasdasdsadasdasdasdasadasdasdaswqe123123";
            
            if (!"asdsadasdasdasdsadasdasdasdasadasdasdaswqe123123".equals(initRead)) {
                throw new IOException("Invalid protocols");
            }
            
            Client.svo = new ServerObject(out, in);
            
            
        } catch (IOException ex) {
             System.out.print( "Error connecting:" + ex.getMessage());
        }
        
        
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            
            public void run() {
                new ClientForm(Client.svo).setVisible(true);
            }
        });
    }
    
}
