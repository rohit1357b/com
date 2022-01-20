package practice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class GetFirstAndSecondColumnDataTest {

	public static void main(String[] args) throws Throwable, IOException {
		FileInputStream fis = new FileInputStream("./src/test/resources/vtigerTestData.xlsx");
		Workbook workbook = WorkbookFactory.create(fis);
	   Sheet sheet = workbook.getSheet("Sheet1");
	   int rowNo = sheet.getLastRowNum();//3
	   
	   for(int i=1;i<=rowNo;i++) {
		   Row row = sheet.getRow(i);
		   String firstcolumnData=row.getCell(0).getStringCellValue();
		   String secondcolumnData=row.getCell(1).getStringCellValue();
		   System.out.println(firstcolumnData+"\t"+secondcolumnData);
	   }
	   workbook.close();
		   
		   
		   
	   }

	}


