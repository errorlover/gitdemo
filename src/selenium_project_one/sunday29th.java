package selenium_project_one;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class sunday29th {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.edge.driver", "Drivers\\msedgedriver.exe"); 
		WebDriver d = new EdgeDriver();
		d.manage().window().maximize();
		d.get("https://demo.opencart.com/");
		d.findElement(By.xpath("//*[@id=\"top-links\"]/ul/li[2]/a")).click();
		d.findElement(By.xpath("//*[@id=\"top-links\"]/ul/li[2]/ul/li[2]/a")).click();
		d.findElement(By.xpath("//*[@id=\"input-email\"]")).sendKeys("hemanth1@gmail.com");
		//d.findElement(By.xpath("//*[@id=\"input-email\"]")).sendKeys("hemanth1@gmail.com");
		d.findElement(By.xpath("//*[@id=\"input-password\"]")).sendKeys("wipro@123");
		d.findElement(By.xpath("//*[@id=\"content\"]/div/div[2]/div/form/input")).click();
		d.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
	}

}
