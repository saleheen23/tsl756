package day7;

import java.io.FileInputStream;
import java.util.Properties;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import util.Base2;

public class ReadProperty extends Base2 {
  @Test
  public void Read() throws Exception {
	  Properties prop=new Properties();
	  prop.load(new FileInputStream(".\\anwarproj.property"));
	  driver.get(prop.getProperty("URL"));
	  driver.findElement(By.linkText(prop.getProperty("e_download"))).click();
  }
  public By element(String Value)
  {
	  By B=null;
	  if(Value.endsWith("_linktext"))
		  B=By.linkText(Value.split("_")[0]);
	  return B;
  }
}
