package com.dsportalapp.dsalgo.fileReader;

import java.io.File;

import java.io.FileInputStream;

import java.io.FileNotFoundException;

import java.io.IOException;
import java.net.URL;
import java.util.Properties;

import javax.enterprise.inject.New;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.dsportalapp.dsalgo.stepDefinition.LoginPageStepDefinition;

import io.cucumber.java.be.I.Is;


public class  ConfigFileReader {


protected Properties properties;
public static Logger LOG = LoggerFactory.getLogger(ConfigFileReader.class);

private final String configFilePath= System.getProperty("user.dir")+"/src/test/resources/config/global.properties";


public void FileReader() {


File  ConfigFile=new File(configFilePath);


try {

FileInputStream configFileReader=new FileInputStream(ConfigFile);

      properties = new Properties();


try {
	properties.load(configFileReader);
      

      configFileReader.close();

    } catch (IOException e) 

      {

        LOG.info(e.getMessage());

      }

  }  catch (FileNotFoundException e) 

      {

	  LOG.info(e.getMessage());

throw new RuntimeException("global.properties not found at config file path " + configFilePath);

      }

  }


public String getApplicationUrl() {

String applicationurl= properties.getProperty("Url");

LOG.info("URL is " + applicationurl);

if(applicationurl != null)

return applicationurl;

else

throw new RuntimeException("Application url not specified in the config.properties file.");

}


public String getUserName(){

String username= properties.getProperty("username");
LOG.info("username is " +username);

if(username != null)

return username;

else

throw new RuntimeException("username not specified in the config.properties file.");

}


public String getPassword(){

String password= properties.getProperty("password");
LOG.info("password is " +password);

if(password != null)

return password;

else

throw new RuntimeException("password not specified in the config.properties file.");

}


public String getBrowser() {

String browser= properties.getProperty("browser");
LOG.info("browser is " +browser);


if(browser != null)

return browser;

else

throw new RuntimeException("browser not specified in the config.properties file.");

}
public static void main(String[] args) {
	ConfigFileReader obj =  new ConfigFileReader();
	obj.FileReader();
	obj.getApplicationUrl();
	obj.getBrowser();
	obj.getUserName();
	obj.getPassword();
}
}

/*
public  long getTimeout() {

String timeout= properties.getProperty(“timeout”);


if(timeout != null)

return Long.parseLong(timeout);

else

throw new RuntimeException(“Timeout not specified in the config.properties file.”);

}


public String getEnvironment() {

String environment= properties.getProperty(“environment”);


if(environment != null)

return environment;

else

throw new  (“Environment not specified in the config.properties file.”);

}
*/