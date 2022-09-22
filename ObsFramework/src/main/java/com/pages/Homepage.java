package com.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Homepage {
	
	static WebDriver driver;
	
	public Homepage(WebDriver driver){
		PageFactory.initElements(driver, this); 		
	}
	
	@FindBy(xpath="//span[text()='Products']")
	WebElement productTitle;
	
	@FindBy(id="add-to-cart-sauce-labs-backpack")
	WebElement addToCartBtn;
	
	public String verifyHomePageTitle(){
		return driver.getTitle();
	}
	
	public String getProductTitle() {
		return productTitle.getText();
	}
	
	public void clickOnAddtoCartButton() {
		addToCartBtn.click();
	}
}
