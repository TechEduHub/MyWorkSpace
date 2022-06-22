package com.obs.base;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.obs.actions.WebActionHelpers;
import com.obs.datahandler.PropertyDataHandler;
import com.obs.exception.AutomationException;
import com.obs.utils.AutomationConstants;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AutomationBase {
	public static WebDriver driver;
	WebActionHelpers webAction = new WebActionHelpers();
	PropertyDataHandler prop = new PropertyDataHandler();

	public void launchBrowser(String browserName) throws AutomationException {
		switch (browserName) {
		case "chrome":
			launchChromeBrowser();
			break;

		case "firefox":
			// launchFirefoxBrowser();
			break;

		default:
			System.out.println(AutomationConstants.CHECKBROWSER_MESSAGE);
			break;
		}
	}

	private void launchChromeBrowser() throws AutomationException {
		try {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			Properties allProp = prop.readPropertiesFile("config.properties");
			webAction.navigateToBrowser(driver, allProp.getProperty("url"));
		} catch (Exception e) {
			throw new AutomationException(e.getMessage(), e);
		}
	}

	/*
	 * public void launchChromeBrowser(String browserType) throws Exception { try {
	 * if(browserType.equalsIgnoreCase("chrome")) {
	 * System.setProperty("webdriver.chrome.driver",
	 * "C:\\Users\\HP\\Downloads\\Files\\chromedriver_101\\chromedriver.exe");
	 * driver = new ChromeDriver(); } driver.get("https://www.saucedemo.com/");
	 * driver.manage().window().maximize();
	 * driver.manage().timeouts().scriptTimeout(Duration.ofMinutes(2));
	 * driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30)); } catch
	 * (Exception e) { throw new Exception(e.getMessage()); }
	 * 
	 * 
	 * }
	 */

	public void quitBrowser() {
		// driver.close();
		//driver.quit();
	}

}
