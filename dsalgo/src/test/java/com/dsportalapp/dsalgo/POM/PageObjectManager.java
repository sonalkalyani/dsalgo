package com.dsportalapp.dsalgo.POM;

import org.openqa.selenium.WebDriver;

public class PageObjectManager {
	public WebDriver driver;
	public HomePageObjects homepageobj;
	public LoginPageObjects loginpageobj;
	public CommonMethodsObject commonobj;

	public PageObjectManager(WebDriver driver) {
		super();
		this.driver = driver;
	}
	
	public LoginPageObjects getLoginPageObjects() {
		loginpageobj = new LoginPageObjects(driver);
		return loginpageobj;
		
	}
	
	public CommonMethodsObject getCommonMethodsObject() {
		commonobj = new CommonMethodsObject(driver);
		return commonobj;
	}
	

}
