package TestNg_projects;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

public class dataprovider2 {
	WebDriver dr;
	@BeforeTest
	public void setTheBrowser()
	{
		System.setProperty("webdriver.edge.driver", "Drivers\\msedgedriver.exe");
		dr = new EdgeDriver();
		dr.manage().window().maximize();
		dr.get("https://opensource-demo.orangehrmlive.com/");
	}
	@Test(dataProvider="dataSender")
	public void dataProvider(String name,String pwd) {
		dr.findElement(By.xpath("//*[@id=\"txtUsername\"]")).sendKeys(name);
		dr.findElement(By.xpath("//*[@id=\"txtPassword\"]")).sendKeys(pwd);
		dr.findElement(By.name("Submit")).click();
		dr.findElement(By.xpath("//*[@id='welcome']")).click();
		dr.findElement(By.linkText("Logout")).click();
	}
	@DataProvider()
	public String[][] dataSender() throws BiffException, IOException {
		String[][] data = Excel.sendsData();
		
		return data;
	}
class Excel{
	public static String[][] sendsData() throws BiffException, IOException{
		File f = new File("C:\\Users\\raviteja sunkara\\Desktop\\selenium files\\Book1.xls");
		Workbook wb = Workbook.getWorkbook(f);
		Sheet s = wb.getSheet(0);
		int rows = s.getRows();
		int cols = s.getColumns();
		String[][] str = new String[rows-1][cols];
		for(int i=1;i<rows;i++) {
			for(int j=0;j<cols;j++) {
				Cell c = s.getCell(j,i);
				str[i-1][j] = c.getContents();
			}
		}
		return str;
		
	}
	
}
	
}
