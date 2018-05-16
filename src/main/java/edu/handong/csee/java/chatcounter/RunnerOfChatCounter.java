package edu.handong.csee.java.chatcounter;

import java.io.FileNotFoundException;
import java.util.Scanner;

public class RunnerOfChatCounter {

	public static void main(String[] args) throws FileNotFoundException {
		String inputName;
		Scanner keyboard = new Scanner(System.in);
		
		System.out.print("Input name of file : ");
		inputName = keyboard.nextLine();
		FileLoader loader = new FileLoader();
		loader.loading(inputName);
		
		MacParser mac = new MacParser(inputName);
		mac.parse();
		
		//WindowsParser window = new WindowsParser();
		//window.windows(inputName);
	}

}
