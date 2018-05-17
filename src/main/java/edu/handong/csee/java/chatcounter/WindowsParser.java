package edu.handong.csee.java.chatcounter;
/**
 * This method will parse a string of .csv file and meke Arraylist that store name of person
 * @author gimdaegyo
 *
 */
import java.io.File; 
import java.io.FileNotFoundException; 
import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner; 

public class WindowsParser {
	/**
	 * using delimiter seperate chating content and just save user name(also, store repeated name ) in array list 
	 * @param name
	 */
	public void parserWindow(String name) {
		try { 
	        File csv = new File(name); 
	        Scanner key = new Scanner(csv); 
	        key.useDelimiter("[,]"); 
	        while (key.hasNextLine()) { 
	           System.out.printf("%s \t", key.); 
	           System.out.println(); 
	        } 
	        key.close(); 
	        } catch (FileNotFoundException e) { 
	        e.printStackTrace(); 
	     } 
	}
	
}

