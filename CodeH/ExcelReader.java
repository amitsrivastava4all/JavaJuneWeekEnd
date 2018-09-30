package com.brainmentors.testengine.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;

public class ExcelReader {
	
	public static void readExcel() throws IOException {
		String path = "/Users/amit/Documents/questions.xls";
		File file = new File(path);
		FileInputStream fs = new FileInputStream(file);
		//XSSFWorkbook - xlsx
		// HSSFWorkbook - xls
		HSSFWorkbook workBook = new HSSFWorkbook(fs);
		HSSFSheet sheet = workBook.getSheetAt(0);
		Iterator<Row> rows = sheet.rowIterator();
		while(rows.hasNext()) {
			Row row = rows.next(); // give current and move to next
			Iterator<Cell> cells = row.cellIterator();
			while(cells.hasNext()) {
				Cell cell = cells.next();
				if(cell.getCellType()==CellType.NUMERIC) {
					System.out.println(cell.getNumericCellValue());
				}
				else 
				if(cell.getCellType()==CellType.STRING)
				{
					System.out.println(cell.getStringCellValue());
				}
			}
		}
		workBook.close();
		fs.close();
		
	}
	public static void main(String[] args) throws IOException {
		ExcelReader.readExcel();
	}
	

}
