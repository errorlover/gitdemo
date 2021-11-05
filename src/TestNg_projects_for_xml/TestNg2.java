package TestNg_projects_for_xml;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Test;

public class TestNg2 {
	//WebDriver dr;
	@Test
	public void method1() {
		System.setProperty("webdriver.edge.driver","Drivers\\msedgedriver.exe");
		WebDriver dr = new EdgeDriver();
		dr.get("https://www.google.com");
	}
	@Test
	public void method2() {
		System.setProperty("webdriver.edge.driver","Drivers\\msedgedriver.exe");
		WebDriver dr = new EdgeDriver();
		dr.get("https://demo.opencart.com");
	}
}
