//grouping tutorial
package TestNg_projects;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestNg4 {
	@BeforeTest
	public void setup() {
		System.out.println("set the browser configurations");
	}
	@Test(priority=1,groups="Login Page") 
	public void loginModule() 
	{ 
		System.out.println("Provide the credentials of webpage"); 
	} 
	@Test(priority=4,groups="Login Page") 
	public void forgotPasswordPage() 
	{ 
		System.out.println("click on Forgot password link and enter the required credentials"); 
	} 
	@Test(priority=2,groups="Home Page") 
	public void desktopPage() 
	{ 
		System.out.println("desktopPage"); 
	}
	@Test(priority=3,groups="Home Page") 
	public void phonePage() 
	{ 
		System.out.println("phone page"); 
	}
}
