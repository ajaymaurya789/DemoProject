package com.myshop.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.myshop.basepackage.BaseClass;

public class Homepage extends BaseClass {
	@FindBy(linkText = "Cart") WebElement Whishlist;
	@FindBy(xpath = "//span[text()='Order history and details']") WebElement Orderhistory;
	
	public Homepage(){
		PageFactory.initElements(getDriver(), this);
	}
	public void validatecart() {
		Whishlist.isDisplayed();
	}
	public void validateorderhistory() {
		Orderhistory.isDisplayed();
	}
	public String getCurrURL() throws Throwable {
		String homePageURL=getCurrURL();
		return homePageURL;
	}
		

}
