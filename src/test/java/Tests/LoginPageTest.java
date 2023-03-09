package Tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Pages.BaseTest;
import Pages.HomePage;
import Pages.LoginPage;
import Util.Utilities;

public class LoginPageTest extends BaseTest{
	LoginPage loginpage;
	HomePage homepage;
	
	
	public LoginPageTest()
	{
		super();
	}
	
	@BeforeMethod
	public void setUp()
	{
		init();
		loginpage = new LoginPage();
		homepage = new HomePage(); 
				
	}
	
	@AfterMethod
	public void tearDown() throws InterruptedException
	{
		Thread.sleep(4000);
		driver.quit();
	}
	
	
	// verifying the Login Functionality with Valid credentials us
	@Test
	public void verifyLoginWithValidCredentialsUsingExcel()
	{
		String un = null;
		String pwd = null;
		
		String fileName = "Valid_Credentials";
		String sheetName = "OrangeHRM";
		
		Object[][] str =Utilities.getExcelData(fileName, sheetName);
		int cnt = 0;
		
		for(int i=0;i<str.length;i++)
		{
			for(int j=0;j<str[0].length;++j)
			{
				if(cnt==0)
				{
					un = (String) str[i][j];
					loginpage.enterUsername(un);
				}else
				{
					pwd = (String) str[i][j];
					loginpage.enterPassword(pwd);
					loginpage.clickOnLoginBtn();
				}
				cnt++;
			}
		}
		String expected = homepage.getLogoDisplayed();
		Assert.assertEquals("true",expected,"Logo is not displaying...!!");
	}

	//verifying the Login Functionality With Invalid credentials using excel
	@Test 
	public void verifyLoginWithInvalidCredentials()
	{

		String un = null;
		String pwd = null;
		String fileName = "Invalid_Credentials";
		String sheetName = "InvalidCredentials";
		Object[][] data = Utilities.getExcelData(fileName,sheetName);
		int cnt = 1; 
		
		for(int i= 0;i<data.length;i++)
		{
			for(int j=0;j<data[0].length;j++)
			{
				if(cnt%2!=0)
				{
					un = (String) data[i][j];
					loginpage.enterUsername(un);
				}else
				{
					pwd = (String) data[i][j];
					loginpage.enterPassword(pwd);
					loginpage.clickOnLoginBtn();
					String Actual = loginpage.getLoginName();
					Assert.assertEquals(Actual, "Login","Test Case Passed...");
				}
				cnt++;
			}
		}
		
	}
	
	
	//verifying the Login Functionality with Valid credentials
	@Test
	public void verifyLoginWthValidCredentials()
	{
		loginpage.getLogin("Admin", "admin123");
		String expected = homepage.getLogoDisplayed();
		Assert.assertEquals("true",expected,"Logo is not displaying...!!");
		
	}
		
	//verifying the Login Functionality with Invalid credentials
	@Test(dataProvider="InvalidCredentials", dataProviderClass = DataSet.class)
	public void verifyLoginWthInvalidCredentials(String un,String pwd)
	{
		loginpage.enterUsername(un);
		loginpage.enterPassword(pwd);
		loginpage.clickOnLoginBtn();
		
		
		if(un.isBlank()||pwd.isBlank())
		{
			Assert.assertEquals("Required", loginpage.getErrorRequired(),"Wrong ErrorMessage for Blank Username/psasword!!!");
		}
		else
			Assert.assertEquals("Invalid credentials",loginpage.getInvalidError(),"Wrong ErrorMessage for Invalid username and password !!!");
	}
	
	
	
}
