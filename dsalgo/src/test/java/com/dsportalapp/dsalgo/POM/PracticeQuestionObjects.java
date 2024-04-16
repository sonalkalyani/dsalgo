package com.dsportalapp.dsalgo.POM;

import java.time.Duration;

import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.Keys;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.testng.asserts.SoftAssert;

import com.dsportalapp.dsalgo.utilities.ConfigReader;
import com.dsportalapp.dsalgo.utilities.ExcelReader;

public class PracticeQuestionObjects extends CommonMethodsObject {
	String baseURL, pageURL;
	String excel_file_path = "./src/test/resources/testData/ArrayPractiseQuestionsTestData.xlsx";
	ExcelReader eread = new ExcelReader(excel_file_path);
	public PracticeQuestionObjects(WebDriver driver) {
		super(driver);
		
	}
	
	// Navigate to Practice Question Page
	public void navigateToPracticeQuestionPage(String pagestr) {
		baseURL = ConfigReader.getProperty("Url");
		pageURL = baseURL.trim()+ "/" +  pagestr.trim() + "/practice";
		LOG.info(baseURL + "Practice Question URL : " + pageURL);
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
		LOG.info("Message from System ::"+screen_msg);
		LOG.info("Expected Message ::"+err);
		softAssert.assertTrue(screen_msg.equals(err), "Displayed Error in the screen" + err);
		softAssert.assertAll();
	}

	// clear data from textarea and insert valid code
	public void clearAndInsertMessage(String pythoncode,int row) throws InterruptedException {
		Actions act = new Actions(driver);
		act.moveToElement(textEditor).doubleClick().click().sendKeys(Keys.BACK_SPACE).perform();
		sendTextEditor(pythoncode);
		act.sendKeys(Keys.ENTER).perform();
		if(row==1) {
		textEditorCorrectData(1, 10, true, "R");
		textEditorCorrectData(4, 12, false, "R");
		textEditorCorrectData(2, 4, false, "R");
		}
		else
			if(row==2) {
				textEditorCorrectData(1, 26, true, "R");
				textEditorCorrectData(4, 28, false, "R");
				textEditorCorrectData(1, 19, false, "R");
				textEditorCorrectData(2, 1, false, "");
				textEditorCorrectData(1, 2, false, "R");
				textEditorCorrectData(2, 1, false, "");
				textEditorCorrectData(1, 1, false, "R");
				
			}
		    if(row ==3 || row==4) {
		    	textEditorCorrectData(1, 2, true, "R");
		    	textEditorCorrectData(2, 2, false, "R");
		    	
		    }
		clickRunButton();

	}

	// clear data from textarea
	public void clearMessage() {
		Actions act = new Actions(driver);
		act.moveToElement(textEditor).doubleClick().click().sendKeys(Keys.BACK_SPACE).perform();
		clickRunButton();

	}

	public void textEditorCorrectData(int outer, int inner, boolean flag, String action) throws InterruptedException {
		Actions act = new Actions(driver);

		for (int i = 1; i <= outer; i++) {
			act.sendKeys(Keys.ARROW_UP).build().perform();
			if (flag) {
				for (int j = 1; j <= inner; j++) {
					act.sendKeys(Keys.BACK_SPACE).build().perform();
				}
			} else {

				if (action.equals("R")) {
					for (int k = 1; k <= inner; k++) {
						act.sendKeys(Keys.DELETE).build().perform();
					}
				} else {
					LOG.info("No Action Required");
				}

			}
		}

	}

	public void tryValidPython(String sheet, String rowno) throws Exception {

		String[][] data = eread.getExcelData(sheet);
		String expected = null;
		String currentURL = driver.getCurrentUrl();
		int row =Integer.parseInt(rowno);
		
		LOG.info(data.length+"Current URL : " + driver.getCurrentUrl());
		LOG.info("Sheet Name : " + sheet);
		LOG.info("Row no : " + row);
	
			expected = data[row][0].toString();
			LOG.info("Data from Excel : " + expected);
        	clearAndInsertMessage(expected,row);
			
		
	}
	
	
	public void tryInValidPython(String sheet, String rowno) throws Exception {

		String[][] data = eread.getExcelData(sheet);
		String expected = null;
		String currentURL = driver.getCurrentUrl();
		Actions act = new Actions(driver);
		LOG.info("Current URL : " + driver.getCurrentUrl());
			int row =Integer.parseInt(rowno);
			expected = data[row][0].toString();
			LOG.info("Data from Excel : " + expected);
			//clearAndInsertMessage(expected);
			act.moveToElement(textEditor).doubleClick().click().sendKeys(Keys.BACK_SPACE).perform();
			sendTextEditor(expected);
			
			clickRunButton();
			//switchToAlert();

	}


	public void checkResult() {

		String console_output = printResultEditor();
		String result = null;
		String sheetname=eread.getSheetName();
		String[][] data = eread.getExcelData(sheetname);
		LOG.info("Current URL : " + driver.getCurrentUrl());
		/* Create an instance of Soft Assert */
		SoftAssert softAssert = new SoftAssert();
		if (driver.getCurrentUrl().equals("https://dsportalapp.herokuapp.com/question/1")) {
			result = data[1][1].toString();
		}
		else if (driver.getCurrentUrl().equals("https://dsportalapp.herokuapp.com/question/2")) {
			result = data[2][1].toString();
		}
		else if (driver.getCurrentUrl().equals("https://dsportalapp.herokuapp.com/question/3")) {
			result = data[3][1].toString();
		}
		else if (driver.getCurrentUrl().equals("https://dsportalapp.herokuapp.com/question/4")) {
			result = data[4][1].toString();
		}
			//result ="Passed";
			LOG.info("Result>>" +console_output.equals(result)+"Data from Console : " + console_output + "Data from Excel :"+ result);
			
			softAssert.assertTrue(console_output.equals(result), "Result >>>>>>>>>" + console_output.equals(result));
			softAssert.assertAll();

		

	}

	// check links in the PQ page
	// Below method is calling in array feature
	public void clickdataStructuresHomeLinks(String link1, String link2, String link3, String link4) {
		try {

			for (WebElement link : dataStructuresHomeLinks) {

				String linkStr = link.getText().replaceAll("\\s", "");
				String link1Str = link1.replaceAll("\\s", "");
				String link2Str = link2.replaceAll("\\s", "");
				String link3Str = link3.replaceAll("\\s", "");
				String link4Str = link4.replaceAll("\\s", "");
				// System.out.println(linkStr+"====================="+homeStr);
				// boolean f=linkStr.contains(homeStr);
				// System.out.println(f+"=====================");
				if (linkStr.contains(link1Str) || linkStr.contains(link2Str) || linkStr.contains(link3Str)
						|| linkStr.contains(link4Str)) {
					LOG.info("====******Matched Link************====" + link.getText());

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
	

}