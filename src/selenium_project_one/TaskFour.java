package selenium_project_one;

import java.io.File;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TaskFour {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "Drivers\\chromedriver.exe");
		WebDriver wd = new ChromeDriver();
		wd.manage().window().maximize();
		wd.get("https://compendiumdev.co.uk/basic_html_form.html");
		WebElement e = wd.findElement(By.xpath("//input[@name='username']"));
		e.clear();
		e.sendKeys("ravi1@gmail.com");
		e = wd.findElement(By.xpath("//input[@name='password']"));
		e.clear();
		e.sendKeys("123456789");
		e = wd.findElement(By.xpath("//*[@id=\"HTMLFormElements\"]/table/tbody/tr[3]/td/textarea"));
		e.clear();
		e.sendKeys("Enter some text here...!");
		File f = new File("D:\\a.txt");
		wd.findElement(By.xpath("//input[@name='filename']")).sendKeys("D:\\a.txt");
		//wd.findElement(By.xpath("//*[@id=\"HTMLFormElements\"]/table/tbody/tr[5]/td/input[1]")).clear();//1
	}

}
