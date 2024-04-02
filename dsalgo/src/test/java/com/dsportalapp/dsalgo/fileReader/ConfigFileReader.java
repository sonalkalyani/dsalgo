package com.dsportalapp.dsalgo.fileReader;

import java.io.File;

import java.io.FileInputStream;

import java.io.FileNotFoundException;

import java.io.IOException;
import java.net.URL;
import java.util.Properties;

import javax.enterprise.inject.New;

import io.cucumber.java.be.I.Is;


public class  ConfigFileReader {


protected Properties properties;

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

        System.out.println(e.getMessage());

      }

  }  catch (FileNotFoundException e) 

      {

        System.out.println(e.getMessage());

throw new RuntimeException("global.properties not found at config file path " + configFilePath);

      }

  }


public String getApplicationUrl() {

String applicationurl= properties.getProperty("url");

System.out.println("URL is " + applicationurl);

if(applicationurl != null)

return applicationurl;

else

throw new RuntimeException("Application url not specified in the config.properties file.");

}


public String getUserName(){

String username= properties.getProperty("username");
System.out.println("username is " +username);

if(username != null)

return username;

else

throw new RuntimeException("username not specified in the config.properties file.");

}


public String getPassword(){

String password= properties.getProperty("password");
System.out.println("password is " +password);

if(password != null)

return password;

else

throw new RuntimeException("password not specified in the config.properties file.");

}


public String getBrowser() {

String browser= properties.getProperty("browser");
System.out.println("browser is " +browser);


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