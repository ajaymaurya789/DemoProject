package com.myshop.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.myshop.basepackage.BaseClass;

public class OrderConfirmationPage extends BaseClass{
	@FindBy(xpath="//p[contains(text(),'Your order on My Shop is complete.')]")
	private WebElement confirmMessage;
	
	public OrderConfirmationPage() {
		PageFactory.initElements(driver.get(), this);
	}
	
	public String validateConfirmMessage() {
		return confirmMessage.getText();
		}

}
