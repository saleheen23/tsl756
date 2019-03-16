package day7junit;

import static org.junit.Assert.*;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

public class HeadlessExecution {
static WebDriver driver;
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		
		System.setProperty("webdriver.gecko.driver",".\\Drivers\\geckodriver.exe");
		FirefoxOptions op =new FirefoxOptions();
		op.addArguments("---headless");
		op.addArguments("--start- maximized");
		driver=new FirefoxDriver(op);
		
		//driver.manage().window().maximize();
		
		
		
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		
		driver=new HtmlUnitDriver(true);
	}

	@Test
	public void test() {
		driver.get("https://www.seleniumhq.org/download/");
		assertEquals("Downloads", driver.getTitle());
		assertTrue(driver.findElement(By.linkText("Maven users")).isDisplayed());
		
	
	}

}
