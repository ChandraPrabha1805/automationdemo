package com.actitime.generic;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

public abstract class BaseTest implements AutoConstant
{
   public WebDriver driver;
   static
   {
	   System.setProperty(Chrome_key, Chrome_value);
	   System.setProperty(gecko_key, gecko_value);
	   
   }
   
   @BeforeMethod
   public void preCondition() throws MalformedURLException
   
   { 
	   driver=new ChromeDriver();
	   driver.manage().window().maximize();
	   driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	   driver.manage().deleteAllCookies();
	   driver.get("https://demo.actitime.com/login.do");
   }
   @AfterMethod
   public void postCondition(ITestResult res)
   {
	  int status=res.getStatus();
	  if(status==2)
	  {
		  String name = res.getName();
		  GenericUtils.getScreenShot(driver,name);
		 
	  }
	  driver.close();
   }
}
