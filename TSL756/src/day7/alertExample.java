package day7;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import util.Base;

public class alertExample extends Base{
  @Test
  public void f() throws Exception {
	  driver.get("https://www.magneticautomation.in/2019/01/alert-example.html");
	  driver.findElement(By.xpath("//button[@onclick='myFunction1()']")).click();
	  Alert A = driver.switchTo().alert();
	  String txt=A.getText();
	  System.out.println(txt);
	  Thread.sleep(5000);
	  A.accept();
	  Thread.sleep(2000);
	  
	  driver.findElement(By.xpath("//button[@onclick='myFunction()']")).click();
	  Alert A2 = driver.switchTo().alert();
	  System.out.println(A2.getText());
	  Thread.sleep(2000);
	  A2.sendKeys("john cena");
	  Thread.sleep(2000);
	  A2.dismiss();
}
}
