package assignment;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import com.crm.comcast.GenericUtility.ExcelUtility;
import com.crm.comcast.GenericUtility.FileUtility;
import com.crm.comcast.GenericUtility.IPathConstants;
import com.crm.comcast.GenericUtility.JavaUtility;
import com.crm.comcast.GenericUtility.WebDriverUtility;
import com.crm.comcast.objectRepository.CreateOrganizationPage;
import com.crm.comcast.objectRepository.HomePage;
import com.crm.comcast.objectRepository.LoginPage;
import com.crm.comcast.objectRepository.OrganizationInformationPage;
import com.crm.comcast.objectRepository.OrganizationPage;

public class NotifyOwner {
       
	@Test
	
	public void NotifyOwner() throws IOException, Throwable {
		FileUtility fUtil = new FileUtility();
		JavaUtility jUtil = new JavaUtility();
		ExcelUtility eUtil =new ExcelUtility();
		WebDriverUtility wUtil =new WebDriverUtility();
		
		//get the data from property file 
		String url = fUtil.getPropertyFileData("url");
		String username=fUtil.getPropertyFileData("username");
		String password=fUtil.getPropertyFileData("password");
		String browserName=fUtil.getPropertyFileData("browser");
		//genrate random number
             int randomNumber= jUtil.getRandomNumber();
		
		//get data from excel sheet
		String ExpectedorganizationName=eUtil.getStringCellData("Sheet1",1,2);
		ExpectedorganizationName=ExpectedorganizationName+randomNumber;
		
		//how to use browser value and launch the browser
		WebDriver driver=null;
		if(browserName.equalsIgnoreCase("chrome")) {
		System.setProperty(IPathConstants.CHROME_KEY,IPathConstants.CHROME_PATH);
		driver=	new ChromeDriver();
		}else {
			System.out.println("browser is not supported");
		

		}
		driver.manage().window().maximize();
		wUtil.waitForPageLoad(driver);
		driver.get(url);	
			
		    //login to application
		    LoginPage login = new LoginPage(driver);
		    login.loginToApplication(username,password);
		    
		    //create organization
		    
			HomePage homePage = new HomePage(driver);
			homePage.clickOrganizationLink();
			
			OrganizationPage orgPage = new OrganizationPage(driver);
			orgPage.clickCreateOrgImg();
			
			CreateOrganizationPage createOrgPage = new CreateOrganizationPage(driver);
			createOrgPage.createOrganization(ExpectedorganizationName);
			
	 			
	 			WebElement Owner=driver.findElement(By.xpath("//td[@class='dvtCellLabel']"));
	 			Actions action = new Actions(driver);
				action.moveToElement(Owner).perform();
	 			WebElement ele = driver.findElement(By.xpath("//input[@name='notify_owner']"));
	 			if(ele.isEnabled()){

				 OrganizationInformationPage orgInfoPage = new OrganizationInformationPage(driver);
					String actualOrgName = orgInfoPage.getOrgInformationText();
					
			
				
           	  	if(actualOrgName.contains(ExpectedorganizationName)) {
					System.out.println("NotifyOWner should be selected");
				}else {
					System.out.println("NotifyOwner should not be selected");
				}
				//logout action
				homePage.logout();
				
				driver.quit();
				
	 			}
	}
}
	 	
	 			
	 			
	 	
	    

	


