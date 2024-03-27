
  package com.dsportalapp.dsalgo.stepDefinition;
  
  import java.time.Duration;
  
  import org.openqa.selenium.WebDriver; import
  org.openqa.selenium.chrome.ChromeDriver; import org.slf4j.Logger; import
  org.slf4j.LoggerFactory;
  
  import com.dsportalapp.dsalgo.utilities.TestSetup;
  
  import io.cucumber.java.en.Given; import io.cucumber.java.en.Then;
  
  
  
  public class HomePageStepDefinition {
	  WebDriver driver; TestSetup testsetup;
  
  public static Logger LOG =
  LoggerFactory.getLogger(HomePageStepDefinition.class);
  
  public HomePageStepDefinition(TestSetup testsetup) { super(); this.testsetup
  = testsetup; }
  
  @Given("I am on the home page") 
  public void i_am_on_the_home_page() { //
  driver = new ChromeDriver(); // testsetup.driver.manage().deleteAllCookies();
  //
  testsetup.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(7));
  // testsetup.driver.manage().window().maximize(); //
  driver.get("https://dsportalapp.herokuapp.com/");
  LOG.info("homepage successful"); }
  
  @Then("I should see the title {string}") public void
  i_should_see_the_title(String string) {
  
  } }
 