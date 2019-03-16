package in.lnt.TestNG;
import org.testng.annotations.Test;
import org.testng.internal.annotations.ITest;

import util.BrowserSetup;
import util.Excel;

import org.testng.annotations.DataProvider;
import org.testng.annotations.BeforeTest;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;

public class Para2 {
	WebDriver driver;
	 Connection c;
	 PreparedStatement stmt;
  @Test(dataProvider = "dp")
  public void login(String un, String pw) throws Exception{
	  
	  driver.get("http://127.0.0.1:8080/htmldb/f?p=4550:11:7964654105214463289::NO:::");
	  driver.findElement(By.cssSelector("input#P11_USERNAME")).clear();
		driver.findElement(By.cssSelector("input[type='password']")).clear();

		driver.findElement(By.cssSelector("input#P11_USERNAME")).sendKeys(un);
		driver.findElement(By.cssSelector("input[type='password']")).sendKeys(pw);
		driver.findElement(By.cssSelector("input[value='Login']")).click();
		stmt=c.prepareStatement("Update  Login set STATUS=? where USER_NAME=? and PASSWORD=?");
		stmt.setString(2,un);
	stmt.setString(3, pw);	
		driver.findElement(By.cssSelector("img[title='Logout']")).click();
		driver.findElement(By.cssSelector("a.htmldbInstruct")).click();
	
		
  }
  @DataProvider
  public Object[][] dp() throws Exception { 
	  DriverManager.registerDriver(new oracle.jdbc.OracleDriver());
	 c= DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "Newuser123");
	  ResultSet rs=c.createStatement().executeQuery("Select count(*) from Login");
	  rs.next();
	  Object data[][]= new Object[rs.getInt(1)][2];
	  int i=0;
	  ResultSet R= c.createStatement().executeQuery("select  * from Login");
	  while (R.next())
	  {
		  data[i][0]=R.getString(1);
		  data[i][1]=R.getString(2);
		  i++;
	  }
	  return data;
  }
	
	  
	  @AfterMethod () //Runs for each Test methods
	  public void AfterMethod(ITestResult result)
	  {
		  try {
			if(result.getStatus()==ITestResult.FAILURE)
			  {
				  System.out.println("Taking ScreenShot");
				  BrowserSetup.getScreenShot(result.getName());
			 	  	stmt.setString(1, "FAil");
			  }
			  else
			{
				  System.out.println("Hii");
					stmt.setString(1, "PASS");
			}
			  stmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	  }
	  

@BeforeTest
	public void BeforeTest()
	{
		driver = BrowserSetup.browserStart("chrome");
	}

@AfterTest
	public void AfterTest()
	{
	driver.quit();

	}

}