package com.dsportalapp.dsalgo.stepDefinition;

import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;

import com.dsportalapp.dsalgo.POM.PortalPageObjects;
import com.dsportalapp.dsalgo.utilities.TestSetup;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


public class PortalPageStepDefinition {
	
	WebDriver driver;
	TestSetup testsetup;
	PortalPageObjects portalintroductionpageobj;
	public static Logger LOG = LoggerFactory.getLogger(PortalPageStepDefinition.class);
	
	
	public PortalPageStepDefinition(TestSetup testsetup) {
		super();
		this.testsetup = testsetup;
		portalintroductionpageobj = testsetup.pageobjectmanager.getPortalIntroductionPageObjects();
	}

	@Given("The user is opening the browser and enter the DS_Algo Portal <URL>")
	public void the_user_is_should_open_the_browser_and_enter_the_ds_algo_portal_url() {
	  
	}

	@Then("The user should landed on the DS_Algo get started page with message {string}")
	public void the_user_should_landed_on_the_ds_algo_get_started_page_with_message(String expectedMessage) throws InterruptedException {
	
	String actualMessage = portalintroductionpageobj.getIntroPageMessage();
	LOG.info("Actual Message is :" + actualMessage);
	Assert.assertEquals(actualMessage, expectedMessage);
	
	}
		
	@When("The user clicks Get Started button")
	public void the_user_clicks_get_started_button() throws InterruptedException {
		Thread.sleep(2000);
		portalintroductionpageobj.clicktoHomeGetStartedButton();
	}

	@Then("The user should land on the DS_Algo home page")
	public void the_user_should_land_on_the_ds_algo_home_page() {
		portalintroductionpageobj.isOnHomePage();
		LOG.info("Landing on the Home Page is successful!");
	}
}
