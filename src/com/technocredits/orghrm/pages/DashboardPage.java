package com.technocredits.orghrm.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.technocredits.orghrm.base.PredefinedActions;

public class DashboardPage extends PredefinedActions{
	
	public String getDashboardPageHeaderTitle() {
		String actualdashboarglinktitleText = driver.getTitle();
		return actualdashboarglinktitleText;
	}
			
	public String getDashboardPageTitle() {
		String actualdashboargHeadertitleText =driver.findElement(By.xpath("//div[@class='menu-visible']//li[@class ='page-title']")).getText();
		return actualdashboargHeadertitleText;
	}
	
	public int getAllWidgetsOnDashBoard() {
		return driver.findElements(By.xpath("//div[@name ='widget.name']")).size();
	}
	
	public List<String> getAllWidgetText(){
		return getTextOfAllElements("//div[@class ='widget-header']/span[2]"); 
	}
	
}
