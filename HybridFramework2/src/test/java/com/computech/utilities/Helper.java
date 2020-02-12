package com.computech.utilities;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class Helper {

	public static String captureScreenshot(WebDriver driver) {
		String path = System.getProperty("user.dir") + "\\src\\test\\resources\\com\\computech\\Screenshots\\Screnshot_"
				+ getCurrentTime() + ".png";
		TakesScreenshot ts = (TakesScreenshot) driver;
		File srcFile = ts.getScreenshotAs(OutputType.FILE);
		try {
			FileHandler.copy(srcFile, new File(path));
		} catch (IOException e) {
			System.out.println("Failed to capture screenshot ");
		}
		return path;
	}

	public static String getCurrentTime() {

		DateFormat dateFormatter = new SimpleDateFormat("yyyy_MM_dd_HH_mm_ss");
		Date date = new Date();
		return dateFormatter.format(date);
	}

	public static void acceptAlert(WebDriver driver) {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.alertIsPresent()).accept();
	}

	public static void dismissAlert(WebDriver driver) {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.alertIsPresent()).dismiss();
	}

	public static void verifyAlertText(WebDriver driver, String alertTextExpected) {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		String alertTextActual = wait.until(ExpectedConditions.alertIsPresent()).getText();
		Assert.assertEquals(alertTextActual, alertTextExpected);
	}

	public static void verifyAlertPartially(WebDriver driver, String alertPartialTextExpected) {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		String alertTextActual = wait.until(ExpectedConditions.alertIsPresent()).getText();
		Assert.assertTrue(alertTextActual.contains(alertPartialTextExpected));
	}

	public static void verifyText(WebDriver driver, By byLocator, String expectedText) {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		boolean status = wait.until(ExpectedConditions.textToBe(byLocator, expectedText));
		Assert.assertTrue(status);
		// Assert.assertTrue(wait.until(ExpectedConditions.textToBe(byLocator,
		// expectedText)));
	}

	public static void verifyPartialText(WebDriver driver, By byLocator, String expectedText) {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		boolean status = wait.until(ExpectedConditions.textToBePresentInElementLocated(byLocator, expectedText));
		Assert.assertTrue(status);
	}

	// This method will handle sync issue- It will wait for webelement and then highlight the same
	public static WebElement waitForWebElement(WebDriver driver, By byLocator) {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		WebElement element = wait.until(ExpectedConditions.elementToBeClickable(byLocator));
		highLightElement(driver, element);
		return element;
	}

	public static WebElement waitForWebElement(WebDriver driver, By byLocator, int time) {
		WebDriverWait wait = new WebDriverWait(driver, time);
		WebElement element = wait.until(ExpectedConditions.elementToBeClickable(byLocator));
		return element;
	}

	public static void verifyTitle(WebDriver driver, String title) {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		Assert.assertTrue(wait.until(ExpectedConditions.titleIs(title)));
	}

	public static void verifyTitleContains(WebDriver driver, String title) {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		Assert.assertTrue(wait.until(ExpectedConditions.titleContains(title)));
	}

	public static void verifyURL(WebDriver driver, String url) {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		Assert.assertTrue(wait.until(ExpectedConditions.urlToBe(url)));
	}

	public static void verifyURLContains(WebDriver driver, String url) {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		Assert.assertTrue(wait.until(ExpectedConditions.urlContains(url)));
	}

	public static void waitTo(int seconds) {
		try {
			Thread.sleep(1000 * seconds);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public static void handleFramesUsingIdOrName(WebDriver driver, String frameNameOrId) {
		new WebDriverWait(driver, 10).until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(frameNameOrId));
	}

	public static void handleFramesUsingIndex(WebDriver driver, int index) {
		new WebDriverWait(driver, 10).until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(index));
	}

	public static void handleFramesUsingElement(WebDriver driver, WebElement frameElement) {
		new WebDriverWait(driver, 10).until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(frameElement));
	}

	public static void highLightElement(WebDriver driver, WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;

		js.executeScript("arguments[0].setAttribute('style', 'background: yellow; border: 2px solid red;');", element);

		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {

			System.out.println(e.getMessage());
		}

		js.executeScript("arguments[0].setAttribute('style','border: solid 2px white');", element);

	}

	

	public static void switchToWindow() {

	}

}
