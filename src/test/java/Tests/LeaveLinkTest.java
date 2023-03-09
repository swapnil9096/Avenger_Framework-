package Tests;

import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Pages.BaseTest;
import Pages.HomePage;
import Pages.LeavePage;
import Pages.LoginPage;

public class LeaveLinkTest extends BaseTest{

	LoginPage loginpage ;
	HomePage homepage ;
	LeavePage  leavepage ;
	
	public	LeaveLinkTest()
	{
		super();
	}
	
	@BeforeMethod
	public void setUp()
	{
		init();
		loginpage = new LoginPage();
		homepage = new HomePage();
		leavepage = new LeavePage();
	}
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}
	
	//verifying leave list functionality
	@Test
	public void verifyMyLeaveLink() throws InterruptedException
	{
		loginpage.getLogin("Admin", "admin123");
		
		//click on leave
		homepage.leave();
		
		//innerLink
		leavepage.clickOnMyLeaveLink();
		Thread.sleep(3000);
		
		//give the dates yyyy-mm-dd
		leavepage.enterTextFromDate("1999-12-24");
		leavepage.enterTextToDate("2022-12-26");
		
		leavepage.clickOnLeaveTypeIcon();
		
		Actions action = new Actions(driver);
		action.keyDown(Keys.ARROW_DOWN).keyUp(Keys.ARROW_DOWN).click().build().perform();

		driver.navigate().back();
		leavepage.clickOnSubmitBtn();
		
		String actMsg = leavepage.noRecordErrorPopUp();
		System.out.println(actMsg);
		
		Assert.assertEquals(actMsg, "No Records Found" , "Test Case Failed...!!");
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
