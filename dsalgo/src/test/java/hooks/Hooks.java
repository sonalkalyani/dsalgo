package hooks;

import io.cucumber.java.After;
import utilities.TestSetup;

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
