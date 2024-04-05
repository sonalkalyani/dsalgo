package com.dsportalapp.dsalgo.POM;

import java.util.List;
import java.util.Map;

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



public class LoginPageObjects {


	private WebDriver driver;
	public ConfigReader configFileReader =new ConfigReader();
	@FindBy(name = "username") WebElement username;
	@FindBy(name = "password") WebElement password;
	@FindBy(xpath = "//input[@value = 'Login']") WebElement loginbtn;
	@FindBy(xpath = "//a[text()='Register!']") WebElement registerlnk;
	@FindBy(xpath = "//div[@class = 'alert alert-primary']") WebElement loginsuccmsg;
	@FindBy(xpath = "//a[text() = ' Ninja153 ']") WebElement loginid;
	@FindBy(xpath = "//div[contains(text(), 'Invalid')]") WebElement invalidErrMsg;

	
	
	public static Logger Log = LoggerFactory.getLogger(LoginPageObjects.class);

	
	public LoginPageObjects(WebDriver driver) {
		
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void isOnSignInPage() {
	
		driver.get(configFileReader.init_prop().getProperty("Url"));
		
	
	}
	public String SigninPageTitle() {
		
		return driver.getTitle();
	}
	
	public void RegisterLinkValidation() {
		
		registerlnk.click();
	
	}
	public String RegisterLinkNavigation() {
		
		return driver.getTitle();
		
	}
	public void EnterValidUsernameandPassword() {
		
		String usrname = configFileReader.init_prop().getProperty("username");
		String passwd = configFileReader.init_prop().getProperty("password");
		username.sendKeys(usrname);
		password.sendKeys(passwd);
		ClickLoginBtn();
		
	}
	public void EnterInvalidUsernameandPassword(List <Map<String, String>> userList) {
		
		
		username.sendKeys(userList.get(0).get("Username"));
		password.sendKeys(userList.get(0).get("Password"));
		
	}
	public void ClickLoginBtn() {
		
		loginbtn.click();
	
	}
	
	public String ValidateSuccssMsg() {
		
		return loginsuccmsg.getText();
	
	}
	
	public String ValidateLoginIdonHomePage() {
		
		return loginid.getText();
	}
	
	public String ValidateinvalidErrorMsg() {
		
		return invalidErrMsg.getText(); 
		
	}
	
public void BlankUsernameAndPasswordValidation() {
		
		
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
                Assert.assertEquals(ActualErrMsg,ExpectedErrMsg);
                break;
                
            }
			
		
		}
		if (!tooltipFound) {
           Log.info("Tooltip is not displayed under any input field.");
        } else {
           
        	Log.info("Tooltip message: " + tooltipMessage);
        }
}
		public void BlankUsernameValidation() {
			password.sendKeys("test");
			loginbtn.click();
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
	                Assert.assertEquals(ActualErrMsg,ExpectedErrMsg);
	              }
	              catch (Exception e) {
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
