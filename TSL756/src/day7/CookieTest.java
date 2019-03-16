package day7;
import java.util.Set;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.testng.annotations.Test;

import util.Base;

public class CookieTest extends Base{
  @Test
  public void Oracle() throws Exception
  {
	  driver.get("http://127.0.0.1:8080/htmldb/f?p=4550:11:4931473861266658635::NO:::");
	  driver.findElement(By.name("p_t01")).sendKeys("sys");
	  driver.findElement(By.name("p_t02")).sendKeys("Newuser123");
	  driver.findElement(By.cssSelector("input[value='Login']")).click();
	  driver.manage().deleteAllCookies();
	  driver.navigate().refresh();
	  Assert.assertTrue(driver.findElement(By.name("p_t01")).isDisplayed());
	  Thread.sleep(3000);
	  }
  }

