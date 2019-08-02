package com.actitime.generic;

import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelData 
{
  public static String getData(String filePath, String sheetName, int rn, int cn)
  {
	  try
	  {
		  FileInputStream fis=new FileInputStream(filePath);
		  Workbook wb = WorkbookFactory.create(fis);
		  Sheet sh = wb.getSheet(sheetName);
		  Row r = sh.getRow(rn);
		  Cell c = r.getCell(cn);
		  String data=c.getStringCellValue();
		  return data;
	  }
	  catch (Exception e) 
	  {
		return "";
	  }
  }
	  public static int getRowCount(String filePath, String sheetName)
	  {
		  try
		  {
			  FileInputStream fis=new FileInputStream(filePath);
			  Workbook wb = WorkbookFactory.create(fis);
			  Sheet sh = wb.getSheet(sheetName);
			  int rc = sh.getLastRowNum();
			  return rc;
		  }
		  catch (Exception e) 
		  {
			return -1;
		  }
  }
	  
	  public static int getCellCount(String filePath, String sheetName,int rn)
	  {
		  try
		  {
			  FileInputStream fis=new FileInputStream(filePath);
			  Workbook wb = WorkbookFactory.create(fis);
			  Sheet sh = wb.getSheet(sheetName);
			  Row r = sh.getRow(rn);
			  short cn = r.getLastCellNum();
			  return cn;
		  }
		  catch (Exception e) 
		  {
			return -1;
		  }
  }
	  
	  public static void setData(String filePath, String sheetName, int rn, int cn, String cellValue )
	  {
		  try
		  {
			  FileInputStream fis=new FileInputStream(filePath);
			  Workbook wb = WorkbookFactory.create(fis);
			  Sheet sh = wb.getSheet(sheetName);
			  Row r = sh.getRow(rn);
			  if(r==null)
			  {
				  r = sh.createRow(rn);
			  }
			  Cell c = r.getCell(cn);
			  if(c==null)
			  {
				  c= r.createCell(cn);
			  }
			  c.setCellValue(cellValue);
			  FileOutputStream fos=new FileOutputStream(filePath);
			  wb.write(fos);
			  wb.close();
			 
		  }
		  catch (Exception e) 
		  {
			
		  }
	  }
  
}
