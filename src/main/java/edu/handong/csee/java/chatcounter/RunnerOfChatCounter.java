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
		System.out.println("Please input pathe name");
		Scanner keyboard = new Scanner(System.in);
		String inputName=keyboard.nextLine();
		NameAdder na = new NameAdder();
		FileWriter fw=new FileWriter();
		//MessageParser parser = new MessageParser();
		
		FileLoader loader = new FileLoader();
		loader.readDirectory(inputName);
		//loader.kakao_id.toString();
		
		//na.add();
		//MacParser mac = new MacParser();
		//mac.parsingAndSotre(inputName);
		//WindowsParser window = new WindowsParser();
		//window.parsingAndSotre(inputName);
		//na.storeMessageToOne();
		//pm.count();
		fw.sortResult();
	}

}
//My path name : "/Users/gimdaegyo/eclipse-workspace/drive-download-20180522T030904Z"