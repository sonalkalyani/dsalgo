package com.dsportalapp.dsalgo.POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CommonMethodsObject {

	WebDriver driver;
	
	public CommonMethodsObject(WebDriver driver) {
		
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//a[@class='btn btn-info']")
	private WebElement tryHereButton;
	
	@FindBy(xpath="//textarea[@id='editor']")
	private WebElement textEditor;
	
	@FindBy(xpath="//button[@onclick='runit()']")
	private WebElement runButton;
	
	@FindBy(xpath="//div[@align='left']/pre")
	private WebElement resultEditor;
	
	public void clickTryHereButton() {
		tryHereButton.click();
	}
	public void clickTextEditor(String input) {
		textEditor.sendKeys(input);
	}
	public void clickRunButton() {
		runButton.click();
	}
	public String printResultEditor() {
		return resultEditor.getText();
	}
	public void switchToAlert() {
		driver.switchTo().alert().accept();
	}
}
