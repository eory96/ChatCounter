package edu.handong.csee.java.chatcounter;

import java.util.ArrayList;

public class NameAdder {
	
	public void add() {
		MacParser mac = new MacParser();
		WindowsParser windows = new WindowsParser();
		
		ArrayList<String> totalMss =new ArrayList();
		
		for(String n:mac.messageM) {
			totalMss.add(n);
		}
		for(String w:windows.messageW) {
			if(!totalMss.contains(w))
			totalMss.add(w);
		}
		
		for(String t:totalMss) {
			System.out.println(t);
		}
		
		//for(String out:totalMss) {
		//	System.out.println(out);
		//}
	}
}
