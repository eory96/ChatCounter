package edu.handong.csee.java.chatcounter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.io.File;
import java.io.FileNotFoundException;


public class MacParser {
	/*HashMap<String,Integer> map = new HashMap<String,Integer>();
	ArrayList<String> list = new ArrayList<String>();
	String delimiter = "\\s|\\d|\\n|\\r|\\[|\\]";
	
	public void token(String fileName) {
		int cnt=0;
		Scanner inputStream=null;
		try {
			inputStream = new Scanner(new File(fileName));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		inputStream.useDelimiter(delimiter);
		
		//System.out.println("name");
		
		while (inputStream.hasNext()) {
			String line = inputStream.nextLine();
			if (line == null || line.length() == 0)
                continue;
            System.out.print(cnt++);
            System.out.print(": ");
            System.out.println(line);
		}
	}*/
	

    Scanner scanner = null;

    public MacParser(String input) {
        scanner = new Scanner(input).useDelimiter("[\\[,\\]]");
        
    }

    public void parse() {
        int i = 0;
        while (scanner.hasNextLine()) {
            String word = scanner.nextLine();
            System.out.print(i++);
            System.out.print(": ");
            System.out.println(word);
        }
    }
}

