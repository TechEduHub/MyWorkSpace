package com.obs.actions;

import org.openqa.selenium.WebDriver;

import com.obs.exception.AutomationException;
import com.obs.utils.AutomationConstants;

public class WebActionHelpers {
	
	public void navigateToBrowser(WebDriver driver, String url) throws AutomationException {
		try {
			driver.navigate().to(url);
		} catch (Exception e) {
			throw new AutomationException(AutomationConstants.EXCEPTION_MESSAGE_FOR_LOAD_URL);
		}
	}

}
