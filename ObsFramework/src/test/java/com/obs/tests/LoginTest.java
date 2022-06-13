package com.obs.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.obs.pages.LoginPage;

public class LoginTest extends BaseTest{
	
	
	@BeforeMethod
	public void invokeLogin() {
		lpage = new LoginPage();
	}
	
	LoginPage lpage;
	@Test(priority = 0, enabled=true)
	public void verifyEmptyLogin() {
		
		lpage.typeUsername("");
		lpage.typePassword("");
		lpage.clickLogin();
		Assert.assertTrue(lpage.isEmptyErrorMsgDisplayed(), "Empty error message is not displayed");
	}

	// Verify that user is unable to login to the page with invalid username and password
	@Test(priority = 1, enabled=true)
	public void verifyInValidLogin() {
		lpage.typeUsername("standard");
		lpage.typePassword("secrete");
		lpage.clickLogin();
		Assert.assertTrue(lpage.isInvalidErrorMsgDisplayed(), "Invalid error message is not displayed");
	}

}
