package com.technocredits.orghrm.testscripts;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.technocredits.orghrm.base.PredefinedActions;
import com.technocredits.orghrm.pages.LogInPage;

public class LogInTest {
	SoftAssert softAssert= new SoftAssert();
	
	
	@BeforeMethod
	public void setUp() {
		PredefinedActions.start();
	}
		
	@Test
	public void verifylogInPage() {
		System.out.println("Step: Verify Logo displayed on Login Page");
		LogInPage logInPage = new LogInPage();
		boolean isLogoDisplayed = logInPage.isLogoDispalyed();
		softAssert.assertTrue(isLogoDisplayed, "Logo was not displayed on long in Page as expected");
		
		System.out.println("Step: Verify Login Panel displayed on Login Page.");
		boolean isLogInPanelDispalyed = logInPage.isLogInPanelDispalyed();
		softAssert.assertTrue(isLogInPanelDispalyed, "Login Panel was not displayed on long in Page as expected");
		
		System.out.println("Step: Please Enter Credentials");
		logInPage.enterCredentials("Admin",  "zM5QbQ@5Sl");
		System.out.println("Step: Click on lOGIN button");
		logInPage.clickonLoginButton();
		softAssert.assertAll();
	}
	
	@Test
	public void LoginTestWithoutPassword() {
		LogInPage logInPage = new LogInPage();
		System.out.println("Step: Please Enter Credentials");
		logInPage.enterCredentials("Admin",  "");
		softAssert.assertAll();
		
		System.out.println("Step: Click on lOGIN button");
		logInPage.clickonLoginButton();
		String expectedErrorMessage= "Password cannot be empty";
		String actualErrorMessage= logInPage.getErrorMessageforloginWithoutpassword();
		Assert.assertEquals(actualErrorMessage,expectedErrorMessage);
	}	
	
	@Test
	public void LoginTestWithoutUsername() {
		LogInPage logInPage = new LogInPage();
		System.out.println("Step: Please Enter Credentials");
		logInPage.enterCredentials("",  "zM5QbQ@5Sl");
		softAssert.assertAll();
		
		System.out.println("Step: Click on lOGIN button");
		logInPage.clickonLoginButton();
		String expectedErrorMessage= "Username cannot be empty";
		String actualErrorMessage= logInPage.getErrorMessageloginWithoutUserName();
		Assert.assertEquals(actualErrorMessage,expectedErrorMessage);
	}	
	
	
	
	@AfterMethod
	public void closeBroswer(){
		PredefinedActions.closeBrowser();
	}	
}		
	
	
	
	

