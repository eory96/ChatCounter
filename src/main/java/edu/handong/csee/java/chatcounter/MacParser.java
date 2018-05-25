package edu.handong.csee.java.chatcounter;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MacParser implements MessageParser{
	//ArrayList<String> name = new ArrayList();
	static ArrayList<String> messageM = new ArrayList<String>();
	//ArrayList<String> date = new ArrayList();
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
		
		/*for(String i:messageM) {
			System.out.println(i);
		}*/
		
	}
	private String cutTime(String r) {
		Pattern forTimeK = Pattern.compile("(\\D+)(\\s)(.*)");
		Pattern forTimeE = Pattern.compile("(.*)(\\s)(\\D+)");
		Matcher dateM1 = forTimeK.matcher(r);
		Matcher dateM2 = forTimeE.matcher(r);
		
		
		if(dateM1.find()) {
			String time = dateM1.group();
			int firstT = dateM1.start(3);
			int lastT = dateM1.end(3);
			String realTime1 = time.substring(firstT, lastT);
			return realTime1;
		}
	
		else if(dateM2.find()) {
			String time = dateM2.group();
			int firstT = dateM2.start(1);
			int lastT = dateM2.end(1);
			String realTime2 = time.substring(firstT,lastT);
			return realTime2;
		}
		return null;
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
