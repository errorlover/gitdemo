package TestNg_projects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestNg3 {
	WebDriver dr;
	@BeforeTest
	public void setUp()
	{
		System.out.println("setting the browser");
		System.setProperty("webdriver.edge.driver", "MyDrivers\\msedgedriver.exe");
		dr = new EdgeDriver();
		dr.manage().window().maximize();
		dr.get("https://demo.opencart.com/");
	}
	@Test
	public void login() {
		String url = dr.getCurrentUrl();
		Assert.assertEquals(url, "https://demo.opencart.com/");
		dr.findElement(By.xpath("//*[@id=\"top-links\"]/ul/li[2]/a")).click();
		dr.findElement(By.xpath("//*[@id=\"top-links\"]/ul/li[2]/ul/li[2]/a")).click();
		dr.findElement(By.xpath("//input[@name='email']")).sendKeys("hemanth1@gmail.com");
		dr.findElement(By.xpath("//input[@name='password']")).sendKeys("wipro@123");
		dr.findElement(By.xpath("//input[@value='Login']")).click();
	}
	@AfterTest
	public void close()
	{
		System.out.println("closing the browser");
		dr.close();
	}
	
}
