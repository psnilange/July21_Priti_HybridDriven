package com.technocredits.orghrm.testscripts;


import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.technocredits.orghrm.base.PredefinedActions;
import com.technocredits.orghrm.pages.LogInPage;
import com.technocredits.orghrm.pages.MenuPage;
import com.technocredits.orghrm.pages.PIM_AddEmployeePage;


public class PIM_AddEmployeeTest extends TestBase{
	PIM_AddEmployeePage pim_AddEmppage = new PIM_AddEmployeePage();
	MenuPage menuPage;
	
	@BeforeClass
	public void setUp() {
		menuPage = super.setUpAndlogin();
	}
		
	@Test(priority=1)
	public void clickOnPIMMenu()  {
		System.out.println("Step: Click on PIM Menu");
		menuPage.navigateTo("PIM->Add Employee");
		
	}
	
	@Test (priority=2)
	public void enterEmployeeDetails() throws InterruptedException {
		System.out.println("Step: Enter add employee details");
		pim_AddEmppage.setFirstName("Priti")
		.setLastName("Vattanavar")
		.setMiddleName("S")
		.setLocation("Australian Regional HQ")
		.clickOnNext();
	}
	
	@Test (priority=3)
	public void clickOnNext() {
	System.out.println("Step: Click on Next");
	
	}
	
	
	
	
	
	
	/*@AfterClass
	public void closebrowser(){
		super.closeBrowser();
	}*/
	
	
/*	System.out.println("Step: Enter FirsName");
	System.out.println("Step: Enter MiddleName");
	System.out.println("Step: Enter LastName");
	System.out.println("Step: Enter Employee Id");
	System.out.println("Step: Enter Employee Location");*/
	
}
