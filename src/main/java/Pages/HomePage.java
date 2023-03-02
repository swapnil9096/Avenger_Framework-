package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import Util.Utilities;

public class HomePage extends BaseTest{
	
	public HomePage()
	{
		super();
	}
	
	//Logo
	By brandLogo = By.xpath("(//div/img)[2]");

	//search TextField
	public By linkSearchBox = By.cssSelector("input[placeholder='Search']");
	
	//Path for searching the link
	public	By oneLink = By.xpath("//body/div[@id='app']/div[1]/div[1]/aside[1]/nav[1]/div[2]/ul[1]/li[1]/a[1]");
	
	//All Links
	public	By adminLink = By.xpath("//body/div[@id='app']/div[1]/div[1]/aside[1]/nav[1]/div[2]/ul[1]/li[1]/a[1]");
	public	By pimLink   = By.xpath("//body/div[@id='app']/div[1]/div[1]/aside[1]/nav[1]/div[2]/ul[1]/li[2]/a[1]");
	public	By leave     = By.xpath("//body/div[@id='app']/div[1]/div[1]/aside[1]/nav[1]/div[2]/ul[1]/li[3]/a[1]");
	public  By timeLink  = By.xpath("//body/div[@id='app']/div[1]/div[1]/aside[1]/nav[1]/div[2]/ul[1]/li[4]/a[1]");
	public	By recruitmentLink = By.xpath("//body/div[@id='app']/div[1]/div[1]/aside[1]/nav[1]/div[2]/ul[1]/li[5]/a[1]");
	public  By infoLink  = By.xpath("//body/div[@id='app']/div[1]/div[1]/aside[1]/nav[1]/div[2]/ul[1]/li[6]/a[1]");
	public	By performanceLink = By.xpath("//body/div[@id='app']/div[1]/div[1]/aside[1]/nav[1]/div[2]/ul[1]/li[7]/a[1]");
	public	By dashboardLink = By.xpath("//a[@class='oxd-main-menu-item active toggle']");
	public	By directoryLink = By.xpath("//body/div[@id='app']/div[1]/div[1]/aside[1]/nav[1]/div[2]/ul[1]/li[9]/a[1]");
	public	By maintenanceLink = By.xpath("//body/div[@id='app']/div[1]/div[1]/aside[1]/nav[1]/div[2]/ul[1]/li[10]/a[1]");
	public	By buzzLink = By.xpath("//body/div[@id='app']/div[1]/div[1]/aside[1]/nav[1]/div[2]/ul[1]/li[11]/a[1]");
	
	By prelogoutBtn = By.xpath("//div//i[@class='oxd-icon bi-caret-down-fill oxd-userdropdown-icon']");
	By logoutBtn = By.xpath("(//div//a[@role='menuitem'])[4]");
	
	
	public void goToLinkSearchBox(String link)
	{
		LoginPage loginpage = new LoginPage();
		loginpage.getLogin("Admin","admin123");
		Utilities.enterText(linkSearchBox, link);
	}
	
	public void logout()
	{
		driver.findElement(prelogoutBtn).click();
		driver.findElement(logoutBtn).click();
	}
	
	public String getLogoDisplayed()
	{
		boolean tf =  driver.findElement(brandLogo).isDisplayed();
		return String.valueOf(tf);
	}

	public AdminLinkPage ClickAdminLink()
	{
		 driver.findElement(adminLink);
		 Utilities.explicitWait(adminLink);
		 Utilities.click(adminLink);
		 
		 return new AdminLinkPage();
	}
	
	public void pimLink()
	{
		driver.findElement(pimLink);
		Utilities.explicitWait(pimLink);
		Utilities.click(pimLink);
	}
	public void leave()
	{
		driver.findElement(leave);
		Utilities.explicitWait(leave);
		Utilities.click(leave);
	}
	public void timeLink()
	{
		driver.findElement(timeLink);
		Utilities.explicitWait(timeLink);
		Utilities.click(timeLink);
	}
	public void recruitmentLink()
	{
		driver.findElement(recruitmentLink);
		Utilities.explicitWait(recruitmentLink);
		Utilities.click(recruitmentLink);
	}
	
	public void infoLink()
	{
		driver.findElement(infoLink);
		Utilities.explicitWait(infoLink);
		Utilities.click(infoLink);
	}
	
	public void clickOnPerformanceLink()
	{
		driver.findElement(performanceLink);
		Utilities.explicitWait(performanceLink);
		Utilities.click(performanceLink);
	}
	public Dashboard dashboardLink()
	{
		WebElement ele = driver.findElement(dashboardLink);
		
		if(!ele.isSelected())
		Utilities.explicitWait(dashboardLink);
		Utilities.click(dashboardLink);
		
		return new Dashboard();
	}
	
	public void directoryLink()
	{
		driver.findElement(directoryLink);
		Utilities.explicitWait(directoryLink);
		Utilities.click(directoryLink);
	}
	public void maintenanceLink()
	{
		driver.findElement(maintenanceLink);
		Utilities.explicitWait(maintenanceLink);
		Utilities.click(maintenanceLink);
	}
	public void clickOnBuzzLink()
	{
		driver.findElement(buzzLink);
		Utilities.explicitWait(buzzLink);
		Utilities.click(buzzLink);
		
	}
	
	public void getAllLinks()
	{
		ClickAdminLink();
		pimLink();
		leave();
		timeLink();
		recruitmentLink();
		infoLink();
		clickOnPerformanceLink();
		directoryLink();
		maintenanceLink();
		clickOnBuzzLink();
		dashboardLink();
		
	}
	

	
	
	
	
	

	
	
	
	
	

	
	
	
	
	

	
	
	
	
	
	
	
	
	
	
}
