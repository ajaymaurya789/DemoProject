package com.myshop.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.myshop.basepackage.BaseClass;

public class AddToCartPage extends BaseClass {
	@FindBy(id="quantity_wanted") WebElement SelectQuantity;
	@FindBy(id="group_1") WebElement SelectSize;
	@FindBy(xpath = "//span[text()='Add to cart']") WebElement addtocartbtn;
	@FindBy(xpath = "//*[@id=\"layer_cart\"]/div[1]/div[1]/h2/i") WebElement productverification;
	@FindBy(xpath = "//a[@class='btn btn-default button button-medium']") WebElement checkoutbtn;
	
	public AddToCartPage() {
		PageFactory.initElements(getDriver(), this);
	}
	public void enterquantity(String Quant) {
		SelectQuantity.clear();
		SelectQuantity.sendKeys(Quant);	
		}
	public void entersize(String Size) {
		Select select = new Select(SelectSize);
		select.selectByVisibleText(Size);
		
	}
	public boolean validateaddtocart() {
		return productverification.isDisplayed();
	}
	public OrderPage proceedtocheckout() {
		checkoutbtn.click();
		return new OrderPage();
	}

}
