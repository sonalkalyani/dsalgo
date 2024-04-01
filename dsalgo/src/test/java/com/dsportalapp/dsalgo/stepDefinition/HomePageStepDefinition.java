package com.dsportalapp.dsalgo.stepDefinition;

import static org.testng.Assert.assertTrue;

import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
import com.dsportalapp.dsalgo.utilities.TestSetup;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;



public class HomePageStepDefinition {
	WebDriver driver;
	TestSetup testsetup;
	HomePageObjects homepageobj;
	CommonMethodsObject commonobj;
	
	public static Logger LOG = LoggerFactory.getLogger(HomePageStepDefinition.class);
	
	public HomePageStepDefinition(TestSetup testsetup) {
		super();
		this.testsetup = testsetup;
		this.driver= testsetup.drivermanager.driver;
		commonobj = testsetup.pageobjectmanager.getCommonMethodsObject();
		homepageobj = testsetup.pageobjectmanager.getHomePageObjects();
		
	}

	@Given("The user is on the Home page of DS_Algo portal")
	public void the_user_is_on_the_home_page_of_ds_algo_portal() {
		commonobj.clicktoHomeGetStartedButton();
	}


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
	}
	
	@When("The user selects following options from the drop down without login")
	public void the_user_selects_following_options_from_the_drop_down_without_login(List<String> dropDownOptions) throws InterruptedException {
	
		for(String option:dropDownOptions) {
			homepageobj.clickDataStructuresDropDown();
			homepageobj.selectDataStructuresDropDown(option);
			driver.navigate().refresh();
			PageFactory.initElements(driver, this);
		}
	}

	@Then("The user should be able to see an warning message {string}")
	public void the_user_should_be_able_to_see_an_warning_message(String expectedWarningMessage) {
		String actualMessage = homepageobj.printloginAlertMessage();
		Assert.assertEquals(actualMessage, expectedWarningMessage,"The actual warning message does not match the with expected warning message");
	}
	

	
//	----------------------------------------------------------------------------------------
	

	
	@When("The user selects {string} from the drop down without login")
	public void the_user_selects_any_data_structures_item_from_the_drop_down_without_login(String option) throws InterruptedException {
		homepageobj.clickDataStructuresDropDown();
//		homepageobj.selectDataStructuresDropDown(option);
	}
	@Then("The user should able to see an warning message {string}")
	public void the_user_should_able_to_see_an_warning_message(String expectedMessage) {
		String warningMessage = homepageobj.printloginAlertMessage();
		Assert.assertEquals(warningMessage, expectedMessage);
	}

	@When("The user clicks following any Get Started button for Data Structures Option on the DS home page")
	public void the_user_clicks_following_any_get_started_button_for_data_structures_option_on_the_ds_home_page(List<String> dataStructuresOption) throws InterruptedException {
		for(String option : dataStructuresOption) {
		Map<String,String> warningMessageMap = homepageobj.clickGetStartedButton(option);
		if(warningMessageMap != null) {
			for(Map.Entry<String, String> entry : warningMessageMap.entrySet()) {
				System.out.println("Option" + entry.getKey() + ", WarningMessage: " + entry.getValue());
			}
		}else {
			System.out.println("WarningMessageMap is null");
		}
		Thread.sleep(3000);
		driver.navigate().refresh();
		PageFactory.initElements(driver, this);
		}
	}


	@When("The user clicks Register link")
	public void the_user_clicks_link() {
		homepageobj.clickRegisterButton();
	}

	@Then("The user should be redirected to Register page")
	public void the_user_should_be_redirected_to_register_page() {
		
		assertTrue(homepageobj.isOnRegisterPage(), "The User is not redirected to Register Page ");
		
	}

	@Then("The user should be able to see Login link at the bottom of the page")
	public void the_user_should_be_able_to_see_link_at_the_bottom_of_the_page() {
		
		assertTrue(homepageobj.isDisplayLoginLink(), "Login Link is not displayed");
	}                                         

	@Then("The user should be able to navigate to login page if clicks")
	public void the_user_should_be_able_to_navigate_to_login_page() {
		homepageobj.clickLoginLink();
		assertTrue(homepageobj.isOnLoginPage(),"The user is not redirected to login page");
		
	}

	@When("The user clicks on Sign In link")
	public void the_user_clicks_on_link() {
		homepageobj.clickSignInButton();
	}

	@Then("The user should be redirected to login page")
	public void the_user_should_be_redirected_to_login_page() {
		assertTrue(homepageobj.isOnLoginPage(),"The user is not redirected to login page");
	}

	@Then("The user should be able to see Register link")
	public void the_user_should_be_able_to_see_link() {
		assertTrue(homepageobj.isDisplayRegisterLink(), "Register Link is not displayed");;
	}

	@Then("The user should able to navigate to register page")
	public void the_user_should_able_to_navigate_to_register_page() {
		homepageobj.clickRegisterLink();
		assertTrue(homepageobj.isOnRegisterPage(), "The User is not redirected to Register Page ");
	}

}
