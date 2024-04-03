package com.dsportalapp.dsalgo.POM;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;



public class PortalPageObjects {
	WebDriver driver;
	public static Logger LOG = LoggerFactory.getLogger(HomePageObjects.class);
	
	public PortalPageObjects(WebDriver driver) {
		super();
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
//	 Portal Introduction page message
	@FindBy(xpath="//div[@class='content']/p")
	private WebElement introPageMessage;
		
	public String getIntroPageMessage() {
		String message = null;
		try {
			message = introPageMessage.getText();
		}catch(NoSuchElementException e) {
			LOG.error("No such element found " + e);
		}catch(Exception e) {
			LOG.error("An error occurred while while getting intro page message: " + e.getMessage());
		}
		return message;
	}

		
// Get title of the DS_Algo Introduction page	
	public String getTitle() {
		String result = null;
		try {
			result = driver.getTitle();
		}catch (WebDriverException e) {
           	LOG.error("WebDriverException occurred: " + e.getMessage());
        }
		return result;
	}
}
