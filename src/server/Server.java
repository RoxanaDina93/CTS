package server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Roxana
 */
public class Server {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.print( "Starting serverutz\n");
        
        //int portNumber = Integer.parseInt(args[0]);
        
        int portNumber = 9991;

    try {
        
        do {
        ServerSocket serverSocket = new ServerSocket(portNumber);
        
        System.out.print( "Waiting for clientei...");
        
        Socket clientSocket = serverSocket.accept();
        
        System.out.print( "Clientel blegut s-a conectat");
        
        PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
        BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
        
        Thread thread = new Thread(new ClientThread(out, in));
        
        thread.start();
        
        
        
        System.out.println("Clientel s-a conectat.");
        
        
        } while (true);
    } catch (IOException ex) { 
        System.out.println("Error : " + ex.getMessage());
    }

        
    }
    
}
