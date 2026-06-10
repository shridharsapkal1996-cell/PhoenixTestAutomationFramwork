package com.api.utils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class ConfigManagerOLD {
	// WAP to read properties file from src/test/resources/config/config.properties

	// public String getProperty(String key) throws IOException {

	private static Properties prop = new Properties(); // Create the object of properties class

  private ConfigManagerOLD(){
  
	  //private constructor 
  }
	// Load the properties file using the load()

	static {

		// operation of loading the properties file is in the memory
		// Static block it will executed once during class loading time

		File configFile = new File(
				System.getProperty("user.dir") +File.separator+"test"+File.separator+"resources"+File.separator+"config"+File.separator+"config.properties");
		FileReader fileReader = null;
		try {

			fileReader = new FileReader(configFile);

			prop.load(fileReader);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {   
			e.printStackTrace();
		}

	}

	public static String getProperty(String key) {
		// create the object of propertes class
		return prop.getProperty(key);
	}

	
}
