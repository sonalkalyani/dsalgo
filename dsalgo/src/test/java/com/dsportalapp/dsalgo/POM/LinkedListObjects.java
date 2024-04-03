package com.dsportalapp.dsalgo.POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;


public class LinkedListObjects {
	WebDriver driver;
	
	public LinkedListObjects(WebDriver driver) {
		
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	
	
	

	
	
	
	
	
	
	
	
	
	
/*	public void bokenLinks() throws MalformedURLException, IOException, URISyntaxException {
		SoftAssert a = new SoftAssert();
		for(WebElement link :dataStructuresLeftPanellinks) 
		{
			String linkedListPageUrl = link.getAttribute("href");
//			URL url = new URL(linkedListPageUrl);
//			HttpURLConnection con = (HttpURLConnection) url.openConnection();
			HttpURLConnection con = (HttpURLConnection) new URI(linkedListPageUrl).toURL().openConnection();
			con.setRequestMethod("HEAD");
			con.connect();
			int responseCode = con.getResponseCode();
			a.assertTrue(responseCode < 400, "The link "+ link + " is broken with the response code " + responseCode);
		}
		a.assertAll();
	} */
}
