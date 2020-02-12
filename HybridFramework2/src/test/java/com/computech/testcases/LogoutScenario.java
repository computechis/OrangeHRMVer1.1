package com.computech.testcases;

//import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
//import org.testng.annotations.AfterClass;
//import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.computech.factory.DataProviderFactory;
//import com.computech.factory.BrowserFactory;
//import com.computech.factory.ConfigDataProvider;
//import com.computech.factory.ExcelDataProvider;
import com.computech.pages.LoginPage;
import com.computech.pages.LogoutPage;

public class LogoutScenario extends BaseClass{
	
	LoginPage lp;
	LogoutPage lout;
	
	@Test
	public void logout() {
		lp=PageFactory.initElements(driver, LoginPage.class);
		//ExcelDataProvider excel = new ExcelDataProvider();
		lp.loginToApplication(DataProviderFactory.getExcel().getStringData("LoginTest", 0, 0),
							  DataProviderFactory.getExcel().getStringData("LoginTest", 0, 1));
		lout=PageFactory.initElements(driver, LogoutPage.class);
		lout.logoutFromApplication();
	}
	

}
