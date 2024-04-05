package com.dsportalapp.dsalgo.stepDefinition;

import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;

import com.dsportalapp.dsalgo.POM.CommonMethodsObject;
//import com.dsportalapp.dsalgo.POM.LinkedListObjects;
import com.dsportalapp.dsalgo.POM.PortalPageObjects;
import com.dsportalapp.dsalgo.utilities.TestSetup;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


public class PortalPageStepDefinition {
	
	WebDriver driver;
	TestSetup testsetup;
	PortalPageObjects portalobj;
//	LinkedListObjects linkedlistobj;
	CommonMethodsObject commonobj;
	public static Logger LOG = LoggerFactory.getLogger(PortalPageStepDefinition.class);
	
	
	public PortalPageStepDefinition(TestSetup testsetup) {
		super();
		this.testsetup = testsetup;
		portalobj = testsetup.pageobjectmanager.getPortalPageObjects();
//		linkedlistobj = testsetup.pageobjectmanager.getLinkedListObjects();
		commonobj = testsetup.pageobjectmanager.getCommonMethodsObject();
	}
	
//	Scenario: User landing on DS_Algo Introduction page
	
	@Given("The user is opening the browser and enter the DS_Algo Portal <URL>")
	public void the_user_is_should_open_the_browser_and_enter_the_ds_algo_portal_url() {
		LOG.info("The user is on Landing Page successful");
	}

	@Then("The user should landed on the DS_Algo get started page with message {string}")
	public void the_user_should_landed_on_the_ds_algo_get_started_page_with_message(String expectedMessage) throws InterruptedException {
		String actualMessage = portalobj.getIntroPageMessage();
		LOG.info("Actual Message is :" + actualMessage);
		Assert.assertEquals(actualMessage, expectedMessage,"You are at the right place message is mismatch");
	}
	
	@Then("The user should see the title {string}")
	public void the_user_should_see_the_title(String pageTitle) {
		String title = portalobj.getTitle();
		LOG.info("Title of the page Introduction page is " + title);
		Assert.assertEquals(title, pageTitle,"Page title mismatch");
	}
		
	@When("The user clicks Get Started button")
	public void the_user_clicks_get_started_button() throws InterruptedException {
		commonobj.clicktoHomeGetStartedButton();
	}

	@Then("The user should redirected to DS_Algo {string} page")
	public void the_user_should_redirected_to_ds_algo_page(String redirectedPageName) {
		boolean isRedirected = commonobj.isOnRedirectedPage(redirectedPageName);
		Assert.assertTrue(isRedirected, "The user is not redirected to DS_Algo Home page");
		LOG.info("The user is redirected to the {} Page successfully!",redirectedPageName);
	}
	
}
