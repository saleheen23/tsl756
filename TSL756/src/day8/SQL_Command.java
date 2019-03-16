package day8;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SQL_Command {
	private WebDriver driver;
	private WebDriver idriver;
	public SQL_Command(WebDriver idriver) {
		// TODO Auto-generated constructor stub
		this.driver=idriver;
	}
	private By e_type=By.name("p_t04");
	private By e_run=By.xpath("//*[@value='Run']");
	private By e_getting=By.linkText("Logout");
	private By e_sql=By.xpath("//*[@title='SQL']");
	private By e_sqlcomm=By.xpath("//*[@title='SQL Commands']");
	void startSql()
	{
		driver.findElement(e_sql).click();
	}
	void startsqlComm()
	{
		driver.findElement(e_sqlcomm).click();
	}
	void executeCommand()
	{
		driver.findElement(e_type).sendKeys("select 2+3 from dual");
		driver.findElement(e_run).click();
	}
	
	void LogoutProcess()
	{
		driver.findElement(e_getting).click();
		System.out.println("Logout done");
	}

}
