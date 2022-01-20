package assignment;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import com.crm.comcast.GenericUtility.IPathConstants;

public class ExecuteRatingFromExcelSheet {

	public static void main(String[] args) throws Throwable, IOException {
		FileInputStream Fis = new FileInputStream(IPathConstants.EXCEL_FILEPATH);
        Workbook workbook = WorkbookFactory.create(Fis);
        Sheet sheet = workbook.getSheet("Sheet1");
        Row row = sheet.getRow(2);
        Cell cell = row.getCell(3);
        row=sheet.getRow(4);
        cell=row.getCell(1);
        
        //fetch the value from the cell
         String Result = cell.getStringCellValue();
         System.out.println(Result);
	}

}
