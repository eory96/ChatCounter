package edu.handong.csee.java.chatcounter;

import java.io.File; 
import java.io.FileNotFoundException; 
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner; 
/**
 * this class call a file(type is *.csv and *.txt) in the computer it will use File I/O
 * @author gimdaegyo
 *
 */
public class FileLoader {
	private ArrayList<String> message;
	/**
	 *  This method receive path name from main method that is RunnerOfChatCounter.
	 * and then, use Scanner class, File class get a file to inputStream variable 
	 * finally it will show result that is list of path name like  
	 * /Users/gimdaegyo/eclipse-workspace/drive-download-20180517T024414Z/자바-L14.csv
	 * /Users/gimdaegyo/eclipse-workspace/drive-download-20180517T024414Z/자바-L15.csv
	 * /Users/gimdaegyo/eclipse-workspace/drive-download-20180517T024414Z/자바-L3.csv ...
	 * @param name
	 */
	public void readDirectory(String path) {
		getFileNames(path);
		Scanner input=null;
		
		ArrayList<File> fileNames = getFileNames(path);
		for(File fileNameA:fileNames) {
			System.out.println(fileNameA);
			String name = fileNameA.toString();
			try {
				input=new Scanner(new File(name));
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
			
			/*while(input.hasNextLine()) {
				String line = input.nextLine();
				System.out.println(line);
			}*/
		}
	}

	private ArrayList<File> getFileNames(String path){
		ArrayList<File> fileNames = new ArrayList<File>();
		File myPath = new File(path);
		//myPath.listFiles();
		for(File fileName:myPath.listFiles()) {
			fileNames.add(fileName);
		}
		return fileNames;
	}
}