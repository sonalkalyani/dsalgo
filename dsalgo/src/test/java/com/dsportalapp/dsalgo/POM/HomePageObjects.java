package com.dsportalapp.dsalgo.POM;


import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class HomePageObjects {
	WebDriver driver;
	
	public HomePageObjects(WebDriver driver) {
		
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public static Logger LOG = LoggerFactory.getLogger(HomePageObjects.class);
	
	@FindBy(xpath="//a[contains(text(),'NumpyNinja')]")
	private WebElement numpyNinjaHomeButton;
	
	public void clickNumpyNinjaHomeButton() {
		numpyNinjaHomeButton.click();	
	}
	@FindBy(xpath="//div[@class='navbar-nav']/div")
	private WebElement dataStructuresDropDown;
	
	public boolean clickDataStructuresDropDown() {
		try {
			dataStructuresDropDown.click();
			
			return true;
		}catch(Exception e) {
			e.printStackTrace();
			return false;
		}
		
		
	}
	By dataStructuresDropDownOptions =By.xpath("//div[@class='navbar-nav']/div/div/a");
//	dropdown  option names
	public List<String> getDataStructuresOptions() {
		List<WebElement> totalOptions = dataStructuresDropDown.findElements(dataStructuresDropDownOptions);
		List<String> optionNames = new ArrayList<String>();
		for(WebElement optionName :totalOptions ) 
		{
			optionNames.add(optionName.getText());
		}
		return optionNames;
	}
//	 Dropdown option xpath
	@FindBy(xpath="//div[@class='navbar-nav'][1]/div/div/a[1]")
	private WebElement arraysOption;
	@FindBy(xpath="//div[@class='navbar-nav'][1]/div/div/a[2]")
	private WebElement linkedListsOption;
	@FindBy(xpath="//div[@class='navbar-nav'][1]/div/div/a[3]")
	private WebElement statckOption;
	@FindBy(xpath="//div[@class='navbar-nav'][1]/div/div/a[4]")
	private WebElement queueOption;
	@FindBy(xpath="//div[@class='navbar-nav'][1]/div/div/a[5]")
	private WebElement treeOption;
	@FindBy(xpath="//div[@class='navbar-nav'][1]/div/div/a[6]")
	private WebElement graphOption;
//	Select data structures dropdown option
	public void waitElementToBeClickable(WebElement element) {
	WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(4));
	wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	public void selectDataStructuresDropDown(String option) throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
		waitElementToBeClickable(dataStructuresDropDown);
		clickDataStructuresDropDown();
		if(clickDataStructuresDropDown()) {
			LOG.info("Dropdown has been clicked");
		}else {
			LOG.info("Failed to click dropdown");
		}
		
		try {
			
		switch(option.toLowerCase()) {
		case "arrays":
			wait.until(ExpectedConditions.elementToBeClickable(arraysOption)).click();
			break;
		case "linked list":
			wait.until(ExpectedConditions.elementToBeClickable(linkedListsOption)).click();
			break;
		case "stack":
			wait.until(ExpectedConditions.elementToBeClickable(statckOption)).click();
			break;
		case "queue":
			wait.until(ExpectedConditions.elementToBeClickable(queueOption)).click();
			break;
		case "tree":
			wait.until(ExpectedConditions.elementToBeClickable(treeOption)).click();
			break;
		case "graph":
			wait.until(ExpectedConditions.elementToBeClickable(graphOption)).click();
			break;
		default: 
			throw new IllegalArgumentException("Invalid option: "+ option );
		  }
		}catch(NoSuchElementException e) {
			LOG.error("Option " + option +" not found in the dropdownlist" + e );
		}
		catch(ElementNotInteractableException e) {
			LOG.error("Option " + option +" not found in the dropdownlist" + e );
		}catch(StaleElementReferenceException e) {
			PageFactory.initElements(driver, this);
			wait.until(ExpectedConditions.elementToBeClickable(linkedListsOption)).click();
			LOG.error("Option " + option +" not found in the dropdownlist" + e );
			
		}
		
	}
	
	@FindBy(xpath="//a[contains(text(),' Register ')]")
	private WebElement registerButton;
	@FindBy(xpath="//a[contains(text(),'Sign in')]")
	private WebElement signInButton;
	public void clickRegisterButton() {
		registerButton.click();
	}
	public void clickSignInButton() {
		signInButton.click();
	}
	public boolean isOnLoginPage() {
		return driver.getCurrentUrl().contains("login");
	}
	public boolean isOnRegisterPage() {
		return driver.getCurrentUrl().contains("register");
	}
	@FindBy(xpath="//a[contains(text(),'Register!')]")
	private WebElement registerLink;
	
	public void clickRegisterLink() {
		registerLink.click();
	}
	public boolean isDisplayRegisterLink() {
		return registerLink.isDisplayed();
	}
	
	@FindBy(xpath="//a[contains(text(),'Login ')]")
	private WebElement loginLink;
	
	public boolean isDisplayLoginLink() {
		return loginLink.isDisplayed();
	}
	public void clickLoginLink() {
		loginLink.click();
	}
	
	
	public void clickGetStartedButton(String option) throws InterruptedException {
		
		Thread.sleep(2000);
		String listOfDtaStructuresItemXpath = "//h5[@class='card-title']";
		List<WebElement> dataStructuresItem = driver.findElements(By.xpath(listOfDtaStructuresItemXpath));
		int j=0;
		for(WebElement itemElement :dataStructuresItem ) {
		  try {
			String item = itemElement.getText();
			if(option.contains(item)) {
				j++;
				String getStartedButton= "//a[contains(text(),'Get Started')]";
				int index = dataStructuresItem.indexOf(itemElement);
				WebElement getStratedButton = driver.findElements(By.xpath(getStartedButton)).get(index); 
				getStratedButton.click();
				if(j==1)
					break;
			}
		  }catch(StaleElementReferenceException e) {
			 LOG.error("Stale element reference encountered." + e);
//			 driver.navigate().refresh();
		  }	
		}
	}
	
	
	@FindBy(xpath="//div[@class='alert alert-primary']")
	private WebElement loginAlertMessage;
	
	public String printloginAlertMessage()  {
		String loginAlert = null;
		try {
			loginAlert =  loginAlertMessage.getText();
		} catch(NoSuchElementException e) {
			LOG.error("NoSuchElementException found", e );
		 }
		   return loginAlert;
		
		}
	
		

}
