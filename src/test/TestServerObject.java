package test;

import static org.junit.Assert.*;

import java.io.BufferedReader;
import java.io.PrintWriter;

import junit.framework.TestSuite;
import junit.textui.TestRunner;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.simpleframework.xml.Serializer;

import protocol.Message;
//import teste.TestCase2;
import client.ServerObject;
import static org.mockito.Mockito.*;

public class TestServerObject {
	
	
	
	@Before
	public void setUp() throws Exception {
		
		
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testProcessCommand() throws Exception {
		
		PrintWriter out = mock(PrintWriter.class);
		BufferedReader in = mock(BufferedReader.class);
		Serializer sr = mock(Serializer.class);
		
		ServerObject serverObject = new ServerObject(out, in);
		serverObject.setSerializer(sr);
		
		
		Message msg = new Message();
		when(sr.read(Message.class,in)).thenReturn(msg);
		
		Message msgResp = serverObject.processCommand(msg);
		
		assertNotNull(msgResp);
	}
	
	@Test
	public void testIn() {
		PrintWriter out = mock(PrintWriter.class);
		BufferedReader in = mock(BufferedReader.class);
		
		
		ServerObject serverObject = new ServerObject(out, in);
		PrintWriter rOut = serverObject.getOut();
		BufferedReader rIn = serverObject.getIn();
		
		assertNotNull(rIn);
		//assertNotNull(rOut);
	}
	
	@Test
	public void testOut() {
		PrintWriter out = mock(PrintWriter.class);
		BufferedReader in = mock(BufferedReader.class);
		
		
		ServerObject serverObject = new ServerObject(out, in);
		PrintWriter rOut = serverObject.getOut();
		BufferedReader rIn = serverObject.getIn();
		
		//assertNotNull(rIn);
		assertNotNull(rOut);
	}
	
	@Test
	public void testMessageRead() throws Exception {

		PrintWriter out = mock(PrintWriter.class);
		BufferedReader in = mock(BufferedReader.class);
		Serializer sr = mock(Serializer.class);
		
		ServerObject serverObject = new ServerObject(out, in);
		serverObject.setSerializer(sr);
		
		
		Message msg = new Message();
		when(sr.read(Message.class,in)).thenReturn(msg);
		
		Message msgResp = serverObject.read(sr);
		
		assertNotNull(msgResp);
	}
	@Test
	public void testSerializer() {
		
		PrintWriter out = mock(PrintWriter.class);
		BufferedReader in = mock(BufferedReader.class);
		ServerObject serverObject = new ServerObject(out, in);
		Serializer sr = mock(Serializer.class);
		
		
		
		serverObject.setSerializer(sr);
		Serializer srr = serverObject.getSerializer();
		
		assertNotNull(srr);
	}
	

}
