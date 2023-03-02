package Pages;

import org.openqa.selenium.By;

import Util.Utilities;

public class BuzzPage extends BaseTest {

	public BuzzPage() 
	{
		super();
	}
	
	
	By enterPostText   = By.cssSelector("textarea[rows='1']");
	By postBtn		   = By.xpath("//button[@type='submit']");
	By confirmationMsg = By.xpath("//p[@class='oxd-text oxd-text--p oxd-text--toast-message oxd-toast-content-text']");
	
	public void enterPostText(String txt)
	{
		Utilities.explicitWait(enterPostText);
		driver.findElement(enterPostText).sendKeys(txt);
	}
	
	public void postBtn()
	{
		Utilities.explicitWait(postBtn);
		driver.findElement(postBtn).click();
	}
	
	
	public String getConfirmationMessaage()
	{
		return driver.findElement(confirmationMsg).getText();
	}
	
	
}
