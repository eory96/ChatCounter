package edu.handong.csee.java.chatcounter;
/**
 * This is class have main method for running program
 * it will just send file name and receive result of class method
 */
import java.io.FileNotFoundException;
import java.util.Scanner;

public class RunnerOfChatCounter {
	/**
	 * this main method receive file name from user and send file name to each class method
	 * @param args
	 * @throws FileNotFoundException
	 */
	public static void main(String[] args) throws FileNotFoundException {
		String inputName="/Users/gimdaegyo/eclipse-workspace/drive-download-20180517T024414Z";
		//Scanner keyboard = new Scanner(System.in);
		
		//System.out.print("Input name of file : ");
		//inputName = keyboard.nextLine();
		FileLoader loader = new FileLoader();
		loader.readDirectory(inputName);
		
		
		//MacParser mac = new MacParser(inputName);
		//mac.parse();
		
		//WindowsParser window = new WindowsParser();
		//window.windows(inputName);
	}

}
