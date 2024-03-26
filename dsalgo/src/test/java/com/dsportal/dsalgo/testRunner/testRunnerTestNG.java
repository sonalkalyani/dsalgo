package com.dsportal.dsalgo.testRunner;

import org.testng.annotations.DataProvider;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

public class testRunnerTestNG {

	@CucumberOptions(
			features=
					"src/test/resources/features/Login.feature",
			glue="stepDefinition",
			monochrome = true,
			tags = "@TC_001")
//			dryRun=true
//			plugin = {"pretty", "html:target/cucumber.html","json:target/cucmber.json",
//			plugin ={"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"}
			
	public class TestNGTestRunner extends AbstractTestNGCucumberTests {
	
//		 this is for pararell execution	, scenarios() present in AbstractTestNGCucumberTests() class.
//		@Override       
//		@DataProvider(parallel = true)
//		public Object[][] scenarios() {
//			return super.scenarios();
//		}
		
		@Override
	    @DataProvider(parallel = false)
	    public Object[][] scenarios() {
					
			return super.scenarios();	
	    }
	}
}
