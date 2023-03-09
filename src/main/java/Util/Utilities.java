package Util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Pages.BaseTest;

public class Utilities extends BaseTest{

	public static  void explicitWait(By wait)
	{
		WebDriverWait explicitWait = new WebDriverWait(driver,Duration.ofSeconds(Integer.parseInt(prop.getProperty("explicittimeout"))));
		explicitWait.until(ExpectedConditions.presenceOfElementLocated(wait));
	}
	public static String getLinkText(By linkName)
	{
		String text = driver.findElement(linkName).getText();

		return text;
	}
	public static void enterText(By by,String data)
	{
		explicitWait(by);
		driver.findElement(by).sendKeys(data);

	}
	public static void click(By by)
	{
		driver.findElement(by).click();
	}

	public static Object[][] getExcelData(String fileName, String sheetName) {
		Object[][] data = null;
		 fileName = System.getProperty("user.dir") + "/src/test/resources/" + fileName + ".xlsx";
//		sheetName = sn; // "OrangeHRM";

		try {
			FileInputStream fis = new FileInputStream(fileName);
			XSSFWorkbook workbook = new XSSFWorkbook(fis);
			XSSFSheet sheet = workbook.getSheet(sheetName);
			int totalRows = sheet.getLastRowNum();
			int totalColms = sheet.getRow(0).getLastCellNum();

			data = new Object[totalRows][totalColms];

			for (int i = 1; i <= totalRows; i++) {
				for (int j = 0; j < totalColms; j++)
					data[i - 1][j] = sheet.getRow(i).getCell(j).getStringCellValue();

				System.out.println();
			}

			workbook.close();

		} catch (FileNotFoundException e) {
			e.printStackTrace();
			System.out.println("File not found...!!");
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("Error in opening file...!!");

		}

		return data;

	}
}
