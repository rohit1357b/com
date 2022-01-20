package com.crm.comcast.GenericUtility;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
/**
 * 
 * @author Rohit
 *
 */
public class ExcelUtility {
	/**
	 *This method will return string value from excel sheet
	 * @param sheetName
	 * @param rowNo
	 * @param cellNo
	 * @return
	 * @throws Throwable
	 */
 public String getStringCellData(String sheetName,int rowNo,int cellNo) throws Throwable {
	 FileInputStream file = new FileInputStream(IPathConstants.EXCEL_FILEPATH);
	 Workbook workbook = WorkbookFactory.create(file);
	 Sheet sheet = workbook.getSheet(sheetName);
	Row row = sheet.getRow(rowNo);
	Cell cell = row.getCell(cellNo);
	  return cell.getStringCellValue();
 }
	  /**
	 * @throws Throwable 
	   * 
	   */
	  public Object[][]getMultipleData(String sheetName) throws Throwable{
		   FileInputStream file = new FileInputStream(IPathConstants.EXCEL_FILEPATH);
		   Workbook workbook = WorkbookFactory.create(file);
		   Sheet sheet = workbook.getSheet(sheetName);
		   int rowNo=sheet.getLastRowNum();
		   int cellNo=sheet.getRow(0).getLastCellNum();
	   Object[][]data=new Object[rowNo][cellNo];
		   for(int i=0;i<rowNo;i++) {
			   for(int j=0;i<cellNo;j++) {
				   data[i][j]=sheet.getRow(i).getCell(j).toString();
				   
			   }
		   }
			   return data;
		   }
		 public  double getNumbericCellData(String sheetName,int rowNo,int cellNo)throws Throwable {
			FileInputStream File=new FileInputStream(IPathConstants.EXCEL_FILEPATH);
			Workbook workbook=WorkbookFactory.create(File);
			return workbook.getSheet(sheetName).getRow(rowNo).getCell(cellNo).getNumericCellValue();
			
		   }
	   
	  		public void writeDataIntoExcel(String sheetName,int rowNo,int cellNo,String value)throws Throwable {
	  			FileInputStream readFile = new FileInputStream(IPathConstants.EXCEL_FILEPATH);
	  			Workbook workbook= WorkbookFactory.create(readFile);
	  			workbook.createSheet(sheetName).createRow(rowNo).createCell(cellNo).setCellValue(value);
	  			
	  			
	  			FileOutputStream writeFile = new FileOutputStream(IPathConstants.EXCEL_FILEPATH);
	  			workbook.write(writeFile);
	  			workbook.close();
	  }	
	  }
	  
	


	  				
	  		
	  			
	  
			
	  
			   
		   
		  
		  
	  
	   
	   
	   
	   
	  
	
			  
 
