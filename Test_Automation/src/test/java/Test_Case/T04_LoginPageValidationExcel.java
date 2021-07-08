package Test_Case;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Utilities.BrowseEngine;

public class T04_LoginPageValidationExcel {
	
	
	
	public static WebDriver driver;
	public static XSSFCell cell;

	public static XSSFSheet sheet;

	public static XSSFWorkbook workbook;
		
		@BeforeTest(groups= {"regTest"})
		
		public static void openBrowser()
		
		{
			driver=BrowseEngine.browserConfig();
		}
		
		
		
		@Test(groups= {"regTest"})
		
		public static void loginpage() throws InterruptedException, IOException
		
		{
			
			//loading the login page
		driver.get(T03_TestCase03.loginpageURL);
		
		//validating the login page 
		
		
		
		String loginpageactualtitle=driver.getTitle();
		
	     AssertJUnit.assertEquals(loginpageactualtitle, T03_TestCase03.loginpageexpectedTitle);
		
		//identify the name text box 
		
		Thread.sleep(2000);
		
		//Import the data file 
		
		File src = new File ("C:\\DevOps test workspace\\Test_Automation\\Data\\data.xlsx");
		
		//Load the data file 
		
		FileInputStream fis = new FileInputStream (src);
		
		
		//load the workbook
		
	     workbook =new XSSFWorkbook(fis);
		
		
		//load the worksheet
		
		XSSFSheet sheet = workbook.getSheetAt(0);
		
		for ( int i =1; i<= sheet.getLastRowNum(); i++)
			
		{
		
			cell = sheet.getRow(i).getCell(0);
		
		
		driver.findElement(By.name("email")).sendKeys(cell.getStringCellValue());
		
		//identify the password text box 
		
		cell = sheet.getRow(i).getCell(1);
		
		driver.findElement(By.name("password")).sendKeys(cell.getStringCellValue());
		
		//identify the signin button 
		
		driver.findElement(By.xpath("/html/body/div[2]/div/div/form/div/div[2]/div[3]/div[2]/button")).click();
		
		//validating the login process
		
		}
		
		
		String afterloginactualtitle=driver.getTitle();
		
		AssertJUnit.assertEquals(afterloginactualtitle,T03_TestCase03.afterloginexpectedtitle);
		
		//logout process
		
		driver.findElement(By.xpath("//*[@id='navbar-right']/li/a/span")).click();
		
		driver.findElement(By.xpath("//*[@id='navbar-right']/li/ul/li/a")).click();
		}
		

		

		@AfterMethod
		@AfterTest(groups= {"regTest"})

		
		public static void tearDown()
		
		{
			//closing the browser
			
		driver.quit();
		}

	}



