package utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtilDemo {

	
	public FileInputStream fi;
	public FileOutputStream fo;
	public XSSFWorkbook wb;
	public XSSFSheet ws;
	public XSSFRow row;
	public XSSFCell cell;
	public CellStyle style;
	String path;
	
	public ExcelUtilDemo(String path) {
		
		this.path=path;
	}
	
	
	public int getRowCount( String xlsheet) throws IOException
	{
		fi=new FileInputStream(path);
		wb= new XSSFWorkbook(fi);
		ws= wb.getSheet(xlsheet);
		int rowcount = ws.getLastRowNum();
		wb.close();
		fi.close();
		
		return rowcount;
	}
	
	public int getCellCount( String xlsheet, int rownum) throws IOException
	{
		fi=new FileInputStream(path);
		wb= new XSSFWorkbook(fi);
		ws= wb.getSheet(xlsheet);
		row=ws.getRow(rownum);
		int cellcount = row.getLastCellNum();
		wb.close();
		fi.close();
		
		return cellcount;
	}
	
	
	public  String getCellData( String xlsheet, int rownum, int colnum) throws IOException
	{
		fi=new FileInputStream(path);
		wb= new XSSFWorkbook(fi);
		ws= wb.getSheet(xlsheet);
		row=ws.getRow(rownum);
		cell= row.getCell(colnum);
		wb.close();
		fi.close();
		
		String data;
		try
		{
			//data=cell.toString();
			DataFormatter formatter = new DataFormatter();
			data= formatter.formatCellValue(cell);
			
		}
		
		catch(Exception e) {
			
			data="";
		}
		
		wb.close();
		fi.close();
		return data;
	}
	
	
	public  void setCellData( String xlsheet, int rownum, int colnum, String data) throws IOException
	{
		
		File xlfile = new File(path);
		if(!xlfile.exists())
		{
			wb= new XSSFWorkbook();
			fo= new FileOutputStream(path);
			wb.write(fo);
		}
		
		fi=new FileInputStream(path);
		wb= new XSSFWorkbook(fi);
		
		if(wb.getSheetIndex(xlsheet)==-1) //if sheet not exists then create new sheet
			wb.createSheet(xlsheet);
		ws = wb.getSheet(xlsheet);
		
		if(ws.getRow(rownum)==null)  //if row not exists then create new row
			ws.createRow(rownum);
		row= ws.getRow(rownum);
		
//		ws= wb.getSheet(xlsheet);
//		row=ws.getRow(rownum);
		
		
		cell=row.createCell(colnum);
		cell.setCellValue(data);
		fo= new FileOutputStream(path);
		wb.write(fo);
		wb.close();
		fi.close();
		fo.close();
		
		
	}
	
	
	public  void filGreenColor( String xlsheet, int rownum, int colnum) throws IOException
	{
		fi=new FileInputStream(path);
		wb= new XSSFWorkbook(fi);
		ws= wb.getSheet(xlsheet);
		row=ws.getRow(rownum);
		cell=row.createCell(colnum);
		
		style=wb.createCellStyle();
		
		style.setFillForegroundColor(IndexedColors.GREEN.getIndex());
		style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
		
		cell.setCellStyle(style);
		fo= new FileOutputStream(path);
		wb.write(fo);
		wb.close();
		fi.close();
		fo.close();
		
		
	}
	
	
}

