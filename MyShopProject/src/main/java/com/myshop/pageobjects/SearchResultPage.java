package com.myshop.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.myshop.basepackage.BaseClass;

public class SearchResultPage extends BaseClass{
	@FindBy(xpath = "//*[@id=\"center_column\"]/ul/li/div/div[1]/div/a[1]/img") 
	WebElement productresult;
	
	public SearchResultPage() {
		PageFactory.initElements(getDriver(), this);
	}
	public boolean isproductavailable() {
		return productresult.isDisplayed();
	}
	public AddToCartPage clickonproduct() {
		productresult.click();
		return new AddToCartPage();
		

	}

	
	

}
