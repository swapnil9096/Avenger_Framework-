package Tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Pages.BaseTest;
import Pages.HomePage;
import Pages.LoginPage;
import Pages.RecruitmentPage;

public class RecruitmentPageTest extends BaseTest {

	LoginPage loginpage ;
	HomePage homepage;
	RecruitmentPage recruitmentPage;
	
	public RecruitmentPageTest()
	{
		super();
	}
	
	@BeforeMethod
	public void setUp()
	{
		init();
		loginpage = new LoginPage();
		homepage = new HomePage();
		recruitmentPage = new 	RecruitmentPage();
		
	}
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}
	
	@Test
	public void verifyAddCandidates() throws InterruptedException
	{
		//login to application
		loginpage.getLogin("Admin", "admin123");
		
		//click on recruitment link
		homepage.recruitmentLink();
		
		//click on candidates
		recruitmentPage.clickOnCandidatesLink();
		
		//click on add button
		recruitmentPage.clickOnAddBtn();
		
		//enter first name
		recruitmentPage.enterFirstName("pranav");
		
		//enter middle name
		recruitmentPage.enterMiddleName("shankar");
		
		//enter last name
		recruitmentPage.enterLastName("navale");
		
		//select vacancy (Associate It Manager)
		recruitmentPage.selectVacancyDDL();
		
		//enter email
		recruitmentPage.enterEmail("pnv@gmail.com");
		
		//contact number
		recruitmentPage.enterContactNum("9853635635");
		
		//enter keywords
		recruitmentPage.enterKeywords("Good");
		
		//enter date of application(give the date in this format yyyy-mm-dd)
		recruitmentPage.enterDateOfAppn("2023-03-01");
		
		//entering notes 
		recruitmentPage.enterNotes("very good");
		
		//click on save Btn
		recruitmentPage.clickOnSaveBtn();
		
		//getting successful message
		String expResult = recruitmentPage.confirmationMsg();
		
		System.out.println(expResult);
		
		Assert.assertEquals(expResult, "Successfully Saved","Test Case Failed..!!");
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
