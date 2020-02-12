package com.computech.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.computech.utilities.Helper;

public class LogoutPage {
	WebDriver driver;
	public LogoutPage(WebDriver driver) {
		this.driver=driver;
	}
	
	By adminText = By.xpath("//a[text()='Welcome Admin']");
	By logoutText = By.xpath("//a[text()='Logout']");
	
	public void logoutFromApplication() {
//		driver.findElement(adminText).click();
		Helper.waitForWebElement(driver, adminText).click();
		Helper.waitTo(3);
		Helper.waitForWebElement(driver, logoutText).click();
	}
}
