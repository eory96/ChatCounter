package edu.handong.csee.java.chatcounter;
/**
 *this class is interface MacParser and WindowsParser follow this form
 * @author gimdaegyo
 *
 */
public interface MessageParser {
	/**
	 * this method will use for parsing the line
	 * @param line
	 */
	public void parsingAndSotre(String line);
	/**
	 * this method will use for selecting data
	 * @param line
	 * @return
	 */
	//public boolean selectData(String line);
}