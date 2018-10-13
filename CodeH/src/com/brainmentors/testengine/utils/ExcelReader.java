package com.brainmentors.testengine.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;

import com.brainmentors.testengine.questions.dto.QuestionDTO;

public class ExcelReader {
	
	public static ArrayList<QuestionDTO> readExcel(String path) throws IOException {
		
		File file = new File(path);
		FileInputStream fs = new FileInputStream(file);
		//XSSFWorkbook - xlsx
		// HSSFWorkbook - xls
		int columnCount = 1;
		HSSFWorkbook workBook = new HSSFWorkbook(fs);
		HSSFSheet sheet = workBook.getSheetAt(0);
		Iterator<Row> rows = sheet.rowIterator();
		boolean isFirstRowPass= false;
		ArrayList<QuestionDTO> questions = new ArrayList<>();
		while(rows.hasNext()) {
			Row row = rows.next(); // give current and move to next
			if(!isFirstRowPass) {
				isFirstRowPass=true;
				continue;
			}
			Iterator<Cell> cells = row.cellIterator();
			QuestionDTO questionDTO = new QuestionDTO();
			String options[] = new String[4];
			int index = 0;
			columnCount=1;
			while(cells.hasNext()) {
				Cell cell = cells.next();
				
				if(cell.getCellType()==CellType.NUMERIC  && (columnCount==1 || columnCount==8)) {
					System.out.println(cell.getNumericCellValue());
					if(columnCount==1) {
					questionDTO.setId((int)cell.getNumericCellValue());
					}
					if(columnCount==8) {
						questionDTO.setScore((int)cell.getNumericCellValue());
					}
				}
				else 
				if(cell.getCellType()==CellType.STRING)
				{
					if(columnCount==2) {
						questionDTO.setName(cell.getStringCellValue());
					}
					else
					if(columnCount>=3 && columnCount<7) {
						
					
							options[index] =  cell.getStringCellValue();
							index++;
							
						}
					else
					if(columnCount==7) {
						questionDTO.setOptions(options);
						questionDTO.setRightAnswer( cell.getStringCellValue());
						
						
					}
					
					System.out.println(cell.getStringCellValue());
				}
				columnCount++;
				
			} // Cell Loop
			questions.add(questionDTO);
		} // Row Loop
		workBook.close();
		fs.close();
		return questions;
	}
	public static void main(String[] args) throws IOException {
		String path = "/Users/amit/Documents/questions.xls";
		ArrayList<QuestionDTO> questions = ExcelReader.readExcel(path);
		System.out.println("Questions are :::::: "+questions);
		System.out.println("Questions are "+questions.toString());
		//System.out.println(questions.get(0).toString());
	}
	

}
