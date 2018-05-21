package edu.handong.csee.java.chatcounter;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MacParser implements MessageParser{
	ArrayList<String> name = new ArrayList();
	public String parsingAndSotre(String line) {
		
		Pattern nameP = Pattern.compile("(\\[)((?:\\D|\\d)+)(\\])(\\s\\[.*(?:\\d{1}|\\d{2}):\\d{2}.*\\](\\s)(.*))");
		Matcher nameM = nameP.matcher(line);
		String realName="";
		
		if(nameM.find()) {
			String patternName = nameM.group();
			int first = nameM.start(2);
			int last = nameM.end(2);
			realName = patternName.substring(first, last);
			
			
		}
		return realName;
	}
}
