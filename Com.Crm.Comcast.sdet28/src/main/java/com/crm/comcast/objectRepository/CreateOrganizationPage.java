package com.crm.comcast.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.comcast.GenericUtility.ExcelUtility;
import com.crm.comcast.GenericUtility.WebDriverUtility;

public class CreateOrganizationPage {
	
	

	public CreateOrganizationPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		
	}
	@FindBy(name="accountname")
	private WebElement organizationTextField;
	
	@FindBy(name="cpy")
	private WebElement copyShippingRadioButton;
	
	@FindBy(xpath="//input[@title='Save [Alt+S]']")
	private WebElement saveButton;
	
	//getters method
	public WebElement getOrganizationTextField() {
		return organizationTextField;
	}

	
	public WebElement getCopyShippingRadioButton() {
		return copyShippingRadioButton;
	}


	public WebElement getSaveButton() {
		return saveButton;
	}
	
	
	

	public void createOrganization(String orgName) {
		organizationTextField.sendKeys(orgName);
		copyShippingRadioButton.click();
		saveButton.click();
		
	}
	
	
	
}
