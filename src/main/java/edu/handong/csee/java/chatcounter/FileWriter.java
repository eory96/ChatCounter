package edu.handong.csee.java.chatcounter;
import java.io.PrintWriter;          
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Scanner;
/**
 * This class make file that given from user path store result of data
 * @author gimdaegyo
 *
 */
public class FileWriter {
	/**
	 * get store path and store data to the file
	 * data get from NameAdder class
	 * if you typing wrong it print out Error message
	 * but, you good path print out Those lines were written to your path
	 */
	public void sortResult() {
		NameAdder na = new NameAdder();
		HashMap<String,Integer> map=na.count();
		String[] arrayName=na.countName();
		
		Scanner keyboard = new Scanner (System.in);
		System.out.println("input store path:");
		String fileName;
		fileName=keyboard.nextLine();//The name could be read from the keyboard.
	
		PrintWriter outputStream = null;
		try {
			outputStream = new PrintWriter (fileName);
		} catch (FileNotFoundException e) {
			System.out.println ("Error opening the file " + fileName);
			System.exit (0);
		}
		
		for (int a=0;a<arrayName.length;a++) {
			outputStream.println (arrayName[a]+","+map.get(arrayName[a]));
		}
		outputStream.close();
		
		System.out.println ("Those lines were written to " + fileName);

	}
}


