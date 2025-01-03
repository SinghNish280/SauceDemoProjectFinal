package excelSheet;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

public class ReadingDataDemo {
  @Test
  public void f() throws IOException {
	  
	  FileInputStream file = new FileInputStream("C:\\AutomationData\\DataswagLabs.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook(file);
		XSSFSheet sheet = workbook.getSheetAt(0);
		int totalrow= sheet.getLastRowNum();
		int totalCell= sheet.getRow(0).getLastCellNum();
		
		System.out.println(totalrow);
		System.out.println(totalCell);
		
		for(int r=0; r<=totalrow;r++) {
			
			XSSFRow currentRow = sheet.getRow(r);
			
			for(int c=0; c<totalCell;c++) {
				
				XSSFCell cell = currentRow.getCell(c);
				System.out.print(cell.toString()+"\t");
				
				
				
			}
			System.out.println();
		}
		workbook.close();
		file.close();
	}

	  
  }

