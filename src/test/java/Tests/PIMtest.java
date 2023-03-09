package Tests;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Pages.BaseTest;
import Pages.HomePage;
import Pages.LoginPage;
import Pages.PIMpage;

public class PIMtest extends BaseTest{

	HomePage homepage ;
	LoginPage loginpage ;
	PIMpage pimPage;
	WebElement ele ;
	
	
	public PIMtest()
	{
			super();
	}
	
	@BeforeMethod
	public void setUp()
	{
		init();
		loginpage = new LoginPage();
		homepage = new HomePage();
		pimPage = new PIMpage();
		
	}
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}
	
	
	//verifying the add employee functionality using different different employee id
	@Test(dataProvider="addEmpId",dataProviderClass = DataSet.class)
	public void verifyAddEmployee(String id) throws InterruptedException
	{
		System.out.println(id);
		
	
		loginpage.getLogin("Admin", "admin123");
		homepage.pimLink();
		
		pimPage.clickOnAddEmployee();
		
		pimPage.addEmployeeFirstNameTxt("firtName");
		pimPage.addEmployeeMiddleName("middleName");
		pimPage.addEmployeeLastName("lastName");
		pimPage.addEmployeeId(id);
		pimPage.clickOnSaveBtn();
		
		String actMsg = pimPage.confirmationMessage();
		
		System.out.println(actMsg);
		
		Assert.assertEquals(actMsg, "Successfully Saved","Test Case Failed....!!!");
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
