package com.obs.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.obs.base.AutomationBase;

public class LoginPage extends AutomationBase{
	
	public LoginPage() {
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(xpath="//input[@id='user-name' and @name='user-name']") 
	WebElement uname;
	
	@FindBy(xpath="//input[@id='password' and @name='password']") 
	WebElement pwd;
	
	@FindBy(xpath="//input[@id='login-button' and @name='login-button']")
	WebElement login;
	
	@FindBy(xpath="//h3[contains(.,'Epic sadface: Username is required')]")
	WebElement emptyErrorMsg;
	
	@FindBy(xpath="//h3[contains(.,'Epic sadface: Username and password do not match any user in this service')]")
	WebElement invalidErrorMsg;
			
	@FindBy(xpath="//span[contains(.,'Products')]")
	WebElement productTitle;
	
	
	public void typeUsername( String email) {
		uname.sendKeys(email);
	}
	public void typePassword(String password) {
		pwd.sendKeys(password);
	}
	public void clickLogin() {
		login.click();
	}
	public boolean isEmptyErrorMsgDisplayed() {
		return emptyErrorMsg.isDisplayed();
	}
	
	public boolean isInvalidErrorMsgDisplayed() {
		return invalidErrorMsg.isDisplayed();
	}
	
	public boolean isProductTitleDisplayed() {
		return productTitle.isDisplayed();
	}

}