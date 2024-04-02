package com.dsportalapp.dsalgo.webDriverManager;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.dsportalapp.dsalgo.POM.LoginPageObjects;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverManager {

public WebDriver driver;
public static Logger Log = LoggerFactory.getLogger(LoginPageObjects.class);
	
	public static ThreadLocal <WebDriver> tldriver = new ThreadLocal<>();
	
	public WebDriver init_driver(String browser) {
		
		Log.info("browser value is:" +browser);
		
		if (browser.equals("chrome")) {
			
			WebDriverManager.chromedriver().setup();
			tldriver.set(new ChromeDriver());
			
		}
		
		else if(browser.equals("firefox")) {
			
			WebDriverManager.firefoxdriver().setup();
			tldriver.set(new FirefoxDriver());
			
		}
		
		else if(browser.equals("edge")) {
			
			WebDriverManager.edgedriver().setup();
			tldriver.set(new EdgeDriver());
		}
		else {
			Log.info("please pass the correct browser: " +browser);
		}
		
		getDriver().manage().deleteAllCookies();
		getDriver().manage().window().maximize();
		return getDriver();
	}
	
	public synchronized WebDriver getDriver() {
		
		return tldriver.get();
	}


}