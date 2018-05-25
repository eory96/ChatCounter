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
	ArrayList<String> totalMss1 =new ArrayList<String>();
	ArrayList<String> totalMss2 =new ArrayList<String>();
	ArrayList<String> kakao_id = new ArrayList<String>();
	ArrayList<String> all_kakao_id = new ArrayList<String>();
	String[] name = new String[kakao_id.size()];
	HashMap<String, Integer> counter = new HashMap<String, Integer>();
	
	/**
	 * this method for countname and store name and counting array (sort result)
	 */
	public void countName() {
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
			System.out.println(name[j]+" "+counter.get(name[j]));
		}
	}
	
	private void storeMessageToOne() {
		MacParser mac = new MacParser();
		WindowsParser windows = new WindowsParser();
		
		for(String n:mac.messageM) {
				totalMss1.add(n);
		}
		for(String a:mac.messageM) {
			System.out.println(a);
		}
		for(String w:windows.messageW) {
			if(!totalMss1.contains(w))
				totalMss1.add(w);
		}

		for(String out:totalMss1) {
			compareWandM(out);
		}
		
		for(String out2:totalMss2) {
			naming(out2);
			totalName(out2);
		}

		
	}
	
	private void naming(String line) {
		Pattern nameP = Pattern.compile("(\")(.*)(\")(\\d*)(\",.*)");
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
		Pattern nameP = Pattern.compile("(\")(.*)(\")(\\d*)(\",.*)");
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
	
	private void compareWandM(String line) {
		Pattern nameP = Pattern.compile("(\".*\")(\\, )(\")(\\d{1}|\\d{2})(:)(.*)");
		Matcher nameM = nameP.matcher(line);
		String cMss="";
		
		if(nameM.find()) {
			String patternName = nameM.group();
			int first =nameM.start(1);
			int last = nameM.end(1);
			String name = patternName.substring(first, last);
			
			String patternMss = nameM.group();
			int firstM = nameM.start(6);
			int lastM = nameM.end(6);
			String mss = patternName.substring(firstM,lastM);
			String message = name+mss;
			
			if(!totalMss2.contains(message))
				totalMss2.add(message);
		}
	}
	
}




