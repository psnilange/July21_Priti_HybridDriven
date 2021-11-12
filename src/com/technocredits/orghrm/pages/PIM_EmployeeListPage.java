package com.technocredits.orghrm.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.technocredits.orghrm.base.PredefinedActions;
import com.technocredits.orghrm.pojo.Employee;

public class PIM_EmployeeListPage extends PredefinedActions {
	
	public PIM_EmployeeListPage clickOnFilter() {
		driver.findElement(By.xpath("//li[@data-tooltip='Filter']")).click();
		return this;
	}
	
	public PIM_EmployeeListPage SetEmpIdInQuickSearch(String empId) {
		return SetEmpNameInQuickSearch(empId); 
	}
	
	public PIM_EmployeeListPage SetEmpNameInQuickSearch(String empName) {
		WebDriverWait wait= new WebDriverWait(driver,40);
		WebElement quickSearch =wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='employee_name_quick_filter_employee_list_value']")));
		quickSearch.sendKeys(empName);
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e2) {
		e2.printStackTrace();
		}
		return this;
	}
	
	public PIM_EmployeeListPage clickOnQuickSearch(boolean isWaitRequired) {
		WebDriverWait wait=new WebDriverWait(driver,15);
		if(isWaitRequired)
			waitTillSuggestionBoxAppear();
		WebElement quickSerch=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//i[@id='quick_search_icon']")));
		quickSerch.click();
		return this;
	}
	
	
	private void waitTillSuggestionBoxAppear() {
		System.out.println("wait until the list get populated and then click quick search");
		WebDriverWait wait=new WebDriverWait(driver,15);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='employee_name_quick_filter_employee_list_dropdown']/div[@class='angucomplete-row']")));
		
	}
	
	public Employee getDetailsOfEmployeeById(boolean isEmployeeExpected) {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		if (isEmployeeExpected)
			wait.until(ExpectedConditions.numberOfElementsToBe(By.xpath("//table [@id='employeeListTable']/tbody/tr"),1));
		return getListOfEmployee().get(0);
	}
	public List<Employee> getListOfEmployee(){
		int rowCount= driver.findElements(By.xpath("//table [@id='employeeListTable']/tbody/tr")).size();
		List<Employee> listOEmployee = new ArrayList<Employee>();
		for(int rowIndex=1;rowIndex<=rowCount;rowIndex++) {
			System.out.println("Row iterated ->"+rowIndex);
			Employee emp1 = new Employee();
			emp1.setEmpiD(driver.findElement(By.xpath("//table [@id='employeeListTable']/tbody/tr["+rowIndex+"]/td[2]")).getText());
			emp1.setName(driver.findElement(By.xpath("//table [@id='employeeListTable']/tbody/tr["+rowIndex+"]/td[3]")).getText());
			emp1.setJobTitle(driver.findElement(By.xpath("//table [@id='employeeListTable']/tbody/tr["+rowIndex+"]/td[4]")).getText());
			emp1.setStatus(driver.findElement(By.xpath("//table [@id='employeeListTable']/tbody/tr["+rowIndex+"]/td[5]")).getText());
			emp1.setSubUnit(driver.findElement(By.xpath("//table [@id='employeeListTable']/tbody/tr["+rowIndex+"]/td[6]")).getText());
			emp1.setCostCenter(driver.findElement(By.xpath("//table [@id='employeeListTable']/tbody/tr["+rowIndex+"]/td[7]")).getText());
			emp1.setlocation(driver.findElement(By.xpath("//table [@id='employeeListTable']/tbody/tr["+rowIndex+"]/td[8]")).getText());
			emp1.setsuperVisor(driver.findElement(By.xpath("//table [@id='employeeListTable']/tbody/tr["+rowIndex+"]/td[9]")).getText());
			listOEmployee.add(emp1);
		}
		return listOEmployee;
	}
	
	public boolean isUserNameTitleDisplayed(String title){
		WebDriverWait  wait = new WebDriverWait(driver, 30);
		try {
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span [@id ='pim.navbar.employeeName']")));
			return true;
		}catch(TimeoutException te) {
			return false;
		}
	
	}
	
	
	
}
