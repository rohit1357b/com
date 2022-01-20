package practice;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CreateOrg {
	  
	@BeforeClass(groups = {"smokeTest"})
	public void bc() {
		System.out.println("launch the browser");
	}
	@AfterClass(groups = {"regressionTest"})
	public void ac() {
		System.out.println("quit the browser");
	}
	@BeforeMethod(groups = {"regressionTest"})
	public void bm() {
		System.out.println("login to application");
	}
	@AfterMethod(groups = {"smokeTest"})
	public void af() {
		System.out.println("logout the application");
		
	}
	@Test (priority =1)
	public void org() {
		System.out.println("Navigate to organization");
		System.out.println("create to organization");
		System.out.println("verify to organization");
	}
	@Test (priority = 1)
	public void Contact() {
		System.out.println("navigate to contact");
		System.out.println("create to contact");
		System.out.println("verify to contact");
	}
	@Test(priority =2)
	public void product() {
		System.out.println("naviagate to product");
		System.out.println("create to product");
		System.out.println("verify to product");
		
		
	}

     

}
