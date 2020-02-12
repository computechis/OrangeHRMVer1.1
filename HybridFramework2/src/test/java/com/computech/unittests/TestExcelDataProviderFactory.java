package com.computech.unittests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.computech.factory.ExcelDataProvider;

public class TestExcelDataProviderFactory {
	
	@Test
	public void testExcelLib() {
		ExcelDataProvider excel = new ExcelDataProvider();
		String expData = "testingExcel";
		String actdata = excel.getStringData("Testing", 0, 0);
		Assert.assertEquals(actdata, expData, "Data is not matching");
//		Assert.assertEquals(actdata, expData);
	}

}
