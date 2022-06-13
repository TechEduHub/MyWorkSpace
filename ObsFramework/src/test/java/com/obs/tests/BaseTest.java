package com.obs.tests;


import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import com.obs.base.AutomationBase;

public class BaseTest {
	
	
	AutomationBase base;
	
	@BeforeTest
	public void launch() throws Exception {
		base = new AutomationBase();
		 base.launchChromeBrowser();
	}

	@AfterTest
	public void quitBrowser() {
		
		base.quitBrowser();
	}
}
