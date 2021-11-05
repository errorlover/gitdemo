package TestNg_projects;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class dependsOnDemo {
	WebDriver dr;
	@BeforeTest
	public void setUp()
	{
		System.setProperty("webdriver.edge.driver", "MyDrivers\\msedgedriver.exe");
		dr= new EdgeDriver();
		dr.manage().window().maximize();
		dr.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		dr.get("https://opensource-demo.orangehrmlive.com/");
	}
	
	@Test
	public void login()
	{
		dr.findElement(By.name("txtUsername")).sendKeys("admin");
		dr.findElement(By.id("txtPassword")).sendKeys("admin123");
		dr.findElement(By.name("Submit")).click();
	}
	
	@Test(dependsOnMethods="login")
	public void logout()
	{
		dr.findElement(By.linkText("Welcome Anton")).click();
		dr.findElement(By.linkText("Logout")).click();
	}
}
