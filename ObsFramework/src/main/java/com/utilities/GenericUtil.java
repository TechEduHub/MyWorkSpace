package com.utilities;

import java.io.File;
import java.util.List;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.Select;

public class GenericUtil {
	Actions act;
	/**
	 * method is to drag and drop operation using XY location
	 * @param driver
	 * @param source
	 * @param a
	 * @param b
	 */
	public void  mouseDragDropUsingXYLocation(WebDriver driver , WebElement source ,int x , int y  )
	
	{
		act = new Actions(driver);
		try {
			act.moveToElement(source).clickAndHold().moveByOffset( x, y).build().perform();
		}
		catch (Exception e) {

			System.out.println("Exceptiom occured" +e);
			// TODO: handle exception
		}
	}
	public void  mouseDragDrop(WebDriver driver, WebElement source, WebElement target)
	{
		act = new Actions(driver);	
		try {
			act.moveToElement(source).clickAndHold().moveToElement(target).build().perform();
		}
		catch (Exception e) {

			System.out.println("Exceptiom occured" +e);
			// TODO: handle exception
		}
	}
	/**
	 * method to return table row count
	 * @return
	 * @throws Exception 
	 */
	public int getTableRowCount(WebDriver driver, List <WebElement> element) throws Exception {
		try {
			return element.size();
		}catch(Exception e) {
			throw new Exception("getTableRowCount (UtilityActionHelper) : "+e.getMessage());
		}
	}
	/**
	 * method to return table column count
	 * @throws Exception 
	 */
	public int getTableColumnCount(WebDriver driver, List <WebElement> element) throws Exception {
		try {
			return element.size();
		}catch(Exception e) {
			throw new Exception("getTableColumnCount (UtilityActionHelper) : "+e.getMessage());
		}
	}
	/**
	 * method to get table content based on row and column index
	 * @throws Exception 
	 */
	public String getTableContentOnRowAndColumn(WebDriver driver, String xpath) throws Exception {
		try {
			return driver.findElement(By.xpath(xpath)).getText();
		}catch (Exception e) {
			throw new Exception("getTableContentOnRowAndColumn (UtilityActionHelper) : "+e.getMessage());
		}
	}
	/**
	 * method to select drop down by visible text
	 * @throws Exception 
	 */
	public void selectDropDownByVisibleText(WebElement element, String visibleText) throws Exception {
		try {
			Select dropDown = new Select(element);
			dropDown.selectByVisibleText(visibleText);
		}catch(Exception e) {
			throw new Exception("selectDropDownByVisibleText : "+e.getMessage());
		}
	}
	/**
	 * method to select drop down by index
	 * @throws Exception 
	 */	
	public void selectDropDownByIndex(WebElement element, int index) throws Exception {
		try{
			Select dropDown = new Select(element);
			dropDown.selectByIndex(index);
		}catch (Exception e) {
			throw new Exception("selectDropDownByIndex  : "+e.getMessage());
		}
	}
	/**
	 * method to select drop down by value
	 * @throws Exception 
	 */
	public void selectDropDownByValue(WebElement element, String value) throws Exception {
		try{
			Select dropDown = new Select(element);
			dropDown.selectByValue(value);
		}catch (Exception e) {
			throw new Exception("selectDropDownByValue : "+e.getMessage());
		}
	}
	/**
	 * method to take screenshot
	 * @throws Exception 
	 */
	public void capturePageScreenshot(WebDriver driver) throws Exception {
		try {
			String random = RandomStringUtils.randomAlphanumeric(10);
			String fileNm = "FailedSS "+ random;
			File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			FileHandler.copy(src, new File(fileNm+".png"));
		}catch (Exception e) {
			throw new Exception("capturePageScreenshot : "+e.getMessage());
		}
	}
	/**
	 * method to drag and drop
	 * @throws Exception 
	 */
	public void dragAndDrop(WebDriver driver, WebElement source, WebElement target) throws Exception {
		try {
			Actions act = new Actions(driver);
			act.moveToElement(source).clickAndHold().moveToElement(target).release().build().perform();
		}catch (Exception e) {
			throw new Exception("dragAndDrop  : "+e.getMessage());
		}
	}
	/**
	 * method to drag to X and Y points
	 * @throws Exception 
	 */
	public void dragToXandY(WebDriver driver,WebElement source, int x, int y) throws Exception {
		try {
			Actions act = new Actions(driver);
			act.moveToElement(source).clickAndHold().moveByOffset(x, y).release().build().perform();
		}catch (Exception e) {
			throw new Exception("dragToXandY : "+e.getMessage());
		}
	}


}
