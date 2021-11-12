package com.technocredits.orghrm.testscripts;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.technocredits.orghrm.base.PredefinedActions;
import com.technocredits.orghrm.pages.LogInPage;
import com.technocredits.orghrm.pages.MenuPage;
import com.technocredits.orghrm.pages.PIM_AddEmployeePage;
import com.technocredits.orghrm.pages.PIM_EmployeeListPage;
import com.technocredits.orghrm.pojo.Employee;
import com.technocredits.orghrm.util.ExcelSheetOperations;


public class PIM_AddEmployeeTest extends TestBase{
	
	private MenuPage menuPage;
	
	@BeforeMethod
	public void setUp() {
		menuPage = super.setUpAndlogin();
	}
		
	/*@Test
	public void clickOnPIMMenu()  {
		System.out.println("Step: Click on PIM Menu");
		menuPage.navigateTo("PIM->Add Employee");
		
	}*/
	
	@Test (dataProvider ="employeeDataProvider")
	public void enterEmployeeDetails(String fName,String middleName, String lName,String location, String hobbies,String wrokShift, String effectiveFrom , String region, String fte, String tempDept) throws InterruptedException {
		System.out.println("Step: Click on PIM Menu");
		menuPage.navigateTo("PIM->Add Employee");
		PIM_AddEmployeePage pim_AddEmppage = new PIM_AddEmployeePage();
		String empId = pim_AddEmppage.getEmployeeId();
		System.out.println("Step: Enter add employee details");
			
		pim_AddEmppage.setFirstName(fName);
		System.out.println("click First Name");
		
		pim_AddEmppage.setMiddleName(middleName);
		System.out.println("enter middel Name");
		
		pim_AddEmppage.setLastName(lName);
		System.out.println("enter last Name");
		
		pim_AddEmppage.setLocation(location);
		System.out.println("select location");
		
		System.out.println("click on next button");
		pim_AddEmppage.clickOnNext();
		
		pim_AddEmppage
		.setHobbies(hobbies);
		
		 System.out.println("Click on nex button");
		 pim_AddEmppage.clickOnNext2()
		 
		.setWorkShift(wrokShift)
		.setEffectiveFrom(effectiveFrom)
		.setRegion(region)
		.setFte(fte)
		.setTemporaryDepartment(tempDept)
		.clickOnSavebutton();
		 boolean isSuccessfullySaved = pim_AddEmppage.isSuccessfullySaved();
		 Assert.assertTrue(isSuccessfullySaved);
		 
		 boolean isUsernameTitleDisplayed = pim_AddEmppage.isUsernameTitleDisplayed();
		 Assert.assertTrue(isUsernameTitleDisplayed );
		 
		 menuPage.navigateTo("Employee List");
		 PIM_EmployeeListPage pim_EmployeeListPage = new PIM_EmployeeListPage();
		/* List<Employee> listOfEmployee = pim_EmployeeListPage
				 .SetEmpNameInQuickSearch("Priti")
				 .clickOnQuickSearch()
				 .getListOFEmployee();
		 boolean isEmployeeDisplayed= false;
		 for (Employee e:listOfEmployee) {
			 if (e.getEmpid().equals("0138")) {
				 isEmployeeDisplayed=true;
				 break;
			 }
		 }*/
		 List<Employee> listOfEmployee = pim_EmployeeListPage
				 .SetEmpIdInQuickSearch(empId)
				 .getListOfEmployee();
		 
		 	//Assert.assertEquals(listOfEmployee.get(0).getEmpid(), empId);
		 	Assert.assertTrue(listOfEmployee.size()==1);
		 System.out.println("enterEmployeeDetails Test comleted successfully");
		
	}
	
	@DataProvider(name="employeeDataProvider")
	public Object[][]getEmployeeData() throws IOException {
		return ExcelSheetOperations.getTableData("./testdata/AddEmployee.xlsx", "data");
		
	}
	
	
	@AfterMethod
	public void closebrowser(){
		super.closeBrowser();
	}
	
	

	
}
