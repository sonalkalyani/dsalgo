package com.dsportalapp.dsalgo.POM;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.asserts.SoftAssert;

public class LinkedListObjects {
	WebDriver driver;
	
	public LinkedListObjects(WebDriver driver) {
		
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//li[@class='list-group-item list-group-item-light ']/a")
	private List<WebElement> linkedListLeftPanellinks;
	
	@FindBy(xpath="//a[@class='list-group-item']")
	private List<WebElement> linkedListHomeLinks;
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public void bokenLinks() throws MalformedURLException, IOException, URISyntaxException {
		SoftAssert a = new SoftAssert();
		for(WebElement link :linkedListLeftPanellinks) 
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
	}
}
