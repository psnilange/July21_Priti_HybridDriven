package com.technocredits.orghrm.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelSheetOperations {
	
	
	 static final public Object[][] getTableData(String filePath, String sheetName) throws IOException{
		
		 File file = new File(filePath);//"./testdata/LogInData.xlsx"
			FileInputStream input = new FileInputStream(file);
			Workbook wb = new XSSFWorkbook(input);
			Sheet sheet =wb.getSheet(sheetName);//"data"
			int totalRows = sheet.getLastRowNum();//4
			int totalcols= sheet.getRow(0).getLastCellNum();//2
			 Object[][] data = new Object[totalRows][totalcols];
			for (int rowIndex=1;rowIndex<=totalRows;rowIndex++) {
				for (int colIndex=0;colIndex<totalcols; colIndex++) {
					Cell cell= sheet.getRow(rowIndex).getCell(colIndex);
					if (CellType.NUMERIC== cell.getCellType())
					data[rowIndex-1][colIndex] = String.valueOf(cell.getNumericCellValue());
					else if(CellType.STRING== cell.getCellType())
						data[rowIndex-1][colIndex] = String.valueOf(cell.getStringCellValue());
					else if (CellType.BOOLEAN == cell.getCellType())
						data[rowIndex-1][colIndex] = String.valueOf(cell.getBooleanCellValue());
				}
			}
		 	return data;
	}
}