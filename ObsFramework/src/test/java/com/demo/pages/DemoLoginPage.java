package com.demo.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DemoLoginPage {
	
	WebDriver driver;
	
	public DemoLoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);				
	}
	@FindBy(name="user-name")
	private WebElement username;
	
	@FindBy(name="password")
	private WebElement password;
	
	@FindBy(id="login-button")
	WebElement loginBtn;
	
	@FindBy(xpath="//h3[text()='Epic sadface: Password is required']")
	WebElement pwdRequiredError;
	
	@FindBy(xpath="//h3[text()='Epic sadface: Username is required']")
	WebElement usernameRequiredError;
	
	@FindBy(xpath="//h3[text()='Epic sadface: Username and password do not match any user in this service']")
	WebElement credentialsNotMatchingError;

	
	public String validateLoginPageTitle(){
		return driver.getTitle();//always use string for getTitle		
	}
	public void typeUsername(String email) {
		username.sendKeys(email);
	}
	public void typePassword(String pwd) {
		password.sendKeys(pwd);
	}
	public void clickLogin() {
		loginBtn.click();
	}
	public boolean isPwdRequiredErrorDisplayed() {
		 return pwdRequiredError.isDisplayed();
	}
	public boolean isUsernameRequiredErrorDisplayed() {
		 return usernameRequiredError.isDisplayed();
	}
	
	
	public boolean iscredentialsNotMatchingErrorDisplayed() {
		 return credentialsNotMatchingError.isDisplayed();
	}
	
	public Homepage login(String un, String pwd){
		username.sendKeys(un);
		password.sendKeys(pwd);
		loginBtn.click();
		return new Homepage(driver);// login page lands to homepage, so use return method
	}
	
}
