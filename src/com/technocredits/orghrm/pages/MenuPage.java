package com.technocredits.orghrm.pages;

import org.openqa.selenium.By;

import com.technocredits.orghrm.base.PredefinedActions;

public class MenuPage extends PredefinedActions {
	public void navigateTo(String menu) {
		String[] inputStr= menu.split("->");
		for(String inputmenu : inputStr)
		driver.findElement(By.xpath("//span[text()='"+inputmenu+"']")).click();
	}
	
	

}
