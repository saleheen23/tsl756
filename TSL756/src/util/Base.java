package util;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;

public class Base {
	
	public static WebDriver driver;
	
  @BeforeTest(alwaysRun=true)
  @Parameters("browser")
  public void beforeTest(String browser) {
	  if(browser.equalsIgnoreCase("firefox"))
	  driver=BrowserSetup.browserStart("firefox");
	  else if (browser.equalsIgnoreCase("chrome"))
		  driver=BrowserSetup.browserStart("chrome");
  }

  @AfterTest
  public void afterTest() {
	  driver.quit();
  }

}
