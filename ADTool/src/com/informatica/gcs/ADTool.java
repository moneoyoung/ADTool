package com.informatica.gcs;

import java.lang.String;
import java.io.File;
import java.util.List;
import java.nio.charset.*;
import com.google.common.io.*;

public class ADTool {
	List<String> addressElement = null;
	
	String srcFileName = ""; //default source file for AD input
	String inputDelimiter =";"; // default input delimiter for input data file
	String addressTemplateFile = "ConsoleDemoJava.tmpl"; //Java template file before give address element
	static String addressInputFormatFile = "InputFormat.cfg";
	
	
	public ADTool () {
		//Initialize AddressDoctor input format file
		addressElement = readAddressInputFormatFile();
		
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
		String fncSnippet = "m_oAO.setInputAddressElement(%agr%, addr[%num%]);\n";
		String str = "";
		Integer i = new Integer(0);
		
		for (String strAddress : this.addressElement) {
			String tempStr = null;
			tempStr = fncSnippet.replace("%agr%", strAddress);
			str += tempStr.replace("%num%", i.toString());
			i++;
		}
		
		return str;
	}
	
	/*
	 * Read Template file and replace %AssignAddressInput% with a string returned from makeAssignString method
	 * And save the sting as a file named  
	 */
	
}
