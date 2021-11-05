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
//import com.sun.org.apache.bcel.internal.generic.Select;
import org.openqa.selenium.support.ui.Select;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

public class TaskTwo {

	public static void main(String[] args) throws BiffException, IOException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "Drivers//chromedriver.exe");
		WebDriver d = new ChromeDriver();
		d.manage().window().maximize();
		d.get("https://petstore.octoperf.com/");
		d.findElement(By.xpath("//a[text()='Enter the Store']")).click();
		File f = new File("C:\\Users\\raviteja sunkara\\Desktop\\selenium files\\task2.xls");
		Workbook wb = Workbook.getWorkbook(f);
		Sheet s = wb.getSheet(0);
		int rows = s.getRows();
		int cols = s.getColumns();
		String[] str = new String[cols];
		//for username
		Cell c1 = s.getCell(0,1);
		str[0] = c1.getContents();
		System.out.println(str[0]);
		//for password
		Cell c2 = s.getCell(1,1);
		str[1] = c2.getContents();
		System.out.println(str[1]);
		//--------------------------------------------------------
		d.findElement(By.xpath("//a[text()='Sign In']")).click();
		WebElement e = d.findElement(By.xpath("//input[@name='username']"));
		e.clear();
		e.sendKeys(str[0]);
		e = d.findElement(By.xpath("//input[@name='password']"));
		e.clear();
		e.sendKeys(str[1]);
		d.findElement(By.xpath("//input[@name='signon']")).click();
		//sign in done
		d.findElement(By.xpath("//*[@id=\"MainImageContent\"]/map/area[2]")).click();
		//take a screenshot of fish page
		TakesScreenshot t = (TakesScreenshot)d;
		File ff = t.getScreenshotAs(OutputType.FILE);
		File destination2 = new File("screenshots//fishpage.png");
		Files.copy(ff, destination2);//screenshot done
		
		//displaying the product id of goldfish
		String text = d.findElement(By.xpath("//a[text()='FI-FW-02']")).getText();
		System.out.println("Product-ID of Gold Fish is : "+text);
		
		//clicking on product id of goldfish
		d.findElement(By.xpath("//a[text()='FI-FW-02']")).click();
		String text2 = d.findElement(By.xpath("//table//tbody//tr[2]//td[4]")).getText();
		//displaying the list price value of adult gold male fish
		System.out.println("List price value of the \"Adult Male Goldfish\" is : "+text2.substring(1, text2.length()));
		//taking screenshot of goldfish page
		TakesScreenshot t1 = (TakesScreenshot)d;
		File f1 = t1.getScreenshotAs(OutputType.FILE);
		File destiny2 = new File("screenshots//goldfishpage.png");
		Files.copy(f1, destiny2);
		//screenshot done
		
		//clicking on item id of adult female gold fish
		d.findElement(By.xpath("//a[text()='EST-20']")).click();
		//adding to cart
		d.findElement(By.xpath("//a[text()='Add to Cart']")).click();
		
		WebElement e1 = d.findElement(By.xpath("//input[@name='EST-20']"));
		e1.clear();
		e1.sendKeys("2");
		
		//updating cart
		d.findElement(By.xpath("//input[@name='updateCartQuantities']")).click();
		
		//displaying the total cost
		String totCost = d.findElement(By.xpath("//table//tbody//tr[2]//td[7]")).getText();
		System.out.println("Total Cost : "+totCost.substring(1, totCost.length()));
		
		//taking screenshot of total cost
		TakesScreenshot totalCost = (TakesScreenshot)d;
		File tc = totalCost.getScreenshotAs(OutputType.FILE);
		File newDestination = new File("screenshots//totalcost.png");
		Files.copy(tc, newDestination);
		//screenshot done
		
		//proceed to checkout
		d.findElement(By.linkText("Proceed to Checkout")).click();
		
		//selecting the mastercard
		Select s1 = new Select(d.findElement(By.name("order.cardType")));
		s1.selectByIndex(1);
		
		//selecting the check box 
		d.findElement(By.name("shippingAddressRequired")).click();
		
		//clicking on continue
		d.findElement(By.xpath("//input[@name='newOrder']")).click();
		
		//counting number of links in shipping address
		int size = d.findElements(By.tagName("a")).size();
		System.out.println("No.of links in \"shipping address page\" is : "+size);
		
		d.findElement(By.xpath("//input[@name='newOrder']")).click();
		
		d.findElement(By.linkText("Confirm")).click();
		
		String newText = d.findElement(By.xpath("//table//tbody//tr//th")).getText();
		System.out.println(newText);
		String textNew = newText.substring(7, 11);
		int order = Integer.parseInt(textNew);
		System.out.println("Order no excludes \"#\" and multiplied by 10 is : "+order*10);
		
		//taking screenshot of the page
		TakesScreenshot a = (TakesScreenshot)d;
		File F = a.getScreenshotAs(OutputType.FILE);
		File dest = new File("screenshots//finalpage.png");
		Files.copy(F, dest);
		//screenshot done
	}

}
