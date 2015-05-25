package test;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.junit.BeforeClass;

public class TestareCuFisText {

	static FileReader reader;
	static BufferedReader buffer;
	static String linie;
	static String result;
	//static Comanda comanda;
	//static int numberToconvert;
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		
		try {
			reader = new FileReader("teste");
			buffer = new BufferedReader(reader);
		
	 		linie = null;
	 		StringBuffer string = new StringBuffer();
			while((linie = buffer.readLine())!=null && linie.length()!= 0){
				//deCitit = buffer.readLine();
				
				string.append(linie);
				string.append("\n");
				result = linie.split(" ")[0];
			   // numberToconvert =  Integer.parseInt(numar);
				//comanda.setNumarComanda(numberToconvert);
				
				
			}
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}