package com.dsportalapp.dsalgo.POM;

import org.openqa.selenium.WebDriver;

public class PageObjectManager {
	public WebDriver driver;
	public HomePageObjects homepageobj;
	public PortalPageObjects portalobj;
	public LinkedListObjects linkedlistobj;
	public CommonMethodsObject commonobj;

	public PageObjectManager(WebDriver driver) {
		super();
		this.driver = driver;
	}
	
	public HomePageObjects getHomePageObjects() {
		homepageobj = new HomePageObjects(driver);
		return homepageobj;
		
	}
	public PortalPageObjects getPortalPageObjects() {
		portalobj = new PortalPageObjects(driver);
		return portalobj;
		
	}
	public LinkedListObjects getLinkedListObjects() {
		linkedlistobj = new LinkedListObjects(driver);
		return linkedlistobj;
		
	}
	public CommonMethodsObject getCommonMethodsObject() {
		commonobj = new CommonMethodsObject(driver);
		return commonobj;
		
	}

}
