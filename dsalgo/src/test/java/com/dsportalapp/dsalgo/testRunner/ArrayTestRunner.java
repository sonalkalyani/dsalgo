package com.dsportalapp.dsalgo.testRunner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
                features = "src/test/resources/features/ArrayPage.feature/",
                glue = "com.dsportalapp.dsalgo.stepDefinition", 
                plugin = { "pretty","html:target/cucumber-reports/cucumber-pretty", 
                           "json:target/cucumber-reports/CucumberTestReport.html",
                           "rerun:target/cucumber-reports/rerun.txt" },
                monochrome = true)
public class ArrayTestRunner extends AbstractTestNGCucumberTests {

}


