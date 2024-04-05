package com.dsportalapp.dsalgo.POM;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.time.Duration;
import java.util.List;

import org.apache.commons.logging.LogConfigurationException;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.asserts.SoftAssert;

public class CommonMethodsObject {

	WebDriver driver;
	public static Logger LOG = LoggerFactory.getLogger(CommonMethodsObject.class);

	public CommonMethodsObject(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

//	Get Started Button on portal Introduction Page

	@FindBy(xpath = "//button[@class='btn']")
	private WebElement toHomeGetStartedButton;

	public void clicktoHomeGetStartedButton() {
		try {
			toHomeGetStartedButton.click();
		} catch (ElementClickInterceptedException e) {
			LOG.error("ElementClickInterceptedException occurred: " + e.getMessage());
		} catch (NoSuchElementException e) {
			LOG.error("No such element found " + e);
		} catch (Exception e) {
			LOG.error("An exception occured while clicking 'Get Started' button: " + e.getMessage());
		}
	}

////	 Login
	@FindBy(name = "username")
	protected WebElement userName;
	@FindBy(name = "password")
	protected WebElement password;
	@FindBy(xpath = "//input[@value = 'Login']")
	protected WebElement loginBtn;
	
	public void enterValidUsernameandPassword() {
		
		try {
			
			LOG.info("Login is successful");
			
		} catch (Exception e) {
			LOG.error("There is an error while signing in" +e.getMessage());
			e.printStackTrace();
		}
	}
	
//	Login link in signin page
	@FindBy(xpath="//a[contains(text(),'Login ')]")
	protected WebElement loginLink;
	
	public boolean isDisplayLoginLink() {
		boolean result = false;
			try {
				result = loginLink.isDisplayed();
			 } catch (Exception e) {
			        LOG.error("Error occurred while checking if login link is displayed: " + e.getMessage());
			        e.printStackTrace(); 
			 }
		return result;
	}

//	tryHereButton
	@FindBy(xpath = "//a[@class='btn btn-info']")
	private WebElement tryHereButton;

	public void clickTryHereButton() {
		try {
			tryHereButton.click();
		} catch (Exception e) {
			LOG.error("An error occured while clicking the 'Try Here' button: " + e.getMessage());
			e.printStackTrace();
		}

	}

//	python textEditor 
	@FindBy(xpath = "//div[@class='CodeMirror-code']")
	private WebElement textEditor;

	public void sendTextEditor(String pythoncode) {
		try {
			Actions act = new Actions(driver);
			act.moveToElement(textEditor).sendKeys(pythoncode).build().perform();
		} catch (Exception e) {
			LOG.error("An error occured while 'sending text' to the python editor: " + e.getMessage());
			e.printStackTrace();
		}
	}

	public boolean isOntryEditorPage() {
		boolean result = false;
		try {
			result = driver.getCurrentUrl().contains("tryEditor");
		} catch (Exception e) {
			LOG.error("An error occured while checking the 'current URL': " + e.getMessage());
			e.printStackTrace();
		}
		return result;
	}

//	runButton
	@FindBy(xpath = "//button[@onclick='runit()']")
	private WebElement runButton;

	public void clickRunButton() {
		try {
			runButton.click();
		} catch (Exception e) {
			LOG.error("An error occured while clicking the 'Run' button: " + e.getMessage());
			e.printStackTrace();
		}
	}

//	resultEditor
	@FindBy(xpath = "//div[@align='left']/pre")
	private WebElement resultEditor;

	public String printResultEditor() {
		try {
			return resultEditor.getText();
		} catch (NoSuchElementException e) {
			LOG.error("An error occured while retrieving text from the result editor " + e.getMessage());
			e.printStackTrace();
		} catch (Exception e) {
			LOG.error("An error occured while retrieving text from the result editor " + e.getMessage());
			e.printStackTrace();
		}
		return "";
	}

//	switchToAlert
	public String switchToAlert() {
		String alertMessage = null;
		try {
			Alert alert = driver.switchTo().alert();
			if (alert != null) {
				alertMessage = alert.getText();
				alert.accept();
				return alertMessage;
			} else {
				LOG.info("No alert present");
			}
		} catch (NoAlertPresentException e) {
			LOG.error("No alert present " + e.getMessage());
			e.printStackTrace();
		} catch (Exception e) {
			LOG.error("An error occured while switching to the alert: " + e.getMessage());
			e.printStackTrace();
		}
		return alertMessage;
	}

	public boolean isOnRedirectedPage(String redirectedPage) {
		boolean result = false;
		try {
			result = driver.getCurrentUrl().contains(redirectedPage);
		} catch (WebDriverException e) {
			LOG.error("An error occurred while checking the current URL: " + e.getMessage());

		}
		return result;
	}

	public void clickGetStartedButtonCommon(String option) throws InterruptedException {
		
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
			  }
			
		  }catch(StaleElementReferenceException e) {
				 LOG.error("Stale element reference encountered." + e);
				 driver.navigate().refresh();
			
		  }	catch(Exception e) {
				LOG.error("An error occured while clicking 'Get Started' button:"+ e.getMessage());
				e.printStackTrace();
		  }	
		}
	}

