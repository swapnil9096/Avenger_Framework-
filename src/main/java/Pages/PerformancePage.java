package Pages;

import org.openqa.selenium.By;

import Util.Utilities;

public class PerformancePage extends BaseTest {

	public PerformancePage()
	{
		super();
	}

	By myTrackerLink 	 = By.partialLinkText("My Trackers");
	By viewBtn			 = By.cssSelector("button[name='view']");
	By adddLogBtn		 = By.cssSelector("button[type='button'][class='oxd-button oxd-button--medium oxd-button--secondary']");
	By logText			 = By.cssSelector("input[placeholder='Type here']");
	By positiveBtn		 = By.cssSelector("button[class='oxd-button oxd-button--medium oxd-button--text orangehrm-tracker-rating-button']");
	By negativeBtn		 = By.cssSelector("button[class='oxd-button oxd-button--medium oxd-button--text orangehrm-tracker-rating-button --deselected']");
	By commentText		 = By.cssSelector("textarea[placeholder='Type here']");
	By saveBtn			 = By.cssSelector("button[type='submit']");
	By confirmationMsg	 = By.cssSelector("p[class='oxd-text oxd-text--p oxd-text--toast-message oxd-toast-content-text']");
	
	
	public void clickOnMyTrackerLink()
	{
		Utilities.explicitWait(myTrackerLink);
		driver.findElement(myTrackerLink).click();
	}
	
	public void clickOnViewBtn()
	{
		Utilities.explicitWait(viewBtn);
		driver.findElement(viewBtn).click();
	}
	
	public void clickOnAddLogBtn()
	{
		Utilities.explicitWait(adddLogBtn);
		driver.findElement(adddLogBtn).click();
	}
	
	public void enterLogText(String txt)
	{
		Utilities.explicitWait(logText);
		driver.findElement(logText).sendKeys(txt);
	}
	
	public void clickOnPositiveBtn()
	{
		Utilities.explicitWait(positiveBtn);
		driver.findElement(positiveBtn).click();
	}
	
	public void clickOnNegativeBtn() 
	{
		Utilities.explicitWait(negativeBtn);
		driver.findElement(negativeBtn).click();
	}
	
	public void enterComment(String com)
	{
		Utilities.explicitWait(commentText);
		driver.findElement(commentText).sendKeys(com);
	}
	
	public void clickOnSaveBtn()
	{
		Utilities.explicitWait(saveBtn);
		driver.findElement(saveBtn).click();
	}
	
	public String getConfirmationMessage()
	{
		return driver.findElement(confirmationMsg).getText();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
