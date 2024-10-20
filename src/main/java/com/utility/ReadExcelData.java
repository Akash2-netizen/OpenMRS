package com.utility;

import java.io.File;
import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcelData {
 public static String readParticularCell(int rows,int column) throws Exception, Exception{
	 
	 File file=new File("C:\\Files\\Data_Driven.xlsx");
	 Workbook book=new XSSFWorkbook(file);
	 
	 Sheet sheet=book.getSheetAt(0);
	 Row row=sheet.getRow(rows);
	 Cell cell=row.getCell(column);
	 //DataFormatter is is used to convert in to string
	 DataFormatter dataFormat=new DataFormatter();
	 String data=dataFormat.formatCellValue(cell);
	 System.out.println(data);
	 return data;
	 
 }
public static void readParticularRowMultiCell() throws Exception, IOException {
	
	File file=new File("C:\\Files\\Data_Driven.xlsx");
	Workbook book=new XSSFWorkbook(file);
	
	 Sheet sheet=book.getSheet("sheet1");
	 
	 
	 int lastRowNo=sheet.getLastRowNum();
	 System.out.println("No of Rows: "+lastRowNo);
	 
	 
	 
	 Short lastCellNo=sheet.getRow(0).getLastCellNum();
	 System.out.println("No of Cells: "+lastCellNo);
	 
	 Row row=sheet.getRow(0);
	 
	 for (int i = 0; i <lastCellNo ; i++) {
		Cell cell = row.getCell(i);
		DataFormatter dataFormat = new DataFormatter();
		String data = dataFormat.formatCellValue(cell);
		System.out.println(data);
	}
	 
	
 }
public static void readAllData() throws Exception, Exception {
	File file=new File("C:\\Files\\Data_Driven.xlsx");
	Workbook book=new XSSFWorkbook(file);
	
	 Sheet sheet=book.getSheet("sheet1");
	 
	 
	 int lastRowNo=sheet.getLastRowNum();
	 System.out.println("No of Rows: "+lastRowNo);
	 
	 
	 
	 Short lastCellNo=sheet.getRow(0).getLastCellNum();
	 System.out.println("No of Cells: "+lastCellNo);
	 
	 for (int i = 1; i < lastRowNo; i++) {
		Row row = sheet.getRow(i);
		for (int j = 0; j < lastCellNo; j++) {
			Cell cell = row.getCell(j);
			DataFormatter dataFormat = new DataFormatter();
			String data = dataFormat.formatCellValue(cell);
			System.out.println(data);
		} 
	}
	 
	
 }

public static void main(String[] args) throws Exception {
	//readParticularCell(2,2);
	//readParticularRowMultiCell();
	readAllData();
}

}
