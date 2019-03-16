package day3;

import java.io.FileInputStream;
/*import java.io.FileNotFoundException;
import java.io.IOException;*/

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Readworkbook {

	public static void main(String[] args) throws Exception {
	
		FileInputStream infile=new  FileInputStream("C:\\Users\\vshadmin\\Desktop\\Book1.xlsx");
		
	 XSSFWorkbook book =new XSSFWorkbook(infile);
	 XSSFSheet sheet=book.getSheet("Sheet1");
	 for(int i=1;i<=sheet.getLastRowNum();i++)
	 {
		 String data=sheet.getRow(i).getCell(0).toString();
		 System.out.print(data);
		 
		 String data1=sheet.getRow(i).getCell(1).toString();
		 System.out.println(" "+data1);
		
	 }
	book.close();
	}

}
