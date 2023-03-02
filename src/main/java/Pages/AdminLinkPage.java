package Pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import Util.Utilities;

public class AdminLinkPage extends BaseTest{

	public AdminLinkPage()
	{
		super();
	}
	
	By userNameText 	= By.xpath("(//input[@class='oxd-input oxd-input--active'])[2]");
	By selectUserRole 	= By.xpath("(//div[@class='oxd-select-text--after'])[1]");
	By selectStatus 	= By.xpath("(//i[@class='oxd-icon bi-caret-down-fill oxd-select-text--arrow'])[2]");
	By empName			= By.cssSelector("input[placeholder='Type for hints...']");
	By resetBtn			= By.cssSelector("button[class='oxd-button oxd-button--medium oxd-button--ghost']");
	By searchBtn		= By.cssSelector("button[class='oxd-button oxd-button--medium oxd-button--secondary orangehrm-left-space']");
	By ddlOptionAdmin   = By.xpath("//input[@placeholder='Type for hints...']");
	By selectedElementUserRole  = By.xpath("(//div[@class='oxd-select-text-input'])[1]");
	By selectedElementStatus = By.xpath("(//div[@class='oxd-select-text-input'][1])[2]");
	By allRecordNames = By.xpath("//div[@role='row']");
	By noRecordFound  = By.xpath("//div[@class='oxd-toast-start']");
	By submitBtn 	  =By.xpath("//button[@type='submit']");

	By searchAdminUsername	=	By.xpath("//div[@role='cell'][@style='flex: 1 1 0%;'][1]");
	By searchEmpName		= 	By.xpath("(//div[@role='cell'])[4]");
	By recordsFoundText		= 	By.xpath("(//span[@class='oxd-text oxd-text--span'])[1]");
	By jobLinks				= 	By.xpath("//ul[@class='oxd-dropdown-menu']/li");
										 
	By jobLink				= 	By.xpath("(//span[@class='oxd-topbar-body-nav-tab-item'])[2]");
	
	public void userNameText(String un)
	{
		Utilities.enterText(userNameText, un);
	}
	
	
	public void empNameText(String employeeName)
	{
		Utilities.enterText(empName, employeeName);
	}
	
	public WebElement selectUserRoleDDL()
	{
		Utilities.explicitWait(selectUserRole);
		 
		return driver.findElement(selectUserRole);
	}
	
	public WebElement selectStatusDDL()
	{
		return driver.findElement(selectStatus);
	}
	
	public WebElement selectedElementUserRole()
	{
		return driver.findElement(selectedElementUserRole);
	}
	
	public WebElement slectedElementStatus()
	{
		return driver.findElement(selectedElementStatus);
	}
	
	public List<WebElement> allRecordNames()
	{
		return driver.findElements(allRecordNames);
	}
	
	public String noRecordFound()
	{
		return driver.findElement(noRecordFound).getText();
				
	}
	
	public void clickOnSearchBtn()
	{
		driver.findElement(submitBtn).click();
	}
	
	
	public WebElement searchAdminName()
	{
		return driver.findElement(searchAdminUsername);
	}
	
	public WebElement searchEmpName()
	{
		return driver.findElement(searchEmpName);
	}
	
	public WebElement resetBtn()
	{
		return driver.findElement(resetBtn);
	}
	
	public WebElement recordsFoundText()
	{
		return driver.findElement(recordsFoundText);
	}
	
	public List<WebElement> jobLinks()
	{
		return driver.findElements(jobLinks);
	}
	
	public void clickOnJobLink()
	{
		driver.findElement(jobLink).click();
	}
	
	
	
	
	
	
}
