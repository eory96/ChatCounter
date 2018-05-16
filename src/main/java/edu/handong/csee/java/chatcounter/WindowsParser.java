package edu.handong.csee.java.chatcounter;

import java.io.File; 
import java.io.FileNotFoundException; 
import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner; 

public class WindowsParser {
	
	public void parserWindow(String name) {
		try { 
	        File csv = new File(name); 
	        Scanner key = new Scanner(csv); 
	        key.useDelimiter("[,]"); 
	        while (key.hasNextLine()) { 
	           System.out.printf("%s \t", key.nextLine()); 
	           System.out.println(); 
	        } 
	        key.close(); 
	        } catch (FileNotFoundException e) { 
	        e.printStackTrace(); 
	     } 
	}
	
}

