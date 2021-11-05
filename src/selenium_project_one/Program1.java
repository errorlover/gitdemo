package selenium_project_one;
import java.io.File;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.Select;

import com.google.common.io.Files;
import com.sun.org.apache.bcel.internal.generic.Select; 
 public class Program1 {
	 static WebDriver dr;
	 public static void main(String[] args) { 
		 // TODO Auto-generated method stub
		 // set the property - set the path of the driver 
		 System.setProperty("webdriver.edge.driver","Drivers\\msedgedriver.exe"); 
		 dr = new EdgeDriver();
		 dr.get("https://www.calculator.net");
		 dr.manage().window().maximize();
		 dr.findElement(By.xpath("//*[@id=\"contentout\"]/div/a/img")).click();
		 dr.findElement(By.xpath("//*[@id=\"sl1\"]/table/tbody/tr[1]/td[2]/a")).click();
		 WebElement e = dr.findElement(By.xpath("//*[@id=\"cloanamount\"]"));
		 e.clear();
		 e.sendKeys("123456");
		 e = dr.findElement(By.xpath("//*[@id=\"cloanterm\"]"));
		 e.clear();
		 e.sendKeys("6");
		 e = dr.findElement(By.cssSelector("input#cloantermmonth"));
		 e.clear();
		 e.sendKeys("10");
		 e=dr.findElement(By.cssSelector("input#cinterestrate"));
		 e.clear();
		 e.sendKeys("5");
		 Select s = new Select(dr.findElement(By.id("ccompound")));
		 s.selectByValue("annually");
		 s=new Select(dr.findElement(By.id("cpayback")));
		 s.selectByIndex(4);
		 dr.findElement(By.xpath("//input[@value='Calculate']")).click();
		 String val = dr.findElement(By.xpath("//table/tbody/tr[1]/td[2]/b")).getText();
		 System.out.print(val);
		 screenshot("screenshots\\pic1.png");
	 }
	 public static void screenshot(String filepath) {
		 TakesScreenshot ts = (TakesScreenshot)dr;
		 File scr = ts.getScreenshotAs(OutputType.FILE);
		 File destination = new File(filepath);
		 try {
			Files.copy(scr, destination);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	 }
 }
