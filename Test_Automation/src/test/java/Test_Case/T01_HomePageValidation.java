package Test_Case;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.apache.xmlbeans.impl.tool.XSTCTester.TestCase;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.AssertJUnit;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Utilities.BrowseEngine;

public class T01_HomePageValidation {
	
public static WebDriver driver;
	
	
	@BeforeMethod
	
	public static void openBrowser()
	
	{
		//loading the browser 
		driver=BrowseEngine.browserConfig();
	}

	
	@Test
	
	public static void homepageValidation()
	
	{
		//loading application under test 
		driver.get(T03_TestCase03.homepageURL);
		
		//validation the home page 
		
		String homepageactualTitle=driver.getTitle();
		
		AssertJUnit.assertEquals(homepageactualTitle, T03_TestCase03.homepageexpectedTitle);
		
	
		
		
	}




@AfterMethod


public static void tearDown()

{
	driver.close();
}

}




	
	
	
	
	
	
	
	
	
	
	


