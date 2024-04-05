package com.dsportalapp.dsalgo.stepDefinition;

import static org.testng.Assert.assertTrue;

import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeoutException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.asserts.IAssert;

import com.dsportalapp.dsalgo.POM.CommonMethodsObject;
import com.dsportalapp.dsalgo.POM.HomePageObjects;
import com.dsportalapp.dsalgo.POM.LoginPageObjects;
import com.dsportalapp.dsalgo.utilities.TestSetup;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;



public class HomePageStepDefinition {
	WebDriver driver;
	TestSetup testsetup;
	HomePageObjects homepageobj;
	CommonMethodsObject commonobj;
	LoginPageObjects loginpageobj;
	Map<String,String> warningMessageMap;
	Map<String,String> dropDownwarningMsgMap;
	
	
	public static Logger LOG = LoggerFactory.getLogger(HomePageStepDefinition.class);
	
	public HomePageStepDefinition(TestSetup testsetup) {
		super();
		this.testsetup = testsetup;
		this.driver= testsetup.drivermanager.driver;
		commonobj = testsetup.pageobjectmanager.getCommonMethodsObject();
		homepageobj = testsetup.pageobjectmanager.getHomePageObjects();
		loginpageobj = testsetup.pageobjectmanager.getLoginPageObjects();
		
	}
//	Background:
	@Given("The user is on the Home page of DS_Algo portal")
	public void the_user_is_on_the_home_page_of_ds_algo_portal() {
		commonobj.clicktoHomeGetStartedButton();
	}

//	Scenario: Verify 'Data Structures DropDown List' size and options
	
	@When("The user clicks on the DataStructures DropDown arrow")
	public void the_user_clicks_on_the_data_structures_drop_down_arrow() {
		homepageobj.clickDataStructuresDropDown();

	}

	@Then("The user should be able to see below  six options in dropdown menu")
	public void the_user_should_be_able_to_see_below_six_options_in_dropdown_menu(List<String> expectedDropDownOptions) {
		List<String> actualDropDownOptions = homepageobj.getDataStructuresOptions();
		Assert.assertEquals(actualDropDownOptions.size(), expectedDropDownOptions.size(),
				"Number of options in the dropdown does not match with the expected number");
		for(String expectedOption : expectedDropDownOptions) {
			assertTrue(actualDropDownOptions.contains(expectedOption), expectedOption + " is not present in the dropdown");
		}
		LOG.info("Assertion successful for DropDown List size and options");
	}
	
//	Scenario: Verify display of 'You are not logged in' Message for Unauthenticated Users for DropDown List
	
	@When("The user selects following options from the drop down without login")
	public void the_user_selects_following_options_from_the_drop_down_without_login(List<String> dropDownOptions) throws InterruptedException, TimeoutException {
	
		for(String option:dropDownOptions) {
			homepageobj.clickDataStructuresDropDown();
			dropDownwarningMsgMap =	homepageobj.selectDataStructuresDropDown(option);
			driver.navigate().refresh();
			PageFactory.initElements(driver, this);
		}
	}

	@Then("The user should be able to see an warning message {string} for dropdown list")
	public void the_user_should_be_able_to_see_an_warning_message_for_dropdown_list(String expectedWarningMessage) {
		dropDownwarningMsgMap.entrySet().forEach(e-> {
			Assert.assertEquals(e.getValue(), expectedWarningMessage, 
					"Expected message is not displayed for option:" +e.getKey() );
		});
		LOG.info("Assertion successful for DropDown List selection without login");
	}
	
//	Scenario: Verify display of 'You are not logged in' Message for Unauthenticated Users for 'Get Started Button'
	
	@When("The user clicks following any Get Started button for Data Structures Option on the DS home page")
	public void the_user_clicks_following_any_get_started_button_for_data_structures_option_on_the_ds_home_page(List<String> dataStructuresOption) throws InterruptedException {
			warningMessageMap = homepageobj.clickGetStartedButton(dataStructuresOption);
		}
	
	@Then("The user should be able to see an warning message {string} for Get Started Button")
	public void the_user_should_be_able_to_see_an_warning_message(String expectedWarningMessage) {
		warningMessageMap.entrySet().forEach(e -> {			
			Assert.assertEquals(e.getValue(), expectedWarningMessage, 
					"Expected message is not displayed for option:" +e.getKey() );
		});
		LOG.info("Assertion successful for Get Started Button");
		
	}


//	Scenario: Navigation to 'Sign In' Page
	
//	@When("The user clicks on Sign In link on DS_Algo Home page")
//	public void the_user_clicks_on_sign_in_link_on_ds_algo_home_page() {
//		loginpageobj.RegisterLinkValidation();
//	}
//
//	@Then("The user shoulde be redirected to {string} page")
//	public void the_user_shoulde_be_redirected_to_page(String redirectedPage) {
//		assertTrue(commonobj.isOnRedirectedPage(redirectedPage), "The User is not redirected to Login Page ");
//		LOG.info("The user is redirected to login page");
//	}
//
//	@When("The user should be able to see Register link in login page")
//	public void the_user_should_be_able_to_see_register_link_in_login_page() {
//		assertTrue(homepageobj.isDisplayRegisterLink(), "Register Link is not displayed");
//		LOG.info("Register link is displayed in login page");
//		
//	}
//
//	@Then("The user should able to navigate to {string} page if clicks Register link")
//	public void the_user_should_able_to_navigate_to_page_if_clicks_register_link(String redirectedPage) {
//		homepageobj.clickRegisterLink();
//		assertTrue(commonobj.isOnRedirectedPage(redirectedPage), "The User is not redirected to Register Page");
//		LOG.info("The user is redirected to Register page from Login page");
//	}
}
