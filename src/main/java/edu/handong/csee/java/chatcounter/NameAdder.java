package edu.handong.csee.java.chatcounter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class NameAdder {
	ArrayList<String> totalMss =new ArrayList<String>();
	ArrayList<String> kakao_id = new ArrayList<String>();
	ArrayList<String> all_kakao_id = new ArrayList<String>();
	String[] name = new String[kakao_id.size()];
	
	public void count() {
		HashMap<String, Integer> counter = new HashMap();
		String[] name = new String[kakao_id.size()];
		kakao_id.toArray(name);
		int count;
		
		for(int i=0;i<name.length;i++) {
			count=0;
			for(String j:all_kakao_id) {
				if(j.equals(name[i]))
					count++;
			}
			counter.put(name[i],count);
		}
		System.out.println(counter.get("남재창"));
	}
	
	public void storeMessageToOne() {
		MacParser mac = new MacParser();
		WindowsParser windows = new WindowsParser();
		HashMap<String, Integer> counter = new HashMap();
		int count=0;
		
		for(String n:mac.messageM) {
			totalMss.add(n);
		}
		for(String w:windows.messageW) {
			if(!totalMss.contains(w))
				totalMss.add(w);
		}
		
		for(String out:totalMss) {
			naming(out);
			totalName(out);
		}
		
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
		System.out.println(counter.get("Java_Lov"));
	}
	
	private void naming(String line) {
		Pattern nameP = Pattern.compile("(\")(\\D*|\\d*)(\",)(\\s)(.*)(\")(.*)(\")");
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
		Pattern nameP = Pattern.compile("(\")(\\D*|\\d*)(\",)(\\s)(.*)(\")(.*)(\")");
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
