package orangeHRM.utilities;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import orangeHRM.baseclass.TestBase;

public class SimpleDatautil extends TestBase{
	public static Object[][] getsheetdata(String sheetName) throws IOException{
	FileInputStream file = new FileInputStream("C:\\Users\\Ramakrishna\\Desktop\\Automated Files&Folders\\POM_Testdata.xlsx");
	XSSFWorkbook book=new XSSFWorkbook(file);
	XSSFSheet sheet = book.getSheet(sheetName);
	Object[][] data = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
	
	for (int i = 0; i < sheet.getLastRowNum(); i++) {
		for (int k = 0; k < sheet.getRow(0).getLastCellNum(); k++) {
			data[i][k] = sheet.getRow(i + 1).getCell(k).toString();
			}
	}
	return data;
}
}
	

