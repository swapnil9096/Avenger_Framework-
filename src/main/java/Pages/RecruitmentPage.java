package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import Util.Utilities;

public class RecruitmentPage extends BaseTest{

	public RecruitmentPage()
	{
		super();
	}
	
	By candidatesLink = By.partialLinkText("Candidates");
	By addBtn 		  = By.cssSelector("button[type='button'][class='oxd-button oxd-button--medium oxd-button--secondary']");
	By firstName 	  = By.name("firstName");
	By middleName	  = By.name("middleName");
	By lastName		  = By.name("lastName");
	
	By vacancyDDL	  = By.xpath("//div/i[@class='oxd-icon bi-caret-down-fill oxd-select-text--arrow']");
	
	By email		  = By.xpath("(//input[@placeholder='Type here'])[1]");
	By contactNum	  = By.xpath("(//input[@placeholder='Type here'])[2]");
	By browseBtn	  = By.cssSelector("div[class='oxd-file-button']");
	By keywords		  = By.cssSelector("input[placeholder='Enter comma seperated words...']");
	By dateAppn		  = By.cssSelector("input[placeholder='yyyy-mm-dd']");
	By notes		  =	By.cssSelector("textarea[placeholder='Type here']");
	
	By saveBtn		  = By.cssSelector("button[type='submit']");
	
	By confirmationMsg= By.cssSelector("p[class='oxd-text oxd-text--p oxd-text--toast-message oxd-toast-content-text']");
	
	By rejectBtn	  = By.xpath("(//button[@type='button'])[2]");
	By shortListBtn	  = By.xpath("(//button[@type='button'])[3]");
	
	
	Actions action = new Actions(driver);
	
	
	public void clickOnCandidatesLink()
	{
		Utilities.explicitWait(candidatesLink);
		driver.findElement(candidatesLink).click();
	}
	
	public void clickOnAddBtn()
	{
		Utilities.explicitWait(addBtn);
		driver.findElement(addBtn).click();
	}
	
	public void enterFirstName(String fn)
	{
		Utilities.explicitWait(firstName);
		Utilities.enterText(firstName, fn);
	}
	
	public void enterMiddleName(String mn)
	{
		Utilities.explicitWait(middleName);
		Utilities.enterText(middleName, mn);
	}
	
	public void enterLastName(String ln)
	{
		Utilities.explicitWait(lastName);
		Utilities.enterText(lastName, ln);
	}
	
	public void selectVacancyDDL()
	{
		Utilities.explicitWait(vacancyDDL);
		  driver.findElement(vacancyDDL).click();
		  action.keyDown(Keys.ARROW_DOWN).keyUp(Keys.ARROW_DOWN).build().perform();
	}
	
	public void enterEmail(String mail)
	{
		Utilities.explicitWait(email);
		driver.findElement(email).sendKeys(mail);
	}
	
	public void enterContactNum(String mobNo)
	{
		Utilities.explicitWait(contactNum);
		driver.findElement(contactNum).sendKeys(mobNo);
	}
	
	public void enterKeywords(String words)
	{
		Utilities.explicitWait(keywords);
		driver.findElement(keywords).sendKeys(words);
		
	}
	
	public void enterDateOfAppn(String date) throws InterruptedException
	{
		Utilities.explicitWait(dateAppn);
		WebElement ele = driver.findElement(dateAppn);
		ele.click();
		action.keyDown(Keys.SHIFT).keyDown(Keys.HOME).keyUp(Keys.HOME).keyUp(Keys.SHIFT).build().perform();

		 Utilities.enterText(dateAppn, date);
	}
	
	public void enterNotes(String note)
	{
		Utilities.explicitWait(notes);
		driver.findElement(notes).sendKeys(note);
		
	}
	
	public void clickOnSaveBtn()
	{
		Utilities.explicitWait(saveBtn);
		driver.findElement(saveBtn).click();
	}
	
	public String confirmationMsg()
	{
		return driver.findElement(confirmationMsg).getText();
	}
	
	
	
	
	
	
	
	
	
}
