package com.file.io.ops;

import java.io.File;
import java.io.FileInputStream;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
public class SamplePOIRead 
{
   static XSSFRow row;
   static int xlRows,xlCols;
   static String localArray[][];
   static WebDriver driver;
   public String[][] ExcelPOiRead(String sheetname) throws Exception 
   {
      FileInputStream fis = new FileInputStream( 
      new File("E:/Data/Book1.xlsx"));
      
     // HSSFWorkbook ddd = new HSSFWorkbook(fis);
      XSSFWorkbook workbook = new XSSFWorkbook(fis);
      
      XSSFSheet sheet = workbook.getSheet(sheetname);
      
    /*
      XSSFRow row = sheet.getRow(1);
      XSSFCell cellvalue = row.getCell(0);*/
      
     //int lastrow =  sheet.getLastRowNum();
      xlRows=sheet.getLastRowNum()+1;
      xlCols=sheet.getRow(1).getLastCellNum();
      
      localArray=new String[xlRows][xlCols];
      
      for(int i=1;i<xlRows;i++){
    	  
       XSSFRow xssfrow = sheet.getRow(i);
     
       		for(int j=0;j<xlCols;j++){
        XSSFCell xssfcell = xssfrow.getCell(j);  
        
        String value = cellToString(xssfcell);
        localArray[i][j]=value;
       // System.out.println("VALUE :::::"+i+":::"+j+":::"+localArray[1][1]);
        
       }
      }
//    driver.findElement(By.name("username")).sendKeys(localArray[i][0]);
//    driver.findElement(By.name("password")).sendKeys(localArray[i][1]);
 return localArray;
   
   }
      
   public static String cellToString(XSSFCell cell){
    
    int type;
    String result;
    
    if(cell==null){
    	return " ";
    }
    else{
    type = cell.getCellType();
    }
    switch(type){
     
     case 0:
      result=String.valueOf(cell.getNumericCellValue());
      break;
     case 1:
      result=cell.getStringCellValue();
      break;
    
     case 2:
    	 result=String.valueOf(cell.getCellFormula());
    	 
     default:
      throw new RuntimeException("No support for this type of cell");
    
      
    }
 return result;
    
   }
}