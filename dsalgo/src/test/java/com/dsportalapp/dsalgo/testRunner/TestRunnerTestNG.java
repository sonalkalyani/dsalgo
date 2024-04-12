
package com.dsportalapp.dsalgo.testRunner;

import org.testng.annotations.DataProvider;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;



@CucumberOptions(

		features = "src/test/resources/features",
//		"src/test/resources/features/LoginPage.feature",
		glue = {"com.dsportalapp.dsalgo.stepDefinition","com.dsportalapp.dsalgo.hooks"},
		monochrome = true,
//		dryRun=true
//		plugin = {"pretty", "html:target/cucumber.html","json:target/cucmber.json",
		plugin ={"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"}

		)
public class TestRunnerTestNG extends AbstractTestNGCucumberTests{
		
//		 this is for pararell execution	, scenarios() present in AbstractTestNGCucumberTests() class.
		@Override       
		@DataProvider(parallel = true)
		public Object[][] scenarios() {
			return super.scenarios();
		}
	}

