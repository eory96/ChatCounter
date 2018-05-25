package edu.handong.csee.java.chatcounter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class NameAdder {
	static ArrayList<String> totalMss1 =new ArrayList<String>();
	static ArrayList<String> totalMss2 =new ArrayList<String>();
	static ArrayList<String> kakao_id = new ArrayList<String>();
	static ArrayList<String> all_kakao_id = new ArrayList<String>();
	static String[] name = new String[kakao_id.size()];
	//String n,w;
	
	public void storeMessageToOne() {
		MacParser mac = new MacParser();
		WindowsParser windows = new WindowsParser();
		
		HashMap<String, Integer> counter = new HashMap();
		int count=0;
		
		
		for(String n:mac.messageM) {
			//if(!totalMss.contains(n))
				totalMss1.add(n);
		}
		
		for(String w:windows.messageW) {
			if(!totalMss1.contains(w))
				totalMss1.add(w);
		}
		
		/*for(String ou1:totalMss1) {
			System.out.println(ou1);
		}*/
		
		for(String out:totalMss1) {
			compareWandM(out);
		}
		
		for(String out2:totalMss2) {
			naming(out2);
			totalName(out2);
		}
		
		/*totalMss2.sort(null);
		for(String s:totalMss2) {
			System.out.println(s);
		}*/
		
		String[] name = new String[kakao_id.size()];
		kakao_id.toArray(name);
		
		/*for(int i=0;i<name.length;i++) {
			System.out.println(name[i]);
		}*/
		
		for(int i=0;i<name.length;i++) {
			count=0;
			for(String j:all_kakao_id) {
				if(j.equals(name[i]))
					count++;
			}
			counter.put(name[i],count);
		}
		for(int j=0;j<name.length;j++) {
			System.out.println(name[j]+" "+counter.get(name[j]));
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




