package com.dsportalapp.dsalgo.stepDefinition;

import static org.testng.Assert.assertTrue;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URISyntaxException;

import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.dsportalapp.dsalgo.POM.CommonMethodsObject;
import com.dsportalapp.dsalgo.POM.HomePageObjects;
import com.dsportalapp.dsalgo.POM.LinkedListObjects;
import com.dsportalapp.dsalgo.POM.LoginPageObjects;
import com.dsportalapp.dsalgo.POM.PortalPageObjects;
import com.dsportalapp.dsalgo.utilities.TestSetup;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class CommonMethodsStepDefinition {
	WebDriver driver;
	TestSetup testsetup;
	LinkedListObjects linkedlistobj;
	HomePageObjects homepageobj;
	CommonMethodsObject commonobj;
	LoginPageObjects loginpageobj;
	
	
	public static Logger LOG = LoggerFactory.getLogger(PortalPageStepDefinition.class);
	
	
	public CommonMethodsStepDefinition(TestSetup testsetup) throws IOException {
		super();
		this.testsetup = testsetup;
		this.driver = testsetup.drivermanager.getDriverManager();
		linkedlistobj = testsetup.pageobjectmanager.getLinkedListObjects();
		commonobj = testsetup.pageobjectmanager.getCommonMethodsObject();
		homepageobj = testsetup.pageobjectmanager.getHomePageObjects();
		loginpageobj = testsetup.pageobjectmanager.getLoginPageObjects();
	}
	@Given("User should be logged in with valid credential")
	public void user_should_be_logged_in_with_valid_credential() {
		driver.get("https://dsportalapp.herokuapp.com/home");
		homepageobj.clickSignInButton();
		loginpageobj.enterValidUsernameandPassword();
//		commonobj.login();
	}
//	@Given("User is on DS_Algo Home page after logged in")
//	public void user_is_on_ds_algo_home_page_after_logged_in() {
//	    // Write code here that turns the phrase above into concrete actions
//	    throw new io.cucumber.java.PendingException();
//	}

	@When("The user select Get Started button in {string} panel")
	public void the_user_select_get_started_button_in_linked_list_panel(String dataStructureName) throws InterruptedException {
		
		commonobj.clickGetStartedButtonCommon(dataStructureName);
	}

	@Then("The user should be redirected to following page")
	public void the_user_should_be_redirected_to_linked_list_page(String redirectedPageName) {
		assertTrue(commonobj.isOnRedirectedPage(redirectedPageName), "The user should be in https://dsportalapp.herokuapp.com/"+ redirectedPageName + "/ Page");
	}
	
//	--------------------------------------------------------
	@Given("User is on {string} Home page")
	public void user_is_on_linked_list_home_page(String dataStructureName) throws InterruptedException {
		commonobj.clickGetStartedButtonCommon(dataStructureName);
//		linkedlistobj.isOnLinkedListHome();
	}

	@When("The user clicks {string} link")
	public void the_user_clicks_link(String homeLinkName) {
		commonobj.clickdataStructuresHomeLinks(homeLinkName);
	}
	
	@Then("The user should be redirected to {string} page")
	public void the_user_should_be_redirected_to_topics_page(String redirectedPage) {
		assertTrue(commonobj.isOnRedirectedPage(redirectedPage), "The user is not redirected to "+redirectedPage+" Topic Page");
		LOG.info("The user is redirected to "+ redirectedPage + " page");
	}
	
	
	@When("The user clicks Try Here button")
	public void the_user_clicks_try_here_button() {
		commonobj.clickTryHereButton();
	}

	@Then("The user should redirected to the page having Editor and Run button")
	public void the_user_should_redirected_to_the_page_having_editor_and_run_button() {
		assertTrue(commonobj.isOntryEditorPage(),"The user is not redirected to Python Editor Page");
		LOG.info("The user is redirected to Python Editor page");
	}

	@When("The user clicks the Run button after writes following Valid Python Code in editor")
	public void the_user_clicks_the_run_button_after_writes_following_valid_python_code_in_editor(String pythonCode) throws InterruptedException {
		
		Thread.sleep(3000);
		commonobj.sendTextEditor(pythonCode);
		Thread.sleep(3000);
		commonobj.clickRunButton();
	}

	@Then("The user is able to see the output inside the console")
	public void the_user_is_able_to_see_the_output_inside_the_console() {
		String result = commonobj.printResultEditor();
		LOG.info(result);
	}

	
	@When("The user clicks the Run button after writes following Invalid Python code in editor")
	public void the_user_clicks_the_run_button_after_writes_following_invalid_python_code_in_editor(String invalidPythonCode) throws InterruptedException {
		commonobj.sendTextEditor(invalidPythonCode);
		Thread.sleep(3000);
		commonobj.clickRunButton();
	}
	
	@Then("The user see error msg in alert window")
	public void the_user_see_error_msg_in_alert_window() {
		String alertMessage = commonobj.switchToAlert();
		LOG.info(alertMessage);
	}
//	---------------------------------------------------------------
	
	@Given("User is on {string} {string} page")
	public void user_is_on_page(String dataStructureName, String dataStructureTopicName) throws InterruptedException {
		commonobj.clickGetStartedButtonCommon(dataStructureName);
		commonobj.clickdataStructuresHomeLinks(dataStructureTopicName);
	}


	@Then("The user tries to click on LINKS on the left panel")
	public void the_user_tries_to_click_on_links_on_the_left_panel() throws URISyntaxException {
		commonobj.checkBrokenLinks();
		LOG.info("All links are validated successfully!!!");
	}
	
	@Then("The user should redirected to the page having Editor button")
	public void the_user_should_redirected_to_the_page_having_editor_button() {
	    
	}


	
	
}
