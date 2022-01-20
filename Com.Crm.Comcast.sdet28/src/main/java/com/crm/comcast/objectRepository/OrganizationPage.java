package com.crm.comcast.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
/**
 * Organization page Pom design
 * @author Rohit
 *
 */
public class OrganizationPage {

	public OrganizationPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		
	}
	@FindBy(xpath="//img[@src='themes/softed/images/btnL3Add.gif']")
	private WebElement createOrgPlusImage;
	
	
	//getters method
	public WebElement getCreateOrgPlusImage() {
		return createOrgPlusImage;
	}
	//business logic
	public void clickCreateOrgImg() {
		createOrgPlusImage.click();
	}
	
	
}
