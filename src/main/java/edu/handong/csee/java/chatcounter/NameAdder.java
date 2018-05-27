package edu.handong.csee.java.chatcounter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.SortedSet;
import java.util.TreeSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/**
 * This class will calculate how many times say in kakaoTalk
 * totalMss1 save all of message and 2 remove same lines talking at same time
 * kakao_id array have id just one time and this make name array 
 * all_kakao_id arraylist have all id of totalMss2
 * last counter hashmap has key that save name, and value that save how many times talking on kakaoTalk0  
 * @author gimdaegyo
 *
 */
public class NameAdder {
	/**
	 * totalMss1 arraylist1 save all message except overlaping data
	 */
	ArrayList<String> totalMss1 =new ArrayList<String>();
	/**
	 * kakao_id arraylist save kakao_id (id store just once)
	 */
	ArrayList<String> kakao_id = new ArrayList<String>();
	/**
	 * all_kakao_id arraylist save all emerged id from tatalMss1
	 */
	ArrayList<String> all_kakao_id = new ArrayList<String>();
	/**
	 * name array use for counting how use kakao
	 */
	String[] name = new String[kakao_id.size()];
	/**
	 * counter hashmap save id(key),counting number(value)->sorted result
	 */
	HashMap<String, Integer> counter = new HashMap<String, Integer>();
	
	/**
	 * this will method return counter hashmap to FileWriter class
	 * @return
	 */
	public HashMap<String,Integer> count(){
		return counter;
	}
	/**
	 * this method for countname and store name and counting array (sort result)
	 */
	public String[] countName() {
		storeMessageToOne();
		int count=0;
		
		String[] name = new String[kakao_id.size()];
		kakao_id.toArray(name);
		
		for(int i=0;i<name.length;i++) {
			count=0;
			for(String j:all_kakao_id) {
				if(j.equals(name[i]))
					count++;
			}
			//if(name[i].equals("남재창")) count=count-1;
			counter.put(name[i],count);
		}
		
		for(int j=0;j<name.length;j++) {
			String temp = "";
			for(int i=j;i<name.length-1;i++) {
				if(counter.get(name[j]).compareTo(counter.get(name[i+1]))<=0) {
					temp = name[j];
					name[j]=name[i+1];
					name[i+1]=temp;
				}
			}	
		}
		
		return name;
	}
	
	private void storeMessageToOne() {
		MacParser mac = new MacParser();
		WindowsParser windows = new WindowsParser();
		String change="";
		String deleteWhiteSpace="";
		
		for(String n:mac.messageM) {
			if(!totalMss1.contains(n))
			totalMss1.add(n);
		}
		
		for(String w:windows.messageW) {
			if(w.contains("\"\"")) {
				change=w.replace("\"\"", "\"");
				if(!totalMss1.contains(change))
					totalMss1.add(change);
			}
			else {
				if(!totalMss1.contains(w));
					totalMss1.add(w);
			}
			
		}

		for(String out2:totalMss1) {
			naming(out2);
			totalName(out2);
		}
	}
	
	private void naming(String line) {
		Pattern nameP = Pattern.compile("(\")(.*)(\")(,\\s)(\")([0-2][0-9]:[0-5][0-9])(\",\\s)(\")(.*)(\")");
		Matcher nameM = nameP.matcher(line);
		String justName="";
		
		if(nameM.find()) {
			String patternName = nameM.group();
			int first = nameM.start(2);
			int last = nameM.end(2);
			justName = patternName.substring(first, last);
			
			if(!kakao_id.contains(justName))
				kakao_id.add(justName);
		}
	}
	
	private void totalName(String line) {
		Pattern nameP = Pattern.compile("(\")(.*)(\")(,\\s)(\")([0-2][0-9]:[0-5][0-9])(\",\\s)(\")(.*)(\")");
		Matcher nameM = nameP.matcher(line);
		String justName="";
		
		if(nameM.find()) {
			String patternName = nameM.group();
			int first = nameM.start(2);
			int last = nameM.end(2);
			justName = patternName.substring(first, last);
			
			all_kakao_id.add(justName);
		}
	}
}




