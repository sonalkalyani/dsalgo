package com.dsportalapp.dsalgo.POM;

import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import com.dsportalapp.dsalgo.stepDefinition.ArrayPageStepDefinition;

import io.cucumber.datatable.DataTable;

public class ArrayPageObjects {

	WebDriver driver;

	@FindBy(xpath = "//button[@class='btn']")
	WebElement btn_GetStarted;

	@FindBy(xpath = "//a[@href=\"/login\"]")
	WebElement sign_Link;

	@FindBy(id = "id_username")
	WebElement user_Name;

	@FindBy(id = "id_password")
	WebElement pass_Word;

	@FindBy(xpath = "//input[@value='Login']")
	WebElement btn_Login;

	@FindBy(xpath = "//div[@role='alert']")
	WebElement text_login;

	@FindBy(xpath = "//a[@href='array']")
	WebElement btn_array_getstarted;

	@FindAll(@FindBy(xpath = "//a[@class='list-group-item']"))
	List<WebElement> array_topics;

	@FindBy(xpath = "//div[@class='col-sm']//p[@class='bg-secondary text-white']")
	WebElement array_text;

	@FindBy(xpath="//a[@href='arrays-in-python']")
	WebElement txt_array_python;
	
	@FindBy(xpath="//a[@href='arrays-using-list']")
	WebElement txt_arrays_list;
	
	
	@FindBy(xpath="//a[@href='basic-operations-in-lists']")
	WebElement txt_basicoperations_lists;
	
	@FindBy(xpath="//a[@href='applications-of-array']")
	WebElement txt_applications_array;
	
	@FindBy(xpath="//a[@class='btn btn-info']")
	WebElement lnk_tryEditor;
	
	public static Logger LOG = LoggerFactory.getLogger(ArrayPageObjects.class);

	public ArrayPageObjects(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void navigateTo_HomePage() {
		driver.get("https://dsportalapp.herokuapp.com/");
	}

	public void home_GetStarted() throws InterruptedException {
		Thread.sleep(1000);
		btn_GetStarted.click();

	}

	public void app_SignIn() {

		driver.navigate().to("https://dsportalapp.herokuapp.com/home/");
		sign_Link.click();

	}

	public void app_Login(DataTable table) {
		List<Map<String, String>> rows = table.asMaps(String.class, String.class);
		String username = null;
		String password = null;
		for (Map<String, String> columns : rows) {
			username = columns.get("Username");
			password = columns.get("Password");

		}

		user_Name.sendKeys(username);
		pass_Word.sendKeys(password);
		btn_Login.click();
		String actual_login = text_login.getText();
		String exp_login = "You are logged in";
		Assert.assertEquals(actual_login, exp_login);

	}

	public void check_Login() {

		String actual_login = text_login.getText();
		String exp_login = "You are logged in";
		Assert.assertEquals(actual_login, exp_login);
		// Log.info("Logn Successfully");
	}

	public void click_Array_GetStarted() {
		btn_array_getstarted.click();

	}

	public void array_topics() {

		for (WebElement ele : array_topics) {

			String topic = ele.getText();

			LOG.info("Array Topic.." + topic);

		}
	}

	public void check_Array_Topic_Link() {
		/*
		 * 
		 * int size= array_topics.size();
		 * 
		 * for (int i=0;i<size;i++) {
		 * 
		 * try { String topic = ele.getText();
		 * 
		 * LOG.info(array_topics.size()+"Array Topic Link.." + topic);
		 * 
		 * ele.click();
		 * 
		 * String page = array_text.getText();
		 * 
		 * LOG.info("User is in the page.." + page);
		 * 
		 * SoftAssert softAssert = new SoftAssert(); softAssert.assertEquals(topic,
		 * page); //driver.navigate().to("https://dsportalapp.herokuapp.com/array/");
		 * //Thread.sleep(1000); } catch (Exception e) { // TODO Auto-generated catch
		 * block e.printStackTrace(); }
		 * 
		 * }
		 * 
		 */}

}
