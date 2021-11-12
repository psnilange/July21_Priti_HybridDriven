package com.technocredits.orghrm.pages;

import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;

import com.technocredits.orghrm.base.PredefinedActions;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
public class PIM_AddEmployeePage extends PredefinedActions  {
	
			
	public void clickonPIM_AddEmployee() {
		clickOnElement(getElement("XPATH","//span [@combinedmenutitle ='PIM > Add Employee']",true));
		//driver.findElement(By.xpath("//span [@combinedmenutitle ='PIM > Add Employee']")).click();
	}
		
	public PIM_AddEmployeePage setFirstName(String firstName) throws InterruptedException {
		//WebDriverWait wait = new WebDriverWait(driver,30);
		//WebElement e =wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input [@id='first-name-box']")));
		WebElement e =getElement("XPATH","//input [@id='first-name-box']",true);
		e.sendKeys(firstName);
		return this;
	}
	
	public PIM_AddEmployeePage setMiddleName(String middleName) {
		//driver.findElement(By.xpath("//input [@id='middle-name-box']")).sendKeys(middleName);
		WebElement e =getElement("XPATH","//input [@id='middle-name-box']",false);
		e.sendKeys(middleName);
		return this;
	}
	
	public PIM_AddEmployeePage setLastName(String lastName) {
		//driver.findElement(By.xpath("//input [@id='last-name-box']")).sendKeys(lastName);
		WebElement e =getElement("XPATH","//input [@id='last-name-box']",false);
		e.sendKeys(lastName);
		return this;
	}
		
	public PIM_AddEmployeePage setEmployeeId(String employeeId) {
		//driver.findElement(By.xpath("//input[@id='employeeId']")).sendKeys(employeeId);
		WebElement e =getElement("XPATH","//input[@id='employeeId']",false);
		e.sendKeys(employeeId);
		return this;
	}
	
