package assignment;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
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

public class CheckWhileCreatingNewOrganizationCopyShippingAddress extends BaseClass{
    @Test(groups = {"smokeTest"})
    
	public void CheckWhileCreatingNewOrganizationCopyShippingAddress()throws Throwable {
		//create object for utilies
		JavaUtility jUtil = new JavaUtility();
		ExcelUtility eUtil = new ExcelUtility();
		WebDriverUtility wUtil = new WebDriverUtility();	
		//generate random number
		int randomNumber = jUtil.getRandomNumber();
	
		//get data from excel sheet
		String ExpectedorganizationName = eUtil.getStringCellData("sheet1",1,2);
		ExpectedorganizationName=ExpectedorganizationName+randomNumber;
		
	
	     //create organization
	     HomePage homePage = new HomePage(driver);
	     homePage.clickOrganizationLink();
	     
	     //create organizationpage
	     OrganizationPage orgPage = new OrganizationPage(driver);
	     orgPage.clickCreateOrgImg();
	     
	     //create organization page
	     CreateOrganizationPage createOrgPage = new CreateOrganizationPage(driver);
	     createOrgPage.createOrganization(ExpectedorganizationName);
	     
	     CreateOrganizationPage radiobtn = new CreateOrganizationPage(driver);
	     radiobtn.createOrganization(ExpectedorganizationName);
	     
	     
	     OrganizationInformationPage orgInfoPage = new OrganizationInformationPage(driver);
	      String actualOrgName = orgInfoPage.getOrgInformationText();
			
			
			//organization name verification
			if(actualOrgName.contains(ExpectedorganizationName)) {
				System.out.println("copy shipping address isSelected");
			}else {
				System.out.println("copy shipping address is Selected");
			}
			  
	     
	}
	  
	  

}

	      

	
			
		
		
		
		


		
	

