package com.demo.tests;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.demo.pages.DemoLoginPage;
import com.demo.pages.Homepage;
import com.obs.base.AutomationBase;
import com.obs.exception.AutomationException;

public class HomepageTest extends AutomationBase{
	
	WebDriver driver;
	DemoLoginPage loginpg;
	Homepage homepg;
	
	public HomepageTest(){
		super();
	}
	
	@BeforeMethod
	@Parameters("browserType")
	public void setup(String browserType) throws AutomationException {
		driver = launchBrowser(browserType);
		loginpg = new DemoLoginPage(driver);
		loginpg.login("standard_user", "secret_sauce");
		homepg = new Homepage(driver);
	}

	@Test
	public void validateProductsPage() {
		homepg.clickOnAddtoCartButton();
	}
}
