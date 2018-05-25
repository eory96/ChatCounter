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
	//ArrayList<String> name = new ArrayList();
	static ArrayList<String> messageW = new ArrayList<String>();
	//ArrayList<String> date = new ArrayList();
	public void parsingAndSotre(String line) {
		
		Pattern nameP = Pattern.compile("(20[0-1][0-9]-[0-1][0-9]-[0-3][1-9]\\s)([0-2][0-9]:[0-5][0-9])(:[0-5][0-9])(\\,\")(\\D*|\\d*)(\"\\,)(\")(.*)(\")");
		Matcher nameM = nameP.matcher(line);
		String realName="" ;
		String realMss="";
		String realTime="";
		String fullString="";
		
		String noMss="joined this chatroom.";
		if(nameM.find()) {
			String patternName = nameM.group();
			int first = nameM.start(5);
			int last = nameM.end(5);
			realName = patternName.substring(first, last);
			
			int firstM = nameM.start(8);
			int lastM = nameM.end(8);
			realMss = patternName.substring(firstM, lastM);
			
			int firstD = nameM.start(2);
			int lastD = nameM.end(2);
			realTime = patternName.substring(firstD,lastD);
			fullString="\""+realName+"\""+", "+"\""+realTime+"\""+", "+"\""+realMss+"\"";
			
			messageW.add(fullString);
		}
		
		
	}
	
	public String selectData(String line) {
		Pattern nameP = Pattern.compile("(20[0-1][0-9]-[0-1][0-9]-[0-3][1-9]\\s)([0-2][0-9]:[0-5][0-9])(:[0-5][0-9])(\\,\")(\\D*|\\d*)(\"\\,)(\")(.*)(\")");
		Matcher nameM = nameP.matcher(line);
		String realName="";
		
		if(nameM.find()) {
			String patternName = nameM.group();
			int first = nameM.start(2);
			int last = nameM.end(2);
			realName = patternName.substring(first, last);
			return realName;
		}
		return realName;
	}
}


