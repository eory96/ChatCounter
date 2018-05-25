package edu.handong.csee.java.chatcounter;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/**
 * This method will parse a string of .txt file and meke Arraylist that store message
 * @author gimdaegyo
 *
 */
public class MacParser implements MessageParser{

	static ArrayList<String> messageM = new ArrayList<String>();
	/**
	 * This method parse txt file and store parsing data to messageW array list
	 * so it can make integrate all message
	 */

	public void parsingAndSotre(String line) {
		String realName="";
		String realMessage="";
		String realDate="";
		String realTime="";
		
		Pattern nameP = Pattern.compile("(\\[)((?:\\D|\\d)+)(\\])(\\s\\[(.*)\\])((\\s)(.*))");
		
		
		Matcher nameM = nameP.matcher(line);
		
		
		
		if(nameM.find()) {
			String patternName = nameM.group();
			int first = nameM.start(2);
			int last = nameM.end(2);
			realName = patternName.substring(first, last);
			
		
			String mss = nameM.group();
			int firstM = nameM.start(8);
			int lastM = nameM.end(8);
			realMessage = mss.substring(firstM, lastM);
			realMessage.replace("\n", " ");
			
			String day = nameM.group();
			int firstD = nameM.start(5);
			int lastD = nameM.end(5);
			realDate=day.substring(firstD, lastD);
			
		}
		
		
		String fullMessage = "\""+realName+"\""+", "+"\""+cutTime(realDate)+"\""+", "+"\""+realMessage+"\"";
		if(!messageM.contains(fullMessage))	
			messageM.add(fullMessage);
	}
	/**
	 * this method used by FileLoader class to check line useful
	 */
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
	private String cutTime(String r) {
		Pattern forTimeK = Pattern.compile("(\\D+)(\\s)(\\d+)(:)(\\d+)");
		Pattern forTimeE = Pattern.compile("(\\d+)(:)(\\d+)(\\s)(\\D+)");
		Matcher dateM1 = forTimeK.matcher(r);
		Matcher dateM2 = forTimeE.matcher(r);
		int currentHour = 0;
		String realTime2=null;
		if(dateM1.find()) {
			String time = dateM1.group();
			String ap = dateM1.group(1);
			if(ap.equals("오전"))
				currentHour = Integer.parseInt(dateM1.group(3));
			else
				currentHour = Integer.parseInt(dateM1.group(3))+12;
			String realTime1 = currentHour+":"+dateM1.group(5);
			return realTime1;
		}
	
		else if(dateM2.find()) {
			String time = dateM2.group();
			String ap = dateM2.group(5);
			if(ap.equals("AM"))
				currentHour = Integer.parseInt(dateM2.group(1));
			else
				currentHour = Integer.parseInt(dateM2.group(1))+12;
			realTime2 = currentHour+":"+dateM2.group(3);
			return realTime2;
		}
		return realTime2;
	}
	
	
}
