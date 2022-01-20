package practice;


import java.io.IOException;
import java.util.Properties;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import com.crm.comcast.GenericUtility.BaseClass;
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

public class CreateOrganizationTest extends BaseClass {
    @Test  (groups = {"smokeTest"})
	public void CreateOrg() throws Throwable {
		//create object for utilites
		JavaUtility jUtil = new JavaUtility();
		ExcelUtility eUtil =new ExcelUtility();
		WebDriverUtility wUtil =new WebDriverUtility();
		
		//generate randomNumber
		int randomNumber= jUtil.getRandomNumber();
		
		//get data from excel sheet
		String ExpectedorganizationName=eUtil.getStringCellData("Sheet1",1,2);
		ExpectedorganizationName=ExpectedorganizationName+randomNumber;	
		
		  
			//create organization
		  	HomePage homePage = new HomePage(driver);
			homePage.clickOrganizationLink();
			
			OrganizationPage orgPage = new OrganizationPage(driver);
			orgPage.clickCreateOrgImg();
			
			CreateOrganizationPage createOrgPage = new CreateOrganizationPage(driver);
			createOrgPage.createOrganization(ExpectedorganizationName);
			
			OrganizationInformationPage orgInfoPage = new OrganizationInformationPage(driver);
			String actualOrgName = orgInfoPage.getOrgInformationText();
			
			//organization name verification
			if(actualOrgName.contains(ExpectedorganizationName)) {
				System.out.println("Organization is created");
			}else {
				System.out.println("Organization is not created");
			}
			
			}
}
			
		
		
	
			 
		


		
		
		

	


