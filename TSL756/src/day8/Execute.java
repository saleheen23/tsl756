package day8;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import util.Base2;

public class Execute extends Base2 {
  @Test
  public void f() throws Exception {

	  //WebDriver driver;
	  
	  Login login= new Login(driver);
	  driver.get("http://127.0.0.1:8080/htmldb");
	  login.LoginProcess("system", "Newuser123");
	  System.out.println("Login done");
	  
	  SQL_Command sql= new SQL_Command(driver);
		

	  
	  sql.startSql();
	  Thread.sleep(1000);
	  sql.startsqlComm();
	  Thread.sleep(1000);
	  sql.executeCommand();
	  Thread.sleep(1000);
	   sql.LogoutProcess();
	  Thread.sleep(1000);
  }
}