package day3;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

import util.BrowserSetup;

public class Test3 {

	static String data;
	
	public static void main(String[] args) throws Exception 
	{
		WebDriver driver = BrowserSetup.browserStart("chrome","https://nseindia.com/");
		
		FileInputStream infile=new  FileInputStream("C:\\Users\\vshadmin\\Desktop\\Book2.xlsx");
		 XSSFWorkbook book =new XSSFWorkbook(infile);
		 XSSFSheet sheet=book.getSheet("Sheet1");
		
		 for(int i=0;i<=sheet.getLastRowNum();i++) 
		 {
			  data=sheet.getRow(i).getCell(0).toString();			 
			  driver.findElement(By.name("companyED")).sendKeys(data);
			  driver.findElement(By.xpath("//*[contains(text(),'"+data+"')]")).click();				
				 String e=driver.findElement(By.id("faceValue")).getText();
		 		System.out.println("face value is"+e);	 		
		 		sheet.getRow(i).createCell(2).setCellValue(e);
	
		 		FileOutputStream out=new  FileOutputStream("C:\\Users\\vshadmin\\Desktop\\Book2.xlsx");
				 book.write(out);
				 BrowserSetup.getScreenShot("abc");
		  }

	}

}
