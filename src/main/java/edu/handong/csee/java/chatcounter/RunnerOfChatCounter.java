package edu.handong.csee.java.chatcounter;


import java.io.FileNotFoundException;
import java.util.Scanner;
/**
 * This is class have main method for running program
 * it will just send file name and receive result of class method
 */
public class RunnerOfChatCounter {
	/**
	 * this main method receive file name from user and send file name to each class method
	 * @param args
	 * @throws FileNotFoundException
	 */
	public static void main(String[] args) throws FileNotFoundException {
		FileWriter fw=new FileWriter();
		
		CliRunner myRunner = new CliRunner();
		myRunner.run(args);
		
		FileLoader loader = new FileLoader();
		
		try {
			loader.getFileNames(myRunner.inputPath);
			loader.readDirectory();
			fw.sortResult(myRunner.outputPath);
		}
		catch (ArrayIndexOutOfBoundsException e){
			System.out.println("you must typing input path and output path");
		}
		
	}

}
//My path name : /Users/gimdaegyo/eclipse-workspace/drive-download-20180517T024414Z
//new file path : /Users/gimdaegyo/eclipse-workspace/hello.txt