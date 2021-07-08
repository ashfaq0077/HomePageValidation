package Test_Case;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Utilities.BrowseEngine;
import Utilities.elementsLocator;

public class T05_LoginPageValidation {
	
public static WebDriver driver;
	
	public static XSSFWorkbook workbook;
	public static XSSFSheet worksheet;
	public static XSSFCell cell;
  
	
	 @BeforeTest(groups = {"smokeTest", "regrsstionTest"})
	  public void openBrowser() {
		 
		 //Code for TS_001 - Open the Browser
		 
      driver=BrowseEngine.browserConfig();
      
      
	  }
	
	 
	 @Test(groups = {"smokeTest","regrsstionTest"}, priority=0)
			 
			 
     public void loadloginURL() {
		 
		 // TS_002 - Navigate to Website
		 
		 driver.get(T03_TestCase03.loginpageURL);
  }
 
	 
	 @Test(groups = {"smokeTest","regrsstionTest"},priority=1)
	 
	 public void loginpagetitleValidation()
	 
	 //TS-003 -Validate login page Title 
	 
	 {
		String loginpageaTitle=driver.getTitle();
		
		AssertJUnit.assertEquals(loginpageaTitle, T03_TestCase03.loginpageexpectedTitle);
	 }
	 
	 
	 @Test(groups = {"smokeTest","regrsstionTest"},priority=2)
	 
	 public void loginFunctionlity() throws IOException
	 
	 {
		 //TS_006 login process Validatation
		 // Import the extrernal excel file location 
		 File src =new File (T03_TestCase03.externalData);
		 
		 // Load /read the External file 
		 
		 FileInputStream fis = new FileInputStream (src);
		 
		 //load the workbook 
		 
		 XSSFWorkbook workbook  = new  XSSFWorkbook(fis);
		 
		 // Read the worksheet
		 
		 XSSFSheet worksheet= workbook.getSheetAt(0);
		 
		 for ( int i=1; i<=worksheet.getLastRowNum(); i++)
			 
		 {
				cell = worksheet.getRow(i).getCell(0); 
				
				//TS_004 send the UID 
				
				driver.findElement(elementsLocator.loginUID).sendKeys(cell.getStringCellValue());
				

				//TS_005 send the PW 
				
				cell = worksheet.getRow(i).getCell(1); 
				
				driver.findElement(elementsLocator.loginPW).sendKeys(cell.getStringCellValue());
				
				//TS_007 Click the login button 
				driver.findElement(elementsLocator.loginButton).click();
				
		 }
	 }
		 
		 
		 @Test(groups = {"smokeTest", "regrsstionTest"},priority=4)
		 
		 //TS_007 -Validate After login page Title 
		 
		 public void afterlogintitleValidation()
		 
		 {
			 String afterloginatitle =driver.getTitle();
			 
			 AssertJUnit.assertEquals(afterloginatitle,T03_TestCase03.afterloginexpectedtitle);
			 
					 
		 }
		 
		 
		 @Test(groups = {"smokeTest","regrsstionTest"},priority=5)
		 
		 // TS_008 - Click on Drop Down
		 public void logoutFuntionlity()
		 
		 {
			 driver.findElement(elementsLocator.logoutdropdownButton).click();
			 
			 // TS_009 -Click on Logout 
			 
			 driver.findElement(elementsLocator.logoutButton).click();
			 
		 }
		

  @AfterTest(groups = {"smokeTest","regrsstionTest"})
  public void aftertearDown() {
	  
	  //TS_010 -Close the Browser 
	  
	  driver.close();
  }

}

	
	
	


