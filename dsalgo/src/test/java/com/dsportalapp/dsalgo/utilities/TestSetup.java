package com.dsportalapp.dsalgo.utilities;

import java.io.IOException;

import org.openqa.selenium.WebDriver;

import com.dsportalapp.dsalgo.POM.PageObjectManager;
import com.dsportalapp.dsalgo.webDriverManager.DriverManager;

public class TestSetup {
	public WebDriver driver;
	public DriverManager drivermanager;
	public PageObjectManager pageobjectmanager;

	public TestSetup() throws IOException {
		
		drivermanager = new DriverManager();
		pageobjectmanager = new PageObjectManager(drivermanager.getDriver());
	}
	
}
