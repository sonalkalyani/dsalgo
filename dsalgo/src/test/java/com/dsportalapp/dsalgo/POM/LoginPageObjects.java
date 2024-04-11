
package com.dsportalapp.dsalgo.POM;

import java.util.List;
import java.util.Map;
import java.util.Properties;
import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import com.dsportalapp.dsalgo.utilities.ConfigReader;




public class LoginPageObjects{

	private WebDriver driver;
	public static Logger Log = LoggerFactory.getLogger(LoginPageObjects.class);

	public LoginPageObjects(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(name = "username")
	private WebElement userName;
	@FindBy(name = "password")
	private WebElement password;
	@FindBy(xpath = "//input[@value = 'Login']")
	private WebElement loginBtn;
//	@FindBy(xpath = "//a[text()='Register!']")
//	private WebElement registerLnk;
	@FindBy(xpath = "//div[@class = 'alert alert-primary']")
	private WebElement loginSuccmsg;
	@FindBy(xpath = "//a[text() = ' Ninja153 ']")
	private WebElement loginId;
	@FindBy(xpath = "//div[contains(text(), 'Invalid')]")
	private WebElement invalidErrMsg;

	

	public String signInPageTitle() {

		String actualtitle = driver.getTitle();

		try {
			
			Log.info("Title of the page is: " + actualtitle);

		} catch (Exception e) {
			e.printStackTrace();
		}

		return actualtitle;
	}

//	public void registerLinkValidation() {
//
//		try {
//			registerLnk.getText();
//		} catch (Exception e) {
//			Log.error("An error occured while checking the Register Link: " + e.getMessage());
//		}
//
//	}

//	public String registerLinkNavigation() {
//		registerLnk.click();
//		String registerLink = driver.getTitle();
//		try {
//			Log.info("Title of the Page is: " + registerLink);
//		} catch (Exception e) {
//			Log.error("Error while checking Register Page Title: " + e.getMessage());
//			e.printStackTrace();
//		}
//		return registerLink;
//
//	}

	public void enterValidUsernameandPassword() {
		try {
			String usrName = ConfigReader.getProperty("username");
			String passwd = ConfigReader.getProperty("password");
	        userName.sendKeys(usrName);
	        password.sendKeys(passwd);
	        clickLoginBtn();
	    } catch (Exception e) {
	        Log.error("An error occurred while entering valid username and password: " + e.getMessage());
	    }

	}

	public void enterInvalidUsernameandPassword(List<Map<String, String>> userList) {

		try {
		userName.sendKeys(userList.get(0).get("Username"));
		password.sendKeys(userList.get(0).get("Password"));
		}
		catch (Exception e) {
			Log.error("Error while entering in username and password textboxes " +e.getMessage() );
		}
	}

	public void clickLoginBtn() {

		try {
			loginBtn.click();
		} catch (Exception e) {
			Log.error("An error occured while checking the Login Button: " + e.getMessage());
			e.printStackTrace();
		}

	}

	public String validateSuccssMsg(String signInMsg) {

		String actualMessage = loginSuccmsg.getText();
		try {
			Assert.assertEquals(actualMessage, signInMsg);
			Log.info("Message on the HomePage is: " + actualMessage);

		} catch (Exception e) {
			e.printStackTrace();
		}

		return actualMessage;

	}

	public void validateLoginIdOnHomePage() {
		
		
		String expectdSignInId = loginId.getText();
		String actualSignInId = ConfigReader.getProperty("username");

		try {
			Assert.assertEquals(StringUtils.capitalize(actualSignInId), expectdSignInId);
		} catch (Exception e) {

			Log.error("Error in displaying SignIn Id: " + e.getMessage());
			e.printStackTrace();
		}
	}

	public String validateInvalidErrorMsg(String errMsg) {

		String actualErrorMsg = invalidErrMsg.getText();
		try {
			Assert.assertEquals(actualErrorMsg, errMsg);
			Log.info("Error Message is: " + actualErrorMsg);

		} catch (Exception e) {

			e.printStackTrace();
		}
		return actualErrorMsg;

	}

	public void blankUsernameAndPasswordValidation() {

		List<WebElement> inputFields = driver.findElements(By.tagName("label"));
		boolean tooltipFound = false;
		String tooltipMessage = "";
		Actions action = new Actions(driver);
		for (WebElement inputField : inputFields) {

			action.moveToElement(inputField).perform();
			WebElement activeElement = driver.switchTo().activeElement();

			String ActualErrMsg = activeElement.getAttribute("validationMessage");
			String ExpectedErrMsg = "Please fill out this field.";

			if (ActualErrMsg != null && !ActualErrMsg.isEmpty()) {

				tooltipFound = true;
				tooltipMessage = ActualErrMsg;

				Log.info("Tooltip is displayed under input field: " + inputField.getText());
				Assert.assertEquals(ActualErrMsg, ExpectedErrMsg);
				break;

			}

		}
		if (!tooltipFound) {
			Log.info("Tooltip is not displayed under any input field.");
		} else {

			Log.info("Tooltip message: " + tooltipMessage);
		}
	}

	public void blankUsernameValidation() {
		password.sendKeys("test");
		loginBtn.click();
		List<WebElement> inputFields = driver.findElements(By.tagName("label"));
		boolean tooltipFound = false;
		String tooltipMessage = "";
		Actions action = new Actions(driver);
		for (WebElement inputField : inputFields) {

			action.moveToElement(inputField).perform();
			WebElement activeElement = driver.switchTo().activeElement();

			String ActualErrMsg = activeElement.getAttribute("validationMessage");
			String ExpectedErrMsg = "Please fill out this field.";

			if (ActualErrMsg != null && !ActualErrMsg.isEmpty()) {

				tooltipFound = true;
				tooltipMessage = ActualErrMsg;
				try {
					Log.info("Tooltip is displayed under input field: " + inputField.getText());
					Assert.assertEquals(ActualErrMsg, ExpectedErrMsg);
				} catch (Exception e) {
					e.printStackTrace();
				}

				break;

			}

		}
		if (!tooltipFound) {
			Log.info("Tooltip is not displayed under any input field.");
		} else {

			Log.info("Tooltip message: " + tooltipMessage);
		}

	}
}
