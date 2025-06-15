package com.myshop.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.myshop.basepackage.BaseClass;

public class ShippingPage extends BaseClass {
	@FindBy(id="cgv")
	private WebElement terms;
	
	@FindBy(xpath="//button/span[contains(text(),'Proceed to checkout')]")
	private WebElement proceedToCheckOutBtn;
	
	public ShippingPage() {
		PageFactory.initElements(getDriver(), this);
	}
	
	public void checkTheTerms(){
		terms.click();
	}
	
	public PaymentPage clickOnProceedToCheckOut() throws Throwable {
		proceedToCheckOutBtn.click();
		return new PaymentPage();
	}

}
