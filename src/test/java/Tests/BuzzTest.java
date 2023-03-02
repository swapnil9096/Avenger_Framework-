package Tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Pages.BaseTest;
import Pages.BuzzPage;
import Pages.HomePage;
import Pages.LoginPage;

public class BuzzTest extends BaseTest{

	LoginPage loginpage;
	HomePage homepage;
	BuzzPage buzzPage;
	
	public BuzzTest()
	{
		super();
	}
	
	@BeforeMethod
	public void setUp()
	{
		init();
		loginpage = new LoginPage();
		homepage  = new HomePage();
		buzzPage  = new BuzzPage();
	}
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}
	
	@Test
	public void verifyBuzzPost()
	{
		//getting login
		loginpage.getLogin("Admin","admin123");
		
		//click on buzz link
		homepage.clickOnBuzzLink();
		
		//enter text in news feed
		buzzPage.enterPostText("Hello");
		
		//click on post button
		buzzPage.postBtn();
		
		//getting confirmation message
		String expResult = buzzPage.getConfirmationMessaage();
		
		System.out.println(expResult);
		
		Assert.assertEquals(expResult, "Successfully Saved","Test case Failed...!!");
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}
}
