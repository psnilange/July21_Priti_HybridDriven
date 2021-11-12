package com.technocredits.orghrm.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.technocredits.orghrm.base.PredefinedActions;

public class CommonMethods extends PredefinedActions {
	
	public void  findElement(String shifValue) {
	try {
		//driver.findElement(By.xpath("//div[@Id ='work_shift_id_inputfileddiv']//span[@class ='work_shift_id_inputfileddiv']")).click();
		driver.findElement(By.xpath("//div[@id='work_shift_id_inputfileddiv']//span[@class='caret']//following-sibling::input")).click();
	}catch(StaleElementReferenceException staleException){
		driver.findElement(By.xpath("//div[@id='work_shift_id_inputfileddiv']//span[@class='caret']//following-sibling::input")).click();
	}
	
	//WebElement e =driver.findElement(By.xpath("//ul[@class ='dropdown-content select-dropdown']//span[text()='"+shiftValue+"']"));
	/*while(!e.isDisplayed()) {
		e =driver.findElement(By.xpath("//ul[@class ='dropdown-content select-dropdown']//span[text()='"+shiftValue+"']"));
	}
	e.click();*/
	WebDriverWait wait = new WebDriverWait(driver, 30);//polling time is 500milisecond
	//wait.until(ExpectedConditions.visibilityOf(e));
	WebElement ee =wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//ul[@class ='dropdown-content select-dropdown']//span[text()='"+shifValue+"']")));
	ee.click();
	
	

}
	
}
