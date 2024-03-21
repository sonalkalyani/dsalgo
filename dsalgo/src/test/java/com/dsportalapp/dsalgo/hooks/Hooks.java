package com.dsportalapp.dsalgo.hooks;

import com.dsportalapp.dsalgo.utilities.TestSetup;
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
