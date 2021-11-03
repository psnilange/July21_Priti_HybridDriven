package com.technocredits.orghrm.testscripts;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.asserts.SoftAssert;

import com.technocredits.orghrm.base.PredefinedActions;
import com.technocredits.orghrm.pages.LogInPage;
import com.technocredits.orghrm.pages.MenuPage;

public class TestBase {
	SoftAssert softAssert = new SoftAssert();
	
	public MenuPage setUpAndlogin() {
		System.out.println("Step: Launch OrangeHRM application.");
		PredefinedActions.start();
		LogInPage  logInPage = new  LogInPage();
		logInPage.enterCredentials("Admin", "zM5QbQ@5Sl");
		return logInPage.clickonLoginButton();
	}
	
	
	public void closeBrowser() {
		PredefinedActions.closeBrowser();
	}
}
