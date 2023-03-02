package Pages;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {

	public static WebDriver driver;
	public static Properties prop;
	
	public BaseTest() 
	{
		String path = System.getProperty("user.dir") + "/src/test/resources/config.properties";
		try {
			FileInputStream fis = new FileInputStream(path);
			prop = new Properties();
			prop.load(fis);
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			System.out.println("File Not found..!!");
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("Error in file reading...!!!");
		}
	}
	
	public void init()
	{
		String browser = prop.getProperty("browser");
		
		if(browser.equalsIgnoreCase("CHROME"))
		{
			WebDriverManager.chromedriver().setup();
			 driver = new ChromeDriver();
		}else if(browser.equalsIgnoreCase("EDGE")) 
		{
			WebDriverManager.edgedriver().setup();
			 driver = new EdgeDriver();
		}
		else
		throw new RuntimeException("Invalid browser...." + browser);
	
		driver.get(prop.getProperty("url"));
		
		boolean maximize = Boolean.parseBoolean(prop.getProperty("maximize"));
		if(maximize)
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Integer.parseInt(prop.getProperty("implicittimeout"))));
	}
	
	public String getScreenshot(String testCaseName)
	{
		TakesScreenshot  ts =(TakesScreenshot)driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		File file = new File(System.getProperty(System.getProperty("user.dir")+ "\\src\\test\\resources\\reports\\" + testCaseName + ".png"));
		
		try {
			FileUtils.copyFile(source, file);
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("Error in copying file...!!");
		}
		
		return System.getProperty(System.getProperty("user.dir")+ "\\src\\test\\resources\\reports\\" + testCaseName + ".png");
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
