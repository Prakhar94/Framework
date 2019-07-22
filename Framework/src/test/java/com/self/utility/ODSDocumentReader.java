package com.self.utility;

import java.io.File;
import java.io.IOException;

import org.jopendocument.dom.spreadsheet.MutableCell;
import org.jopendocument.dom.spreadsheet.Sheet;
import org.jopendocument.dom.spreadsheet.SpreadSheet;

public class ODSDocumentReader {
	SpreadSheet spreadsheet;
	
	public ODSDocumentReader() {
		try {
			File file = new File("./testdata/Data.ods");
			spreadsheet = SpreadSheet.createFromFile(file);
			
		} catch (Exception e) {
			System.out.println("ODS file type not found : " +e.getMessage());
		}
	}
	
	
	public String readStringFromODS(int sheetindex,int col, int row) {
		return (String) spreadsheet.getSheet(sheetindex).getCellAt(col,row).getValue();
	}
	
	
	public String readStringFromODS(String sheetname,int col, int row) {
		return (String) spreadsheet.getSheet(sheetname).getCellAt(col,row).getValue();
	}
	
	public int readIntFromODS(String sheetname, int col, int row) {
		return (Integer) spreadsheet.getSheet(sheetname).getCellAt(col,row).getValue();
	}
	
	public int readIntFromODS(int sheetindex, int col, int row) {
		return (Integer) spreadsheet.getSheet(sheetindex).getCellAt(col,row).getValue();
	}

}
