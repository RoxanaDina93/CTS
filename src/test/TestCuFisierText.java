package test;

import static org.junit.Assert.*;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import protocol.Message;

public class TestCuFisierText {
	static BufferedReader bf;
	static FileReader reader;

	
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		System.out.println("setUpBeforeClass");
		reader = new FileReader(new File("Untitled 1"));
		bf = new BufferedReader(reader);
		}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		System.out.println("tearDownClass");
		bf.close();
	}

	@Before
	public void setUp() throws Exception {
		//System.out.println("setUp");
	}

	@After
	public void tearDown() throws Exception {
		//System.out.println("tearDown");
	}

	@Test
	public void test() {
		
		Message msg = new Message();
		msg.setCommand("select * from users;");
		msg.setDbname("db_name");
		try{
			String linie = bf.readLine();
			while (linie != null ) {
				String values = linie;
				msg.setCommand(values);
				msg.setDbname("db_name");
				String type = msg.getType();
				
				assertNotNull(type);
				
				
				linie = bf.readLine();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
			
	}
	
	
	
	

}

	


