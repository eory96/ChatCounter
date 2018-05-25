package edu.handong.csee.java.chatcounter;
/**
 *this class is interface MacParser and WindowsParser follow this form
 * @author gimdaegyo
 *
 */
public interface MessageParser {
	public void parsingAndSotre(String line);
	public String selectData(String line);
}