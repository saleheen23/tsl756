package in.lnt.TestNG;

import org.testng.annotations.Test;
import org.testng.internal.annotations.ITest;

import util.BrowserSetup;
import util.Excel;

import org.testng.annotations.DataProvider;
import org.testng.annotations.BeforeTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;

public class para {
	WebDriver driver;
	
  @Test(dataProvider = "dp")
  public void f(String un, String pw) {
	  
	  driver.get("http://127.0.0.1:8080/htmldb/f?p=4550:11:7964654105214463289::NO:::");
	  driver.findElement(By.cssSelector("input#P11_USERNAME")).clear();
		driver.findElement(By.cssSelector("input[type='password']")).clear();

		driver.findElement(By.cssSelector("input#P11_USERNAME")).sendKeys(un);
		driver.findElement(By.cssSelector("input[type='password']")).sendKeys(pw);
		driver.findElement(By.cssSelector("input[value='Login']")).click();
		driver.findElement(By.cssSelector("img[title='Logout']")).click();
		driver.findElement(By.cssSelector("a.htmldbInstruct")).click();
  }

  @DataProvider
  public Object[][] dp() {
	  
	  Object[][] data=new Object[4][2];
	  Excel excel= new Excel("C:\\Users\\vshadmin\\Desktop\\abc.xlsx");
	  for(int i=0;i<=excel.rowCount("Sheet1");i++)
	  {
		  data[i][0]=excel.Read("Sheet1",i,0);
		  data[i][1]=excel.Read("Sheet1",i,1);
	  }
	 /* Object[][] data=new Object[4][2];
	  data[0][0]= "sys";
	  data[0][1]= "Newuser123";
	  data[1][0]= "system";
	  data[1][1]= "Newuser123";
	  data[2][0]= "sysXYZ";
	  data[2][1]= "sys";
	  data[3][0]= "sysPQR";
	  data[3][1]= "syspass";
	*/
	  return data;
    };
  
    @AfterMethod
    public void AfterMethod(ITestResult result)
    {
    	System.out.println(ITestResult.FAILURE);
    	System.out.println(ITestResult.SUCCESS);
    	System.out.println(ITestResult.SKIP);
    	
    	if(result.getStatus()==ITestResult.FAILURE)
    	{
    		System.out.println("Taking Screenshot");
    		BrowserSetup.getScreenShot(result.getName());
    	}
    	
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
