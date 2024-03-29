//package com.dsportalapp.dsalgo.stepDefinition;
//
//import org.openqa.selenium.WebDriver;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//
//import com.dsportalapp.dsalgo.POM.RegisterPageObjects;
//import com.dsportalapp.dsalgo.utilities.TestSetup;
//
//import io.cucumber.java.en.Given;
//import io.cucumber.java.en.Then;
//import io.cucumber.java.en.When;
//
//public class RegisterStepold {
//	WebDriver driver;
//	TestSetup testsetup;
//	RegisterPageObjects registerobjects;
//	
//	public static Logger LOG = LoggerFactory.getLogger(ResgistrationPageStepDefinition.class);
//	
//	public ResgistrationPageStepDefinition(TestSetup testsetup) {
//		super();
//		this.testsetup = testsetup;
//		registerobjects=testsetup.pageobjectmanager.getRegisterPageObjects();
//		
//	}
//	
//
//@Given("I am on the registration page")
//public void i_am_on_the_registration_page() {
//	
//	registerobjects.clickRegisterLnk();
//	LOG.info("User is on Registartion page");
//   
//}
//
//@When("User does not enter username {string} and password {string}")
//public void user_does_not_enter_username_and_password(String username, String password) {
//   
//	registerobjects.registerNewUser(username, password);
//	registerobjects.validateBlankValueErrMsg(registerobjects.userNameTxtBox);
//	LOG.info("NULL value validation successfully done for Username textbox");
//	
//}
//
//@When("User submit the registration form")
//public void user_submit_the_registration_form() {
//	
//	
//    
//}
//
//@Then("User should see an error message")
//public void user_should_see_an_error_message() {
//    // Write code here that turns the phrase above into concrete actions
//    throw new io.cucumber.java.PendingException();
//}
//
//@When("User enters username {string} and leaves password {string} and confirmpassword feilds blank")
//public void user_enters_username_and_leaves_password_and_confirmpassword_feilds_blank(String string, String string2) {
//    // Write code here that turns the phrase above into concrete actions
//    throw new io.cucumber.java.PendingException();
//}
//
//@When("User enters username {string} and  password {string} and leaves confirmpassword feild blank")
//public void user_enters_username_and_password_and_leaves_confirmpassword_feild_blank(String string, String string2) {
//    // Write code here that turns the phrase above into concrete actions
//    throw new io.cucumber.java.PendingException();
//}
//
//@When("User enters username {string} with invalid special charecter and valid password {string}")
//public void user_enters_username_with_invalid_special_charecter_and_valid_password(String string, String string2) {
//    // Write code here that turns the phrase above into concrete actions
//    throw new io.cucumber.java.PendingException();
//}
//
//@When("User enters valid username {string} and invalid password {string} with all numeric values")
//public void user_enters_valid_username_and_invalid_password_with_all_numeric_values(String string, String string2) {
//    // Write code here that turns the phrase above into concrete actions
//    throw new io.cucumber.java.PendingException();
//}
//
//@When("User enters valid username {string} and invalid password {string} with charecters less than {int}")
//public void user_enters_valid_username_and_invalid_password_with_charecters_less_than(String string, String string2, Integer int1) {
//    // Write code here that turns the phrase above into concrete actions
//    throw new io.cucumber.java.PendingException();
//}
//
//@When("User enters valid username {string} and invalid password \"happy123\"with charecters equal to {int}")
//public void user_enters_valid_username_and_invalid_password_happy123_with_charecters_equal_to(String string, Integer int1) {
//    // Write code here that turns the phrase above into concrete actions
//    throw new io.cucumber.java.PendingException();
//}
//
//@When("User enters valid username {string} and password {string} and different confirmpassword {string} feild")
//public void user_enters_valid_username_and_password_and_different_confirmpassword_feild(String string, String string2, String string3) {
//    // Write code here that turns the phrase above into concrete actions
//    throw new io.cucumber.java.PendingException();
//}
//
//@When("User enters valid username {string} and password {string}")
//public void user_enters_valid_username_and_password(String string, String string2) {
//    // Write code here that turns the phrase above into concrete actions
//    throw new io.cucumber.java.PendingException();
//}
//
//@Then("User should see a success message")
//public void user_should_see_a_success_message() {
//    // Write code here that turns the phrase above into concrete actions
//    throw new io.cucumber.java.PendingException();
//}
//
//@When("User enters existing username {string} and password {string}")
//public void user_enters_existing_username_and_password(String string, String string2) {
//    // Write code here that turns the phrase above into concrete actions
//    throw new io.cucumber.java.PendingException();
//}
//
//@Then("User should see a error message")
//public void user_should_see_a_error_message() {
//    // Write code here that turns the phrase above into concrete actions
//    throw new io.cucumber.java.PendingException();
//}
//
//@When("User clicks on login link")
//public void user_clicks_on_login_link() {
//    // Write code here that turns the phrase above into concrete actions
//    throw new io.cucumber.java.PendingException();
//}
//
//@Then("User should traverse to Login page")
//public void user_should_traverse_to_login_page() {
//    // Write code here that turns the phrase above into concrete actions
//    throw new io.cucumber.java.PendingException();
//}
//
//}
