package com.dsportalapp.dsalgo.POM;

import org.openqa.selenium.WebDriver;

public class PageObjectManager {
	public WebDriver driver;
	public HomePageObjects homepageobj;
	private ArrayPageObjects arrayPage;

	public PageObjectManager(WebDriver driver) {
		super();
		this.driver = driver;
	}
	
	public HomePageObjects getHomePageObjects() {
		homepageobj = new HomePageObjects();
		return homepageobj;
		
	}
	
	public ArrayPageObjects getArrayPage(){

		return (arrayPage == null) ? arrayPage = new ArrayPageObjects(driver) : arrayPage;

	}
	

}
