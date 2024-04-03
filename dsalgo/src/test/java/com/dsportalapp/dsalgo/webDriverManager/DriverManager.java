
package com.dsportalapp.dsalgo.webDriverManager;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverManager {

	public WebDriver driver;
	
	public WebDriver getDriverManager() throws IOException {
		if (driver == null) {
            FileInputStream fis = new FileInputStream(System.getProperty("user.dir") + "//src//test//resources//config//global.properties");
            Properties property = new Properties();
            property.load(fis);
            String browserType = property.getProperty("browser");
            String url = property.getProperty("Url");

            switch (browserType.toLowerCase()) {
                case "chrome":
                    WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver();
                    break;
                case "edge":
                    WebDriverManager.edgedriver().setup();
                    driver = new EdgeDriver();
                    break;
                default:
                    throw new IllegalArgumentException("Unsupported browser: " + browserType);
            }

            driver.manage().deleteAllCookies();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(7));
            driver.manage().window().maximize();
            driver.get(url);
        }
        return driver;
    }
		


}
