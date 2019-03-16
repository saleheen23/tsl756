package util;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.io.FileHandler;

public class BrowserSetup {

	
	public static WebDriver browserStart(String name,String url) 
	{

	WebDriver driver=browserStart(name);
	driver.get(url);
	driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	return driver;
}
	public static void getScreenShot(String Name)
	{
TakesScreenshot screen =(TakesScreenshot)driver;
String timestamp = new SimpleDateFormat("yyyy_MMM_dd__hh_mm_ss").format(new Date());

		File src = screen.getScreenshotAs(OutputType.FILE);
		try {
			FileHandler.copy(src,new File(".\\"+Name+timestamp+".png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
static	WebDriver driver;//parent handle
	public static WebDriver browserStart(String name) 
	{
		
	
	if(name.equalsIgnoreCase("chrome"))
	{
		
		System.setProperty("webdriver.chrome.driver",".\\Drivers\\chromedriver.exe ");
	 driver=new ChromeDriver();//child object-so child functio viewed
	}
	else if(name.equalsIgnoreCase("firefox"))
	{
		System.setProperty("webdriver.gecko.driver",".\\Drivers\\geckodriver.exe ");
		driver=new FirefoxDriver();
	}
	driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	return driver;
}
}