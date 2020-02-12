package com.computech.unittests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.computech.factory.ConfigDataProvider;

public class TestConfigDataProviderFactory {
	
	@Test
	public void testConfigLib() {
		ConfigDataProvider config = new ConfigDataProvider();
		String data = config.getValue("testConfig");
		Assert.assertEquals(data, "ConfigurationFile");
	}

}
