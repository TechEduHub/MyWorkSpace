package com.tests;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.base.AutomationBase;
import com.pages.DemoLoginPage;
import com.pages.Homepage;


public class DemoLoginTest extends AutomationBase {
	WebDriver driver;
	DemoLoginPage loginpg;
	Homepage homepg;
	

	public DemoLoginTest() {
		super();
	}

	@BeforeMethod
	@Parameters("browserType")
	public void setup(String browserType) throws Exception {
		driver = launchBrowser(browserType);
		loginpg = new DemoLoginPage(driver);
		
	}
	
	@Parameters("browserType")
	@BeforeGroups(groups="sanity")
	public void setup2(String browserType) throws Exception {
		driver = launchBrowser(browserType);
		loginpg = new DemoLoginPage(driver);
		homepg = new Homepage(driver);
		
	}

	// 1. Invalid Username check
	@Test(priority = 1, groups= {"sanity"})
	public void validateInvalidUsernameErrorMessage() throws Exception {
		loginpg.typeUsername("hfhsidfhosj");
		loginpg.clickLogin();
		//Assert.assertTrue(loginpg.isUsernameRequiredErrorDisplayed(), "Error msg is not displayed");

		
	}

	// 2. Invalid password check
	@Test(priority = 2, groups= {"sanity"})
	public void validateInvalidPasswordErrorMessage() throws Exception {
		driver.navigate().refresh();
		loginpg.typePassword("hfhsidfhosj");
		loginpg.clickLogin();
		//Assert.assertTrue(loginpg.isPwdRequiredErrorDisplayed(), "Error msg is not displayed");
		}

	// 3. Empty credentials check
//	@Test(priority = 3)
	public void validateEmptyCredentialsErrorMessage() throws Exception {
		loginpg.typeUsername("");
		loginpg.typePassword("");
		loginpg.clickLogin();
		//Assert.assertTrue(loginpg.isUsernameRequiredErrorDisplayed(), "Error msg is not displayed");
		}

	// 4. Empty credentials check
	//@Test(priority = 4)
	public void validateInvalidCredentialsErrorMessage() {
		loginpg.typeUsername("fdsfs");
		loginpg.typePassword("fsdsf");
		loginpg.clickLogin();
		//Assert.assertTrue(loginpg.iscredentialsNotMatchingErrorDisplayed(), "Error msg is not displayed");

	}

	// 5. Validate Successful login
	//@Test(priority = 5)
	public void validateSuccessfulLogin() {
		loginpg.typeUsername("standard_user");
		loginpg.typePassword("secret_sauce");
		loginpg.clickLogin();
		Assert.assertEquals(homepg.getProductTitle(), "PRODUCTS", "UNable to find the title");

	}

	@AfterMethod
	public void quitBrowser() {
		driver.quit();
	}
}
