package com.demo.tests;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import com.demo.pages.DemoLoginPage;
import com.demo.pages.Homepage;
import com.obs.base.AutomationBase;
import com.obs.exception.AutomationException;

public class DemoLoginTest extends AutomationBase {
	WebDriver driver;
	DemoLoginPage loginpg;
	Homepage homepg;

	public DemoLoginTest() {
		super();
	}

	@BeforeMethod
	@Parameters("browserType")
	public void setup(String browserType) throws AutomationException {
		driver = launchBrowser(browserType);
		loginpg = new DemoLoginPage(driver);
		homepg = new Homepage(driver);
	}
	
	@Parameters("browserType")
	@BeforeGroups(groups="sanity")
	public void setup2(String browserType) throws AutomationException {
		driver = launchBrowser(browserType);
		loginpg = new DemoLoginPage(driver);
		homepg = new Homepage(driver);
		
	}

	// 1. Invalid Username check
	@Test(priority = 1, groups= {"sanity"})
	public void validateInvalidUsernameErrorMessage() {
		loginpg.typeUsername("hfhsidfhosj");
		loginpg.clickLogin();
		Assert.assertTrue(loginpg.isPwdRequiredErrorDisplayed(), "Error msg is not didplayed");
		
	}

	// 2. Invalid password check
	@Test(priority = 2, groups= {"sanity"})
	public void validateInvalidPasswordErrorMessage() {
		driver.navigate().refresh();
		loginpg.typePassword("hfhsidfhosj");
		loginpg.clickLogin();
		Assert.assertTrue(loginpg.isUsernameRequiredErrorDisplayed(), "Error msg is not displayed");

	}

	// 3. Empty credentials check
	@Test(priority = 3)
	public void validateEmptyCredentialsErrorMessage() {
		loginpg.typeUsername("");
		loginpg.typePassword("");
		loginpg.clickLogin();
		Assert.assertTrue(loginpg.isUsernameRequiredErrorDisplayed(), "Error msg is not displayed");

	}

	// 4. Empty credentials check
	@Test(priority = 4)
	public void validateInvalidCredentialsErrorMessage() {
		loginpg.typeUsername("fdsfs");
		loginpg.typePassword("fsdsf");
		loginpg.clickLogin();
		Assert.assertTrue(loginpg.iscredentialsNotMatchingErrorDisplayed(), "Error msg is not displayed");

	}

	// 5. Validate Successful login
	@Test(priority = 5)
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
