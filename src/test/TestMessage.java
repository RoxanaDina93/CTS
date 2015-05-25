package test;

import static org.junit.Assert.*;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.PrintWriter;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.mockito.Mock;
import org.simpleframework.xml.Serializer;

import protocol.Message;
import client.ServerObject;
import static org.mockito.Mockito.*;

public class TestMessage {
	

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testMessageTypeSelect() {    //*

		Message msg = new Message();
		msg.setCommand("select * from users;");
		msg.setDbname("db_name");

		String type = msg.getType();
		
		assertTrue("SELECT".equals(type));
	}
	
	public void testMessageTypeSelectEquals() {

		Message msg = new Message();
		msg.setCommand("select * from users;");
		msg.setDbname("db_name");

		String type = msg.getType();
		String command ="SELECT";
		
		assertEquals(command, type);
	}
	
	public void testMessageTypeSelectNotNull() {

		Message msg = new Message();
		msg.setCommand("select * from users;");
		msg.setDbname("db_name");

		String type = msg.getType();
		
		assertNotNull(type);
	}
	@Test
	public void testMessageTypeUpdate() {
		Message msg = new Message();
		msg.setCommand("update users set column1=nume,column2=prenume WHERE some_column=some_value;");
		msg.setDbname("db_name");

		String type = msg.getType();
		
		assertTrue("UPDATE".equals(type));
	}
	
	@Test
	public void testMessageTypeUpdateEquals() {
		Message msg = new Message();
		msg.setCommand("update users set column1=nume,column2=prenume WHERE some_column=some_value;");
		msg.setDbname("db_name");

		String type = msg.getType();
		String typeREZ="UPDATE";
		
		assertEquals(typeREZ, type);
	}
	
	@Test
	public void testMessageTypeUpdateNotNull() {
		Message msg = new Message();
		msg.setCommand("update users set column1=nume,column2=prenume WHERE some_column=some_value;");
		msg.setDbname("db_name");

		String type = msg.getType();
		
		assertNotNull(type);
	}
	
	@Test
	public void testGetCommandSelect() {
		
		String command = "select * from users";
		Message msg = new Message();
		msg.setCommand("select * from users");
		String result = msg.getCommand();
		
		
		assertEquals(command, result);
		
		
	}
	
	@Test
	public void testGetCommandSelectTrue() {
		
		
		Message msg = new Message();
		msg.setCommand("select * from users");
		String result = msg.getCommand();
		
		
		assertTrue("select * from users".equals(result));
		
		
	}
	
	@Test
	public void testGetCommandSelectNOtNull() {
		
		
		Message msg = new Message();
		msg.setCommand("select * from users");
		String result = msg.getCommand();
		
		
		assertNotNull(result);
		
		
	}
	
	@Test
	public void testGetCommandUpdate() {
		
		String command = "update users set column1=nume,column2=prenume WHERE some_column=some_value;";
		Message msg = new Message();
		msg.setCommand(command);
		String result = msg.getCommand();
		
		assertNotNull(result);
		
		
	}
	
	@Test
	public void testGetCommandUpdateEquals() {
		
		String command = "update users set column1=nume,column2=prenume WHERE some_column=some_value;";
		Message msg = new Message();
		msg.setCommand("update users set column1=nume,column2=prenume WHERE some_column=some_value;");
		String result = msg.getCommand();
		
		assertEquals(command, result);
		
		
	}
	
	@Test
	public void testGetCommandUpdateTrue() {
		
		Message msg = new Message();
		msg.setCommand("update users set column1=nume,column2=prenume WHERE some_column=some_value;");
		String result = msg.getCommand();
		
		assertTrue("update users set column1=nume,column2=prenume WHERE some_column=some_value;".equals(result));
		
		
	}
	
	@Test
	public void testGetDbName() {
		
		String name = "users";
		Message msg = new Message();
		msg.setDbname("users");
		String result = msg.getDbname();
		
		
		assertEquals(name, result);
		
		
	}
	
	@Test
	public void testGetDbNameNotNull1() {
		
		
		Message msg = new Message();
		msg.setDbname("users");
		String result = msg.getDbname();
		
		
		assertNotNull(result);
		
		
	}
	@Test
	public void testGetDbNameTrue() {
		
		Message msg = new Message();
		msg.setDbname("users");
		String result = msg.getDbname();
		
		assertTrue("users".equals(result));
		
		
		
		
	}
	
	@Test
	public void testGetResult() {
		
		String rez = "blabla";
		Message msg = new Message();
		msg.setResult("blabla");
		String result = msg.getResult();
		
		
		assertEquals(rez, result);
		
		
	}
	@Test
	public void testGetResultTrue() {
		
		
		Message msg = new Message();
		msg.setResult("result");
		String result = msg.getResult();
		
		assertTrue("result".equals(result));
		
		
	}
	
	@Test
	public void testGetResultNotNull() {
		
		
		Message msg = new Message();
		msg.setResult("result");
		String result = msg.getResult();
		
		assertNotNull(result);
		
		
	}
	
	@Test
	public void testGetResultColumns() {
		
		
		Message msg = new Message();
		msg.setResultColumns(new String[]{"nume"});
		String[] result = msg.getResultColumns();
		
		
		assertArrayEquals(new String[]{"nume"}, result);
		
		
	}
	
	
}
