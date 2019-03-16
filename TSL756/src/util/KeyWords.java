package util;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.Select;

public class KeyWords
{
	private WebDriver driver;
	public  WebDriver browserStart(String name)
	{
		if(name.equalsIgnoreCase("chrome"))
		{
		System.setProperty("webdriver.chrome.driver", ".\\Drivers\\chromedriver.exe");
		driver=new ChromeDriver();
		}
		else if(name.equalsIgnoreCase("firefox"))
		{
			System.setProperty("webdriver.gecko.driver", ".\\Drivers\\geckodriver.exe");
			driver=new FirefoxDriver();
		}
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		return driver;
	}
	
	public  WebDriver browserStart(String name,String url)
	{
		WebDriver driver=browserStart(name);
		driver.get(url);
		return driver;
	}
	
	public  void getScreenShot(String Name)
	{	
		Date d=new Date();
		System.out.println("Before "+d.toString());
		String date=d.toString().replaceAll(" ", "_").replaceAll(":","_");
		System.out.println("After "+date);
		
		TakesScreenshot screen=(TakesScreenshot)driver;
		File src=screen.getScreenshotAs(OutputType.FILE);
		try {
			FileHandler.copy(src, new File(".\\"+Name+date+".png"));
		} catch (IOException e) {
			System.out.println("Error  while taking screenshot");
			
		}
	}
	public KeyWords(WebDriver idriver)
	{
		this.driver=idriver;
	}

	public void openUrl(String url)
	{
		driver.get(url);
	}

	public void type(String Locator,String text)
	{
		driver.findElement(element(Locator)).sendKeys(text);
	}
	public void click(String Locator)
	{
		driver.findElement(element(Locator)).click();;
	}
	public void dropDown(String Locator,String visibletext)
	{
		new Select(driver.findElement(element(Locator))).selectByVisibleText(visibletext);
	}	
	public By element(String Value)
	  {
		  By B=null;
		  if(Value.endsWith("_:linktext"))
			B=  By.linkText(Value.split("_:")[0]);
		  else if (Value.endsWith("_:xpath"))	 
			B=  By.xpath(Value.split("_:")[0]);
		  else if (Value.endsWith("_:id"))	 
				B=  By.id(Value.split("_:")[0]);
		  else if (Value.endsWith("_:name"))	 
				B=  By.name(Value.split("_:")[0]);
		  else if (Value.endsWith("_:css"))	 
				B=  By.cssSelector(Value.split("_:")[0]);
		  else 
			  System.out.println("Invalid Locator");
		  return B;
	  }  
}
