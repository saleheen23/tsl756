package day9;

import java.net.URL;

import org.junit.Assert;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

public class GridExample {
  @Test
  public void f() throws Exception{
	  DesiredCapabiltites dc=DesiredCapabilities.firefox();
	  dc.setPlatform(Platform.WINDOWS);
	  dc.setBrowserName("firefox");
	  
	  
	  WebDriver driver=new RemoteWebdriver(new URL(" http://192.168.100.147:4444/wd/hub"),dc);
	  driver.get("http://seleniumhq.org");
	  		Assert.assertEquals(driver.getTitle(),"Selenium - Web Browser Automation");
	  		driver.quit();
  }
}
