package com.computech.testcases;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.computech.factory.DataProviderFactory;
import com.computech.pages.LoginPage;
import com.computech.pages.LogoutPage;

public class OrangeHRMTest1 extends BaseClass{
	LoginPage lp;
	LogoutPage lout;
  @Test(priority=1)
  public void verifyPage() {
	  lp=PageFactory.initElements(driver, LoginPage.class);
	 
	  logger =report.createTest("URL Validation");
	  lp.verifyURLBeforeLogin();
	  logger.info("Validating URL");
  }
  @Test(priority=2)
  public void login() {
	  logger = report.createTest("Login as admin");
	  lp.loginToApplication(DataProviderFactory.getExcel().getStringData("LoginTest", 0, 0), 
			  		DataProviderFactory.getExcel().getStringData("LoginTest", 0, 1));
	  lp.verifyUrlAfterLogin();
	  logger.info("Logged in");
	  
  }
  @Test(priority=3)
  public void logout() {
	  lout=PageFactory.initElements(driver, LogoutPage.class);
	  logger =report.createTest("Logout Test");
	  lout.logoutFromApplication();
	  logger.info("Logout done");
  }
}