	public String getEmployeeId() {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		WebElement employeeId = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='employeeId']")));
		//WebElement employeeId =getElement("XPATH","//input[@id='employeeId']",true);
		return employeeId.getAttribute("value");
	}
	
	public PIM_AddEmployeePage setLocation(String location){
		//driver.findElement(By.xpath("//button [@data-id='location']")).click();
		clickOnElement(getElement("XPATH","//button [@data-id='location']",false));
		//driver.findElement(By.xpath("//span[text() ='"+location+"']//parent::a")).click();
		clickOnElement(getElement("XPATH","//span[text() ='"+location+"']//parent::a",false));
		return this;
	}
		
	public PIM_AddEmployeePage clickOnNext(){
		//WebDriverWait wait = new WebDriverWait(driver,30);
		//WebElement e = 
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button [@id ='modal-save-button']")));
		//e.click();
		clickOnElement(getElement("XPATH","//button [@id ='modal-save-button']",true));
		return this;
	}
	
	public PIM_AddEmployeePage clickOnNext2(){
		//JavascriptExecutor js = (JavascriptExecutor) driver;
		//js.executeScript("window.scrollBy(0,300)");
		//WebDriverWait wait = new WebDriverWait(driver,30);
		//WebElement e = 
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@class ='btn waves-effect waves-light right']")));
		//e.click();
		clickOnElement(getElement("XPATH","//button[@class ='btn waves-effect waves-light right']",true));
		return this;
	}
	
	
	public void addEmployeeinfo(String firstName,String middleName,String lastName,String location) throws InterruptedException {
		setFirstName(firstName);
		setMiddleName(middleName);
		setLastName(lastName);
		setLocation(location);
	}	
	
	public PIM_AddEmployeePage setHobbies(String hobby) {
		/*JavascriptExecutor js= (JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollInToView(true)", hobbyElement);*/
		//WebDriverWait wait = new WebDriverWait(driver,15);
		//WebElement hobbyElement =wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id ='5']")));
		WebElement hobbyElement = getElement("XPATH","//input[@id ='5']",true );
		hobbyElement.sendKeys(hobby);
		return this;
	}
		
	public PIM_AddEmployeePage setWorkShift(String shiftValue) throws InterruptedException {
		//WebDriverWait wait1 = new WebDriverWait(driver, 30); 
		//WebElement ee = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='work_shift_id_inputfileddiv']//span[@class='caret']//following-sibling::input")));
		//ee.click();
		clickOnElement(getElement("XPATH", "//div[@id='work_shift_id_inputfileddiv']//span[@class='caret']//following-sibling::input",true ));
		
		
		//WebElement e = driver.findElement(
				//By.xpath("//ul[contains(@class,'dropdown-content select-dropdown')]//span[text()='"+shiftValue+"']"));
		/*while(!e.isDisplayed()) {
			e = driver.findElement(
					By.xpath("//ul[contains(@class,'dropdown-content select-dropdown')]//span[text()='"+shiftValue+"']"));
		}*/
		//WebDriverWait wait = new WebDriverWait(driver, 30); // 500 ms
		//wait.until(ExpectedConditions.visibilityOf(e));
		//WebElement e = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//ul[contains(@class,'dropdown-content select-dropdown')]//span[text()='"+shiftValue+"']")));
		//e.click();
		clickOnElement(getElement("XPATH","//ul[contains(@class,'dropdown-content select-dropdown')]//span[text()='"+shiftValue+"']",true ));
		
		return this;
	}
		
	public PIM_AddEmployeePage setEffectiveFrom(String date){
		date= date.split("\\.")[0];
		//driver.findElement(By.xpath("//label[text()='Effective From']/following-sibling::span//i")).click();
		clickOnElement(getElement("XPATH","//label[text()='Effective From']/following-sibling::span//i",false));
		//WebDriverWait wait = new WebDriverWait(driver, 10);
		//WebElement effectiveFromElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='add_employee_effective_date']//following-sibling::span[1]//div[text()='"+date+"'][contains(@class,'--infocus')]")));
		//effectiveFromElement.click();
		clickOnElement(getElement("XPATH","//input[@id='add_employee_effective_date']//following-sibling::span[1]//div[text()='"+date+"'][contains(@class,'--infocus')]",true));
		return this;
	} 
	
	public PIM_AddEmployeePage setRegion(String region) {
		//WebDriverWait wait= new WebDriverWait(driver,10);
		//WebElement regionDropDown =wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//label[text()='Region']/preceding-sibling::div/input")));
		//regionDropDown.click();
		clickOnElement(getElement("XPATH","//label[text()='Region']/preceding-sibling::div/input",true));
		
		//WebElement regionName =wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span [text()='"+region+"']")));
		//regionName.click();
		clickOnElement(getElement("XPATH","//span [text()='"+region+"']",true));
		return this;
	}
	
		
	public PIM_AddEmployeePage setFte(String fteInput) throws InterruptedException {
		if(fteInput.equals("1.0"))
			fteInput = "1";
		//JavascriptExecutor js = (JavascriptExecutor) driver;
		//js.executeScript("window.scrollBy(0,300)");
		//driver.findElement(By.xpath("//div[@id='10_inputfileddiv']//span[@class='caret']//following-sibling::input")).click();
		clickOnElement(getElement("XPATH","//div[@id='10_inputfileddiv']//span[@class='caret']//following-sibling::input",false));
		//WebDriverWait wait = new WebDriverWait(driver,10);
		//WebElement fteElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='10_inputfileddiv']//span[text()='\" + fteInput + \"']")));
		//fteElement.click();
		clickOnElement(getElement("XPATH","//div[@id='10_inputfileddiv']//span[text()='"+fteInput+"']",true));
		//clickOnElement(fteElement);
		return this;
	}
	
	public PIM_AddEmployeePage setTemporaryDepartment(String tempDept) {
		//WebDriverWait wait = new WebDriverWait(driver,20);
		//WebElement e =driver.findElement(By.xpath("//div[@id='11_inputfileddiv']//span[@class='caret']//following-sibling::input"));
		//WebElement tempDeptElement = getElement("XPATH", "//div[@id='11_inputfileddiv']//span[@class='caret']//following-sibling::input", true);
		//tempDeptElement.click();
		clickOnElement(getElement("XPATH", "//div[@id='11_inputfileddiv']//span[@class='caret']//following-sibling::input",false));
		//WebElement tempDeptelement =wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='11_inputfileddiv']//span[text()='" + tempDept + "']")));
		//tempDeptElement = getElement("XPATH", "//div[@id='11_inputfileddiv']//span[text()='\" + tempDept + \"']", true);
		
		//JavascriptExecutor js = (JavascriptExecutor) driver;
		//js.executeScript("arguments[0].scrollInToView", tempDeptElement);
		//tempDeptElement.click();
		clickOnElement(getElement("XPATH", "//div[@id='11_inputfileddiv']//span[text()='"+tempDept+"']", true));
		return this;
	}
	
	/*public PIM_AddEmployeePage setTemporaryDepartment(String tempDept) {
		driver.findElement(By.xpath("//div[@id='11_inputfileddiv']//span[@class='caret']//following-sibling::input"));
		driver.findElement(By.xpath("//div[@id='11_inputfileddiv']//span[text()='"+tempDept+"']")).click();
		return this;
	}*/
	

	
	public PIM_AddEmployeePage clickOnSavebutton() {
		//driver.findElement(By.xpath("//button[text()='Save']")).click();
		clickOnElement(getElement("XPATH","//button[text()='Save']",false));
		return this;
	}
	
	public boolean isSuccessfullySaved() {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		try {
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='toast-message']")));
			return true;
		}catch(NoSuchElementException | StaleElementReferenceException e) {
			return false;
		}
	}
	
	public void waitTillSuccessfulMessageIsInvisible() {
		//WebDriverWait wait = new WebDriverWait(driver, 10);
		//wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='toast-message']")));
		getElement("XPATH","//div[@class='toast-message']",true);
	}
	
	public boolean isUsernameTitleDisplayed() {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		try {
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@id='pim.navbar.employeeName']")));
			return true;
		}catch(TimeoutException te) {
			return false;
		}
	}
}
	
	
	
	
	
	
	
	
	

