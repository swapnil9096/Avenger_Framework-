package Pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class DashboardPage extends BaseTest{

	public DashboardPage()
	{
		super();
	}
	
	//Quick lunch (6)
		public By quickLunchLinks= By.xpath("//button[@class='oxd-icon-button orangehrm-quick-launch-icon']");

	//My Actions
		public By myActionsLinks = By.xpath("//div[@class='orangehrm-todo-list-item']");
		
		
		public List<WebElement> quickLunchLinks()
		{
			List<WebElement> links = driver.findElements(quickLunchLinks);
			
			return links;
		}
		
		public List<WebElement> myActionsLinks()
		{
			List<WebElement> links = driver.findElements(myActionsLinks);
			
			return links;
		}
}
