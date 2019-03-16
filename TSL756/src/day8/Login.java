package day8;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Login {
	private WebDriver driver;
	private WebDriver idriver;

	Login(WebDriver idriver){
		
		this.driver=idriver;
	}

	private By e_username=By.name("p_t01");
	private By e_password=By.name("p_t02");
	private By e_login=By.xpath("//*[@value='Login']");
	private By e_getting=By.xpath("//*[@value='Getting Started']");
	
	public void LoginProcess(String UN, String PWD) {
		driver.findElement(e_username).sendKeys(UN);
		driver.findElement(e_password).sendKeys(PWD);
		driver.findElement(e_login).click();
	}

}
