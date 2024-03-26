package com.dsportal.dsalgo.stepDefinition;

import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import com.dsportal.dsalgo.fileReader.ConfigFileReader;

import jdk.internal.org.jline.utils.Log;


public class Logintest extends ConfigFileReader{
	
	static WebDriver driver;
	
	public void login() {

	//static ConfigFileReader configFileReader;

	String url = "https://dsportalapp.herokuapp.com/login";
	driver = new ChromeDriver();
	//configFileReader = new ConfigFileReader();
	driver.get(url);
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

	driver.findElement(By.name("username")).sendKeys(properties.getProperty("username"));
	driver.findElement(By.name("password")).sendKeys(properties.getProperty("password"));
	driver.findElement(By.xpath("//input[@value = 'Login']")).click();
	//Thread.sleep(2000);
	String msg = "You are logged in";
	WebElement loginmsg = driver.findElement(By.xpath("//div[@class = 'alert alert-primary']"));
   System.out.println(loginmsg.getText());
	Assert.assertEquals(loginmsg.getText(), msg);
	
	WebElement usrname = driver.findElement(By.xpath("//a[text() = ' Ninja153 ']"));
	System.out.println(usrname.getText());
	Assert.assertEquals(properties.getProperty("username"),usrname.getText());
	
	}
	
	public static void main(String[] args) {
		
		Logintest obj = new Logintest();
		obj.FileReader();
		obj.login();
		
	}

}
