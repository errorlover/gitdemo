package selenium_project_one;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

import com.google.common.io.Files;

public class FlipkartScreenshot {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.edge.driver", "Drivers\\msedgedriver.exe"); 
		WebDriver d = new EdgeDriver();
		d.manage().window().maximize();
		d.get("https://www.google.com");
		d.findElement(By.name("q")).sendKeys("amazon.com");
		d.findElement(By.xpath("/html/body/div[1]/div[3]/form/div[1]/div[1]/div[3]/center/input[1]")).click();
		d.findElement(By.xpath("//*[@id=\"rso\"]/div[1]/div/div/div/div/div/div[1]/a/h3")).click();
		TakesScreenshot t = (TakesScreenshot)d;
		File source = t.getScreenshotAs(OutputType.FILE);
		File Destination = new File("screenshots\\pic2.png");
		try {
			Files.copy(source, Destination);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
