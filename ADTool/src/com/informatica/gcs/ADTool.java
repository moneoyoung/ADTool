package com.informatica.gcs;

import java.lang.String;
import java.util.List;
import java.io.File;

public class ADTool {
	String srcFileName = ""; //default source file for AD input
	String inputDelimiter =";"; // default input delimiter for input data file
	String addressInputFormatFile = "InputConfig.xml";
	
	public ADTool () {
		//Initialize AddressDoctor input format file
		
		//	check default file location
		//Initialize Java environment
		//	check location of Java
		//Initialize AD environment
	}
	
	List<String> readAddressInputFormatFile() {
		 
		try {
			File configXml = new File(addressInputFormatFile);
		} catch (Exception e) {
			
		}
		
		return "";
	}
}
