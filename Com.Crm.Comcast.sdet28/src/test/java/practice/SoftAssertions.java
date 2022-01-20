package practice;

import org.testng.Reporter;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class SoftAssertions {		
	@Test
	public void sample() {
		String expectedName="Rohit";
		String actualName="Rohit";
		
		Reporter.log("soft assert",true);
		SoftAssert sa = new SoftAssert();
		sa.assertEquals(expectedName,actualName);
		
		sa.assertAll();
		
	}
	}



