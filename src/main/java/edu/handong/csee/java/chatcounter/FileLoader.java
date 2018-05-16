package edu.handong.csee.java.chatcounter;

import java.io.File; 
import java.io.FileNotFoundException; 
import java.io.IOException; 
import java.util.Scanner; 
/**
 * this class call a file(type is *.csv and *.txt) in the computer
 * @author gimdaegyo
 *
 */
public class FileLoader {
	
	/**
	 *  This method receive file name from main method that is RunnerOfChatCounter.
	 * and then, use Scanner class, File class get a file to inputStream variable 
	 * finally it will show result of input like [ㅇ] [오전 10:53] 교수님 오늘 한 salesAssociate comparable코드도 github에 올려주시나요..? 
	 * or 
	 * @param name
	 */
	public void loading(String name) {
		String fileName = name;
		Scanner inputStream=null;
		try {
			inputStream = new Scanner(new File(fileName));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		System.out.println ("The file " + fileName + "\ncontains the following lines:\n");
				
		while (inputStream.hasNextLine ()) {
			System.out.printf("%s \t", inputStream.nextLine()); 
            System.out.println();
		}
		inputStream.close ();
	}
}

