package Test_Case;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Utilities.BrowseEngine;

public class T02_LoginPageValidation {
	
	
public static WebDriver driver;
	
	@BeforeTest(groups= {"regTest"})
	
	public static void openBrowser()
	
	{
		driver=BrowseEngine.browserConfig();
	}
	
	
	
	@Test(groups= {"regTest"})
	
	public static void loginpage() throws InterruptedException
	
	{
		
		//loading the login page
	driver.get(T03_TestCase03.loginpageURL);
	
	//validating the login page 
	
	
	
	String loginpageactualtitle=driver.getTitle();
	
     AssertJUnit.assertEquals(loginpageactualtitle, T03_TestCase03.loginpageexpectedTitle);
	
	//identify the name text box 
	
	Thread.sleep(2000);
	driver.findElement(By.name("email")).sendKeys(T03_TestCase03.loginUID);
	
	//identify the password text box 
	
	driver.findElement(By.name("password")).sendKeys(T03_TestCase03.loginPW);
	
	//identify the signin button 
	
	driver.findElement(By.xpath("/html/body/div[2]/div/div/form/div/div[2]/div[3]/div[2]/button")).click();
	
	//validating the login process
	
	
	
	
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



