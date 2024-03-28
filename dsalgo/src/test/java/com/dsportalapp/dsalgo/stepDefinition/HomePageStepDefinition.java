package com.dsportalapp.dsalgo.stepDefinition;

import static org.testng.Assert.assertTrue;

import java.io.IOException;
import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;

import com.dsportalapp.dsalgo.POM.HomePageObjects;
import com.dsportalapp.dsalgo.POM.PortalPageObjects;
import com.dsportalapp.dsalgo.utilities.TestSetup;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class HomePageStepDefinition {
	
	WebDriver driver;
	TestSetup testsetup;
	PortalPageObjects portalintroductionpageobj;
	HomePageObjects homepageobj;
	public static Logger LOG = LoggerFactory.getLogger(HomePageStepDefinition.class);
	
	public HomePageStepDefinition(TestSetup testsetup) throws IOException {
		super();
		this.testsetup = testsetup;
		this.driver = testsetup.drivermanager.getDriverManager();
		portalintroductionpageobj = testsetup.pageobjectmanager.getPortalIntroductionPageObjects();
		homepageobj = testsetup.pageobjectmanager.getHomePageObjects();
	}
	@Given("The user is on the home page of DS_Algo portal")
	public void the_user_is_on_the_home_page_of_ds_algo_portal() throws InterruptedException {
		Thread.sleep(2000);
//		portalintroductionpageobj.clicktoHomeGetStartedButton();
		driver.get("https://dsportalapp.herokuapp.com/home");
	}

	@When("The user clicks on the Data Structures dropdown arrow")
	public void the_user_is_on_the_home_page_and_clicks_on_the_data_structures_dropdown_arrow() {
		homepageobj.clickDataStructuresDropDown();
	}

	@Then("The user should be able to see below options in dropdown menu")
	public void the_user_should_able_to_see_options_in_dropdown_menu(List<String> expectedOptions) {
		List<String> dataStructuresDropDownInfo =homepageobj.getDataStructuresOptions();
		int actualSize = dataStructuresDropDownInfo.size();
		int expectedSize = expectedOptions.size();
	
		Assert.assertEquals(actualSize, expectedSize);
		
		for(int i=0;i< expectedOptions.size();i++)
		{
			String expectedOption = expectedOptions.get(i);
			String actualOption =dataStructuresDropDownInfo.get(i);
			Assert.assertEquals(actualOption,expectedOption);
		}
		LOG.info("Assertion is successful for DataStructures Dropdown size and its Options");
	}
	
//	----------------------------------------------------------------------------------------
	

	@When("The user selects {string} from the drop down without login")
	public void the_user_selects_any_data_structures_item_from_the_drop_down_without_login(String option) throws InterruptedException {
		homepageobj.clickDataStructuresDropDown();
		homepageobj.selectDataStructuresDropDown(option);
	}
	@Then("The user should able to see an warning message {string}")
	public void the_user_should_able_to_see_an_warning_message(String expectedMessage) {
		String warningMessage = homepageobj.printloginAlertMessage();
		Assert.assertEquals(warningMessage, expectedMessage);
	}

	@When("The user clicks any Get Started button for {string}  on the DS home page without login")
	public void the_user_clicks_any_buttons_of_data_structures_on_the_ds_introduction_page(String option) throws InterruptedException {
		homepageobj.clickGetStartedButton(option);
		LOG.info("Get Started Button clicked");
	}

	

	@When("The user clicks Register link")
	public void the_user_clicks_link() {
		homepageobj.clickRegisterButton();
	}

	@Then("The user should be redirected to Register page")
	public void the_user_should_be_redirected_to_register_page() {
		homepageobj.isOnRegisterPage();
	}

	@Then("The user should be able to see Login link at the bottom of the page")
	public void the_user_should_be_able_to_see_link_at_the_bottom_of_the_page() {
		
		assertTrue(homepageobj.isDisplayLoginLink(), "Login Link is not displayed");
	}                                         

	@Then("The user should be able to navigate to login page if clicks")
	public void the_user_should_be_able_to_navigate_to_login_page() {
		homepageobj.clickLoginLink();
	}

	@When("The user clicks on Sign In link")
	public void the_user_clicks_on_link() {
		homepageobj.clickSignInButton();
	}

	@Then("The user should be redirected to login page")
	public void the_user_should_be_redirected_to_login_page() {
		homepageobj.isOnLoginPage();
	}

	@Then("The user should be able to see Register link")
	public void the_user_should_be_able_to_see_link() {
		assertTrue(homepageobj.isDisplayRegisterLink(), "Register Link is not displayed");;
	}

	@Then("The user should able to navigate to register page")
	public void the_user_should_able_to_navigate_to_register_page() {
		homepageobj.clickRegisterLink();
	}


}
