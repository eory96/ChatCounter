package edu.handong.csee.java.chatcounter;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MacParser implements MessageParser{
	//ArrayList<String> name = new ArrayList();
	static ArrayList<String> messageM = new ArrayList<String>();
	//ArrayList<String> date = new ArrayList();
	public void parsingAndSotre(String line) {
		
		Pattern nameP = Pattern.compile("(\\[)((?:\\D|\\d)+)(\\])(\\s\\[(.*(?:\\d{1}|\\d{2}):\\d{2}).*\\])((\\s)(.*))");
		Matcher nameM = nameP.matcher(line);
		String realName="";
		String realMessage="";
		String realDate="";
		
		if(nameM.find()) {
			String patternName = nameM.group();
			int first = nameM.start(2);
			int last = nameM.end(2);
			realName = patternName.substring(first, last);
			
		
			String mss = nameM.group();
			int firstM = nameM.start(8);
			int lastM = nameM.end(8);
			realMessage = mss.substring(firstM, lastM);
			realMessage.replace("\\n", " ");
			
			String day = nameM.group();
			int firstD = nameM.start(5);
			int lastD = nameM.end(5);
			realDate=day.substring(firstD, lastD);
			if(realDate.contains("오전 ")|realDate.contains("오후 ")) {
				realDate.replace("오전 ", "");
				realDate.replace("오후 ", "");
			}
			String fullMessage = realName+" "+realMessage;
			if(!messageM.contains(fullMessage))	
				messageM.add(fullMessage);
		}
		
	}
	public String selectData(String line) {
		Pattern nameP = Pattern.compile("(\\[)((?:\\D|\\d)+)(\\])(\\s\\[(.*(?:\\d{1}|\\d{2}):\\d{2}).*\\])((\\s)(.*))");
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
