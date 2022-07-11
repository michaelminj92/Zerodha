package utility;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class Excel {
	
      public static String getData(String Sheet,int row,int cell) throws IOException, EncryptedDocumentException {
		FileInputStream file = new FileInputStream("C:\\Users\\user\\eclipse-workspace\\Zerodha\\src\\test\\resources\\Sheet1.xlsx");
		String value = WorkbookFactory.create(file).getSheet(Sheet).getRow(row).getCell(cell).getStringCellValue();
        return value;
	}
}
