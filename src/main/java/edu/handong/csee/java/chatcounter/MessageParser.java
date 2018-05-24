package edu.handong.csee.java.chatcounter;

public interface MessageParser {
	//public boolean existPattern(String string);
	//public String return_kakao_name(String line);
	public void parsingAndSotre(String line);
	public String selectData(String line);
}