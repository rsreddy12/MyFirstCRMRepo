package com.crm.qa.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import com.crm.qa.base.TestBase;

public class TestUtil extends TestBase {
	
	public static long PAGE_LOAD_TIMEOUT = 20;
	public static long IMPLICIT_WAIT = 20;
	
	public static String TESTDATA_SHEET_PATH= "F:/SeleniumTesting/CRMProject/src/main/java/com/crm/qa/testdata/FreeCRMTestsData.xlsx";
	
	static Workbook book;
	static Sheet sheet;
	
	public static Object[][] getTestData(String sheetName) {
		FileInputStream file= null;
		try {
			file = new FileInputStream(TESTDATA_SHEET_PATH);
		} catch (FileNotFoundException ex) {
			ex.printStackTrace();
		}
		
		try {
			book = WorkbookFactory.create(file);
		} catch (IOException ex) {
			ex.printStackTrace();
		}
		
		sheet = book.getSheet(sheetName);
		int rowCount=sheet.getLastRowNum();
		int colCount=sheet.getRow(0).getLastCellNum();
		Object[][] data = new Object[rowCount][colCount];
		
		for (int i=0; i<rowCount; i++) {
			for (int j=0; j<colCount; j++) {
				data[i][j] = sheet.getRow(i+1).getCell(j).toString();
				System.out.println(data[i][j]);
			}
		}
			
		return data;
				
	} 

}
