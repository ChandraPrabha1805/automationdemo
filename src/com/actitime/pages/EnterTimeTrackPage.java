package com.actitime.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.actitime.generic.BasePage;

public class EnterTimeTrackPage  extends BasePage
{
	//Declaration
	
//	@FindBy(xpath="//div[@id='container_tasks']")
//	private WebElement task;
	
	@FindBy(xpath="//div[@style='padding:10px 0 0 28px']/../../..//div[3]")
	private WebElement helpLink;
	@FindBy(xpath="//a[.='About your actiTIME']")
	private WebElement abtYourActiTime;
	@FindBy(xpath="//span[.='(build 997_55)']")
	private WebElement buildNum;
	@FindBy(xpath="//div[@id='aboutPopupCloseButtonId']")
	private WebElement closeBtn;
	@FindBy(id="logoutLink")
	private WebElement logoutLink;
	
  //Initialization
	public EnterTimeTrackPage(WebDriver driver) 
	{
		super(driver);
		PageFactory.initElements(driver, this);
	}
	//Utilization
	
	public void clickOnHelpLink()
	{
		helpLink.click();
	}
	public void clickOnabtYourActitime()
	{
		abtYourActiTime.click();
	}
	
	public String verifyBuildNum()
	{
		verifyElement(buildNum);
		String aBuildNum=buildNum.getText();
		return aBuildNum;
	}
	
	public void clickOnClose()
	{
		closeBtn.click();
	}
	
	public void clickOnlogout()
	{
		logoutLink.click();
	}

}
