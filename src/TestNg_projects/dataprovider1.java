package TestNg_projects;

	import java.io.File;
	import java.io.IOException;
	import java.util.concurrent.TimeUnit;
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
	public class dataprovider1 {
		
		WebDriver dr;
		@BeforeTest
		public void setUp()
		{
			System.setProperty("webdriver.edge.driver", "Drivers\\msedgedriver.exe");
			dr= new EdgeDriver();
			dr.manage().window().maximize();
			dr.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			dr.get("https://opensource-demo.orangehrmlive.com/");
		}
		
		@Test(dataProvider = "getData")
		public void login(String name, String pwd)
		{
			dr.findElement(By.name("txtUsername")).sendKeys(name);
			dr.findElement(By.id("txtPassword")).sendKeys(pwd);
	dr.findElement(By.name("Submit")).click();
			dr.findElement(By.linkText("Welcome Anton")).click();
			dr.findElement(By.linkText("Logout")).click();
		}
		
		@DataProvider
		public String[][] getData() throws BiffException, IOException
		{
			String[][] data = Excel.testData();
			
			return data;
		}
		
	}
	class Excel
	{
		public static String[][] testData() throws BiffException, IOException
		{
			File f = new File("C:\\Users\\raviteja sunkara\\Desktop\\selenium files\\Book1.xls");
			Workbook w = Workbook.getWorkbook(f);
			Sheet sh = w.getSheet(0);
			int row= sh.getRows();
			int col = sh.getColumns();
			
			String[][] str = new String[row-1][col];
			
			for(int i = 1;i<row;i++)
			{
				for(int j= 0 ;j<col;j++)
				{
					Cell c = sh.getCell(j, i);
					str[i-1][j] = c.getContents();
				}
			}
			return str;
		}
	}

