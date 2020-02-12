package com.computech.testcases;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.computech.factory.BrowserFactory;
//import com.computech.factory.ConfigDataProvider;
import com.computech.factory.DataProviderFactory;
import com.computech.utilities.Helper;

public class BaseClass {
	
	WebDriver driver;
	public static ExtentReports report;
	public ExtentTest logger;
	@BeforeSuite
	public void setupReport() {
		System.out.println("Log:INFO - Report is getting setup");
		                                                          //E:\WorkSpaceUKSS\HybridFramework\src\test\resources\com\computech\Reports
		ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir")+"\\src\\test\\resources\\com\\computech\\Reports\\ExtentReport.html");
		report = new ExtentReports();
		report.attachReporter(htmlReporter);
		System.out.println("Log:INFO - Report value " + report);
		System.out.println("Log:INFO - Report setup is ready");
		
	}
	@BeforeClass
	public void setUp() {
//		ConfigDataProvider config = new ConfigDataProvider();
//		driver = BrowserFactory.getApplication(config.getBrowser(), config.getStagingURL());
		driver = BrowserFactory.getApplication(DataProviderFactory.getConfig().getBrowser(), DataProviderFactory.getConfig().getStagingURL());
	}
	@AfterMethod
	public void tearDownReport(ITestResult result) {
		if(result.getStatus() == ITestResult.SUCCESS) 
		{
			System.out.println("Log:INFO - Test Executed - Test status is passed..");
		}
		else if(result.getStatus() == ITestResult.FAILURE) {
			System.out.println("Log:INFO - Test Executed - Test status is failed..");
		}
		else if(result.getStatus() == ITestResult.SKIP) {
			System.out.println("Log:INFO - Test Executed - Test status is skipped..");
		}
		if(result.getStatus() == ITestResult.SUCCESS) 
		{
			try {
				logger.pass("Test Passed.." + MediaEntityBuilder.createScreenCaptureFromPath(Helper.captureScreenshot(driver)).build());
			} catch (IOException e) {
				System.out.println("Unable to  attach screenshot in the report : " + e.getMessage());
			}
		}else if(result.getStatus() == ITestResult.FAILURE) 
		{
			try {
				logger.fail("Test failed.."+result.getThrowable().getMessage(), 
						MediaEntityBuilder.createScreenCaptureFromPath(Helper.captureScreenshot(driver)).build());
			} catch (IOException e) {
				System.out.println("Unable to  attach screenshot in the report : " + e.getMessage());
			}
		}
		report.flush();
	}
	@AfterClass
	public void tearDown() {
		BrowserFactory.closeApplciation(driver);
	}

}
