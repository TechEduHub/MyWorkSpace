package com.obs.base;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class AutomationBase {
	public static WebDriver driver;
	
	public void launchChromeBrowser() throws Exception {
		try {
			System.setProperty("webdriver.chrome.driver",
					"C:\\Users\\HP\\Downloads\\Files\\chromedriver_101\\chromedriver.exe");
			driver = new ChromeDriver();
			driver.get("https://www.saucedemo.com/");
			driver.manage().window().maximize();
			driver.manage().timeouts().scriptTimeout(Duration.ofMinutes(2));
			driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
		
	}
	
	public void quitBrowser() {
		//driver.close();
		driver.quit();
	}

}
