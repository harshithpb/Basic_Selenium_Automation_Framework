package reuseableComponents;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelOperations {
	
	String filePath;
	Sheet sh;
	
	public ExcelOperations(String sheetname) {
		try {
			filePath = System.getProperty("user.dir")+PropertiesOperations.getPropertyValueByKey("testDataLocation");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		//open file - workbook
		File testDataFile = new File(filePath);
		Workbook wb = null;
		try {
			wb = WorkbookFactory.create(testDataFile);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		sh = wb.getSheet(sheetname);
	}

	//get test data from test data sheet in hashmap
	public HashMap<String, String> getTestDataInMap(int rowNum) throws Exception {
				
		//read data row by row
		HashMap<String, String> hm = new HashMap<String, String>();
		
		for (int i = 0; i < sh.getRow(0).getLastCellNum(); i++) {
			sh.getRow(rowNum).getCell(i).setCellType(CellType.STRING);
			hm.put(sh.getRow(0).getCell(i).toString(), sh.getRow(rowNum).getCell(i).toString()); //hashmap (key,value) pair creation
		}
		
		return hm;
	}
	
	//get row count
	public int getRowCount() {
		return sh.getLastRowNum();
	}
	
	public int getColCount() {
		return sh.getRow(0).getLastCellNum();
	}
	
	
}
