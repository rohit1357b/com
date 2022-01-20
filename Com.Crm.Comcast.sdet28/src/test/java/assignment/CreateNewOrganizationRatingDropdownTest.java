package assignment;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
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

public class CreateNewOrganizationRatingDropdownTest {

	@Test	

	public void CretenewOrganizationRatingDropdownTest() throws Throwable {
		 FileUtility fUtil = new FileUtility();
		 JavaUtility jUtil = new JavaUtility();
		 ExcelUtility eUtil = new ExcelUtility();
		 WebDriverUtility wUtil = new WebDriverUtility();
		  
		
		String url =fUtil .getPropertyFileData("url");
		String username=fUtil.getPropertyFileData("username");
		String password=fUtil.getPropertyFileData("password");
		String browserName=fUtil.getPropertyFileData("browser");
		
		
		int randomNumber = jUtil.getRandomNumber();
		
		String ExpectedorganizationName=eUtil.getStringCellData("Sheet1",1,2);
		ExpectedorganizationName=ExpectedorganizationName+randomNumber;
		
		
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
		
	
		
		//Rating Dropdown
		Actions action = new Actions(driver);
		WebElement mouseOver = driver.findElement(By.xpath("//td[@class='dvtCellLabel']"));
		action.moveToElement(mouseOver).perform();
		
	
		 WebElement sel = driver.findElement(By.name("rating"));
		 Select Select = new Select(sel);
		 Select.selectByIndex(1);
		 
		 OrganizationInformationPage orgInfoPage = new OrganizationInformationPage(driver);
		 
		 String actualOrgName = orgInfoPage.getOrgInformationText();
			
			
			//orga nization name verification
			if(actualOrgName.contains(ExpectedorganizationName)) {
				System.out.println("Rating DropDown table should appear");
			}else {
				System.out.println("Rating DropDown table should not appears");
			}
			//logout action
			homePage.logout();
			
			driver.quit(); 
			
		 
		 
		 
		 
		 
		
		
		
	     
		
		
		
		}
		
	 }
	 
	 


