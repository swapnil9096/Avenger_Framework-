package Tests;

import org.openqa.selenium.By;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Pages.BaseTest;
import Pages.HomePage;
import Pages.LoginPage;
import Util.Utilities;

public class HomePageTest extends BaseTest {

	public HomePage homepage = new HomePage();
	LoginPage loginpage;

	public HomePageTest() {
		super();
	}

	@BeforeMethod
	public void setUp() {
		init();
		loginpage = new LoginPage();
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

	@Test
	public void verfyAllLinks() throws InterruptedException {
		loginpage.getLogin("Admin", "admin123");
		homepage.getAllLinks();

	}

	@Test(dataProvider = "getLinks", dataProviderClass = DataSet.class)
	public void verifySearchLinkTextField(String linkName, By ele) throws InterruptedException {

		String text = null;

		homepage.goToLinkSearchBox(linkName);

		String actualValue = driver.findElement(homepage.linkSearchBox).getAttribute("value");

		System.out.println("Search Box Name : => " + actualValue);

		text = Utilities.getLinkText(ele);

		System.out.println("Expected Value : => " + text);

		if (!text.equalsIgnoreCase(actualValue))
			System.out.println("Test Case Failed");

	}


	@Test
	public void verifyLogout()
	{
		loginpage.getLogin("Admin","admin123");
		homepage.logout();
	}
	
	
}
