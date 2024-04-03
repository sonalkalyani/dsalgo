
package com.dsportalapp.dsalgo.testRunner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import io.qameta.allure.testng.Tags;

public class testRunnerTestNG {

	@CucumberOptions(

			features = "src/test/resources/features/LoginPage.feature",
//			"src/test/resources/features/linkedList.feature",
//			"src/test/resources/features/LoginPage.feature",

			glue = {"com.dsportalapp.dsalgo.stepDefinition","com.dsportalapp.dsalgo.hooks"},
			monochrome = true
//			tags  = ,


//			dryRun=true
//			plugin = {"pretty", "html:target/cucumber.html","json:target/cucmber.json",
//			plugin ={"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"}

			)
	public class TestNGTestRunner extends AbstractTestNGCucumberTests {
	
//		 this is for pararell execution	, scenarios() present in AbstractTestNGCucumberTests() class.
//		@Override       
//		@DataProvider(parallel = true)
//		public Object[][] scenarios() {
//			return super.scenarios();
//		}
	}
}
