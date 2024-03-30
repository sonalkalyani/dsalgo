package com.dsportalapp.dsalgo.stepDefinition;

import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.dsportalapp.dsalgo.POM.CommonMethodsObject;
import com.dsportalapp.dsalgo.POM.HomePageObjects;
import com.dsportalapp.dsalgo.POM.LinkedListObjects;
import com.dsportalapp.dsalgo.POM.PortalPageObjects;
import com.dsportalapp.dsalgo.utilities.TestSetup;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LinkedListPageStepDefinition {
	WebDriver driver;
	TestSetup testsetup;
	LinkedListObjects linkedlistobj;
	HomePageObjects homepageobj;
	CommonMethodsObject commonobj;
	
	
	public static Logger LOG = LoggerFactory.getLogger(PortalPageStepDefinition.class);
	
	
	public LinkedListPageStepDefinition(TestSetup testsetup) throws IOException {
		super();
		this.testsetup = testsetup;
		this.driver = testsetup.drivermanager.getDriverManager();
		linkedlistobj = testsetup.pageobjectmanager.getLinkedListObjects();
		commonobj = testsetup.pageobjectmanager.getCommonMethodsObject();
		homepageobj = testsetup.pageobjectmanager.getHomePageObjects();
	}
	@Given("User should be logged in with valid credential.")
	public void user_should_be_logged_in_with_valid_credential() {
		driver.get("https://dsportalapp.herokuapp.com/home");
		homepageobj.clickSignInButton();
		commonobj.login();
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

	@Then("The user should be redirected to Linked List page.")
	public void the_user_should_be_redirected_to_linked_list_page() {
		assertTrue(linkedlistobj.isOnLinkedListHome(), "The user should be in Linked List Page");
	}
	
//	--------------------------------------------------------
	@Given("User is on {string} Home page")
	public void user_is_on_linked_list_home_page(String dataStructureName) throws InterruptedException {
		commonobj.clickGetStartedButtonCommon(dataStructureName);
		linkedlistobj.isOnLinkedListHome();
	}

	@When("The user clicks {string} link")
	public void the_user_clicks_link(String homeLinkName) {
		commonobj.clickdataStructuresHomeLinks(homeLinkName);
	}

	@Then("The user should be redirected to Topics page")
	public void the_user_should_be_redirected_to_topics_page() {
		assertTrue(linkedlistobj.isOnLinkedListHome(), "The user is not redirected to Linked List Topic Page");
		
		
	}

	@When("The user clicks Try Here button")
	public void the_user_clicks_try_here_button() {
		commonobj.clickTryHereButton();
	}

	@Then("The user should redirected to the page having Editor and Run button")
	public void the_user_should_redirected_to_the_page_having_editor_and_run_button() {
		assertTrue(commonobj.isOntryEditorPage(),"The user is not redirected to Python Editor Page");
	}

	@When("The user clicks the Run button after writes following Valid Python Code in editor")
	public void the_user_clicks_the_run_button_after_writes_following_valid_python_code_in_editor(String pythonCode) throws InterruptedException {
		System.out.println(pythonCode);
		Thread.sleep(3000);
		commonobj.sendTextEditor(pythonCode);
		Thread.sleep(3000);
		commonobj.clickRunButton();
	}

	@Then("The user is able to see the output inside the console")
	public void the_user_is_able_to_see_the_output_inside_the_console() {
		String result = commonobj.printResultEditor();
		System.out.println(result);
	}



	
	
}
