package Pages;

import org.openqa.selenium.By;

import Util.Utilities;

public class LoginPage extends BaseTest{
	
	public LoginPage()
	{
		super();
	}

	By txtUsername = By.name("username");
	By txtPassword = By.name("password");
	By btnLogin    = By.cssSelector("button[type='submit']");
	By errorRequired = By.xpath("(//div/span)[1]");
	By errorInvalid = By.cssSelector("div[class='oxd-alert oxd-alert--error']");
	
	
	public  void enterUsername(String un)
	{
		Utilities.explicitWait(txtUsername);
		Utilities.enterText(txtUsername, un);
	}
	
	
	public void enterPassword(String pwd)
	{
		Utilities.explicitWait(txtPassword);
		Utilities.enterText(txtPassword, pwd);
	}
	
	public void clickOnLoginBtn()
	{
		Utilities.explicitWait(btnLogin);
		Utilities.click(btnLogin);
	}
	
	public String getErrorRequired()
	{
		Utilities.explicitWait(errorRequired);	
		return driver.findElement(errorRequired).getText();
	}
	
	public String getInvalidError()
	{
		Utilities.explicitWait(errorInvalid);	
		return driver.findElement(errorInvalid).getText();
	}
	
	public HomePage getLogin(String un,String pwd)
	{
		enterUsername(un);
		enterPassword(pwd);
		clickOnLoginBtn();
		
		return new HomePage();
		
		
		
		
		
		
		
		
	}
	
}
