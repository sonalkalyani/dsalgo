package utilities;

import java.io.IOException;

import org.openqa.selenium.WebDriver;

import pageObjectModel.PageObjectManager;
import webDriverManager.DriverManager;

public class TestSetup {
	public WebDriver driver;
	public DriverManager drivermanager;
	public PageObjectManager pageobjectmanager;

	public TestSetup() throws IOException {
		
		drivermanager = new DriverManager();
		pageobjectmanager = new PageObjectManager(drivermanager.getDriverManager());
	}
	
}
