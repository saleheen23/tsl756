package day3;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;

import util.BrowserSetup;

public class Write {
	
public static void main(String[] args) throws Exception 
{
	FileInputStream infile=new  FileInputStream("C:\\Users\\vshadmin\\Desktop\\Book1.xlsx");
	
	 XSSFWorkbook book =new XSSFWorkbook(infile);
	 XSSFSheet sheet=book.getSheet("Sheet1");
	 
	 sheet.createRow(6).createCell(2).setCellValue("LNT");
	 
	 FileOutputStream out=new  FileOutputStream("C:\\Users\\vshadmin\\Desktop\\Book1.xlsx");
	 book.write(out);
}
}
