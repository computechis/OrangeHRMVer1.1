package com.computech.factory;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigDataProvider {
	
	Properties pro;
	
	public ConfigDataProvider() {
		try {
			pro = new Properties();
			FileInputStream fis = new FileInputStream(new File(System.getProperty("user.dir")+"\\src\\test\\resources\\com\\computech\\Config\\ProjectConfig.properties"));
			pro.load(fis);
		} catch (FileNotFoundException e) {
			System.out.println("Exception message is : " +e.getMessage());
		} catch (IOException e) {
			System.out.println("Exception message is : " +e.getMessage());
		}
	}
	
	public String getValue(String key) {
		return pro.getProperty(key);
	}
	public String getStagingURL() {
		return pro.getProperty("stagingURL");
	}
	public String getBrowser() {
		return pro.getProperty("browser");
	}
}
