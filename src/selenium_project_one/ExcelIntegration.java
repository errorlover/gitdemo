package selenium_project_one;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

public class ExcelIntegration {

	public static void main(String[] args) throws BiffException, IOException {
		// TODO Auto-generated method stub
		//WebDriver d = new EdgeDriver();
		//d.manage().window().maximize();
		File f = new File("C:\\Users\\raviteja sunkara\\OneDrive\\Desktop\\xl.xls");
		Workbook wb = Workbook.getWorkbook(f);
		Sheet s = wb.getSheet(0);
		int rows = s.getRows();
		int cols = s.getColumns();
		System.out.println(rows+" "+cols);
		String[] str = new String[cols];
		for(int r=0;r<rows;r++) {
			for(int c=0;c<cols;c++) {
				Cell x = s.getCell(c,r);
				str[c] = x.getContents();
				System.out.println(str[c]);
			}
			application(str);
		}

	}
	public static void application(String[] val) {
		System.setProperty("webdriver.edge.driver", "MyDrivers\\msedgedriver.exe"); 
		WebDriver d = new EdgeDriver();
		d.manage().window().maximize();
		d.get("https://demo.opencart.com/");
		d.findElement(By.xpath("//*[@id=\"top-links\"]/ul/li[2]/a")).click();
		d.findElement(By.xpath("//*[@id=\"top-links\"]/ul/li[2]/ul/li[2]/a")).click();
		d.findElement(By.xpath("//*[@id=\"input-email\"]")).sendKeys(val[0]);
		d.findElement(By.xpath("//*[@id=\"input-password\"]")).sendKeys(val[1]);
		d.findElement(By.xpath("//*[@id=\"content\"]/div/div[2]/div/form/input")).click();
		d.findElement(By.xpath("//*[@id=\"column-right\"]/div/a[13]"));
	}

}
