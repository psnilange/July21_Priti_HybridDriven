package com.technocredits.orghrm.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.technocredits.orghrm.base.PredefinedActions;

public class UserProfilePage extends PredefinedActions{
	
	
	public boolean isUserProfileDisplayed() {
		return driver.findElement(By.xpath("//div [@id ='menu-container']//div[@id='menu-profile']")).isDisplayed();
	}
	
	public void clickOnUserprofileDropDown() throws InterruptedException {
		Thread.sleep(2000);
		driver.findElement(By.xpath("//a [@id='user-dropdown']//i [@class ='material-icons']")).click();
	}
	
	public List<String> getListOfUserMenuOptions(){
		return getTextOfAllElements("//ul [@id='user_menu']//li/a"); 
	}
	
	public int getTotalUSerMenuOptions() {
		return getListOfUserMenuOptions().size();
	}
		
	public void selectAbouOption() throws InterruptedException {
		driver.findElement(By.xpath("//ul [@id ='user_menu']//li/a [text() ='About']")).click();
		Thread.sleep(5000);
	}
		
	public String getEmpCountinfo() {
		String NoOfEmployee = driver.findElement(By.xpath("//p[contains(text(),'Employees: 95 (305 more allowed)')]")).getText();
		return NoOfEmployee;
	}
	
	public  List<String> getAboutPopUpText(){
		return getTextOfAllElements("//div[@class='modal-body']//div[@class ='row']/div"); 
	} 
	
	public void clickOnPopCancelButton() {
		driver.findElement(By.xpath("//div[@class ='modal-footer']//a[@id ='heartbeatCancelBtn']")).click();
	}
	
	
}
