package com.dsportalapp.dsalgo.POM;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CommonMethodsObject {

	WebDriver driver;
	public static Logger LOG = LoggerFactory.getLogger(CommonMethodsObject.class);
	
	public CommonMethodsObject(WebDriver driver) {
		
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
//	 Login
	@FindBy(xpath="//input[@id='id_username']")
	private WebElement userNameText;
	
	@FindBy(xpath="//input[@id='id_password']")
	private WebElement passwordText;
	@FindBy(xpath="//input[@value='Login']")
	private WebElement clickLoginBtn;
	
	public void login() {
		
		userNameText.sendKeys("ninja153");
		passwordText.sendKeys("sdet@153");
		clickLoginBtn.click();
	}
	
	@FindBy(xpath="//a[@class='btn btn-info']")
	private WebElement tryHereButton;
	//span[@role='presentation']/../../..
	@FindBy(xpath="//div[@class='CodeMirror-code']")
	private WebElement textEditor;
	
	@FindBy(xpath="//button[@onclick='runit()']")
	private WebElement runButton;
	
	@FindBy(xpath="//div[@align='left']/pre")
	private WebElement resultEditor;
	
	public void clickTryHereButton() {
		tryHereButton.click();
	}
	public boolean isOntryEditorPage() {
		return driver.getCurrentUrl().contains("tryEditor");
	}
	
	public void sendTextEditor(String pythoncode) {
		Actions act = new Actions(driver);
		act.moveToElement(textEditor).sendKeys(pythoncode).build().perform();;
//		textEditor.sendKeys(pythoncode);
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
    public void clickGetStartedButtonCommon(String option) throws InterruptedException {
		
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
    
    public void clickGetStartedButtonAndCheckHomePage() {
		
	}
    @FindBy(xpath="//li[@class='list-group-item list-group-item-light ']/a")
	private List<WebElement> dataStructuresLeftPanellinks;
	
	@FindBy(xpath="//a[@class='list-group-item']")
	private List<WebElement> dataStructuresHomeLinks;
	
	
public void clickdataStructuresHomeLinks(String homeLink) {
		for(WebElement link:dataStructuresHomeLinks )
		{
				if(link.getText().contains(homeLink))
			{
				link.click();
				break;
			}
		}
		
	}
}
