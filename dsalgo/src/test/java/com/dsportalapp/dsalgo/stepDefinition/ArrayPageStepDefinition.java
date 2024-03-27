package com.dsportalapp.dsalgo.stepDefinition;

import java.io.IOException;

import org.apache.commons.logging.Log;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.dsportalapp.dsalgo.POM.ArrayPageObjects;
import com.dsportalapp.dsalgo.POM.PageObjectManager;
import com.dsportalapp.dsalgo.webDriverManager.DriverManager;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ArrayPageStepDefinition {

	WebDriver driver;
	DriverManager drivermanager = new DriverManager();
	ArrayPageObjects ap =null;

	public static Logger LOG = LoggerFactory.getLogger(ArrayPageStepDefinition.class);
    PageObjectManager pm =null;
	

	@Given("User is on DSAlgo Portal URL")
	public void user_is_on_ds_algo_portal_url() throws IOException {
		
        driver=drivermanager.getDriverManager();
        pm=new PageObjectManager(driver);
        ap=pm.getArrayPage();
        ap.navigateTo_HomePage();
	    LOG.info("User is on DSAlgo Portal URL");

	}

	@When("User clicks the Get Started Button")
	public void user_clicks_the_get_started_button() throws InterruptedException {
		LOG.info("GS Button");
		ap.home_GetStarted();
		
	}

	@And("User enters home page and click Sign in")
	public void user_enters_home_page_and_click_sign_in() {
		LOG.info("Home Page");
		ap.app_SignIn();
	}

	@Then("User can enter below Username and Password and click the Login Button and navigate to home page.")
	public void user_can_enter_below_username_and_password_and_click_the_login_button_in_the_login_page(
			io.cucumber.datatable.DataTable dataTable) {
	 ap.app_Login(dataTable);
		LOG.info("login");
		
	}

	@Given("User clicks on Array - Get Started button")
	public void user_clicks_on_array_get_started_button() {
		ap.click_Array_GetStarted();
		LOG.info("User clicks on Array - Get Started button");
		
	}

	@When("User can able to view the topics covered in array")
	public void user_can_able_to_view_the_topics_covered_in_array() {
		
		ap.array_topics();
	}
	
	@Then("User can click on the links and navigate to the linked page")
	public void user_can_click_on_the_links_and_navigate_to_the_linked_page() {
		
		//ap.check_Array_Topic_Link();
	   
	}

	@Given("User should be in Arrays in the Python page and check the title Arrays in Python")
	public void user_should_be_in_arrays_in_the_python_page_and_check_the_title_arrays_in_python() {
	   
	}

	@When("User clicks on the side links")
	public void user_clicks_on_the_side_links() {
	   
	}

	@Then("User should be navigated to the clicked links")
	public void user_should_be_navigated_to_the_clicked_links() {
	  
	}

}
