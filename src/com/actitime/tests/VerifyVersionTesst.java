package com.actitime.tests;

import org.openqa.selenium.WebElement;
import org.testng.Reporter;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.actitime.generic.BaseTest;
import com.actitime.generic.ExcelData;
import com.actitime.pages.LoginPage;

public class VerifyVersionTesst extends BaseTest
{
	@Test(priority=3)
	private void testVerifyVersion()
	{
		String loginTitle=ExcelData.getData(file_path, "TC01", 1, 2);
		String expectedVersion = ExcelData.getData(file_path, "TC03", 1, 0);
		
		LoginPage lp=new LoginPage(driver);
		
		lp.verifyPage(loginTitle);
		
		String actualVersion = lp.verifyVersion();
		Reporter.log("Actual Version:"+ actualVersion,true);
		Reporter.log("Expected Version:"+expectedVersion,true);
		
		SoftAssert sa=new SoftAssert();
		sa.assertEquals(actualVersion, expectedVersion, "version is not matching");
		sa.assertAll();
		Reporter.log("Version is matching:",true);
		
	}

}
