package TestNg_projects;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestNg2 {
	@BeforeTest
	public void beforeTest() {
		System.out.println("this is before test");
	}
	@Test
	public void test() {
		System.out.println("this is test");
	}
	@AfterTest
	public void afterTest() {
		System.out.println("this is after test");
	}
	@Test
	public void test2() {
		System.out.println("this is after test2");
	}
	@AfterMethod
	public void afterMethod() {
		System.out.println("this is after method");
	}
	@BeforeMethod
	public void beforeMethod() {
		System.out.println("this is before method");
	}

}
