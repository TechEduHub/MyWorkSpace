package com.obs.tests;

import java.io.IOException;
import java.util.Properties;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.obs.actions.WebActionHelpers;
import com.obs.datahandler.PropertyDataHandler;
import com.obs.pages.LoginPage;

public class LoginTest extends BaseTest{
	LoginPage lpage;
	PropertyDataHandler prop = new PropertyDataHandler();
	
	@BeforeMethod
	public void invokeLogin() {
		lpage = new LoginPage();
	}
	
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
	@Test(priority=2)
	public void verifyValidLogin() throws IOException {
		Properties allProp = prop.readPropertiesFile("config.properties");
		lpage.typeUsername(allProp.getProperty("username"));
		lpage.typePassword(allProp.getProperty("password"));
		lpage.clickLogin();
		Assert.assertTrue(lpage.isInvalidErrorMsgDisplayed(), "Invalid error message is not displayed");
	}

}
