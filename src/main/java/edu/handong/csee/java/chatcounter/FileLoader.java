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
	
	/**
	 *  This method receive path name from main method that is RunnerOfChatCounter.
	 * and then, use Scanner class, File class get a file to inputStream variable 
	 * finally it will show result that is list of path name like  
	 * @param name
	 */
	public void readDirectory(String path) {
		getFileNames(path);
		Scanner input=null;
		ArrayList<File> fileNames = getFileNames(path);
		MacParser mParser = new MacParser();
		WindowsParser wParser = new WindowsParser();
				
		for(File fileNameA:fileNames) {
			String name = fileNameA.toString();

			try {
				input=new Scanner(new File(name));
				if(name.contains(".txt")){
					while(input.hasNextLine()) {
						String line = input.nextLine();
						if(mParser.selectData(line)==true) 
							mParser.parsingAndSotre(line); 
					}
				}
				else if(name.contains(".csv")) {
					while(input.hasNextLine()) {
						String line = input.nextLine();
						wParser.parsingAndSotre(line); 
					}
				}
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
		}
	}

	private ArrayList<File> getFileNames(String path){
		ArrayList<File> fileNames = new ArrayList<File>();
		File myPath = new File(path);
		for(File fileName:myPath.listFiles()) {
			fileNames.add(fileName);
		}
		return fileNames;
	}
}