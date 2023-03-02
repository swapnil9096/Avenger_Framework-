package Tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Pages.BaseTest;
import Pages.HomePage;
import Pages.LoginPage;

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
	public void tearDown()
	{
		driver.quit();
	}
	
	
	@Test
	public void verifyLoginWthValidCredentials()
	{
		loginpage.getLogin("Admin", "admin123");
		String expected = homepage.getLogoDisplayed();
		Assert.assertEquals("true",expected,"Logo is not displaying...!!");
		
	}
	
	
	@Test(dataProvider="InvalidCredentials")
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
