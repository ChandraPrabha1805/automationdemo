package com.actitime.generic;

import java.io.File;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class GenericUtils
{
  public static void getScreenShot( WebDriver driver,String name)
  {
	  try
	  {
		  TakesScreenshot t= (TakesScreenshot)driver;
		  File src = t.getScreenshotAs(OutputType.FILE);
		  File dest = new File("./ScreenShot/"+"name"+".png");
		  FileUtils.copyFile(src,dest);
	  }
	  catch (Exception e) 
	  {
		
	  }
  }
		 public static void selectByIndex(WebElement element,int index) 
		 {
			 Select sel=new Select(element);
			 sel.selectByIndex(index);
		 }
		 
		 public static void selectAll(WebElement element)
		 {
			 Select sel=new Select(element);
			 List<WebElement> allOption = sel.getOptions();
			 for(WebElement option:allOption)
			 {
				 String text = option.getText();
				 selectByVisibleText(element, text);
			 }
		 }
		public static void selectByVisibleText(WebElement element, String text)
		{
	
			 Select sel=new Select(element);
			 sel.selectByVisibleText(text);
		}
	  public static void deselectAll(WebElement element)
	  {
		  Select sel=new Select(element);
		  sel.deselectAll();
	  }
	  
	  public static void closeChildBrowser(WebDriver driver)
	  {
		  String parentWh = driver.getWindowHandle();
		  Set<String> allWh = driver.getWindowHandles();
		  allWh.remove(parentWh);
		  for(String wh:allWh)
		  {
			  driver.switchTo().window(wh);
			  driver.close();
		  }
	  }
	  
	  public static void dropAndDrag(WebDriver driver, WebElement source, WebElement target)
	  {
		  Actions act=new Actions(driver);
		  act.dragAndDrop(source, target).perform();
		  
	  }
	  
  }

