package selenium_project_one;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class programTwo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 System.setProperty("webdriver.edge.driver","Drivers\\msedgedriver.exe"); 
		WebDriver d = new EdgeDriver();
		d.get("https://www.google.com");
		d.manage().window().maximize();
		d.findElement(By.xpath("//*[@id=\"gb\"]/div/div[2]/a")).click();
		d.findElement(By.xpath("//*[@id=\"identifierId\"]")).sendKeys("suninthebluesky1999@gmail.com");
		d.findElement(By.xpath("//*[@id=\"identifierNext\"]/div/button/span")).click();
	}

}
