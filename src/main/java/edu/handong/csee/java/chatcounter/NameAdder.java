package edu.handong.csee.java.chatcounter;

import java.util.ArrayList;

public class NameAdder {
	
	public void add(ArrayList<String> names) {
		ArrayList <String> name = new ArrayList<String>();
		
		//String arr[] = new String[names.size()];
		//names.toArray(arr);
		names.sort(null);
		
		/*for(int i=0;i<arr.length;i++) {
			if(!name.contains(arr[i]))
				name.add(arr[i]);
		}*/
		
		for(String n:names) {
			System.out.println(n);
		}
	}
}
