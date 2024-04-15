package com.dsportalapp.dsalgo.stepDefinition;

import java.util.List;
import java.util.Map;
import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import com.dsportalapp.dsalgo.POM.CommonMethodsObject;
import com.dsportalapp.dsalgo.POM.LoginPageObjects;
import com.dsportalapp.dsalgo.utilities.ConfigReader;
import com.dsportalapp.dsalgo.utilities.TestSetup;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


public class LoginPageStepDefinition  {
	
	WebDriver driver;
	TestSetup testsetup;
	CommonMethodsObject commonobj;
	LoginPageObjects loginpageobj;
	public static Logger LOG = LoggerFactory.getLogger(LoginPageStepDefinition.class);
	
	public LoginPageStepDefinition(TestSetup testsetup) {
		super();
		this.testsetup = testsetup;
		loginpageobj = testsetup.pageobjectmanager.getLoginPageObjects();
		commonobj = testsetup.pageobjectmanager.getCommonMethodsObject();
	}
	
	
	
	@Given("The user is on the DS Algo Sign in Page")
	public void the_user_is_on_the_ds_algo_sign_in_page() {
		commonobj.clicktoHomeGetStartedButton();
		commonobj.clickSignInButton();
	}

	@When("The user gets the title of the page")
	public void the_user_gets_the_title_of_the_page() {
		
		loginpageobj.signInPageTitle();
	}

	@Then("Page title should be {string}")
	public void page_title_should_be(String expectedTitlename) {
	   
		String title = loginpageobj.signInPageTitle();
		Assert.assertTrue(title.contains(expectedTitlename));
	}

	
	@Then("On clicking register link, page should navigate to Registration page with title Registration")

	public void on_clicking_register_link_page_should_navigate_to_registration_page_with_title_Registration() {
	
		commonobj.clickRegisterLnk();
	}

	@When("The user enters valid username and valid password and clicks on Login button")
	public void the_user_enters_valid_username_and_valid_password_and_clicks_on_Login_button() {
		
		loginpageobj.enterValidUsernameandPassword();
	}


	@Then("The user should be navigated to Home Page with the message {string} and with the user name on the top")
	public void the_user_should_be_navigated_to_home_page_with_the_message_and_with_the_user_name_on_the_top(String expectedMsg) {
		
		loginpageobj.validateSuccssMsg(expectedMsg);
		loginpageobj.validateLoginIdOnHomePage();
	}

	@When("The user clicks login button after leaving the username textbox and password textbox blank")
	public void the_user_clicks_login_button_after_leaving_the_username_textbox_and_password_textbox_blank() {
	   
		loginpageobj.clickLoginBtn();
	   
	}

	@Then("The error message Please fill out this field should appear below Username textbox")
	public void the_error_message_please_fill_out_this_field_should_appear_below_username_textbox() {
		
		loginpageobj.blankUsernameAndPasswordValidation();
	   
	}


	@When("The user enters below valid username and invalid password in textbox")
	public void the_user_enters_below_valid_username_and_invalid_password_in_textbox(DataTable dataTable) {
		
		List<Map<String, String>> userList = dataTable.asMaps(String.class,String.class);
		
		loginpageobj.enterInvalidUsernameandPassword(userList);
	}
	
	@When("The user clicks on login button")
	public void the_user_clicks_on_login_button() {
		
		loginpageobj.clickLoginBtn();
	}

	@Then("The user should able to see an error message {string}")
	public void the_user_should_able_to_see_an_error_message(String ExpectedErrorMsg) {
		
		loginpageobj.validateInvalidErrorMsg(ExpectedErrorMsg);

	}

	@When("The user enters below invalid username and valid password in textbox")
	public void the_user_enters_below_invalid_username_and_valid_password_in_textbox(DataTable dataTable) {
		

		List<Map<String, String>> userList = dataTable.asMaps(String.class,String.class);
		loginpageobj.enterInvalidUsernameandPassword(userList);
	}
	

	@When("The user enters below invalid username and invalid password in textbox")
	public void the_user_enters_below_invalid_username_and_invalid_password_in_textbox(DataTable dataTable) {
		
		List<Map<String, String>> userList = dataTable.asMaps(String.class,String.class);
		loginpageobj.enterInvalidUsernameandPassword(userList);
	}
	


}
