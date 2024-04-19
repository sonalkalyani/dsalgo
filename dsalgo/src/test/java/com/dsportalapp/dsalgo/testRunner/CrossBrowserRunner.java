package com.dsportalapp.dsalgo.testRunner;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import com.dsportalapp.dsalgo.utilities.ConfigReader;
import com.dsportalapp.dsalgo.webDriverManager.DriverManager;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(


		features = "src/test/resources/features/",


		glue = {"com.dsportalapp.dsalgo.stepDefinition","com.dsportalapp.dsalgo.hooks"},
		monochrome = true,

//		dryRun=true
		plugin = {"pretty", "html:target/cucumber.html","json:target/cucumber.json",
		       	  "pretty","io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm",
			      "pretty","com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"}
		)
public class CrossBrowserRunner extends AbstractTestNGCucumberTests{
	
	String browser;
	
	@BeforeClass
	@Parameters("browser")
	public  void beforeClass(@Optional String browser) {
		 this.browser = browser;
		if(browser != null && !browser.equals("param-val-not-found")) {
			ConfigReader.setProperty("browser", browser);

		}
	}



	}