//  dropdown xpath
	@FindBy(xpath = "//div[@class='navbar-nav'][1]/div/div/a[1]")
	protected WebElement arraysOption;
	@FindBy(xpath = "//div[@class='navbar-nav'][1]/div/div/a[2]")
	protected WebElement linkedListsOption;
	@FindBy(xpath = "//div[@class='navbar-nav'][1]/div/div/a[3]")
	protected WebElement statckOption;
	@FindBy(xpath = "//div[@class='navbar-nav'][1]/div/div/a[4]")
	protected WebElement queueOption;
	@FindBy(xpath = "//div[@class='navbar-nav'][1]/div/div/a[5]")
	protected WebElement treeOption;
	@FindBy(xpath = "//div[@class='navbar-nav'][1]/div/div/a[6]")
	protected WebElement graphOption;

	public void selectDataStructuresDropDownCommon(String option) throws InterruptedException {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

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
		} catch (NoSuchElementException | ElementNotInteractableException | StaleElementReferenceException e) {
			LOG.error("Option " + option + " not found in the dropdownlist", e);
		}

	}

	@FindBy(xpath = "//li[@class='list-group-item list-group-item-light ']/a")
	private List<WebElement> dataStructuresLeftPanellinks;

//	dataStructures Home Page Link
	@FindBy(xpath = "//a[@class='list-group-item']")
	private List<WebElement> dataStructuresHomeLinks;

	public void clickdataStructuresHomeLinks(String homeLink) {
		try {
			for (WebElement link : dataStructuresHomeLinks) {
				if (link.getText().contains(homeLink)) {
					link.click();
					break;
				}
			}
		} catch (StaleElementReferenceException e) {
			LOG.error("Stale element reference encountered." + e);
			driver.navigate().refresh();
		} catch (ElementNotInteractableException e) {
			LOG.error("Element not interactable: " + e.getMessage());

		} catch (Exception e) {
			LOG.error("An error occurred while clicking the link: " + e.getMessage());
			e.printStackTrace();
		}

	}

	public void checkBrokenLinks() throws URISyntaxException {
	    SoftAssert softAssert = new SoftAssert();
	    for (WebElement link : dataStructuresLeftPanellinks) {
	        String href = link.getAttribute("href");
	        if (href != null && (href.startsWith("http://") || href.startsWith("https://"))) {
	            try {
	                HttpURLConnection connection = (HttpURLConnection) new URI(href).toURL().openConnection();
	                connection.setRequestMethod("HEAD");
	                connection.connect();
	                int responseCode = connection.getResponseCode();
	                softAssert.assertTrue(responseCode < 400, "The link '" + href + "' is broken with response code " + responseCode);
	                LOG.info(href +" has been verified");
	            } catch (IOException e) {
	                softAssert.fail("Error occurred while checking link '" + href + "': " + e.getMessage());
	            }
	        }
	    }
	    softAssert.assertAll();
	}
	public void waitElementToBeClickable(WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(4));
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}
//	public void waitVisibilityOfElementLocated(WebElement element) {
//		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(4));
//		wait.until(ExpectedConditions.visibilityOfElementLocated;
//	}

}



