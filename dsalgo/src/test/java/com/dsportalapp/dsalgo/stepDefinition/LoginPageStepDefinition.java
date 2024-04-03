package com.dsportalapp.dsalgo.stepDefinition;

import static org.testng.Assert.assertTrue;

import java.io.IOException;
import java.sql.Driver;
import java.util.List;
import java.util.Map;

import javax.management.loading.PrivateClassLoader;

import org.apache.commons.lang3.StringUtils;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.xmlbeans.impl.xb.xsdschema.Public;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;

import com.dsportalapp.dsalgo.POM.CommonMethodsObject;
import com.dsportalapp.dsalgo.POM.LoginPageObjects;
import com.dsportalapp.dsalgo.utilities.ConfigReader;
import com.dsportalapp.dsalgo.utilities.TestSetup;
import com.dsportalapp.dsalgo.webDriverManager.DriverManager;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


public class LoginPageStepDefinition  {
	
	ConfigReader configFileReader = new ConfigReader();
	WebDriver driver;
	TestSetup testsetup;
	CommonMethodsObject commonobj;
	private String title;
	private LoginPageObjects loginpageobj;
	public static Logger LOG = LoggerFactory.getLogger(LoginPageStepDefinition.class);
	
	public LoginPageStepDefinition(TestSetup testsetup) {
		super();
		this.testsetup = testsetup;
		//this.driver = testsetup.drivermanager.getDriver();
		loginpageobj = testsetup.pageobjectmanager.getLoginPageObjects();
		commonobj = testsetup.pageobjectmanager.getCommonMethodsObject();
	}
	
	
	@Given("The user is on DS Algo Sign in Page")
	public void the_user_is_on_ds_algo_sign_in_page() {
	
		loginpageobj.isOnSignInPage();
	}

	@When("The user gets the title of the page")
	public void the_user_gets_the_title_of_the_page() {
		
		title = loginpageobj.SigninPageTitle();
		LOG.info("Title of the page is: "+title);
	}

	@Then("Page title should be {string}")
	public void page_title_should_be(String expectedTitlename) {
	   
		Assert.assertTrue(title.contains(expectedTitlename));
	}


	@Then("Register link should be displayed under the login button")
	public void register_link_should_be_displayed_under_the_login_button() {
		
		loginpageobj.RegisterLinkValidation();
	   
	}
	
	@Then("On clicking register link, page should navigate to Registration page with title {string}")
	public void on_clicking_register_link_page_should_navigate_to_registration_page_with_title(String ExpectedRgstrnPagetitle) {
		
		String ActualRegisterPageTitle = loginpageobj.RegisterLinkNavigation();
		LOG.info("Current Page Title is: "+ActualRegisterPageTitle);
		Assert.assertEquals(ActualRegisterPageTitle, ExpectedRgstrnPagetitle);
	}

	@Given("The user is on the DS Algo Sign in Page")
	public void the_user_is_on_the_ds_algo_sign_in_page() {
		 
		loginpageobj.isOnSignInPage();
	}

	@When("The user enters valid username and valid password")
	public void the_user_enters_valid_and_valid() {
		
		loginpageobj.EnterValidUsernameandPassword();
	}

	@When("THe user clicks on Login button")
	public void t_he_user_clicks_on_login_button() {
	   
		loginpageobj.ClickLoginBtn();
	}

	@Then("The user should be navigated to Home Page with the message {string} and with the user name on the top")
	public void the_user_should_be_navigated_to_home_page_with_the_message_and_with_the_user_name_on_the_top(String expectedMsg) {
		
		String Actualmsg = loginpageobj.ValidateSuccssMsg();
		Assert.assertEquals(Actualmsg, expectedMsg);
		LOG.info("Message on the HomePage is: "+Actualmsg);
		String loginId= configFileReader.init_prop().getProperty("username");
		Assert.assertEquals((StringUtils.capitalize(loginId)),loginpageobj.ValidateLoginIdonHomePage());
	  
	}

	@When("The user clicks login button after leaving the username textbox and password textbox blank")
	public void the_user_clicks_login_button_after_leaving_the_username_textbox_and_password_textbox_blank() {
	   
		loginpageobj.ClickLoginBtn();
	   
	}

	@Then("The error message Please fill out this field should appear below Username textbox")
	public void the_error_message_please_fill_out_this_field_should_appear_below_username_textbox() {
		
		loginpageobj.BlankUsernameAndPasswordValidation();
	   
	}


	@When("The user enters below valid username and invalid password in textbox")
	public void the_user_enters_below_valid_username_and_invalid_password_in_textbox(DataTable dataTable) {
		
		List<Map<String, String>> userList = dataTable.asMaps(String.class,String.class);
		
		loginpageobj.EnterInvalidUsernameandPassword(userList);
	}
	
	@When("The user clicks on login button")
	public void the_user_clicks_on_login_button() {
		
		loginpageobj.ClickLoginBtn();
	}

	@Then("The user should able to see an error message {string}")
	public void the_user_should_able_to_see_an_error_message(String ExpectedErrorMsg) {
		
		String ActualErrMsg = loginpageobj.ValidateinvalidErrorMsg();
		LOG.info("Error Message is: "+ActualErrMsg);
		Assert.assertEquals(ActualErrMsg, ExpectedErrorMsg);

	}

	@When("The user enters below invalid username and valid password in textbox")
	public void the_user_enters_below_invalid_username_and_valid_password_in_textbox(DataTable dataTable) {
		

		List<Map<String, String>> userList = dataTable.asMaps(String.class,String.class);
		loginpageobj.EnterInvalidUsernameandPassword(userList);
	}
	

	@When("The user enters below invalid username and invalid password in textbox")
	public void the_user_enters_below_invalid_username_and_invalid_password_in_textbox(DataTable dataTable) {
		
		List<Map<String, String>> userList = dataTable.asMaps(String.class,String.class);
		loginpageobj.EnterInvalidUsernameandPassword(userList);
	}
	



}
