package Pages;

import org.openqa.selenium.By;

import Util.Utilities;

public class PIMpage extends BaseTest{

	public PIMpage()
	{
		super();
	}
	
	By addEmployee = By.xpath("//div[@class='oxd-topbar-body']//li[3]");
	By addEmployeeFirstNameTxt = By.name("firstName");
	By addEmployeeMiddleName   = By.name("middleName");
	By addEmployeeLastName	   = By.name("lastName");	
	By addEmployeeId		   = By.xpath("(//input[@class='oxd-input oxd-input--active'])[2]");
	By ProfilePhotoBtn		   = By.xpath("(//button[@type='button'])[2]");
	By saveBtn				   = By.cssSelector("button[type='submit']");
	By cancelBtn			   = By.xpath("(//button[@type='button'])[3]");
	By confirmationMessage	   = By.xpath("//p[@class='oxd-text oxd-text--p oxd-text--toast-message oxd-toast-content-text']");
	
	public void clickOnAddEmployee()
	{
		driver.findElement(addEmployee).click();
	}
	
	public void addEmployeeFirstNameTxt(String firstName)
	{
		Utilities.explicitWait(addEmployeeFirstNameTxt);
		Utilities.enterText(addEmployeeFirstNameTxt, firstName);
	}
	
	public void addEmployeeMiddleName(String middleName)
	{
		Utilities.enterText(addEmployeeMiddleName, middleName);
	}
	
	public void addEmployeeLastName(String lastName)
	{
		Utilities.enterText(addEmployeeLastName, lastName);
	}
	
	public  void addEmployeeId(String id) throws InterruptedException
	{
		driver.findElement(addEmployeeId).sendKeys(id);
		
	}
	
	public void clickOnSaveBtn()
	{
		driver.findElement(saveBtn).click();
	}
	
	public void clickOnCancelBtn()
	{
		driver.findElement(cancelBtn).click();
	}
	
	public void addProfilePhoto()
	{
		
	}
	
	public String confirmationMessage()
	{
		return driver.findElement(confirmationMessage).getText();
	}


































}
