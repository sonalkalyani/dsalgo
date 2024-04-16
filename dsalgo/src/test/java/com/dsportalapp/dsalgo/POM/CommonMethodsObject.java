
package com.dsportalapp.dsalgo.POM;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeoutException;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.Keys;
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
import org.testng.Assert;
import com.dsportalapp.dsalgo.utilities.ConfigReader;

public class CommonMethodsObject {

	WebDriver driver;
	WebDriverWait wait;
	
	
	public static Logger LOG = LoggerFactory.getLogger(CommonMethodsObject.class);

	public CommonMethodsObject(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(4)); 
		
		
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
////	Register Link in home page
	
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
	protected WebElement textEditor;

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
	protected WebElement runButton;

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
			
		String listOfDtaStructuresItemXpath = "//h5[@class='card-title']";
		List<WebElement> dataStructuresItem = driver.findElements(By.xpath(listOfDtaStructuresItemXpath));
		
		for(WebElement itemElement :dataStructuresItem ) {
		  try {
			  waitElementToBeClickable(itemElement);
			  String item = itemElement.getText();
			if(option.contains(item)) {
				
				String getStartedButton= "//a[contains(text(),'Get Started')]";
				int index = dataStructuresItem.indexOf(itemElement);
				WebElement getStratedButton = driver.findElements(By.xpath(getStartedButton)).get(index); 
				getStratedButton.click();
			  }
			
		  }
			catch(Exception e) {
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

	@FindBy(xpath = "//div[@class='col-2']//a")
	private List<WebElement> dataStructuresLeftPanellinks;

//	dataStructures Home Page Link
	@FindBy(xpath = "//a[@class='list-group-item']")
	protected List<WebElement> dataStructuresHomeLinks;


	public void clickdataStructuresHomeLinks(String homeLink) {
		try {
			for (WebElement link : dataStructuresHomeLinks) {
//				String linkStr=link.getText().replaceAll("\\s", "");
//				String homeStr = homeLink.replaceAll("\\s", "");
//				if (linkStr.contains(homeStr)) {
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


	
	@FindBy(xpath="//a[@class='navbar-brand']")
	private WebElement numpyNinjaLogo;
	@FindBy(xpath="//a[@class='nav-link dropdown-toggle']")
	private WebElement dataStructuresDD;
	@FindBy(xpath="//ul//a[2]")
	private WebElement signInName;
	@FindBy(xpath="//a[contains(text(),'Sign out')]")
	private WebElement signOut;
	
	
	public void headervalidation()
	{
		try
		{
			Assert.assertTrue(numpyNinjaLogo.isDisplayed(),"NumpyNinja Logo is not displayed");
			Assert.assertTrue(dataStructuresDD.isEnabled(),"Datastructures dropdown is not Enabled");
			String expectedUsername = ConfigReader.getProperty("username");
			String actualUsername = signInName.getText();
			Assert.assertEquals(actualUsername.toLowerCase(), expectedUsername.toLowerCase());
			Assert.assertTrue(signOut.isDisplayed(),"Sign Out Link is not displayed");
			LOG.info("Header validation done sucessfully");
				
		}
		catch(Exception e)
		{
			LOG.error("Header validation Failed with error"+e.getMessage());
			e.printStackTrace();
		}
		
	}
	
	@FindBy(xpath="//a[contains(text(),'Sign out')]")
	private WebElement signOutBtn;
	@FindBy(xpath="//div[@class='alert alert-primary']")
	private WebElement logOutMsg;
	@FindBy(xpath="//a[contains(text(),' Register ')]")
	private WebElement registerLnk;
	@FindBy(xpath="//a[contains(text(),' Register ')]")
	private WebElement signInLnk;
	

	public void signOut()
	{
		
		try {
		signOutBtn.click();
		Assert.assertEquals(logOutMsg.getText() ,"Logged out successfully" );
		Assert.assertTrue(registerLnk.isEnabled(), "Resgister Link is  not enabled");
		Assert.assertTrue(signInLnk.isEnabled(), "Sign In Link is not enabled");
		LOG.info("Logged out successfully");
		}
		catch (Exception e) {
			LOG.error(e.getMessage());
			e.printStackTrace();
          }
	}
	
	

	public void leftLink(String pythonCode) {

		int linkSize = dataStructuresLeftPanellinks.size();
		int j = 0;
		for (int i = 0; i < linkSize; i++) {
			WebElement link = dataStructuresLeftPanellinks.get(i);
			String href = link.getAttribute("href");
			System.out.println(href);
//			if(href.contains("array/practice"))
			try {
				link.click();
				j++;
				String currentURL = driver.getCurrentUrl();
				Assert.assertTrue(currentURL.contains(href), "Expected Page is not availabe");
				if (j == linkSize) 
//				{
//					if (href.contains("array/practice")) {
//
//					}
					break;
//				} 
			else {
					clickTryHereButton();
					sendTextEditor(pythonCode);
					clickRunButton();
					driver.navigate().back();
					driver.navigate().refresh();
					dataStructuresLeftPanellinks = driver.findElements(By.xpath("//div[@class='col-2']//a"));

				}
			} catch (Exception e) {
				LOG.info("Error occurred while clicking the link '" + href + "': " + e.getMessage());

			}
		}
	}
	
// Explicit wait	
	public void waitElementToBeClickable(WebElement element) throws TimeoutException {
		 try {
		        
		        wait.until(ExpectedConditions.elementToBeClickable(element));
		        LOG.info("Element is clickable: " + element);
		    } catch (Exception e) {
		        LOG.info("Error occurred while waiting for element: " + e.getMessage());
		        e.printStackTrace();
		    }	}


		public void waitVisibilityOfElementLocated(WebElement element) {
			try {
				wait.until(ExpectedConditions.visibilityOf(element));
			} catch (Exception e) {
				LOG.info("Error occurred while waiting for element: " + e.getMessage());
				e.printStackTrace();
			}
		}
		public static void TextIndentation(WebDriver driver, WebElement pythonElement, int row, int space,boolean flag) {
			Actions action = new Actions(driver);
		       // Keys cmdCtrl = Platform.getCurrent().is(Platform.MAC) ? Keys.COMMAND : Keys.CONTROL;
			for(int i=1;i<=row;i++) {
			      action.sendKeys(Keys.ARROW_UP).keyUp(Keys.SHIFT).perform();
			       for(int j=1;j<=space;j++) {
		            if(i==1 && flag) action.sendKeys(Keys.BACK_SPACE).perform();
		            else action.sendKeys(Keys.DELETE).perform();
				   }
			}
		}
		
		
		
	/*	public void clickArrayPracticeHomeLinks(String homeLink) {
			try {
				for (WebElement link : dataStructuresHomeLinks) {
					if (link.getText().contains(homeLink)) {
						link.click();
						
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

		} */

//	public void waitVisibilityOfElementLocated(WebElement element) {
//		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(4));
//		wait.until(ExpectedConditions.visibilityOfElementLocated;
//	}
	
	
	public void clickRegisterLnk()
	{
		registerLnk.click();
		String expectedRegisterPageTitle = "Registration";
		String actualRegisterPageTitle=driver.getTitle();
		Assert.assertEquals(actualRegisterPageTitle, expectedRegisterPageTitle);
		LOG.info("User is " +actualRegisterPageTitle+" page");
	}
	


}
