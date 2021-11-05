package selenium_project_one;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class dummy {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String path = "Drivers\\chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", path);
		WebDriver dr = new ChromeDriver();
		dr.manage().window().maximize();
		dr.get("https://opensource-demo.orangehrmlive.com/");
		dr.findElement(By.name("txtUsername")).sendKeys("admin");
		dr.findElement(By.id("txtPassword")).sendKeys("admin123");
		dr.findElement(By.xpath("//*[@id=\"btnLogin\"]")).click();
		dr.findElement(By.xpath("//*[@id=\"welcome\"]")).click();
		//dr.findElement(By.linkText("Logout")).click();
		dr.findElement(By.xpath("//*[@id=\"welcome-menu\"]/ul/li[3]/a")).click();
	}

}
