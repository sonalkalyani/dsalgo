package com.dsportalapp.dsalgo.hooks;

import java.io.IOException;

import com.dsportalapp.dsalgo.utilities.TestSetup;
import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Hooks {
	
	public TestSetup testup;

	public Hooks(TestSetup testup) {
		
		this.testup = testup;
	}
	@Before
	public void beforeScenario() throws IOException {
		testup.drivermanager.getDriverManager();
	}
	@After
	public void afterScenario() throws IOException {
		testup.drivermanager.getDriverManager().quit();
		}
	
}
