package assignment;

import java.awt.Desktop.Action;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.crm.comcast.GenericUtility.BaseClass;
import com.crm.comcast.GenericUtility.ExcelUtility;
import com.crm.comcast.GenericUtility.IPathConstants;
import com.crm.comcast.GenericUtility.JavaUtility;
import com.crm.comcast.GenericUtility.WebDriverUtility;
import com.crm.comcast.objectRepository.HomePage;

      public class RatingTest extends BaseClass{

@Test


	public void RatingTest() throws Throwable {
		ExcelUtility eUtil = new ExcelUtility();
		WebDriverUtility wUtil = new WebDriverUtility();
		JavaUtility jUtil = new JavaUtility();
		
		
		FileInputStream fis = new FileInputStream(IPathConstants.PROPERTY_FILEPATH);
		Properties property = new Properties();

		property.load(fis);
		String browser=property.getProperty("browser");
		String url=property.getProperty("url");
		String username=property.getProperty("username");
		String password=property.getProperty("password");
		
		WebDriver driver=null;
		if(browser.equals("chrome")) {
		
		System.setProperty(IPathConstants.CHROME_KEY,IPathConstants.CHROME_PATH);
		driver=	new ChromeDriver();
		}else {
			System.out.println("browser is not supported");
		}
		    driver.manage().window().maximize();
		    driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		    driver.get("http://localhost:8888/");
		    driver.findElement(By.name("user_name")).sendKeys(username);
		    driver.findElement(By.name("user_password")).sendKeys(password);
		    driver.findElement(By.id("submitButton")).click();
			driver.findElement(By.linkText("Organizations")).click();
			driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();
			driver.findElement(By.xpath("//select[@name='rating']")).click();
			
	
		
			
			
			ExcelUtility eUtils = null;
			JavaUtility jUtils = null;
			String orgName=eUtils.getStringCellData(IPathConstants.SHEET_NAME,1,2)+jUtils.getRandomNumber();
			
			//selecting from Rating Dropdown
			String RatingText= eUtils.getStringCellData(IPathConstants.SHEET_NAME,1,3);
			WebElement eleForRating = driver.findElement(By.xpath("Rating"));
			
			WebDriverUtility wUtils = null;
			wUtils.selectOption(RatingText,eleForRating);
			driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
			//veryfing the wheather the contact has been created
			String actualText = driver.findElement(By.xpath("//td[@class='dvtCellLabel']")).getText();
			String expectedText = eUtils.getStringCellData(IPathConstants.SHEET_NAME,1,2);
			
			
			if(actualText.contains(expectedText)) {
				System.out.println("Organization has been created or not");
			}
			else System.out.println("Organization has been not created and verified");
			}
			
      @AfterMethod
        public void configAm() {
	  HomePage homePage = new HomePage(driver);
	  homePage.logout();	  
    }
    @AfterClass
      public void configAc() {
	  //closing or quitting the browser
	  driver.quit();
			
    }
      }
      
			
			
				
			 
			
		 
			
			
			

	

