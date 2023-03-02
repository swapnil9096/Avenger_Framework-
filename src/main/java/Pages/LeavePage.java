package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import Util.Utilities;

public class LeavePage extends BaseTest {

	public LeavePage()
	{
		super();
	}
	
	int no ;
	int day ;
	
	By myLeaveLink = By.partialLinkText("My Leave");
	
//	By fromDate	   = By.xpath("(//input[@class='oxd-input oxd-input--active'])[2]");
//	By toDate 	   = By.xpath("(//input[@class='oxd-input oxd-input--active'])[3]");
	By noRecords   = By.xpath("//p[@class='oxd-text oxd-text--p oxd-text--toast-message oxd-toast-content-text']");
	By leaveType   = By.xpath("(//div[@class='oxd-select-text--after'])[2]");
	By submitBtn   = By.cssSelector("button[type='submit']");
	
	By selectMonth = By.xpath("//div[@class='oxd-calendar-selector-month-selected']");
	By selectYear  = By.xpath("//div[@class='oxd-calendar-selector-year-selected']");
	By selectDate  = By.xpath("(//div[@class='oxd-calendar-date'])"+"[" + no  + "]");
	By fromDate    = By.xpath("(//input[@placeholder='yyyy-mm-dd'])[1]");
	By toDate	   = By.xpath("(//input[@placeholder='yyyy-mm-dd'])[2]");
	
	By selectFromIcon = By.xpath("(//i[@class='oxd-icon bi-calendar oxd-date-input-icon'])[1]");
	By selectToDateIcon = By.xpath("(//i[@class='oxd-icon bi-calendar oxd-date-input-icon'])[2]");
	
	
	
	
	
	
	
	
	
	public void enterTextFromDate(String date) throws InterruptedException
	{
		Utilities.explicitWait(fromDate);
		WebElement ele = driver.findElement(fromDate);
		ele.click();
		
		
		 Keys.chord(Keys.CONTROL,"A");
		 Keys.chord(Keys.CONTROL,"X");
		
		Utilities.enterText(fromDate, date);
	}
	
	public void enterTextToDate(String date) throws InterruptedException
	{
		Utilities.explicitWait(toDate);
		WebElement ele = driver.findElement(toDate);
		ele.click();
		 Keys.chord(Keys.CONTROL,"A");
		 Keys.chord(Keys.CONTROL,"X");
		Utilities.enterText(toDate, date);
	}
	

	public void clickOnMyLeaveLink()
	{
		driver.findElement(myLeaveLink).click();
	}
	
	public void clickOnLeaveTypeIcon()
	{
		driver.findElement(leaveType).click();
	}
	
	public void clickOnSubmitBtn()
	{
		driver.findElement(submitBtn).click();
	}
	
	public String noRecordErrorPopUp()
	{
		return driver.findElement(noRecords).getText();
	}
	
	
	
	
	
	
	
	
	
	
}
