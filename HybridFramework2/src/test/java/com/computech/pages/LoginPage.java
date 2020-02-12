package com.computech.pages;

import org.openqa.selenium.By;
//import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.computech.utilities.Helper;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.support.CacheLookup;
//import org.openqa.selenium.support.FindBy;
//import org.openqa.selenium.support.How;

public class LoginPage {
	WebDriver driver;

	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}

	/*
	 * @FindBy(id="txtUsername") WebElement txtboxUserName;
	 * 
	 * @FindBy(how=How.NAME, using="txtPassword") WebElement txtboxPassword;
	 * 
	 * @FindBy(how=How.XPATH, using="//input[@id='btnLogin']")
	 * 
	 * @CacheLookup 
	 * WebElement btnLogin;
	 */
	By user = By.id("txtUsername");
	By password = By.name("txtPassword");
	By loginBtn = By.xpath("//input[@value='LOGIN']");

	/*public void typeUserName() {
		driver.findElement(user).sendKeys("Admin");
	}
	public void typePassword() {
		driver.findElement(password).sendKeys("admin123");
	}
	public void clickOnLoginButton() {
		driver.findElement(loginBtn).click();
	}
	public void loginToApplication() {
		driver.findElement(user).sendKeys("Admin");
		driver.findElement(password).sendKeys("admin123");
		driver.findElement(loginBtn).click();
	}
	public void loginToApplication(String userName, String passwd) {
		driver.findElement(user).sendKeys(userName);
		driver.findElement(password).sendKeys(passwd);
		driver.findElement(loginBtn).click();
	}
	*/
	public void typeUserName() {
		Helper.waitForWebElement(driver, user).sendKeys("Admin");
	}


	public void typePassword() {
		Helper.waitForWebElement(driver, password).sendKeys("admin123");
	}
	public void clickOnLoginButton() {
		Helper.waitForWebElement(driver, loginBtn).click();
	}
	public void verifyURLBeforeLogin() {
		Helper.verifyURLContains(driver, "demo");
	}
	public void verifyUrlAfterLogin() {
		Assert.assertTrue(driver.getCurrentUrl().contains("dashboard"), "Dashboard does not contain dashboard keyword");
	}
	public void loginToApplication() {
		Helper.waitForWebElement(driver, user).sendKeys("Admin");
		Helper.waitForWebElement(driver, password).sendKeys("admin123");
		Helper.waitForWebElement(driver, loginBtn).click();
	}
	public void loginToApplication(String userName, String passwd) {
		Helper.waitForWebElement(driver, user).sendKeys("Admin");
		Helper.waitForWebElement(driver, password).sendKeys("admin123");
		Helper.waitForWebElement(driver, loginBtn).click();
	}
	public void verifyFBIcon() {
		System.out.println(driver.findElement(By.xpath("//div[@id='social-icons']/a[2]")).isDisplayed());
	}
}
