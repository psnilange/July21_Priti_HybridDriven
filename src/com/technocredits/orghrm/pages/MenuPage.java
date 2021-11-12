package com.technocredits.orghrm.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.technocredits.orghrm.base.PredefinedActions;

public class MenuPage extends PredefinedActions {
	public void navigateTo(String menu) {
		String[] inputStr= menu.split("->");
		WebDriverWait wait = new WebDriverWait(driver, 30);
		for(String inputmenu : inputStr)
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='"+inputmenu+"']"))).click();
			//WebElement e  =wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()='\"+inputmenu+\"']")));
			//e.click();
		}
	
	/*public void navigateTo(String menu) {
		String[] inputStr= menu.split("->");
		WebDriverWait wait = new WebDriverWait(driver, 30);
		for(String inputmenu : inputStr)
		WebElement e  =wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()='\"+inputmenu+\"']")));
		e.click();
		}*/
	
	
}	
	


