package com.informatica.gcs;

import java.lang.String;
import java.io.File;
import java.util.List;
import java.nio.charset.*;
import com.google.common.io.*;
import java.util.HashMap;


public class ADTool {
	List<String> addressElement = null;
	
	String srcFileName = ""; //default source file for AD input
	String inputDelimiter =";"; // default input delimiter for input data file
	String addressTemplateFile = "ConsoleDemoJava.tmpl"; //Java template file before give address element
	static String addressInputFormatFile = "InputFormat.cfg";
	HashMap<String, Integer> addressKey;
	HashMap<HashMap<String, Integer>, Integer> addressFormat;
	
	
	public ADTool () {
		//Initialize AddressDoctor input format file
		addressElement = readAddressInputFormatFile();
		
		
		//Initialize addressFormat key map
		addressKey = new HashMap<String, Integer>();
		
		
		
		//Initialize addreeFormat map
		addressFormat = new HashMap<HashMap<String, Integer>, Integer>();
		
		//make address assign part
		
		//ReadConsoleDemoJava
		//Replace %AssignAddressInput%
		
		//	check default file location
		//Initialize Java environment
		//	check location of Java
		//Initialize AD environment
	}
	
	public void printAddressElement () {
		for (String element : addressElement) {
			System.out.println(element);
		}
	}
	
	
	/*
	 * method to read input format file
	 */
	public List<String> readAddressInputFormatFile() {
		File f = new File(addressInputFormatFile);
		Charset cs = Charset.forName("UTF-8");
		
		try {
			addressElement = Files.asCharSource(f,  cs).readLines();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return addressElement;
	}
	
	/*
	 * Generate a string which assigns Address Elements to Address Object, m_oAO here
	 */
	String makeAssignString() {
		String[] addressArr;
		String str = new String();
		
		for (String strAddress : this.addressElement) {
			addressArr = strAddress.split(",");
			addressKey.put(addressArr[0], Integer.parseInt(addressArr[1]));
		}
		
		return str;
	}
	
	/*
	 * Read Template file and replace %AssignAddressInput% with a string returned from makeAssignString method
	 * And save the sting as a file named  
	 */
	
}
