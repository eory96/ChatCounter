package edu.handong.csee.java.chatcounter;
import java.util.ArrayList;
/**
 * This method will parse a string of .csv file and meke Arraylist that store message
 * @author gimdaegyo
 *
 */
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/**
 * this class will parse csv file using static arraylist 
 * arraylist store name, time, message in particular form
 * and be used by NameAdder class for make hashmap
 * @author gimdaegyo
 *
 */
public class WindowsParser implements MessageParser{
	/**
	 * messageW arraylist save data from csv file
	 */
	static ArrayList<String> messageW = new ArrayList<String>();
	/**
	 * This method parse csv file and store parsing data to messageW array list
	 * so it can make integrate all message
	 */
	public void parsingAndSotre(String line) {

		Pattern nameP = Pattern.compile("(20[0-1][0-9]-[0-1][0-9]-[0-3][0-9]\\s)([0-2][0-9]:[0-5][0-9])(:[0-5][0-9])(\\,\")(.*)(\"\\,)(\")(.*)");
		Matcher nameM = nameP.matcher(line);
		String realName="" ;
		String realMss="";
		String realTime="";
		String fullString="";

		//String noMss="joined this chatroom.";
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
			if(!messageW.contains(fullString))
			messageW.add(fullString.replace(" \"", "\""));
		}


	}
	/**
	 * this method used by FileLoader class to check line useful
	 */
	public String selectData(String line) {
		Pattern nameP = Pattern.compile("(20[0-1][0-9]-[0-1][0-9]-[0-3][0-9]\\s)([0-2][0-9]:[0-5][0-9])(:[0-5][0-9])(\\,\")(.*)(\"\\,)(\")(.*)");
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


