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

import com.crm.comcast.GenericUtility.IPathConstants;

public class NotifyOwnerIsEnabledorNot {
   @Test
	public void NotifyOwnerIsEnabledorNot()  throws Throwable {
		FileInputStream Fis = new FileInputStream(IPathConstants.PROPERTY_FILEPATH);
	    Properties property = new Properties();
	    
	    property.load(Fis);
	     String browser = property.getProperty("browser");
	     String url = property.getProperty("url");
	     String username = property.getProperty("username");
	     String password = property.getProperty("password");
	     
	     WebDriver driver = null;
	     if(browser.equals("chrome")) {
	 		
	 		System.setProperty(IPathConstants.CHROME_KEY,IPathConstants.CHROME_PATH);
	 		driver=	new ChromeDriver();
	 		}else {
	 			System.out.println("browser is not supported");
	 		}
    driver.manage().window().maximize();
    driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
    driver.get("http://localhost:8888/");
    driver.findElement(By.name("user_name")).sendKeys(username);
    driver.findElement(By.name("user_password")).sendKeys(password);
    driver.findElement(By.id("submitButton")).click();
	driver.findElement(By.linkText("Organizations")).click();
	driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();
	
	  WebElement NotifyOwner = driver.findElement(By.xpath("//td[@class='dvtCellLabel']"));
	  Actions action = new Actions(driver);
	  action.moveToElement(NotifyOwner).perform();
	   WebElement ele = driver.findElement(By.xpath("//input[@name='notify_owner']"));
	  if(ele.isEnabled()) {
			System.out.println("pass:element is enabled");
			ele.click();
		}
		else
		{
			System.out.println("Fail:is not enabled");
			Thread.sleep(3000);
		}
	  driver.close();
	}
}
	  
	  
	  
	 
	  
	

		
	
	
