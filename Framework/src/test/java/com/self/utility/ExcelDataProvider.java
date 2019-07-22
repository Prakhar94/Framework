package com.self.utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelDataProvider {
	
	XSSFWorkbook wb;
	
	public ExcelDataProvider() {
		
		File file = new File("");
		try {
			FileInputStream src = new FileInputStream(file);
			
			wb = new XSSFWorkbook(src);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("Unable to laod excel file: " +e.getMessage());
			e.printStackTrace();
		} 
	}
	
	
	//get string value from file using sheet index
	public String readStringData(int sheetindex, int row, int cell) {
		return wb.getSheetAt(sheetindex).getRow(row).getCell(cell).getStringCellValue();
	}
	
	
	//get string value from file using sheet name
	public String readStringData(String sheetname, int row, int cell) {
		return wb.getSheet(sheetname).getRow(row).getCell(cell).getStringCellValue();
	}
	
	public double readIntData(String sheetname, int row, int cell) {
		return wb.getSheet(sheetname).getRow(row).getCell(cell).getNumericCellValue();
	}

}
