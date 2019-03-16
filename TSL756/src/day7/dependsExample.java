package day7;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import util.Base;

public class dependsExample extends Base{
	@Test
	public void f() {
		driver.get("https://google.com");
		Assert.assertEquals(driver.getTitle(), "Google");
	}

	@Test(dependsOnMethods="f")
	public void f1() {
		boolean display=driver.findElement(By.name("q")).isDisplayed();
		Assert.assertTrue(display);

	}

	@Test(dependsOnMethods="f1")
	public void f2() throws Exception {
		String data="MakeMyTrip";
		System.out.println("In test3");
		driver.findElement(By.name("q")).sendKeys(data);
		new WebDriverWait(driver,20).until(ExpectedConditions.elementToBeClickable(By.name("btnK")));
		driver.findElement(By.name("btnK")).click();
		Assert.assertEquals(driver.getTitle(), data+" - Google Search");
		//Assert.assertTrue(driver.getTitle().contains(arg0));

	}
}
