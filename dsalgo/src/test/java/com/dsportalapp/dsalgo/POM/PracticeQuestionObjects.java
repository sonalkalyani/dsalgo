package com.dsportalapp.dsalgo.POM;

import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.Keys;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.testng.asserts.SoftAssert;
import com.dsportalapp.dsalgo.utilities.ConfigReader;

public class PracticeQuestionObjects extends CommonMethodsObject {
	
	
	String baseURL, pageURL;
	
	public PracticeQuestionObjects(WebDriver driver) {
		super(driver);
		
		
	}
	// Navigate to Practice Question Page

		public void navigateToPracticeQuestionPage(String pagestr) {

			baseURL = ConfigReader.getProperty("BaseURL");

			pageURL = baseURL + pagestr + "/practice";

			LOG.info("Practice Question URL : " + pageURL);

			driver.navigate().to(pageURL);

		}

		// Submit Button
		@FindBy(xpath = "//input[@type='submit']")
		WebElement submit;

		public void checkElementsinPracticeQuestionPage() {
			boolean texteditorFlag = textEditor.isDisplayed();
			boolean runbtnFlag = runButton.isDisplayed();
			boolean submitbtnFlag = submit.isDisplayed();

			if (texteditorFlag && runbtnFlag && submitbtnFlag) {
				LOG.info("Elements are present in Practice Question Page");
			}

		}

		// click on Submit Button
		public void clickSubmitButton() {
			try {
				submit.click();
			} catch (Exception e) {
				LOG.error("An error occured while clicking the 'Submit' button: " + e.getMessage());
				e.printStackTrace();
			}
		}

		// checking the error message in the submit invalid scenario
		public void getErrorMessage(String err) {

			String screen_msg = printResultEditor();

			/* Create an instance of Soft Assert */
			SoftAssert softAssert = new SoftAssert();
			softAssert.assertTrue(screen_msg.equals(err), "Displayed Error in the screen" + err);
			softAssert.assertAll();
		}

		// clear data from textarea and insert valid code
		public void clearAndInsertMessage(String pythoncode) {
			Actions act = new Actions(driver);
			act.moveToElement(textEditor).doubleClick().click().sendKeys(Keys.BACK_SPACE).perform();
			sendTextEditor(pythoncode);
			clickRunButton();

		}
		// clear data from textarea
		public void clearMessage() {
			Actions act = new Actions(driver);
			act.moveToElement(textEditor).doubleClick().click().sendKeys(Keys.BACK_SPACE).perform();
			clickRunButton();

		}
		// check links in the PQ page
	/*	public void clickdataStructuresHomeLinks(String link1,String link2, String link3, String link4) {
			try {
				
				for (WebElement link : dataStructuresHomeLinks) {
					
					String linkStr=link.getText().replaceAll("\\s", "");
					String link1Str = link1.replaceAll("\\s", "");
					String link2Str = link2.replaceAll("\\s", "");
					String link3Str = link3.replaceAll("\\s", "");
					String link4Str = link4.replaceAll("\\s", "");
					//System.out.println(linkStr+"====================="+homeStr);
					//boolean f=linkStr.contains(homeStr);
					//System.out.println(f+"=====================");
					if (linkStr.contains(link1Str)||linkStr.contains(link2Str)||linkStr.contains(link3Str)||linkStr.contains(link4Str)) {
						LOG.info("====******Matched Link************===="+link.getText());
						
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

		}*/


	}

