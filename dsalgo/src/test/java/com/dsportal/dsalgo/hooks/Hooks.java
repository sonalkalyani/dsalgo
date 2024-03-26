package com.dsportal.dsalgo.hooks;

import com.dsportal.dsalgo.utilities.TestSetup;

import io.cucumber.java.After;

public class Hooks {
	
	public TestSetup testup;

	public Hooks(TestSetup testup) {
		
		this.testup = testup;
	}
	
//	@After
//	public void afterScenario() {
//		testup.drivermanager.webDriverManager().quit();
//		}
	
}
