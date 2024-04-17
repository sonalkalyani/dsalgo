package com.dsportalapp.dsalgo.hooks;

import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.dsportalapp.dsalgo.utilities.ConfigReader;
import com.dsportalapp.dsalgo.utilities.TestSetup;
import com.dsportalapp.dsalgo.webDriverManager.DriverManager;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class Hooks {
	
	private DriverManager driverManager;
	private WebDriver driver;
	private ConfigReader configFileReader;
	Properties prop;
	public TestSetup testup;
	
	
	public Hooks(TestSetup testup) throws IOException {
		
		this.testup = testup;
		this.driver=testup.drivermanager.getDriverManager();
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
	
	
	*/
	@After(order = 0)
	public void quitBrowser() {
		driver.quit();
	}
	
	@After(order = 1)
	public void takeScreenshotOnFailure(Scenario scenario)
	{
		if(scenario.isFailed())
		{
			TakesScreenshot ts=(TakesScreenshot)driver;
			byte[] src=ts.getScreenshotAs(OutputType.BYTES);
			scenario.attach(src, "image/png", "screenshot");
		}
	}
	
}
