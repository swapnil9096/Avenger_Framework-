package Tests;

import java.util.Random;

import org.testng.annotations.DataProvider;

import Pages.HomePage;

public class DataSet {

	HomePage homepage = new HomePage();

	//Inputs for search links 
	@DataProvider(name = "getLinks")
	public Object[][] getLink() {

		Object[][] data = { { "Admin", homepage.oneLink }, { "pim", homepage.oneLink }, { "leave", homepage.oneLink },
				{ "time", homepage.oneLink }, { "recruitment", homepage.oneLink }, { "my info", homepage.oneLink },
				{ "performance", homepage.oneLink }, { "dashboard", homepage.oneLink },
				{ "directory", homepage.oneLink }, { "maintenance", homepage.oneLink }, { "buzz", homepage.oneLink }

		};
		return data;

	}

	
	@DataProvider(name = "getText")
	public Object[][] getTextUsername() {

		Object[][] data = {

								{ "admin", "valid" },
								{ " admin", "invalid" }, 
								{ "admin ", "valid" }, 
								{ "admin123", "invalid" } 
				
							};
		return data;

	}

	//Creating random employee id
	@DataProvider(name="addEmpId")
	public String[] getRandomNumbers() {
		Random random = new Random();
		int number = random.nextInt(85);

		String ranNo = String.valueOf(number);

		String[] str = {ranNo};
		return str;

	}
	
	
	//Invalid credentials for login
	@DataProvider(name="InvalidCredentials")
	public Object[][] getData()
	{
		Object [] [] data = { 
				{"Hello","Hello"},
				{" ","admin123"},
				{"Admin"," "}
		};
		
		return data;
	}
	
	
}
