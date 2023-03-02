package Tests;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Pages.BaseTest;
import Pages.Dashboard;
import Pages.HomePage;
import Pages.LoginPage;

public class DashboardTest extends BaseTest {

	Dashboard dashboard ;
	LoginPage loginpage;
	HomePage homepage;
	public DashboardTest()
	{
		super();
	}
	
	@BeforeTest
	public void setUp()
	{
		init();
		dashboard = new Dashboard();
		loginpage = new LoginPage();
		homepage  = new HomePage();
	}
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}
	
	@Test
	public void verifyQuickLaunchLinks()
	{	
		loginpage.getLogin("Admin","admin123");
		List<WebElement> links = dashboard.quickLunchLinks();

		String text;
		for(WebElement ele : links)
		{
			 ele.click();
			 text = driver.getCurrentUrl();
			 
			 System.out.println(text);

			 driver.navigate().back();
		}
	
	}
	
	@Test
	public void verifyMyActionsLinks()
	{	
		loginpage.getLogin("Admin","admin123");
		List<WebElement> links = dashboard.myActionsLinks();

		String text;
		for(WebElement ele : links)
		{
			 ele.click();
			 text = driver.getCurrentUrl();
			 
			 System.out.println(text);

			 driver.navigate().back();
		}
	
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
