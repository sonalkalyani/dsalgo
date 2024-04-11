package com.dsportalapp.dsalgo.stepDefinition;

import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;

import com.dsportalapp.dsalgo.POM.CommonMethodsObject;
import com.dsportalapp.dsalgo.POM.RegisterPageObjects;
import com.dsportalapp.dsalgo.utilities.TestSetup;

import io.cucumber.java.After;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ResgistrationPageStepDefinition {
	WebDriver driver;
	TestSetup testsetup;
	RegisterPageObjects registerobjects;
	CommonMethodsObject commonobj;
	
	public static Logger LOG = LoggerFactory.getLogger(ResgistrationPageStepDefinition.class);
	
	public ResgistrationPageStepDefinition(TestSetup testsetup) {
		super();
		this.testsetup = testsetup;
		commonobj = testsetup.pageobjectmanager.getCommonMethodsObject();
		registerobjects=testsetup.pageobjectmanager.getRegisterPageObjects();
		commonobj = testsetup.pageobjectmanager.getCommonMethodsObject();
		
	}
	
	@Given("I am on the registration page")
	public void i_am_on_the_registration_page() {
		commonobj.clicktoHomeGetStartedButton();
		commonobj.clickRegisterLnk();
		   
	}

	@When("User does not enter username {string} and password {string}")
	public void user_does_not_enter_username_and_password(String username, String password) {
	
		registerobjects.registerNewUser(username, password);
		registerobjects.blankValidationUsernameNPasssword();
		LOG.info("NULL validation done successfully");
			
	}

	@When("User submit the registration form with errors")
	public void user_submit_the_registration_form() {
		
		LOG.info("User has submited details with errors.Resumit the form with valid details");
	    
	}

	@Then("User should see an error popup")
	public void user_should_see_an_error_message() {
		
		String errMsg=registerobjects.blankValidationUsernameNPasssword();
	    LOG.info("Error Message is  :"+errMsg);
	}


	
	@When("User enters username {string} with invalid special charecter and valid password {string}")
	public void user_enters_username_with_invalid_special_charecter_and_valid_password(String username, String password) {
	  
		registerobjects.registerNewUser(username, password);
				
	}

	@When("User enters valid username {string} and invalid password {string} with all numeric values")
	public void user_enters_valid_username_and_invalid_password_with_all_numeric_values(String username, String password) {
		registerobjects.registerNewUser(username, password);
	}

	@When("User enters valid username {string} and invalid password {string} with charecters less than {int}")
	public void user_enters_valid_username_and_invalid_password_with_charecters_less_than(String username, String password, Integer int1) {
		registerobjects.registerNewUser(username, password);
	}

	@When("User enters valid username {string} and invalid password {string} with charecters equal to {int}")
	public void user_enters_valid_username_and_invalid_password_happy123_with_charecters_equal_to(String username,String password, Integer int1) {
		registerobjects.registerNewUser(username, password);
	}


	@When("User enters valid username {string} and password {string} and different confirmpassword {string} feild")
	public void user_enters_valid_username_and_password_and_different_confirmpassword_feild(String username, String password, String confirmpassword) {
		registerobjects.registerDiffPwd(username, password, confirmpassword);
	}

	@When("User enters valid username {string} and password {string}")
	public void user_enters_valid_username_and_password(String username, String password) {
		registerobjects.registerNewUser(username, password);
		registerobjects.validUsernameNPasssword(username);
	    
	}

	
	@And("User submits the registration form  successfully")
	public void user_submit_the_registration_form_with_successfully() {
		
		LOG.info("Form Submitted successfully");
	    
	}


	@Then("User should be redirected to Home Page")
	public void user_should_be_redirected_to_home_page() {
		boolean homePageAssert =registerobjects.isOnHomePage();
	    Assert.assertTrue(homePageAssert,"Home page assertion failed");
	    LOG.info("User is on Home page");
	}
	
	@And ("user should be logged in with the registered {string}")
	public void user_should_be_logged_in_with_the_registered(String username) {
		registerobjects.isUserLoggedIn(username);
		
	}
	    

	@When("User enters existing username {string} and password {string}")
	public void user_enters_existing_username_and_password(String username, String password) {
		registerobjects.registerNewUser(username, password);
	}

	@Then("User should see an error message")
	public void user_should_see_a_error_message() {
		registerobjects.validateErrMsg();
	
	}

	@When("User clicks on login link")
	public void user_clicks_on_login_link() {
		registerobjects.goToHomePage();
	  
	}

	@Then("User should traverse to Login page")
	public void user_should_traverse_to_login_page() {
		boolean loginPageAssert =registerobjects.isOnLoginPage();
	    Assert.assertTrue(loginPageAssert,"Home page assertion failed");
	    LOG.info("User is on Login page");
	  
	}
	


	


	




}
