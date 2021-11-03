package com.technocredits.orghrm.testscripts;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.technocredits.orghrm.base.PredefinedActions;
import com.technocredits.orghrm.pages.DashboardPage;
import com.technocredits.orghrm.pages.LogInPage;

public class DashboardTest extends TestBase {
		
	@BeforeClass
	public void setUp() {
		super.setUpAndlogin();
	}
	@
	Test(priority=1)
	public void verifyWidgetsTest() throws InterruptedException{
		DashboardPage dashboardPage = new DashboardPage();
				
		System.out.println("Step: Verify Dashboard page HeaderTitle should be Dashbord");
		String actualdashboargHeadertitleText = dashboardPage.getDashboardPageHeaderTitle();
		String expecteddashboargHeadertitleText  = "Dashboard";
		softAssert.assertEquals(actualdashboargHeadertitleText,expecteddashboargHeadertitleText ,"DashBoard page Header title was not disaplyed as DashBoard");
		Thread.sleep(3000);
		System.out.println("Step: Verify Dashboard PageTitle should be Dashbord");
		String actualdashboargtitleText = dashboardPage.getDashboardPageTitle();
		String expecteddashboargtitleText="Dashboard";
		softAssert.assertEquals(actualdashboargtitleText,expecteddashboargtitleText ,"DashBoard page title was not disaplyed as DashBoard");
		
		System.out.println("Step: Verify total 11 widget's are disply on Dashboard page");
		int totalWidgets= dashboardPage.getAllWidgetsOnDashBoard();
		System.out.println("totalWidgets:"+totalWidgets);
		softAssert.assertEquals(totalWidgets,12, "Total no of actual Widgets are +listofWidgets.size()+  does not match with the expected widgets =12.");
				
		ArrayList<String> expectedListofWidgets = new ArrayList<String>();
		expectedListofWidgets.add("Quick Access");
		expectedListofWidgets.add("Buzz Latest Posts");
		expectedListofWidgets.add("Employee Job Details");
		expectedListofWidgets.add("My Actions");
		expectedListofWidgets.add("Headcount by Location");
		expectedListofWidgets.add("Employees on Leave Today");
		expectedListofWidgets.add("Time At Work");
		expectedListofWidgets.add("Performance Quick Feedback");
		expectedListofWidgets.add("Annual basic payment by Location");
		expectedListofWidgets.add("Latest Documents");
		expectedListofWidgets.add("Latest News");
		expectedListofWidgets.add("Yearly New Hires");
		
		System.out.println("Step:Get all 12 widget's name");
		List<String> actualListofWidgets = dashboardPage.getAllWidgetText();
		System.out.println("Step: verify all 12 Widgets names");
		softAssert.assertEquals(actualListofWidgets, expectedListofWidgets,"List of actual and expected Widgets does not match");
		softAssert.assertAll();				
	} 
	@AfterClass
	public void closeBroswer() {
		super.closeBrowser();
	}
	
	
}
