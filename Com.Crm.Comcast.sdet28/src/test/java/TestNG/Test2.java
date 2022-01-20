package TestNG;

import org.testng.annotations.Test;

public class Test2 {
	
	@Test (groups = {"smokeTest","regressionTest"})
	public void customerTest1() {
		System.out.println("This is smoke");
	}
	
	
	@Test (groups = {"regressionTest"})
	public void customerTest2() {
		System.out.println("This is Regression");
		
		
	}
}
