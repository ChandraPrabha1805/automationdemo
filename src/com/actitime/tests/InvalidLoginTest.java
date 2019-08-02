package com.actitime.tests;



import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.actitime.generic.BaseTest;
import com.actitime.generic.ExcelData;
import com.actitime.pages.LoginPage;

public class InvalidLoginTest extends BaseTest
{
   @Test(priority=2)
   public void testInvalidLogin() throws InterruptedException
   {
	   String loginTitle = ExcelData.getData(file_path, "TC01", 1, 2);
	   String expectedErroeMsg = ExcelData.getData(file_path, "TC02", 1, 2);
	   
	   LoginPage lp=new LoginPage(driver);
	   
	   lp.verifyPage(loginTitle);
	   
	   int rc = ExcelData.getRowCount(file_path, "TC02");
	   
	   for(int i=1;i<=rc;i++)
	   {
		  String username= ExcelData.getData(file_path, "TC02", i, 0);
		  String password= ExcelData.getData(file_path, "TC02", i, 1);
		  
		    Reporter.log("InValid usernamme:"+ username,true);
			lp.enterUserName(username);
			Reporter.log("InValid password:"+ password,true);
			lp.enterPassword(password);
			
			lp.clickOnLogin();
			String actualErrorMsg = lp.verifyErrorMsg();
			Reporter.log("Actual Erroe msg:"+ actualErrorMsg,true);
			Reporter.log("expexted erroe Msg:"+ expectedErroeMsg,true);
			
			Assert.assertEquals(actualErrorMsg, expectedErroeMsg, "error msg not matching");
			Reporter.log("Error msg matching:",true);
			Reporter.log("===================================",true);

			Thread.sleep(2000);
			
	   }
	   
   }
}
