package edu.handong.csee.java.chatcounter;
import java.util.ArrayList;
/**
 * This method will parse a string of .csv file and meke Arraylist that store name of person
 * @author gimdaegyo
 *
 */
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class WindowsParser implements MessageParser{
	ArrayList<String> name = new ArrayList();
	
	public String parsingAndSotre(String line) {
		
		Pattern nameP = Pattern.compile("(20[0-1][0-9]-[0-1][0-9]-[0-3][1-9]\\s[0-2][0-9]:[0-5][0-9]:[0-5][0-9]\\,\")(\\S*)(\"\\,)(\")(.*)(\")");
		Matcher nameM = nameP.matcher(line);
		String realName="" ;
		
		if(nameM.find()) {
			String patternName = nameM.group();
			int first = nameM.start(2);
			int last = nameM.end(2);
			realName = patternName.substring(first, last);
			if(realName==null) return null;
		}
		return realName;
	}
	
}


