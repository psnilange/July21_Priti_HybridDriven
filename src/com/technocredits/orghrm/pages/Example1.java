package com.technocredits.orghrm.pages;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.technocredits.orghrm.util.ExcelSheetOperations;

public class Example1 {

	@Test(dataProvider ="loginDataprovider")
	public void LogIn(String username, String password) {
		System.out.println(username);
		System.out.println(password);
	}
	
	@DataProvider(name ="loginDataprovider")
	public Object[][] getData() throws IOException{
	
		File file = new File("./testdata/LogInData.xlsx");
		FileInputStream input= new FileInputStream(file);
		
		Workbook myWorkBook = new XSSFWorkbook(input);
		
		Sheet sheet = myWorkBook.getSheet("LoginData");
		sheet.getRow(0).getCell(0).getStringCellValue();
		System.out.println(sheet.getRow(0).getCell(0).getStringCellValue());
		int totalRows=sheet.getLastRowNum();
		int totalcols=sheet.getRow(0).getLastCellNum();
		Object[][] empData = new Object[totalRows][totalcols];
			for(int rowIndex=1;rowIndex<=totalRows;rowIndex++) {
				for(int colIndex=0;colIndex<totalcols;colIndex++) {
					empData[rowIndex-1][colIndex]=sheet.getRow(rowIndex).getCell(colIndex).getStringCellValue();
				}
			}
			return empData;
		}
	
		
	
	
	
	
	/*
	data[0][0] = sheet.getRow(1).getCell(0).getStringCellValue();
	data[0][1] = sheet.getRow(1).getCell(1).getStringCellValue();
	
	data[1][0] = sheet.getRow(2).getCell(0).getStringCellValue();
	data[1][1] =sheet.getRow(2).getCell(1).getStringCellValue();
	
	data[2][0] = sheet.getRow(3).getCell(0).getStringCellValue();
	data[2][1] = sheet.getRow(3).getCell(1).getStringCellValue();
	
	data[3][0] =sheet.getRow(4).getCell(0).getStringCellValue();
	data[3][1] =sheet.getRow(4).getCell(1).getStringCellValue();*/
}
