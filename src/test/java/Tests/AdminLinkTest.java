package Tests;

import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Pages.AdminLinkPage;
import Pages.BaseTest;
import Pages.HomePage;
import Pages.LoginPage;

public class AdminLinkTest extends BaseTest {

	// creating instances of page classes
	HomePage homepage;
	LoginPage loginpage;
	AdminLinkPage adminlink;
	WebElement ele;
	String text ;
	// reading .properties file
	public AdminLinkTest() {
		super();
	}

	// open browser in BaseTest
	@BeforeMethod
	public void setUp() {
		init();
		homepage = new HomePage();
		loginpage = new LoginPage();
		adminlink = new AdminLinkPage();
	}

	// close browsers
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

	// verifying user ddl list of select user
	@Test
	public void verifySelectUserRoleDDL() throws InterruptedException {
		// login to app
		loginpage.getLogin("Admin", "admin123");

		// cliking on adminLink
		homepage.ClickAdminLink();

		// clicking on status ddl
		ele = adminlink.selectUserRoleDDL();
		ele.click();
		Thread.sleep(3000);

		Actions action = new Actions(driver);

		// Selecting admin option and print selected option
		action.keyDown(Keys.ARROW_DOWN).keyUp(Keys.ARROW_UP).build().perform();
		Thread.sleep(2000);
		System.out.println(adminlink.selectedElementUserRole().isDisplayed());
		ele = adminlink.selectedElementUserRole();
		text = ele.getText();
		System.out.println("Selected Element :=>" + text);
		
		Assert.assertEquals(text, "Admin","Test Case Failed.....");

		// Selecting admin option and print selected option
		action.keyDown(Keys.ARROW_DOWN).keyUp(Keys.ARROW_UP).build().perform();
		Thread.sleep(2000);
		System.out.println(adminlink.selectedElementUserRole().isDisplayed());
		ele = adminlink.selectedElementUserRole();
		text = ele.getText();
		System.out.println("Selected Element :=>" + text);
		
		Assert.assertEquals(text,"ESS","Test Case Failed.....");
	}

	@Test
	public void verifyStatusDDL() throws InterruptedException
	{
		loginpage.getLogin("Admin","admin123");
		
		homepage.ClickAdminLink();
		
		//select status ddl
		ele = adminlink.selectStatusDDL();
		ele.click();
		Thread.sleep(3000);
		
		Actions action = new Actions(driver);
		
//		select enabled option and print
		action.keyDown(Keys.ARROW_UP).keyUp(Keys.ARROW_UP).build().perform();
		
		System.out.println(adminlink.slectedElementStatus().isDisplayed());//true
		ele = adminlink.slectedElementStatus();
		text = ele.getText();
		System.out.println("Selected Element :=>" + text);
		Assert.assertEquals(text, "Enabled","Test Case Failed.....");
		
//		select disabled option and print
		action.keyDown(Keys.ARROW_DOWN).keyUp(Keys.ARROW_DOWN).build().perform();
		
		System.out.println(adminlink.slectedElementStatus().isDisplayed());//true
		ele = adminlink.slectedElementStatus();
		text = ele.getText();
		System.out.println("Selected Element :=>" + text);
		
		Assert.assertEquals(text, "Disabled","Test Case Failed.....");
	}
	
	@Test(dataProvider="getText",dataProviderClass = DataSet.class)
	public void verifyUserNameText(String txtUsername,String tf) throws InterruptedException
	{
		loginpage.getLogin("Admin","admin123");
		
		homepage.ClickAdminLink();
		
		adminlink.userNameText(txtUsername);
		Thread.sleep(3000);
		
		adminlink.clickOnSearchBtn();
		
		if(tf.equals("invalid"))
		{
			text = adminlink.noRecordFound();
			System.out.println(text);
			
			Assert.assertTrue(text.contains("No Records Found"),"Test Case Failed...");
			
		}else if(tf.equals("valid")) 
		{
			ele = adminlink.searchAdminName();
			text = ele.getText();
			 
			System.out.println(text);
			Assert.assertTrue(text.contains("Admin"),"Test Case Failed....");
		}
	
	}
	
	@Test 
	public void verifyEmpNameText() throws InterruptedException
	{
		loginpage.getLogin("Admin","admin123");
		
		homepage.ClickAdminLink();
		
		adminlink.empNameText("Sara  Tencrady");
		Thread.sleep(3000);
		Actions action = new Actions(driver);
		action.keyDown(Keys.ARROW_DOWN).keyUp(Keys.ARROW_DOWN).build().perform();
		
		adminlink.clickOnSearchBtn();
		
		ele = adminlink.searchEmpName();
		text = ele.getText();
		System.out.println(text);
	}
	
	@Test
	public void verifyResetBtn()
	{
		loginpage.getLogin("Admin","admin123");
		
		homepage.ClickAdminLink();
		
		ele = adminlink.resetBtn();
		ele.click();
		text = adminlink.recordsFoundText().getText();
		System.out.println(text);
		Assert.assertTrue(text.contains("Records Found"),"Test Case Failed");
	}
	
	@Test
	public void verifyJobLinks() throws InterruptedException
	{
		loginpage.getLogin("Admin","admin123");
		
		homepage.ClickAdminLink();
		
		adminlink.clickOnJobLink();
		
		List<WebElement> list = adminlink.jobLinks();
		
		for(int i=0;i<list.size();i++)
		{
			adminlink.clickOnJobLink();
			list = adminlink.jobLinks();
			list.get(i).click();
			System.out.println(driver.getCurrentUrl());
		}
		
//		int sz=10;
//		for(int i=0; i<sz; i++)
//		{
//			adminlink.clickOnJobLink();
//			list =  adminlink.jobLinks();  
//			if ( i ==0)	
//				sz=list.size();
//			list.get(i).click();
//			System.out.println(driver.getCurrentUrl());
//		}
	}
	
	
	
	
	
	
	
	
	
	
	
//	No Records Found
	
	@Test(alwaysRun=false)
	public void verifyAllRecords()
	{
		loginpage.getLogin("Admin","admin123");
		
		homepage.ClickAdminLink();
		
		JavascriptExecutor js =(JavascriptExecutor) driver; 
		js.executeScript("window.scrollBy(0,500);");
		List<WebElement> los = adminlink.allRecordNames();
		int cnt = 0;
		for(WebElement ele : los)
		{
			if(!(cnt==0))
			{
				System.out.print(ele.getText());
			}
			cnt++;
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
}
