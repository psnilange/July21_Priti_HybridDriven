package com.technocredits.orghrm.base;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class PredefinedActions {
	protected static WebDriver driver;
	public static WebDriver start(String url) {
		System.setProperty("webdriver.chrome.driver", "./resources/chromedriver.exe");
		System.out.println("STEP - Open Chrome Browser");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		System.out.println("STEP - Enter url");
		driver.get(url);
		driver.manage().window().maximize();
		return driver;
	}
	
	public static WebDriver start() {
		System.setProperty("webdriver.chrome.driver", "./resources/chromedriver.exe");
		System.out.println("STEP - Open Chrome Browser");
		driver = new ChromeDriver();
		System.out.println("STEP - Enter url");
		driver.get("https://julyautomation-trials72.orangehrmlive.com/");
		driver.manage().window().maximize();
		return driver;
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
	
	
	
	
		
}
