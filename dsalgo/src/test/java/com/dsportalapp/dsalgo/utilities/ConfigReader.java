
package com.dsportalapp.dsalgo.utilities;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {
	
	public static ThreadLocal<Properties> prop = new ThreadLocal<Properties>();
	
	private static void init_prop() {		
		prop.set(new Properties());
		try {
			FileInputStream fis = new FileInputStream("./src/test/resources/config/global.properties");
			prop.get().load(fis);
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
		} catch (IOException e) {
			
			e.printStackTrace();
		}		 
	}
	
	public static String getProperty(String key) {
		if (prop.get() == null) {
			init_prop();
		}
		return prop.get().getProperty(key);
	}
	public static void setProperty(String key, String value) {
		if (prop.get() == null) {
			init_prop();
		}
		prop.get().setProperty(key,value);
	}

}
