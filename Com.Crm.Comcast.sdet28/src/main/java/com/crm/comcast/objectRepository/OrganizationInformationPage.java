package com.crm.comcast.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
/**
 * OrganizationPage Pom design
 * @author Rohit
 *
 */
public class OrganizationInformationPage {

	public OrganizationInformationPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		
	}
	@FindBy(xpath="//span[@class='dvHeaderText']")
	private WebElement orgInfoText;
	
	//getters method
	public WebElement getOrgInfoText() {
		return orgInfoText;
	}
	/**
	 * It will return the organization information text
	 * @return
	 */
	public String getOrgInformationText() {
		return orgInfoText.getText();
		
	}
	
	
}
