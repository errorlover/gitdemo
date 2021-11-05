package selenium_project_one;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class FlpikartApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver d = new EdgeDriver();
		System.setProperty("webdriver.edge.driver","Drivers\\msedgedriver.exe");
		d.get("https://www.flipkart.com");

	}

}
