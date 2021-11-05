package TestNg_projects_for_xml;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Test;
import org.testng.annotations.Parameters;

public class TestNg1 {
	@Test
	@Parameters({"url","emailId","password"})
	public void application(String url,String name,String pwd) 
	{
		System.setProperty("webdriver.edge.driver", "Drivers\\msedgedriver.exe");
		WebDriver dr = new EdgeDriver();
		dr.manage().window().maximize();
		dr.get(url);
		dr.findElement(By.xpath("//span[text()='My Account']")).click();
		dr.findElement(By.linkText("Login")).click();
		dr.findElement(By.name("email")).sendKeys(name);
		dr.findElement(By.name("password")).sendKeys(pwd);
		dr.findElement(By.xpath("//*[@id=\"content\"]/div/div[2]/div/form/input")).click();
	}
}
