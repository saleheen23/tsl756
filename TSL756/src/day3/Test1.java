package day3;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

import util.BrowserSetup;

public class Test1 {

	public static void main(String[] args)
	{
		WebDriver driver = BrowserSetup.browserStart("chrome","https://nseindia.com/");
		Actions  action= new Actions(driver);
		 driver.findElement(By.name("companyED")).sendKeys("Reliance Industries Limited");;
		driver.findElement(By.xpath("//*[contains(text(),'Reliance Industries Limited')]")).click();
		
		BrowserSetup.getScreenShot("reliance");
		String e=driver.findElement(By.id("faceValue")).getText();
		 System.out.println("face value is"+e);
		 WebElement e1=driver.findElement(By.xpath(" //*[@id=\"high52\"]/font"));
		 System.out.println("52 week high value is"+e1.getText());
		 WebElement e2=driver.findElement(By.xpath(" //*[@id=\"low52\"]/font"));
		 System.out.println("52 week low value is"+e2.getText());
		 	 
	}

}
