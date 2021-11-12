package com.technocredits.orghrm.base;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.technocredits.orghrm.customException.Invalidlocatorselectorexception;

public class PredefinedActions {
	protected static WebDriver driver;
	private static WebDriverWait wait ;
	public static WebDriver start(String url) {
		System.setProperty("webdriver.chrome.driver", "./resources/chromedriver.exe");
		System.out.println("STEP - Open Chrome Browser");
		driver = new ChromeDriver();
		//driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		System.out.println("STEP - Enter url");
		driver.get(url);
		driver.manage().window().maximize();
		wait =new WebDriverWait(driver, 30);
		return driver;
	}
	
	public static void start() {
		start("https://novautomation-trials72.orangehrmlive.com/");
	}
	
	public static void closeBrowser() {
		driver.close();
	}
	
	public static void quitBrowser() {
		driver.quit();
	}
	
	protected List<String>getTextOfAllElements(String locator) {
		List<String> list= new ArrayList<String>();
		 List<WebElement> LisOfWebelements = driver.findElements(By.xpath(locator));
		 for(WebElement elements:LisOfWebelements) {
			 list.add(elements.getText());
		}
		 return list;
	}
	
	public By getByReference(String locatorType, String locatorValue) {
		switch(locatorType) {
		case"XPATH":
			return By.xpath(locatorValue);
		case"ID":
			return By.id(locatorValue);
		default:
			return null;
		}
		
		
	}
	
	public WebElement getElement(String locatorType, String locatorValue, boolean isWaitRequired) {
		//WebDriverWait wait = new WebDriverWait(driver, 30);
		WebElement element =null;
	
		if(isWaitRequired)
			wait.until(ExpectedConditions.invisibilityOfElementLocated(getByReference(locatorType, locatorValue)));
		else
			element = driver.findElement(getByReference(locatorType, locatorValue));
		switch(locatorType) {
			case"XPATH":
				if(isWaitRequired)
					element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locatorValue)));
				else
					element = driver.findElement(By.xpath(locatorValue));
				break;	
				
			case"ID":
				if(isWaitRequired)
					element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(locatorValue)));
				else
					element = driver.findElement(By.xpath(locatorValue));
				break;
			default:
				throw new Invalidlocatorselectorexception ("User should select values from Xpath, css, id, name");
		}
		return element;	
	}		
	
	public void waitTillInVisibilityOfElement(String locatorType, String locatorValue) {
		wait.until(ExpectedConditions.invisibilityOfElementLocated(getByReference(locatorType, locatorValue)));
		
	}
	
	public void waitTillElementToBeClickable(String locatorType, String locatorValue) {
		wait.until(ExpectedConditions.elementToBeClickable(getByReference(locatorType, locatorValue)));
	}
	
	private void scrollToElement(WebElement element) {
		JavascriptExecutor js= (JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollInToView(true)", element);
	}
	
	public void clickOnElement(WebElement element) {
		if(!element.isDisplayed())
			scrollToElement(element);
		wait.until(ExpectedConditions.elementToBeClickable(element));
		element.click();
	}	
	
	/*public List<WebElement> getElements(String locatorType, String locatorValue, boolean isWaitRequired) {
		List<WebElement> listOfWebElement = new ArrayList<WebElement>();
		switch (locatorType) {
		case"XPATH":
			if (isWaitRequired)
				listOfWebElement =wait.until(ExpectedConditions.visibilityOfElementLocated(getByReference(locatorType, locatorValue)));
		
		}
		
		
		return listOFWebElement;
	}*/
		
		
		
	
	
	
		
}
