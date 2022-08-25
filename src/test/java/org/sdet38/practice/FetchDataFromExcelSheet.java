package org.sdet38.practice;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class FetchDataFromExcelSheet {

	public static void main(String[] args) throws EncryptedDocumentException, IOException 
	{
		//Step 1: read the file using input stream //
		FileInputStream fis=new FileInputStream(".\\Data\\testdata.xlsx");
		
		//Srep 2: create workbbok//
		Workbook workbook=WorkbookFactory.create(fis);
		
		//Step 3: load sheet //
		Sheet sh = workbook.getSheet("sheet1");
		
		//Step 4: navigate to the row //
		Row row = sh.getRow(1);
		
		//Step 5: navigate to the cell //
		Cell cel = row.getCell(2);
		
		//Step 6: read the value inside the cell//
		System.out.println(cel.getStringCellValue());
		
		
	}

}
