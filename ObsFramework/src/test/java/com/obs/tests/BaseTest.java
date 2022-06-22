package com.obs.tests;


import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import com.obs.actions.WebActionHelpers;
import com.obs.base.AutomationBase;

public class BaseTest {
	
	AutomationBase base;
	
	
	@BeforeTest
	@Parameters("browserType")
	public void launch(String browserType) throws Exception {
		base = new AutomationBase();
		base.launchBrowser(browserType);
		
		
	}

	@AfterTest
	public void quitBrowser() {
		
		base.quitBrowser();
	}
}
