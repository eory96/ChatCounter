package edu.handong.csee.java.chatcounter;


import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
/**
 * This is class have main method for running program
 * it will just send file name and receive result of class method
 */
public class RunnerOfChatCounter {
	static ArrayList<File> fileNames = new ArrayList<File>();
	/**
	 * this main method receive file name from user and send file name to each class method
	 * @param args
	 * @throws FileNotFoundException
	 */
	public static void main(String[] args) throws FileNotFoundException {
		RunnerOfChatCounter counter = new RunnerOfChatCounter();
		counter.runner(args);
	}
	/**
	 * this method is make thread pool and call a file
	 * @param args
	 */
	public void runner(String[] args) {
		RunnerOfChatCounter counter = new RunnerOfChatCounter();
		FileWriter fw=new FileWriter();
		CliRunner myRunner = new CliRunner();
		int threadCounting;
		myRunner.run(args);
		
		try {
			counter.getFileNames(myRunner.inputPath);
			threadCounting = Integer.parseInt(myRunner.countThread);
			
			ExecutorService executor = Executors.newFixedThreadPool(threadCounting);
			
			for(File path:fileNames) {
				Runnable worker = new FileLoader(path);
				executor.execute(worker);
				
			}
			
			executor.shutdown();
			
			while (!executor.isTerminated()) {
			}

			fw.sortResult(myRunner.outputPath);
		}
		catch (ArrayIndexOutOfBoundsException e){
			System.out.println("you must typing input path and output path");
		}
		
	}
	
	private ArrayList<File> getFileNames(String path){
		File myPath = new File(path);
		for(File fileName:myPath.listFiles()) {
			fileNames.add(fileName);
		}
		return fileNames;
	}

}
//My path name : /Users/gimdaegyo/eclipse-workspace/drive-download-20180517T024414Z
//new file path : /Users/gimdaegyo/eclipse-workspace/hello.txt