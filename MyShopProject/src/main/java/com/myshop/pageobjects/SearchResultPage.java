package com.myshop.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.myshop.basepackage.BaseClass;

public class SearchResultPage extends BaseClass{
	@FindBy(xpath = "//div[@class='product-image-container']//a[@title='Printed Summer Dress']") 
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
