package com.informatica.gcs;

import java.lang.String;
import java.util.List;
import java.util.ArrayList;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;

public class ADTool {
	String srcFileName = ""; //default source file for AD input
	String inputDelimiter =";"; // default input delimiter for input data file
	static String addressInputFormatFile = "InputFormat.cfg";
	
	public ADTool () {
		//Initialize AddressDoctor input format file
		readAddressInputFormatFile();
		//	check default file location
		//Initialize Java environment
		//	check location of Java
		//Initialize AD environment
	}
	
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
}
