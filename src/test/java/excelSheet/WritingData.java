package excelSheet;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class WritingData {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		FileOutputStream file = new FileOutputStream("C:\\AutomationData\\DataswagLabsWrite.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook();
		XSSFSheet sheet = workbook.createSheet("data");
		
		XSSFRow row1 = sheet.createRow(0);
		 row1.createCell(0).setCellValue("Nishant");
		 row1.createCell(1).setCellValue("Kumar");
		 
		 XSSFRow row2 = sheet.createRow(1);
		 row2.createCell(0).setCellValue("Aman");
		 row2.createCell(1).setCellValue("Sharma");
		 
		 workbook.write(file);
		 
		 workbook.close();
		 file.close();
	}

}
