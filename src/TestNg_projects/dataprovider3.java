package TestNg_projects;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class dataprovider3 {
	@Test(dataProvider="sendData")
	public void getData(String name,String pwd) {
		System.out.print(name+"-"+pwd);
		System.out.println();
		
	}
	@DataProvider
	public String[][] sendData()
	{
		String[][] data = new String[2][2];
		
		data[0][0] = "user1";
		data[0][1] = "password1";
		
		data[1][0] = "user2";
		data[1][1] = "password2";
		
		return data;
	}
}
