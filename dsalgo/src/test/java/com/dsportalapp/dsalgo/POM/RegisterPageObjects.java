package com.dsportalapp.dsalgo.POM;

import java.util.HashMap;
import java.util.Map.Entry;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;

import com.dsportalapp.dsalgo.stepDefinition.ResgistrationPageStepDefinition;

public class RegisterPageObjects {
	
	private  WebDriver driver;
	
	public RegisterPageObjects(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
		
	}
	
	HashMap<WebElement,String> eleLst=new HashMap<>();
	
	public static Logger LOG = LoggerFactory.getLogger(RegisterPageObjects.class);
	//locators
	
	@FindBy(id="id_username")
	private  WebElement userNameTxtBox;
	@FindBy(id="id_password1")
	private WebElement passwordTxtBox;
	@FindBy(id="id_password2")
	private WebElement confrmPasswordTxtBox;
	@FindBy(xpath="//input[@type='submit']")
	private WebElement registerBtn;
	@FindBy(xpath="//a[contains(text(),'Login')]")
	private WebElement loginLnk;
	@FindBy(xpath="//div[contains(text(),'password_mismatch:The two password fields didn’t match.')]")
	private WebElement errorMsg;
	@FindBy(xpath="//a[contains(text(),'Register')]")
	private WebElement registerLnk;
	@FindBy(xpath="//div[contains(text(),' New Account Created.')]")
	private WebElement sucessMsg;
	@FindBy(xpath="//ul//a[2]")
	private WebElement signInName;
	
	
	public void registerNewUser(String username,String password)
	{		
	
		userNameTxtBox.sendKeys(username);
		passwordTxtBox.sendKeys(password);
		confrmPasswordTxtBox.sendKeys(password);
		eleLst=readCredentials();
		registerBtn.click();
			
	}
	
	public void registerDiffPwd(String username,String password,String confirmpassword)
	{		
	
		userNameTxtBox.sendKeys(username);
		passwordTxtBox.sendKeys(password);
		confrmPasswordTxtBox.sendKeys(confirmpassword);
		eleLst=readCredentials();
		registerBtn.click();
			
	}
	
	
	public void validateErrMsg()
	{
		String expectedErrMsg="password_mismatch:The two password fields didn’t match.";
		String actualErrMsg=errorMsg.getText();
		try
		{
			Assert.assertEquals(actualErrMsg, expectedErrMsg);
			LOG.error(actualErrMsg);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
	}
	
	public  HashMap<WebElement, String> readCredentials()
	{		
		 String username = userNameTxtBox.getAttribute("value");
		 String password = passwordTxtBox.getAttribute("value");
		 String confrmPwd = confrmPasswordTxtBox.getAttribute("value");
		HashMap<WebElement,String> eleMap=new HashMap<>();
		eleMap.put(userNameTxtBox,username);
		eleMap.put(passwordTxtBox, password);
		eleMap.put(confrmPasswordTxtBox, confrmPwd);
		
		return eleMap;
	}

	
	public String blankValidationUsernameNPasssword()
	{
		
		WebElement nullElement=null;
		HashMap<WebElement,String> eleMap=eleLst;		
		for(HashMap.Entry<WebElement, String> entry : eleMap.entrySet())
		{
			if(entry.getValue().equals(""))
			{
				nullElement=entry.getKey();
				System.out.println(nullElement);
				break;
			}
		}
		String expectedErrMsg="Please fill in this field.";
		System.out.println(nullElement);
		String actualErrMsg=nullElement.getAttribute("validationMessage");
		try
		{
			Assert.assertEquals(actualErrMsg, expectedErrMsg);
			LOG.info("Error message for blank values is : "+actualErrMsg);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return actualErrMsg;
		
	}
		
	public void validUsernameNPasssword(String username)
	{
		
		String expectedSuccMsg="New Account Created. You are logged in as "+username;
		String actualSuccMsg=sucessMsg.getText();
		try
		{
			Assert.assertEquals(actualSuccMsg, expectedSuccMsg);
			LOG.info(actualSuccMsg);
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
						
	}
	
	public boolean isOnHomePage() {
		return driver.getCurrentUrl().contains("home");
		
	}
	
	public boolean isOnLoginPage() {
		return driver.getCurrentUrl().contains("login");
	}
	
	public void isUserLoggedIn(String username) {
		
	try
	{
		Assert.assertEquals(signInName.getText(),username );
		LOG.info("User is logged in with new credentials");
	
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
	}
	
	public void goToHomePage()
	{
		try
		{
			loginLnk.click();
		}
		catch(Exception e)
		{
			LOG.error("An error occured while checking the Login Link: "+ e.getMessage());
			e.printStackTrace();
		}
	}
	
	
}


		

		

	
		
	
		
		
		
		

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	


