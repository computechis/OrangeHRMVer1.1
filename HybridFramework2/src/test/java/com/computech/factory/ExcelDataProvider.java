package com.computech.factory;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelDataProvider {
	XSSFWorkbook wb;
	public static final String COURSE="Selenium";
	
	public ExcelDataProvider() {
		try {
			wb = new XSSFWorkbook(new FileInputStream(new File(System.getProperty("user.dir")+"\\src\\test\\resources\\com\\computech\\TestData\\ProjectData.xlsx")));
		} catch (FileNotFoundException e) {
			System.out.println("Exception message is : " +e.getMessage());
		} catch (IOException e) {
			System.out.println("Exception message is : " +e.getMessage());
		}
	}
	public ExcelDataProvider(String excelFilePath) {
		try {
			wb = new XSSFWorkbook(new FileInputStream(new File(excelFilePath)));
		} catch (FileNotFoundException e) {
			System.out.println("Exception message is : " +e.getMessage());
		} catch (IOException e) {
			System.out.println("Exception message is : " +e.getMessage());
		}
	}

	public String getStringData(String sheetName, int rowNo, int colNo) {
		return wb.getSheet(sheetName).getRow(rowNo).getCell(colNo).getStringCellValue();
	}
	public String getStringData(int sheetIndex, int rowNo, int colNo) {
		return wb.getSheetAt(sheetIndex).getRow(rowNo).getCell(colNo).getStringCellValue();
	}
	
	public double getDoubleData(String sheetName, int rowNo, int colNo) {
		return wb.getSheet(sheetName).getRow(rowNo).getCell(colNo).getNumericCellValue();
	}
	public int getNumericData(String sheetName, int rowNo, int colNo) {
		return (int)wb.getSheet(sheetName).getRow(rowNo).getCell(colNo).getNumericCellValue();
	}
	public boolean getbooleanData(String sheetName, int rowNo, int colNo) {
		return wb.getSheet(sheetName).getRow(rowNo).getCell(colNo).getBooleanCellValue();
	}
	
	public int getRowCount(String sheetName) {
		return wb.getSheet(sheetName).getPhysicalNumberOfRows();
		/*int rowCount = wb.getSheet(sheetName).getPhysicalNumberOfRows();
		return rowCount;*/
	}
	public int getColumnCount(String sheetName) {
		return wb.getSheet(sheetName).getRow(0).getPhysicalNumberOfCells();
	}
	public int getColumnCount(String sheetName, int rowNo) {
		return wb.getSheet(sheetName).getRow(rowNo).getPhysicalNumberOfCells();
	}
	public static void m1() {
		
	}
	
}
