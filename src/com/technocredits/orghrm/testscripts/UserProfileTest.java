package com.technocredits.orghrm.testscripts;

import java.util.ArrayList;
import java.util.List;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.technocredits.orghrm.base.PredefinedActions;
import com.technocredits.orghrm.pages.LogInPage;
import com.technocredits.orghrm.pages.UserProfilePage;

public class UserProfileTest extends TestBase{
	UserProfilePage userProfilePage = new UserProfilePage();
	
	SoftAssert softAssert = new SoftAssert();
	
	@BeforeClass
	public void setup() {
		super.setUpAndlogin();
	}
		
	@Test(priority=2)
	public void isUserProfiledisplayed() {
		System.out.println("Step: Verify User profile is displayed.");
		softAssert.assertTrue(userProfilePage.isUserProfileDisplayed());
	}
	
	@Test(priority=3)
	public void clickOnUserProfileDD() throws InterruptedException {
		System.out.println("Step: Click on Arrow icon on profile.");
		userProfilePage.clickOnUserprofileDropDown();
		System.out.println("Yes");
	}
	
	@Test(priority=4)
	public void verifyListOfUserMenuOptions() {
		System.out.println("Step: Verify user menu total 3 options are displayed.");
		List<String> actuallistOFUserMenuOptions = userProfilePage.getListOfUserMenuOptions();
		ArrayList<String>explistOFUserMenuOptions =new ArrayList<String>();
		explistOFUserMenuOptions.add("About");
		explistOFUserMenuOptions.add("Change Password");
		explistOFUserMenuOptions.add("Logout");
		softAssert.assertEquals(actuallistOFUserMenuOptions,explistOFUserMenuOptions,"Actual and expcted list of user options doesnot mathc");
	}
	
	@Test
	void VerifyTotalUserMenuOptions() {
		System.out.println("Total avalible User Menu Options are :"+userProfilePage.getListOfUserMenuOptions());
	}
		
	@Test(priority=5)
	public void clickOnAbout() throws InterruptedException {
		System.out.println("Step: Click on About option.");
		userProfilePage.clickOnUserprofileDropDown();;
		Thread.sleep(3000);
	}
			
	@Test(priority=6)
	public void  verifyAboutPopUpText() {
		System.out.println("Step: Verify information displayed alert");
		List<String> actuallistOfDetails = userProfilePage.getAboutPopUpText();
		ArrayList<String> explistOfDetails =new ArrayList<String>();
		explistOfDetails.add("Company Name: OrangeHRM (Pvt) Ltd(Parallel Demo)");
		explistOfDetails.add("Version: OrangeHRM 7.2.159485");
		explistOfDetails.add("Employees: 95 (305 more allowed)");
		explistOfDetails.add("Users: 77 (723 more allowed)");                                
		softAssert.assertEquals(actuallistOfDetails,explistOfDetails,"Actual and expcted list of user options doesnot mathc");
	}
	
	@AfterClass
	public void closeBrowser() {
		super.closeBrowser();
	}
	
		
	/*@Test
	public void clickOnPopUpButton() {
	System.out.println("Step: Click on the Cancel button on Alert");
		userProfilePage.clickOnPopCancelButton();
	}*/
	
	

}
