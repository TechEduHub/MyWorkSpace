package com.utilities;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitUtil {
	public WebDriverWait wait;

	
	public WebElement waitForElement(WebDriver driver, By elementLocator) throws Exception  {
		WebElement element = null;		
		try {			
			wait = new WebDriverWait(driver, Duration.ofSeconds(30));
			element = wait.until(ExpectedConditions.presenceOfElementLocated(elementLocator));
		} catch (Exception e) {
			throw new Exception("");
		}
		return element;
	}
	public void implicitWait(WebDriver driver, int timeOut) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	
	public void explicitWait(WebDriver driver, WebElement element, int timeOut ) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	
	public void pageLoadTimeOut(WebDriver driver, int timeOut) {
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(timeOut));
	}
	
}
