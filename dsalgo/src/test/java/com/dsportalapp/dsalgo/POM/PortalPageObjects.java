package com.dsportalapp.dsalgo.POM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;



public class PortalPageObjects {
	WebDriver driver;
	
	public PortalPageObjects(WebDriver driver) {
		super();
		this.driver = driver;
	}
	
	private By introPageMessageLocator = By.xpath("//div[@class='content']/p");
	public String getIntroPageMessage() {
		return driver.findElement(introPageMessageLocator).getText();
	}
	
	private By toHomeGetStartedButton = By.xpath("//button[@class='btn']");
	public void clicktoHomeGetStartedButton() {
		driver.findElement(toHomeGetStartedButton).click();
	}
		
	public boolean isOnHomePage() {
		return driver.getCurrentUrl().contains("home");
	}
	
}
