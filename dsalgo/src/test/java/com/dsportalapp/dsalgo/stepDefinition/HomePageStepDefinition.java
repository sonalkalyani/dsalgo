package com.dsportalapp.dsalgo.stepDefinition;

import static org.testng.Assert.assertTrue;

import java.time.Duration;

import org.openqa.selenium.WebDriver;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.asserts.IAssert;

import com.dsportalapp.dsalgo.POM.HomePageObjects;
import com.dsportalapp.dsalgo.utilities.TestSetup;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;



public class HomePageStepDefinition {
	WebDriver driver;
	TestSetup testsetup;
	HomePageObjects homepageobj;
	
	public static Logger LOG = LoggerFactory.getLogger(HomePageStepDefinition.class);
	
	public HomePageStepDefinition(TestSetup testsetup) {
		super();
		this.testsetup = testsetup;
		homepageobj = testsetup.pageobjectmanager.getHomePageObjects();
	}

		@Given("I am on the home page")
	public void i_am_on_the_home_page() {
//		driver = new ChromeDriver();
//		testsetup.driver.manage().deleteAllCookies();
//		testsetup.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(7));
//		testsetup.driver.manage().window().maximize();
//		driver.get("https://dsportalapp.herokuapp.com/");
			LOG.info("homepage successful");
	}

	@Then("I should see the title {string}")
	public void i_should_see_the_title(String string) {
		
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
