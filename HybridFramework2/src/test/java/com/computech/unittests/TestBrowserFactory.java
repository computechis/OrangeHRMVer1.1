package com.computech.unittests;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.computech.factory.BrowserFactory;
import com.computech.factory.ConfigDataProvider;

public class TestBrowserFactory {
	WebDriver driver;
	@Test
	public void testBrowser() {
		ConfigDataProvider config = new ConfigDataProvider();
		driver = BrowserFactory.getApplication(config.getBrowser(), config.getStagingURL());
		BrowserFactory.closeApplciation(driver);
	}

}
