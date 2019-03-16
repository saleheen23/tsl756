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

public class Test2 {

	static String data,data1;
	 
	public static void main(String[] args) throws Exception
	{
		FileInputStream infile=new  FileInputStream("C:\\Users\\vshadmin\\Desktop\\Book1.xlsx");
		WebDriver driver = BrowserSetup.browserStart("chrome","http://127.0.0.1:8080/htmldb/f?p=4550:11:17286496247486679950::NO:::");
		 XSSFWorkbook book =new XSSFWorkbook(infile);
		 XSSFSheet sheet=book.getSheet("Sheet1");
		
		 for(int i=1;i<=sheet.getLastRowNum();i++) 
		 {
			  data=sheet.getRow(i).getCell(0).toString();
			 System.out.print(data);
			 
			 data1=sheet.getRow(i).getCell(1).toString();
			System.out.println(" "+data1);
			 
			 	driver.findElement(By.cssSelector("input#P11_USERNAME")).clear();
			 	driver.findElement(By.name("p_t01")).sendKeys(data);
			 	
			 	driver.findElement(By.cssSelector("input[type='password']")).clear();
				driver.findElement(By.name("p_t02")).sendKeys(data1);
				driver.findElement(By.cssSelector("input[value='Login']")).click();
				
				if (driver.getTitle().equals("Oracle"))
				{

					sheet.getRow(i).createCell(2).setCellValue("Login Unsuccessful");}
			 }
		
		 FileOutputStream out=new  FileOutputStream("C:\\Users\\vshadmin\\Desktop\\Book1.xlsx");
		 book.write(out);
	}

}
