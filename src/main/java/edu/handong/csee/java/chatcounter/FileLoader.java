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
public class FileLoader implements Runnable{
	ArrayList<File> fileNames = new ArrayList<File>();
	ArrayList<String> message = new ArrayList<String>();
	
	@Override
	/**
	 *  This method receive path name from main method that is RunnerOfChatCounter.
	 * and then, use Scanner class, File class get a file to inputStream variable 
	 * finally it will show result that is list of path name like  
	 * @param name
	 */
	public void run() {
		Scanner input=null;
		MacParser mParser = new MacParser();
		WindowsParser wParser = new WindowsParser();
				
		for(File fileNameA:fileNames) {
			String name = fileNameA.toString();

			try {
				input=new Scanner(new File(name));
				if(name.contains(".txt")){
					while(input.hasNextLine()) {
						String line = input.nextLine();
						if(!mParser.selectData(line).equals("")) mParser.parsingAndSotre(line); 
					}
				}
				else if(name.contains(".csv")) {
					while(input.hasNextLine()) {
						String line = input.nextLine();
						wParser.parsingAndSotre(line); 
					}
				}
			} catch (FileNotFoundException e) {
				System.out.println("you type wrong path name");
			}
		}
	}
	
	/**
	 * constructor for FileLoader class it will 
	 * @param path
	 */
	public FileLoader(File path) {
		this.fileNames.add(path);
	}

	
}