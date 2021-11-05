package selenium_project_one;
import org.openqa.selenium.By; 
import org.openqa.selenium.WebDriver; 
import org.openqa.selenium.edge.EdgeDriver; 
public class project1 { 
	public static void main(String[] args) { 
		// TODO Auto-generated method stub 
		// set the property - set the path of the driver 
		System.setProperty("webdriver.edge.driver","Drivers\\msedgedriver.exe"); 
		// webdriver.chrome.driver 
		//webdriver.gecko.driver 
		//create a Webdriver instance 
		WebDriver dr = new EdgeDriver(); 
		// maximize the screen 
		dr.manage().window().maximize(); 
		// launch the url - get(); 
		dr.get("https://demo.opencart.com/"); 
		// how to get the title of the page 
		System.out.println("Title of the page is "+dr.getTitle()); 
		System.out.println("Url of the page : "+dr.getCurrentUrl()); 
		dr.findElement(By.xpath("//*[@id=\"top-links\"]/ul/li[2]/a/span[1]")).click(); 
		//dr.findElement(By.xpath("//a[text()='Login']")).click(); 
		dr.findElement(By.xpath("//*[@id=\"top-links\"]/ul/li[2]/ul/li[2]/a")).click();
		// xpath = //tagname[@attribute ='value of the attribute'] 
		dr.findElement(By.name("email")).sendKeys("hemanth1@gmail.com"); 
		dr.findElement(By.id("input-password")).sendKeys("wipro@123"); 
		dr.findElement(By.xpath("//input[@value='Login']")).click(); 
		//dr.close(); 
} 
}