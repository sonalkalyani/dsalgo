package com.dsportalapp.dsalgo.stepDefinition;

import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.dsportalapp.dsalgo.POM.LinkedListObjects;
import com.dsportalapp.dsalgo.POM.PortalPageObjects;
import com.dsportalapp.dsalgo.utilities.TestSetup;

public class LinkedListHomePageStepDefinition {
	WebDriver driver;
	TestSetup testsetup;
	LinkedListObjects linkedlistobj;
	PortalPageObjects portalintroductionpageobj;
	public static Logger LOG = LoggerFactory.getLogger(PortalPageStepDefinition.class);
	
	
	public LinkedListHomePageStepDefinition(TestSetup testsetup) {
		super();
		this.testsetup = testsetup;
		linkedlistobj = testsetup.pageobjectmanager.getLinkedListObjects();
	}
	
}
