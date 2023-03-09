package Tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Pages.BaseTest;
import Pages.HomePage;
import Pages.LoginPage;
import Pages.PerformancePage;

public class PerformancePageTest extends BaseTest{


	LoginPage loginpage ;
	HomePage homepage;
	PerformancePage perPage;
	public PerformancePageTest()
	{
		super();
	}
	
	@BeforeMethod
	public void setUp()
	{
		init();
		loginpage = new LoginPage();
		homepage = new HomePage();
		perPage  = new PerformancePage();
	}
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}
	
	
	//verifying add log functionality
	@Test
	public void verifyAddLog()
	{
		//get login to application
		loginpage.getLogin("Admin", "admin123");
		
		//click on performance link
		homepage.clickOnPerformanceLink();
		
		//click on my tracker link
		perPage.clickOnMyTrackerLink();
		
		//click on view button
		perPage.clickOnViewBtn();
		
		//click on add log button
		perPage.clickOnAddLogBtn();
		
		//entering log text
		perPage.enterLogText("Pranav");
		
		//click on negative button
		perPage.clickOnNegativeBtn();
		
		//entering comment
		perPage.enterComment("Good");
		
		//click on save button
		perPage.clickOnSaveBtn();
		
		//getting confirmation message
		String expResult = perPage.getConfirmationMessage();
		
		System.out.println(expResult);
		
		//validation
		Assert.assertEquals(expResult, "Successfully Saved","Test Case Failed...!!");
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
