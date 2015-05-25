/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;

import org.simpleframework.xml.Serializer;
import org.simpleframework.xml.core.Persister;

import protocol.Message;

/**
 *
 * @author Roxana
 */
public class ServerObject {
    public PrintWriter out;
    public BufferedReader in;
    public Serializer serializer = new Persister();
    
    public Serializer getSerializer() {                 //*
		return serializer;
	}

	public void setSerializer(Serializer serializer) {
		this.serializer = serializer;
	}

	public ServerObject(PrintWriter out, BufferedReader in) {
       this.out = out;
       this.in = in;
    }
    
    public Message processCommand(Message msg) throws IOException, Exception {    //*
        
        serializer.write(msg, out);

        return this.read(serializer);
    }

    public Message read(Serializer serializer) throws Exception {                 //*
    	return (Message)serializer.read(Message.class, in);
    }
    
	public PrintWriter getOut() {                       //*
		return out;
	}

	public void setOut(PrintWriter out) {
		this.out = out;
	}

	public BufferedReader getIn() {                    //*
		return in;
	}

	public void setIn(BufferedReader in) {
		this.in = in;
	}
    
    
}
