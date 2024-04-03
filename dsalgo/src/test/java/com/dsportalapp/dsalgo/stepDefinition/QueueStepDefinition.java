package com.dsportalapp.dsalgo.stepDefinition;

import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.dsportalapp.dsalgo.POM.QueuePageObjects;
import com.dsportalapp.dsalgo.POM.RegisterPageObjects;
import com.dsportalapp.dsalgo.utilities.TestSetup;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class QueueStepDefinition {
	
	WebDriver driver;
	TestSetup testsetup;
	QueuePageObjects queueobjects;
	
	public static Logger LOG = LoggerFactory.getLogger(QueueStepDefinition.class);
	
	public QueueStepDefinition(TestSetup testsetup) {
		super();
		this.testsetup = testsetup;
		queueobjects=testsetup.pageobjectmanager.getQueuePageObjects();
		
	}
	
	
	@Given("I am on the Home page")
	public void i_am_on_the_home_page() {
	   
	}

	@Given("User is on DS_Algo Home page after logged in")
	public void user_is_on_ds_algo_home_page_after_logged_in() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@When("User selects Queue item from Data Structures dropdown")
	public void user_selects_queue_item_from_data_structures_dropdown() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@Then("User should be redirected to Queue Page")
	public void user_should_be_redirected_to_queue_page() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@Given("User is on Queue home page")
	public void user_is_on_queue_home_page() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@Given("User clicks  {string} link")
	public void user_clicks_link(String string) {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@Then("User should be redirected to {string}  Page")
	public void user_should_be_redirected_to_page(String string) {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@Then("User clicks TRY HERE button")
	public void user_clicks_try_here_button() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@Then("User should be redirected to a page having an tryEditor with a Run button")
	public void user_should_be_redirected_to_a_page_having_an_try_editor_with_a_run_button() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@Then("User writes Valid \"print\\(\"Hello\")\" and clicks Run button")
	public void user_writes_valid_print_hello_and_clicks_run_button() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@Then("User is able to see the output in console")
	public void user_is_able_to_see_the_output_in_console() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@Then("User writes Valid {string} and clicks Run button")
	public void user_writes_valid_and_clicks_run_button(String string) {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@Then("User writes InValid \"Println\\(\"Hello\")\" and clicks Run button")
	public void user_writes_in_valid_println_hello_and_clicks_run_button() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@Then("User is able to see the error msg in pop up window")
	public void user_is_able_to_see_the_error_msg_in_pop_up_window() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@Then("User writes InValid {string} and clicks Run button")
	public void user_writes_in_valid_and_clicks_run_button(String string) {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

//	@Given("User is on Queue Home page")
//	public void user_is_on_queue_home_page() {
//	    // Write code here that turns the phrase above into concrete actions
//	    throw new io.cucumber.java.PendingException();
//	}

	@When("The user clicks {string} link")
	public void the_user_clicks_link(String string, io.cucumber.datatable.DataTable dataTable) {
	    // Write code here that turns the phrase above into concrete actions
	    // For automatic transformation, change DataTable to one of
	    // E, List<E>, List<List<E>>, List<Map<K,V>>, Map<K,V> or
	    // Map<K, List<V>>. E,K,V must be a String, Integer, Float,
	    // Double, Byte, Short, Long, BigInteger or BigDecimal.
	    //
	    // For other transformations you can register a DataTableType.
	    throw new io.cucumber.java.PendingException();
	}

	@Then("User should be redirected to Topics page")
	public void user_should_be_redirected_to_topics_page() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@Then("User tries to click on LINKS on the left panel")
	public void user_tries_to_click_on_links_on_the_left_panel() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}


}
