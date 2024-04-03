package com.dsportalapp.dsalgo.POM;


import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

public class HomePageObjects extends CommonMethodsObject {
	WebDriver driver;
	
	public HomePageObjects(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public static Logger LOG = LoggerFactory.getLogger(HomePageObjects.class);
	
//	NumpyNinja Header
	@FindBy(xpath="//a[contains(text(),'NumpyNinja')]")
	private WebElement numpyNinjaHomeButton;
	
	public void clickNumpyNinjaHomeButton() {
		try {
		numpyNinjaHomeButton.click();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
//	Data Structures Drop down
	@FindBy(xpath="//div[@class='navbar-nav']/div")
	private WebElement dataStructuresDropDown;
	
	By dataStructuresDropDownLocator = By.xpath("//div[@class='navbar-nav']/div");
	
	public boolean clickDataStructuresDropDown() {
		try {
			dataStructuresDropDown.click();
			
			return true;
		}catch(Exception e) {
			e.printStackTrace();
		}
		 return false;
	}
	
//  Data Structures	dropdown  option names
	
	By dataStructuresDropDownOptions =By.xpath("//div[@class='navbar-nav']/div/div/a");

	public List<String> getDataStructuresOptions() {
		try {
			List<WebElement> totalOptions = dataStructuresDropDown.findElements(dataStructuresDropDownOptions);
			List<String> optionNames = new ArrayList<String>();
			for (WebElement optionName : totalOptions) {
				optionNames.add(optionName.getText());
			}
			return optionNames;
		} catch (Exception e) {
			LOG.error("Error occurred while getting data structures options: " + e.getMessage());
			e.printStackTrace(); 
			return Collections.emptyList(); 
		}
	}
	
	
//	Select data structures dropdown option
	
	public Map<String, String> selectDataStructuresDropDown(String option) throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		Map<String, String> dropDownwarningMsgMap = new HashMap<>();
			waitElementToBeClickable(dataStructuresDropDown);
			clickDataStructuresDropDown();
			if (clickDataStructuresDropDown()) {
				LOG.info("Dropdown has been clicked");
			} else {
				LOG.info("Failed to click dropdown");
			}

			try {

				switch (option.toLowerCase()) {
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
					throw new IllegalArgumentException("Invalid option: " + option);
				}
				String warningMessage = printloginAlertMessage();
				if (warningMessage != null) {
					dropDownwarningMsgMap.put(option, warningMessage);
//			LOG.info(option + ":"+warningMessageMap.get(option));
				}
			} catch (NoSuchElementException e) {
				LOG.error("Option " + option + " not found in the dropdownlist" + e);
			} catch (ElementNotInteractableException e) {
				LOG.error("Option " + option + " not found in the dropdownlist" + e);
			} catch (StaleElementReferenceException e) {
				PageFactory.initElements(driver, this);
				wait.until(ExpectedConditions.elementToBeClickable(linkedListsOption)).click();
				LOG.error("Option " + option + " not found in the dropdownlist" + e);

			}
			
		return dropDownwarningMsgMap;
	}

//	Register Link in home page
	
	@FindBy(xpath="//a[contains(text(),' Register ')]")
	private WebElement registerButton;
	public void clickRegisterButton() {
		try {
			registerButton.click();
		}catch (Exception e) {
	        LOG.error("Error occurred while clicking register link on home page: " + e.getMessage());
	        e.printStackTrace(); 
	    }
	}
	
//	Sign In Link in home page
	
	@FindBy(xpath="//a[contains(text(),'Sign in')]")
	private WebElement signInButton;
	
	public void clickSignInButton() {
		try {
			signInButton.click();
		} catch (Exception e) {
			LOG.error("Error occurred while clicking signin link on home page " + e.getMessage());
			e.printStackTrace();
		}
	}
// 	Register Link in login page
	@FindBy(xpath="//a[contains(text(),'Register!')]")
	private WebElement registerLink;
	
	public void clickRegisterLink() {
		try {
			registerLink.click();
		}catch (Exception e) {
	        LOG.error("Error occurred while clicking register link: " + e.getMessage());
	        e.printStackTrace(); 
	    }
	}

	public boolean isDisplayRegisterLink() {
		boolean result = false;
		try {
			return registerLink.isDisplayed();
		} catch (Exception e) {
			LOG.error("Error occurred while checking if register link is displayed: " + e.getMessage());
			e.printStackTrace();
		}
		return result;
	}
////	Login link in signin page
//	@FindBy(xpath="//a[contains(text(),'Login ')]")
//	private WebElement loginLink;
//	
//	public boolean isDisplayLoginLink() {
//		boolean result = false;
//			try {
//				result = loginLink.isDisplayed();
//			 } catch (Exception e) {
//			        LOG.error("Error occurred while checking if login link is displayed: " + e.getMessage());
//			        e.printStackTrace(); 
//			 }
//		return result;
//	}
	public void clickLoginLink() {
		try {
			loginLink.click();
		} catch (Exception e) {
	        
	        LOG.error("Error occurred while clicking login link: " + e.getMessage());
	        e.printStackTrace(); 
	    }
	}
	
//	 GetStarted Button 
	public Map<String, String> clickGetStartedButton(List<String> dataStructuresOption) throws InterruptedException {
		Map<String, String> warningMessageMap = new HashMap<>();
		for(String option : dataStructuresOption) {
		Thread.sleep(2000);
		String listOfDtaStructuresItemXpath = "//h5[@class='card-title']";
		List<WebElement> dataStructuresItem = driver.findElements(By.xpath(listOfDtaStructuresItemXpath));
		for(WebElement itemElement :dataStructuresItem ) {
		  try {
			String item = itemElement.getText();
			if(option.contains(item)) {
			
				String getStartedButton= "//a[contains(text(),'Get Started')]";
				int index = dataStructuresItem.indexOf(itemElement);
				WebElement getStratedButton = driver.findElements(By.xpath(getStartedButton)).get(index); 
				getStratedButton.click();
				Thread.sleep(3000);
				String warningMessage = printloginAlertMessage();
				if(warningMessage != null) {
					warningMessageMap.put(option,warningMessage);
//					System.out.println(option + ":"+warningMessageMap.get(option));
				}
			}
		  }catch(Exception e) {
			 LOG.error("Exception encountered." + e.getMessage());
			 e.printStackTrace();
			 driver.navigate().refresh();
		  }	
		}
	}
		Thread.sleep(3000);
		driver.navigate().refresh();
		PageFactory.initElements(driver, this);
		return warningMessageMap;
	}

//	 GetStarted Button 
/*	public Map<String, String> clickGetStartedButton(String option) throws InterruptedException {
		Map<String, String> warningMessageMap = new HashMap<>();
		Thread.sleep(2000);
		String listOfDtaStructuresItemXpath = "//h5[@class='card-title']";
		List<WebElement> dataStructuresItem = driver.findElements(By.xpath(listOfDtaStructuresItemXpath));
		for(WebElement itemElement :dataStructuresItem ) {
		  try {
			String item = itemElement.getText();
			if(option.contains(item)) {
			
				String getStartedButton= "//a[contains(text(),'Get Started')]";
				int index = dataStructuresItem.indexOf(itemElement);
				WebElement getStratedButton = driver.findElements(By.xpath(getStartedButton)).get(index); 
				getStratedButton.click();
				Thread.sleep(3000);
				String warningMessage = printloginAlertMessage();
				if(warningMessage != null) {
					warningMessageMap.put(option,warningMessage);
//					System.out.println(option + ":"+warningMessageMap.get(option));
				}
			}
		  }catch(Exception e) {
			 LOG.error("Exception encountered." + e);
			 driver.navigate().refresh();
		  }	
		}
		   return warningMessageMap;
	}*/
	
//	Login warning message for not user logged in 
	
	@FindBy(xpath="//div[@class='alert alert-primary']")
	private WebElement loginAlertMessage;
	
	public String printloginAlertMessage()  {
		String loginAlert = null;
		try {
			loginAlert =  loginAlertMessage.getText();
		} catch(NoSuchElementException e) {
			LOG.error("NoSuchElementException found", e );
		 }catch(Exception e) {
				LOG.error("Exception occured while getting text ", e );
			 }
		   return loginAlert;
		
		}
	
	

}
