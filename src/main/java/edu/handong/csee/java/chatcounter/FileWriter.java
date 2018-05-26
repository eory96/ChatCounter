package edu.handong.csee.java.chatcounter;
import java.io.PrintWriter;          
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Scanner;

public class FileWriter {

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


