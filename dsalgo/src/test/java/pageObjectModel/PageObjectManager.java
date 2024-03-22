package pageObjectModel;

import org.openqa.selenium.WebDriver;

public class PageObjectManager {
	public WebDriver driver;
	public HomePageObjects homepageobj;

	public PageObjectManager(WebDriver driver) {
		super();
		this.driver = driver;
	}
	
	public HomePageObjects getHomePageObjects() {
		homepageobj = new HomePageObjects();
		return homepageobj;
		
	}
	

}
