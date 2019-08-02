package com.actitime.tests;

import org.testng.Reporter;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.actitime.generic.BaseTest;
import com.actitime.generic.ExcelData;
import com.actitime.pages.EnterTimeTrackPage;
import com.actitime.pages.LoginPage;

public class VerifyBuildNumTest extends BaseTest
{
	@Test(priority=4)
	public void testVerifyBuildNum() throws InterruptedException
	{
		String username=ExcelData.getData(file_path, "TC01", 1, 0);
		String password=ExcelData.getData(file_path, "TC01", 1, 1);
		String loginTitle=ExcelData.getData(file_path, "TC01", 1, 2);
		String enterTimeTrackTitle=ExcelData.getData(file_path, "TC01", 1, 3);
		String expectedBuildNumber = ExcelData.getData(file_path, "TC04", 1, 0);
		
		
		LoginPage lp=new LoginPage(driver);
		EnterTimeTrackPage ep=new EnterTimeTrackPage(driver);
		//Verify login page
		lp.verifyPage(loginTitle);
		
		//Enter valid username
		Reporter.log("Valid usernamme:"+ username,true);
		lp.enterUserName(username);
		
		//Enter valid password
		Reporter.log("Valid password:"+ password,true);
		lp.enterPassword(password);
		
		//click on login
		lp.clickOnLogin();
		
		//verify page
		lp.verifyPage(enterTimeTrackTitle);
		
		//click on  help link
		ep.clickOnHelpLink();
		
		//click on about your actitime
		ep.clickOnabtYourActitime();
		
		//verify build num
		String ActualBuild = ep.verifyBuildNum();
		Reporter.log("Actual Build Num:"+ActualBuild,true);
		Reporter.log("Expected Build Num:"+expectedBuildNumber,true);
		
		//Comparing  Build num
		SoftAssert sa=new SoftAssert();
		sa.assertEquals(ActualBuild, expectedBuildNumber, "Build num is not matching");
		sa.assertAll();
		Reporter.log("Build Num is matching:",true);
		
		Thread.sleep(1000);
		
		//click on close
		ep.clickOnClose();
		
		Thread.sleep(1000);
		
		//click on logout
		ep.clickOnlogout();
	
	}
}
