package selenium_project_one;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

public class TaskThree {

	public static void main(String[] args) throws BiffException, IOException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "Drivers\\chromedriver.exe");
		WebDriver wd = new ChromeDriver();
		wd.manage().window().maximize();
		wd.get("https://www.calculator.net/");
		wd.findElement(By.xpath("//*[@id=\"contentout\"]/div/a/img")).click();
		wd.findElement(By.xpath("//a[text()='Gas Mileage Calculator']")).click();
		File f = new File("C:\\Users\\raviteja sunkara\\Desktop\\selenium files\\task3.xls");
		Workbook wb = Workbook.getWorkbook(f);
		Sheet s = wb.getSheet(0);
		int rows = s.getRows();
		int cols = s.getColumns();
		String[] str = new String[cols];
		Cell c1 = s.getCell(0,1);
		str[0] = c1.getContents();
		Cell c2 = s.getCell(1,1);
		str[1] = c2.getContents();
		Cell c3 = s.getCell(2,1);
		str[2] = c3.getContents();
		Cell c4 = s.getCell(3,1);
		str[3] = c4.getContents();
		//System.out.println(str[0]+" "+str[1]+" "+str[2]+" "+str[3]);
		//System.out.print(rows+" "+cols);
		WebElement e = wd.findElement(By.xpath("//input[@name='mucodreading']"));
		e.clear();
		e.sendKeys(str[0]);
		e = wd.findElement(By.xpath("//input[@name='mupodreading']"));
		e.clear();
		e.sendKeys(str[2]);
		e = wd.findElement(By.xpath("//input[@name='mugasputin']"));
		e.clear();
		e.sendKeys(str[3]);
		e = wd.findElement(By.xpath("//input[@name='mugasprice']"));
		e.clear();
		e.sendKeys(str[3]);
		wd.findElement(By.xpath("//*[@id=\"metric\"]/tbody/tr[5]/td/input")).click();
		String xx = wd.findElement(By.xpath("//*[@id=\"content\"]/p[2]/font/b")).getText();
		System.out.println(xx);		

	}

}
