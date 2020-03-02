package com.autodesk.crm.commonlib;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class FileLib {
	String filepath="./Data/testdata.xlsx";
	/**
	 * used to read data from excel
	 * @param sheetName
	 * @param rowNum
	 * @param colNum
	 * @return 
	 * @throws IOException 
	 * @throws EncryptedDocumentException
	 */
	public String getExcelData(String sheetName,int rowNum,int colNum) throws EncryptedDocumentException, IOException{
		FileInputStream fis = new FileInputStream(filepath);
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet(sheetName);
		Row row = sh.getRow(rowNum);
		String data = row.getCell(colNum).getStringCellValue();
		wb.close();
		return data;	
	}
	public void setExcelData(String sheetName,int rowNum,int colNum,String data) throws EncryptedDocumentException, IOException{
		FileInputStream fis = new FileInputStream(filepath);
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet(sheetName);
		Row row = sh.getRow(rowNum);
		Cell cel = row.createCell(colNum);
		cel.setCellValue(data);
		FileOutputStream fos=new FileOutputStream(filepath);
		wb.write(fos);
		wb.close();
	}
	public int getRowCount(String sheetName) throws EncryptedDocumentException, IOException{
		FileInputStream fis = new FileInputStream(filepath);
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet(sheetName);
		int rowIndex = sh.getLastRowNum();
		return rowIndex;
	}
public String getPropertyKeyValue(String key) throws IOException{
	FileInputStream fis = new FileInputStream("./Data/commondata properties2.txt");
	Properties pobj = new Properties();
    pobj.load(fis);
    String value = pobj.getProperty(key);
    return value;
	
}
}
