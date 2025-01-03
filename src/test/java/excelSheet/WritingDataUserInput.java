package excelSheet;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.Scanner;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

public class WritingDataUserInput {
  @Test
  public void f() throws FileNotFoundException {
	  
	  FileOutputStream file = new FileOutputStream("C:\\AutomationData\\DataswagLabsWriteUser.xlsx");
	  XSSFWorkbook workbook = new XSSFWorkbook();
	 XSSFSheet sheet=  workbook.createSheet("Data");
	 
	 Scanner sc = new Scanner(System.in);
	 int rowNum = sc.nextInt();
	 int colNum = sc.nextInt();
	 
	 XSSFSheet row1 = sheet.createRow(rowNum);
	  
  }
}
