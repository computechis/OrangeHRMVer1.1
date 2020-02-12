package com.computech.testcases;

//import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
//import org.testng.annotations.AfterClass;
//import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.computech.factory.ExcelDataProvider;

//import com.computech.factory.BrowserFactory;
//import com.computech.factory.ConfigDataProvider;

import com.computech.pages.LoginPage;

public class LoginScenarios extends BaseClass{
	LoginPage lp;
	
/*
	@Test
	public void login() {
		lp=PageFactory.initElements(driver, LoginPage.class);
		lp.typeUserName();
		lp.typePassword();
		lp.clickOnLoginButton();
	}
*/
	@Test
	public void login() {
		ExcelDataProvider excel = new ExcelDataProvider();
	lp=PageFactory.initElements(driver, LoginPage.class);
	//lp.loginToApplication();
	lp.loginToApplication(excel.getStringData("LoginTest", 0, 0), 
						  excel.getStringData("LoginTest", 0, 1));
}
	
}
