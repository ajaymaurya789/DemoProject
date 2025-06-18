package com.myshop.pageobjects;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.myshop.basepackage.BaseClass;

public class Homepage extends BaseClass {
	@FindBy(xpath = "//span[text()='Order history and details']") WebElement Orderhistory;
	
	public Homepage(){
		PageFactory.initElements(getDriver(), this);
	}
	public boolean validateorderhistory() {
		 WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));
		    WebElement Orderhistory = wait.until(
		        ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Order history and details']")));
		   return Orderhistory.isDisplayed();
	}
	public String getCurrURL() {
		return getDriver().getCurrentUrl();
	}
		

}
