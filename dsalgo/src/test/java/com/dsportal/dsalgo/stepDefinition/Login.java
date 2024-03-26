package com.dsportal.dsalgo.stepDefinition;

import static org.testng.Assert.assertEquals;

import java.io.FileReader;
import java.io.InputStream;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;

import com.beust.ah.A;
import com.dsportal.dsalgo.fileReader.ConfigFileReader;
import com.google.inject.spi.Message;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import jdk.internal.org.jline.utils.Log;

public class Login extends ConfigFileReader {
	
	static WebDriver driver;
	
	ConfigFileReader configFileReader;
	
	@BeforeTest
	@Given("The user is on the DS Algo Sign in Page")
	public void the_user_is_on_the_ds_algo_sign_in_page() {
		
		String url = "https://dsportalapp.herokuapp.com/login";
		driver = new ChromeDriver();
		configFileReader = new ConfigFileReader();
		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		
	   
	}

	@When("The user enters valid credentials")
	public void the_user_enters_valid_credentials() {
		FileReader();
		driver.findElement(By.name("username")).sendKeys(properties.getProperty("username"));
		driver.findElement(By.name("password")).sendKeys(properties.getProperty("password"));
		driver.findElement(By.xpath("//input[@value = 'Login']")).click();
	}

	@Then("The user should be redirected to Home Page with the message {string} and with the user name on the top")
	public void the_user_should_be_redirected_to_home_page_with_the_message_and_with_the_user_name_on_the_top(String string) throws InterruptedException {
	   
		Thread.sleep(2000);
		String msg = "You are logged in";
		WebElement loginmsg = driver.findElement(By.xpath("//div[@class = 'alert alert-primary']"));
	    Log.info(loginmsg.getText()); 
		Assert.assertEquals(loginmsg, msg);
		
		WebElement usrname = driver.findElement(By.xpath("//a[text() = ' Ninja153 ']"));
		usrname.getText();
		Assert.assertEquals(properties.getProperty("username"),usrname);
		
		
	}

	@When("The user clicks login button after leaving the {string} textbox and {string} textbox blank")
	public void the_user_clicks_login_button_after_leaving_the_textbox_and_textbox_blank(String string, String string2) {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@Then("The error message {string} appears below Username textbox")
	public void the_error_message_appears_below_username_textbox(String string) {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@When("The user clicks login button after entering the {string} and leaves {string} textbox blank")
	public void the_user_clicks_login_button_after_entering_the_and_leaves_textbox_blank(String string, String string2) {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@Then("The error message {string} appears below password textbox")
	public void the_error_message_appears_below_password_textbox(String string) {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@When("The user clicks login button after entering invalid username and invalid password")
	public void the_user_clicks_login_button_after_entering_invalid_username_and_invalid_password() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@Then("The user should able to see an error message {string}.")
	public void the_user_should_able_to_see_an_error_message(String string) {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@When("The user clicks login button after entering valid username and invalid password")
	public void the_user_clicks_login_button_after_entering_valid_username_and_invalid_password() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

}
