package in.lnt.TestNG;

import org.testng.annotations.Test;

import util.BrowserSetup;

import org.testng.annotations.BeforeTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterTest;

public class FirstNG {
	WebDriver driver;

	@Test(priority=1)
	public void title() {
		driver.get("https://www.google.com");
		String title = driver.getTitle();
		Assert.assertEquals(title, "Google");

	}
	@Test(priority=2)
	public void serachBoxTest()
	{
		WebElement E=driver.findElement(By.name("q"));
		Assert.assertEquals(E.isDisplayed(), true);
		Assert.assertEquals(E.isEnabled(), true);
		Assert.assertEquals(E.getAttribute("maxlength"),"2048","Max length not match");
	}
	

	@BeforeTest
	public void beforeTest() {
		driver = BrowserSetup.browserStart("chrome");

	}

	@AfterTest
	public void afterTest() {
		driver.quit();
	}

}
