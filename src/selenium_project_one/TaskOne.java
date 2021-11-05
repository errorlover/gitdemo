package selenium_project_one;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.google.common.io.Files;

public class TaskOne {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "Drivers\\chromedriver.exe"); 
		WebDriver d = new ChromeDriver();
		d.manage().window().maximize();
		d.get("https:\\www.calculator.net/");
		d.findElement(By.xpath("//a[text()='Body Fat Calculator']")).click();
		d.findElement(By.id("csex2")).click();
		WebElement element = d.findElement(By.xpath("//input[@name='cage']")); 
		element.clear();
		element.sendKeys("30");
		//----------
		element = d.findElement(By.xpath("//input[@name='cweightkgs']")); 
		element.clear();
		element.sendKeys("60");
		//------------
		element = d.findElement(By.xpath("//input[@name='cheightmeter']")); 
		element.clear();
		element.sendKeys("180");
		//-------------
		element = d.findElement(By.xpath("//input[@name='cneckmeter']")); 
		element.clear();
		element.sendKeys("50");
		//-------------
		element = d.findElement(By.cssSelector("input#cwaistmeter")); 
		element.clear();
		element.sendKeys("88");
		element = d.findElement(By.cssSelector("input#chipmeter")); 
		element.clear();
		element.sendKeys("90");
		//calculatee
		d.findElement(By.xpath("//input[@value='Calculate']")).click();
		TakesScreenshot t = (TakesScreenshot)d;
		File f = t.getScreenshotAs(OutputType.FILE);
		File destiny = new File("screenshots//bodyFat.png");
		try {
			Files.copy(f, destiny);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
