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
	 *  This method receive file name from main method that is RunnerOfChatCounter.
	 * and then, use Scanner class, File class get a file to inputStream variable 
	 * finally it will show result of input like [ㅇ] [오전 10:53] 교수님 오늘 한 salesAssociate comparable코드도 github에 올려주시나요..? 
	 * or 2018-04-02 12:17:16,"최동현","교수님 혹시 자바 export 할때 javadoc: error - cannot read Input length = 1 " 	
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
			
			while(input.hasNextLine()) {
				String line = input.nextLine();
				System.out.println(line);
			}
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
	/*public void loading(String name) {
		String fileName = name;
		Scanner input=null;
		try {
			input = new Scanner(new File(fileName));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		System.out.println ("The file " + fileName + "\ncontains the following lines:\n");
				
		while (input.hasNextLine ()) {
			System.out.printf("%s \t", input.nextLine()); 
            System.out.println();
		}
		input.close ();
	}*/
}
//reaplaceAll(String a,String b)->a를 b로 바꿔
/*String fileName = "out.txt";
PrintWriter outputStream = null;

try {
	outputStream = new PrintWriter(fileName);
} catch(FileNotFoundException e) {
	System.out.println("Error opening the file " + fileName);
	System.exit(0);
}*/