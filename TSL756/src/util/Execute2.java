package util;

import org.testng.annotations.Test;

public class Execute2 extends Base2{
  @Test
  public void f() {
  	  
  KeyWords Key=new KeyWords(driver);
  Key.openUrl("https://opensource-demo.orangehrmlive.com/");
  Key.type("txtUsername_name","admin");
  Key.type("txtPassword_id","admin123");
  Key.click("//*[@type='submit']_xpath");
  Key.click("//*[@id='welcome']_xpath");
  Key.click("Logout_linktext");
  }

}
 