package APITesting;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelReader {

	private static Workbook workbook;
	
	public static Object[][] getdatafromexcel(String filepath , String sheetname) throws IOException {
		
		FileInputStream file = new FileInputStream (new File(filepath));
		workbook = WorkbookFactory.create(file);
		Sheet sheet = workbook.getSheet(sheetname);
		int rowcount = sheet.getPhysicalNumberOfRows();
		int column = sheet.getRow(0).getPhysicalNumberOfCells();
		Object[][] testdata = new Object[rowcount-1][column];
		
		for(int i = 1;i<rowcount;i++) {
			Row row = sheet.getRow(i);
			
			for(int j=0;j<column;j++) {
				
			testdata[i-1][j] = row.getCell(j).toString();	
			}
		}
		return testdata;
	}
}
