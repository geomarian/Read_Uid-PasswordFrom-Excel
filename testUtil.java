package com.utilOne;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook; //
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class testUtil {
	
	static Workbook book;
	static Sheet sheet;
	
	public static String TESTDATA_SHEET_PATH = "E:/GEO/Selenium Sample/dataProviderTest/TestDataOne.xlsx";
	
	
	public static Object[][] getTestData(String sheetName) {
		FileInputStream file = null;
		try{
			file = new FileInputStream(TESTDATA_SHEET_PATH); //creat file input stream
			
		}
		catch(FileNotFoundException e){
			e.printStackTrace(); 
		}
		try {
		     book = WorkbookFactory.create(file); //it will come from apache.api & will get book object & will create method
		    } catch(FileNotFoundException e){
		    	e.printStackTrace();
		    }
		
		
		catch (IOException e) {
			e.printStackTrace();
		}
		sheet = book.getSheet(sheetName); //From which we wnat to fetch the data
		Object[][] data = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
		
		for (int i = 0; i< sheet.getLastRowNum(); i++) {
			for(int k = 0; k <sheet.getRow(0).getLastCellNum();k++){
				data[i][k]= sheet.getRow(i+1).getCell(k).toString();
			}
			
			}
		return data;
		}
	}

