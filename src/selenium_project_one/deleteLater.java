package selenium_project_one;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.Select;
import com.google.common.io.Files;
public class deleteLater {
static WebDriver dr;//global variable
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.edge.driver","Drivers\\msedgedriver.exe");
		dr=new EdgeDriver();
		dr.manage().window().maximize();
		dr.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		dr.get("https://www.calculator.net/");
		// to Calculate number of links which are available 
		int links=dr.findElements(By.tagName("a")).size();
		System.out.println("Number of links in a page :"+links);
		// To open or to click on all calculator 
		dr.findElement(By.xpath("//div[@id='contentout']/div[1]/a/img")).click();
		// To open or to click on Loan calculator 
		dr.findElement(By.linkText("Loan Calculator")).click();
		//instead of clear and giving the data-storing the data into the webelement
		WebElement element=dr.findElement(By.cssSelector("input#cloanamount"));
		element.clear();
		element.sendKeys("5000");
		// for the next field just call by its webelement
		element=dr.findElement(By.name("cloanterm"));
		element.clear();
		element.sendKeys("6");
		element=dr.findElement(By.name("cloanterm"));
		element.clear();
		element.sendKeys("6");
		element=dr.findElement(By.name("cloantermmonth"));
		element.clear();
		element.sendKeys("10");
		//If we have drop box to select anything--import the select package
		Select s=new Select (dr.findElement(By.id("ccompound")));
		//s.deselectAll();
		s.selectByVisibleText("Semi-annually"); // it is applicable if the tagname is select
		//If select by value then use the following
		s=new Select(dr.findElement(By.name("cpayback")));
		s.selectByValue("biweekly");
		dr.findElement(By.xpath("//input[@value='Calculate']")).click();
		//To capture the payment--the value go on changing
		String value=dr.findElement(By.xpath("//table/tbody/tr[1]/td[2]/b")).getText();
		System.out.println(value);
		screenshot("screenshots\\newPic.png");//calling of the method
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
