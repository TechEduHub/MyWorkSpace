package com.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import com.constants.AutomationConstants;
import io.github.bonigarcia.wdm.WebDriverManager;

public class AutomationBase {
	static WebDriver driver;

	
	public WebDriver launchBrowser(String browserName) throws Exception {
		switch (browserName) {
		case "chrome":
			launchChromeBrowser();
			break;

		case "firefox":
			//launchFirefoxBrowser();
			break;

		default:
			System.out.println(AutomationConstants.CHECKBROWSER_MESSAGE);
			break;
		}
		return driver;
	}

	
	private void launchChromeBrowser() throws Exception {
		try {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			driver.manage().window().maximize();
		} catch (Exception e) {
			throw new Exception(e);
		}
	}

	
/*	private void launchFirefoxBrowser() throws Exception {
		try {
			FirefoxProfile fp = new FirefoxProfile();
			fp.setPreference("intl.accept_languages", "no,en-us,en");
			DesiredCapabilities capabilities = DesiredCapabilities.firefox();
			capabilities.setCapability(FirefoxDriver.MARIONETTE, true);
			capabilities.setCapability(FirefoxDriver.PROFILE, fp);
			capabilities.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
			FirefoxOptions firefoxOptions = new FirefoxOptions(capabilities);
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver(firefoxOptions);

			driver.manage().window().maximize();
		} catch (Exception e) {
			throw new Exception(e.getCause());
		}
	} */


	public void setDriver(WebDriver driver) {
		this.driver = driver;
	}

	
	public static WebDriver getDriver() {
		return driver;
	}

	
	
	
	
	
}
