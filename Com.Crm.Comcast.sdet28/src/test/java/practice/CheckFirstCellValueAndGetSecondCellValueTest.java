package practice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class CheckFirstCellValueAndGetSecondCellValueTest {
	//if first cell has expected value fetch second cell data
	
	public static void main(String[] args) throws Throwable, IOException {
		FileInputStream Fis = new FileInputStream("./src/test/resources/vtigerTestData.xlsx");
		Workbook workbook = WorkbookFactory.create(Fis);
		Sheet sheet = workbook.getSheet("Sheet1");
		
		String cellData="CreateOrgnaization";
		int rowNo=sheet.getLastRowNum();
		for(int i=1;i<rowNo;i++) {
			Row row = sheet.getRow(i);
			String firstCellData = row.getCell(0).getStringCellValue();
			
			
			
			
		}
	
		
		

	}

}
