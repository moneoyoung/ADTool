package com.informatica.gcs;

import java.lang.String;
import java.util.List;
import java.util.ArrayList;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;

public class ADTool {
	List<String> addressElement = null;
	String srcFileName = ""; //default source file for AD input
	String inputDelimiter =";"; // default input delimiter for input data file
	String addressTemplateFile = "ConsoleDemoJava.java";
	static String addressInputFormatFile = "InputFormat.cfg";
	
	
	public ADTool () {
		//Initialize AddressDoctor input format file
		addressElement = readAddressInputFormatFile();
		
		//make address assign part
		
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
	static List<String> readAddressInputFormatFile() {
		String currentLine;
		BufferedReader br = null;
		List<String> addressElement = new ArrayList<String>();
	 
		try {
			FileReader inputConfigFile = new FileReader(addressInputFormatFile);
			br = new BufferedReader(inputConfigFile);
			
			while ((currentLine = br.readLine()) != null) {
				addressElement.add(currentLine);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (br != null)br.close();
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
		
		return addressElement;
	}
	
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
}
