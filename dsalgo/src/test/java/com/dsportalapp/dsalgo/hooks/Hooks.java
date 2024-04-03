package com.dsportalapp.dsalgo.hooks;

import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;

import com.dsportalapp.dsalgo.utilities.ConfigReader;
import com.dsportalapp.dsalgo.utilities.TestSetup;
import com.dsportalapp.dsalgo.webDriverManager.DriverManager;

import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Hooks {
	
	private DriverManager driverManager;
	private WebDriver driver;
	private ConfigReader configFileReader;
	Properties prop;
	public TestSetup testup;
	
	
	public Hooks(TestSetup testup) {
		
		this.testup = testup;
	}
/*	
	@Before(order = 0)
	public void getProperty() {
		configFileReader = new ConfigReader();
		prop = configFileReader.init_prop();
	}
	
	@Before(order = 1)
	public void launchBrowser() {
	
		//String browserName = prop.getProperty("browser");
		driverManager = new DriverManager();
		try {
			driver = driverManager.getDriverManager();
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
	}
	@After(order = 0)
	public void quitBrowser() {
		driver.quit();
	}
	
	*/
	
	
}
