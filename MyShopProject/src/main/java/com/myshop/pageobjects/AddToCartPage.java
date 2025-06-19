package com.myshop.pageobjects;

import java.time.Duration;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.myshop.basepackage.BaseClass;

public class AddToCartPage extends BaseClass {
	@FindBy(id="quantity_wanted") WebElement SelectQuantity;
	@FindBy(id="group_1") WebElement SelectSize;
	@FindBy(xpath = "//span[text()='Add to cart']") WebElement addtocartbtn;
	@FindBy(xpath = "//i[@class='icon-check']") WebElement productverification;
	@FindBy(xpath = "//a[@title='Proceed to checkout']") WebElement checkoutbtn;
	
	public AddToCartPage() {
		PageFactory.initElements(getDriver(), this);
	}
	public void enterquantity(String Quant) {
		SelectQuantity.clear();
		SelectQuantity.sendKeys(Quant);	
		}
	public void entersize(String Size) throws Exception {
		//Select select = new Select(SelectSize);
		//select.selectByVisibleText(Size);
		Thread.sleep(2000);
		SelectSize.sendKeys(Size);
		SelectSize.sendKeys(Keys.ENTER);
		
	}
	public void addtocart() {
		addtocartbtn.click();
	}
	
	public boolean validateaddtocart() {
	    WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));
	    wait.until(ExpectedConditions.visibilityOf(productverification));
	    return productverification.isDisplayed();
	}

	public OrderPage proceedtocheckout() {
		checkoutbtn.click();
		return new OrderPage();
	}

}
