package com.dsportalapp.dsalgo.POM;

import org.openqa.selenium.WebDriver;

public class PageObjectManager {
	public WebDriver driver;
	public HomePageObjects homepageobj;
	public RegisterPageObjects registerobjects;
	public QueuePageObjects queueobjects;

	public PageObjectManager(WebDriver driver) {
		super();
		this.driver = driver;
	}
	
	public HomePageObjects getHomePageObjects() {
		homepageobj = new HomePageObjects();
		return homepageobj;
		
	}
	public RegisterPageObjects getRegisterPageObjects() {
		registerobjects = new RegisterPageObjects(driver);
		return registerobjects;
		
	}
	public QueuePageObjects getQueuePageObjects() {
		queueobjects = new QueuePageObjects(driver);
		return queueobjects;
		
	}
	

}
