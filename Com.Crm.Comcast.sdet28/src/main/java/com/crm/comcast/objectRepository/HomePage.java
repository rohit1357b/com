package com.crm.comcast.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.comcast.GenericUtility.WebDriverUtility;
/**
 * HomePage pom design
 * @author Rohit
 *
 */
public class HomePage extends WebDriverUtility {
        WebDriver driver;
	    public HomePage(WebDriver driver) {
		PageFactory.initElements(driver,this);
		 this.driver=driver;
	}
	//declaration of elements
	@FindBy(linkText="Organizations")
	private WebElement organizationLink;
	
	@FindBy(linkText="Contacts")
	 private WebElement ContactsLink;
	
	@FindBy(xpath="//img[@src='themes/softed/images/user.PNG']")
	private WebElement logoutImg;
	
	@FindBy(linkText="Sign Out")
	private WebElement signOutLink;
	
   //getters methods
	public WebElement getOrganizationLink() {
		return organizationLink;
	}

	public WebElement getContactsLink() {
		return ContactsLink;
	}

	public WebElement getLogoutImg() {
		return logoutImg;
	}

	public WebElement getSignOutLink() {
		return signOutLink;
	}
	
	public void logout() {
		mouseOver(driver,logoutImg);
		signOutLink.click();
	}

	public void clickOrganizationLink() {
		organizationLink.click();
		
	}
	
	
	
}
