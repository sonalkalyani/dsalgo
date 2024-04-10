package com.dsportalapp.dsalgo.utilities;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {
	
	private static Properties prop = null;
	/**
	 * this method is to load properties from config.properties file
	 * @return properties from prop object
	 */
	private static void init_prop() {		
		prop = new Properties();
		try {
			FileInputStream fis = new FileInputStream("./src/test/resources/config/global.properties");
			prop.load(fis);
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
		} catch (IOException e) {
			
			e.printStackTrace();
		}		
	}
	
	public static String getProperty(String key) {
		if (prop == null) {
			init_prop();
		}
		return prop.getProperty(key);
	}

}
