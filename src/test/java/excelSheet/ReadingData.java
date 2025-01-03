package excelSheet;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadingData {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		System.setProperty("log4j2.loggerContextFactory", "org.apache.logging.log4j.simple.SimpleLoggerContextFactory");
		FileInputStream file = new FileInputStream("C:\\AutomationData\\DataswagLabs.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook(file);
		XSSFSheet sheet = workbook.getSheetAt(0);
		int totalrow= sheet.getLastRowNum();
		int totalCell= sheet.getRow(0).getLastCellNum();
		
		System.out.println(totalrow);
		System.out.println(totalCell);
		
//		for(int r=0; r<=totalrow;r++) {
//			
//			XSSFRow currentRow = sheet.getRow(r);
//			
//			for(int c=0; c<totalCell;c++) {
//				
//				XSSFCell cell = currentRow.getCell(c);
//				System.out.println(cell.toString());
//				
//			}
//		}
		
	}

}
