
package com.dsportalapp.dsalgo.webDriverManager;

import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.dsportalapp.dsalgo.utilities.ConfigReader;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverManager {

	public WebDriver driver;
	
	
	public WebDriver getDriverManager() throws IOException {
		if (driver == null) {

			 String browserType = ConfigReader.getProperty("browser");
	            String url = ConfigReader.getProperty("Url");
		            if (browserType == null || url == null) {
		                throw new IllegalArgumentException("Browser type or URL not found in configuration");
		            }

               switch (browserType.toLowerCase()) {
                case "chrome":
                    WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver();
                    break;
                case "edge":
                    WebDriverManager.edgedriver().setup();
                    driver = new EdgeDriver();
                    break;
                case "firefox":
                    WebDriverManager.firefoxdriver().setup();
                    driver = new FirefoxDriver();
                    break;   
                default:
                    throw new IllegalArgumentException("Unsupported browser: " + browserType);
            }

            driver.manage().deleteAllCookies();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(7));
//            driver.manage().window().maximize();
            driver.get(url);
        }
        return driver;
    }
		


}
