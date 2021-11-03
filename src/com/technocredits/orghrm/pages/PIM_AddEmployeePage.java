package com.technocredits.orghrm.pages;

import org.openqa.selenium.By;

import com.technocredits.orghrm.base.PredefinedActions;

public class PIM_AddEmployeePage extends PredefinedActions  {
	
	/*public void clickOnPIM() {
		driver.findElement(By.xpath("//span[text()='PIM']")).click();
	}*/
	
	public void clickonPIM_AddEmployee() {
		driver.findElement(By.xpath("//span [@combinedmenutitle ='PIM > Add Employee']")).click();
		
	}
		
	public PIM_AddEmployeePage setFirstName(String firstName) throws InterruptedException {
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input [@id='first-name-box']")).sendKeys(firstName);
		return this;
	}
	
	public PIM_AddEmployeePage setMiddleName(String middleName) {
		driver.findElement(By.xpath("//input [@id='middle-name-box']")).sendKeys(middleName);
		return this;
	}
	
	public PIM_AddEmployeePage setLastName(String lastName) {
		driver.findElement(By.xpath("//input [@id='last-name-box']")).sendKeys(lastName);
		return this;
	}
		
	public PIM_AddEmployeePage setEmployeeId(String employeeId) {
		driver.findElement(By.xpath("//input[@id='employeeId']")).sendKeys(employeeId);
		return this;
	}
	
	public PIM_AddEmployeePage setLocation(String location){
		driver.findElement(By.xpath("//button [@data-id='location']")).click();
		driver.findElement(By.xpath("//span[text() ='"+location+"']//parent::a")).click();
		return this;
	}
		
	public PIM_AddEmployeePage clickOnNext(){
		//driver.findElement(By.xpath("//button [@id ='modal-save-button']")).click();
		driver.findElement(By.xpath("//button[text() ='Next']']")).click();
		return this;
	}
	
	
	public void addEmployeeinfo(String firstName,String middleName,String lastName,String location) throws InterruptedException {
		setFirstName(firstName);
		setMiddleName(middleName);
		setLastName(lastName);
		setLocation(location);
	}	
	
	public PIM_AddEmployeePage setHobbies(String hobby) {
		driver.findElement(By.xpath("//input[@id ='5']")).sendKeys(hobby);
		//driver.findElement(By.xpath("//label [text()='Hobbies']//preceding-sibling::input")).sendKeys(hobby);
		return this;
	}
	
	public PIM_AddEmployeePage setworkShift(String shiftValue) {
		driver.findElement(By.xpath("//div[@Id ='work_shift_id_inputfileddiv']//span[@class ='work_shift_id_inputfileddiv']")).click();
		driver.findElement(By.xpath("//ul[@class ='dropdown-content select-dropdown']//span[text()='"+shiftValue+"']")).click();
		return this;
	}	
	/*public PIM_AddEmployeePage effectiveFrom(){
		//input[contains(@class,'ng-valid-schema-form ng-touched')]//following-sibling::i
		return this;
	} 
	*/
	
	

}
