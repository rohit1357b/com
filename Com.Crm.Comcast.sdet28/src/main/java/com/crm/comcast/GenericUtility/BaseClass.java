package com.crm.comcast.GenericUtility;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.crm.comcast.objectRepository.HomePage;
import com.crm.comcast.objectRepository.LoginPage;
/**
 * This is the base class.it contains the confriguration annotations.
 * @author Rohit
 *
 */
public class BaseClass {
	public WebDriver driver;
	public static WebDriver sdriver;
	public FileUtility fUtil=new FileUtility();
	public WebDriverUtility wUtil = new WebDriverUtility();

	@BeforeSuite(groups = {"smokeTest","regressionTest"})
	public void configBs() {
		//connection to db
		System.out.println("=====connect to DB=====");
		
	}
	@BeforeClass(groups = {"smokeTest","regressionTest"})
	public void configBc() throws Throwable {
	    //get the data from property file
		String browserName = fUtil.getPropertyFileData("browser");
		String  url = fUtil.getPropertyFileData("url");
		
		
	    //launching the browser
		if(browserName.equalsIgnoreCase("chrome")) {
			System.setProperty(IPathConstants.CHROME_KEY,IPathConstants.CHROME_PATH);
			driver=	new ChromeDriver();
			
			}else if(browserName.equals("firefox")) {
				System.setProperty(IPathConstants.FIREFOX_KEY,IPathConstants.FIREFOX_PATH);
			}else {
				System.out.println("browser is not supported");
		}
		sdriver=driver;
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		wUtil.waitForPageLoad(driver);
		driver.get(url);
	}
	@BeforeMethod
	public void configBm() throws Throwable {
		String username = fUtil.getPropertyFileData("username");
		String password = fUtil.getPropertyFileData("password");
		LoginPage login = new LoginPage(driver);
		login.loginToApplication(username, password);
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
	  @AfterSuite
	  public void configAs() {
		  //close the db connection
		  System.out.println("======Database connection is closed");
	  }
	  
	
	
	
	

}
