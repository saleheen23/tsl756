package day7junit;

import java.net.HttpURLConnection;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import util.BrowserSetup;

public class LinkImageTest 
{
	static WebDriver driver;
	@BeforeClass
	public static void setUpBeforeClass() throws Exception
	{
		driver=BrowserSetup.browserStart("chrome");
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception 
	{
		driver.quit();
	}

	@Test
	public void test() 
	{
		driver.get("http://newtours.demoaut.com");
		List<WebElement> alllinks=driver.findElements(By.xpath("//a"));
								alllinks.addAll(driver.findElements(By.tagName("img")));
		
		for(WebElement E: alllinks)
		{
			String url=	E.getAttribute("href");
			System.out.println(url);
			try {
				Proxy proxy = new Proxy(Proxy.Type.HTTP, 
						new InetSocketAddress("192.168.100.1", 8081));
				URL U=new URL(url);
				URLConnection C=U.openConnection(proxy);
				HttpURLConnection HC=(HttpURLConnection)C;
				HC.connect();
				
				int code=HC.getResponseCode();
				
				if(code==200)
				{
					System.out.println(url+" Working");
				}
				else
				{
					System.out.println(url+" Not working");
				}
			} catch (Exception e) 
			{
				System.out.println("Error with URL Check");
			}
		}
	}
	
	
	public void urlTest(String url) 
	{
		
	}
}