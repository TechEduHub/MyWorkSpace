package com.utilities;

import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtil {
	public static final String currentDir  = System.getProperty("user.dir"); 
	public static String filePath = currentDir + "/src/test/resources/";
	static XSSFWorkbook workbook; 
	static XSSFSheet sheet;
	
	public ExcelUtil(String fileName, String sheetName)throws IOException {
		String excelPath = filePath+fileName;
	    workbook = new XSSFWorkbook(excelPath);
	    sheet = (XSSFSheet) workbook.getSheetAt(0);
	}
	
	
	/**
	 * method to get rowsCount
	 */
	public static int getRowCount() {
		int rowCount = 0;
		try {
			rowCount = sheet.getPhysicalNumberOfRows();
		}catch (Exception e) {
			e.printStackTrace();
		}
		return rowCount;
	}
	
	/**
	 * method to get columnCount
	 */
	public static int getColCount() {
		int colCount = 0;
		try {
			colCount = sheet.getRow(0).getLastCellNum();
		}catch (Exception e) {
			e.printStackTrace();
		}
		return colCount;
	}
	
	/**
	 * method to get cell data (String)
	 */
	public String getCellDataString(int rowNum, int colNum) {
		String cellValue = null;
		try {
			cellValue = sheet.getRow(rowNum).getCell(colNum).getStringCellValue();
		}catch (Exception e) {
			e.printStackTrace();
		}
		return cellValue;
	}
	public static String readStringData(String fileName, int i,int j,String sheetname) throws IOException
	{
		String excelPath = filePath+fileName;

		workbook=new XSSFWorkbook(excelPath);
		sheet=workbook.getSheet(sheetname);
		Row row=sheet.getRow(i);
		Cell c=row.getCell(j);
		
		return c.getStringCellValue();
	}
	public static int readIntegerData(String fileName, int i,int j,String sheetname) throws IOException
	{
		String excelPath = filePath+fileName;
		workbook=new XSSFWorkbook(excelPath);
		sheet=workbook.getSheet(sheetname);
		Row row=sheet.getRow(i);
		Cell c=row.getCell(j);
		int a=(int) c.getNumericCellValue();
		return a;
	}
}
