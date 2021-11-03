package com.technocredits.orghrm.pages;

import org.openqa.selenium.By;

import com.technocredits.orghrm.base.PredefinedActions;

public class LogInPage extends PredefinedActions{
	public boolean isLogoDispalyed() {
	boolean isLogoDispalyed = driver.findElement(By.xpath("//div [@id ='divLogo']//img")).isDisplayed();
	return isLogoDispalyed;
	}
	
	public boolean isLogInPanelDispalyed() {
		 boolean isLogInPanelDispalyed =driver.findElement(By.xpath("//div[@id ='logInPanelHeading']")).isDisplayed();
		 return isLogInPanelDispalyed;
	}
	
	public void enterCredentials(String userName,String passwrod ) {
		driver.findElement(By.xpath("//input[@id ='txtUsername']")).sendKeys(userName);
		driver.findElement(By.xpath("//input[@id ='txtPassword']")).sendKeys(passwrod);
	}
	public MenuPage clickonLoginButton() {
		driver.findElement(By.xpath("//input [@id='btnLogin']")).click();
		return new MenuPage();
	}
	
	/*public void clickOnLoginButton() {
		driver.findElement(By.xpath("//input [@id='btnLogin']")).click();
		
	}*/
	
	public String getErrorMessageforloginWithoutpassword() {
		return driver.findElement(By.xpath("//div[@id ='divLoginButton']/span ")).getText();
	}
	
	public String getErrorMessageloginWithoutUserName() {
		return driver.findElement(By.xpath("//div[@id ='divLoginButton']/span")).getText();
	}
	
}
