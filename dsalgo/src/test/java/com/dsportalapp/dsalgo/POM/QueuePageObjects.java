package com.dsportalapp.dsalgo.POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class QueuePageObjects {
	
	private  WebDriver driver;
	
	public QueuePageObjects(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
		
	}
	
	public static Logger LOG = LoggerFactory.getLogger(QueuePageObjects.class);
	
	
	@FindBy(xpath="//h5[contains(text(),'Queue')]//following-sibling::a[contains(text(),'Get Started')]")
	WebElement getStartedBtn;
	@FindBy(xpath="//a[contains(text(),'Data Structures')]")
	WebElement dataStructureDD;
	@FindBy(xpath="//a[contains(text(),'Queue')]")
	WebElement queueOpt;
	
	String linkText = "Queue";
	String xpath = "//a[contains(text(), '" + linkText + "')]";
	
	
	


}
