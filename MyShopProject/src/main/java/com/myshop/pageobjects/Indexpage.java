package com.myshop.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.myshop.basepackage.BaseClass;

public class Indexpage extends BaseClass{
	
	@FindBy(xpath = "//a[@class='login']") WebElement Signinbtn;
	@FindBy(xpath = "//img[@class='logo img-responsive']") WebElement myshoplogo;
	@FindBy(id="search_query_top") WebElement searchbox;
	@FindBy(name = "submit_search") WebElement searchbtn;
	
	public Indexpage() {
		PageFactory.initElements(getDriver(), this);
	}
	public Loginpage ClickonSignin() {
		Signinbtn.click();
		return new Loginpage();
	}
	public boolean validatelogo() {
		return myshoplogo.isDisplayed();
		
	}
	public String validatetitle() {
		String Myshoptitle1 = getDriver().getTitle();
		return Myshoptitle1;
	}
	public SearchResultPage searchproduct(String product) {
		searchbox.clear();
		searchbox.sendKeys(product);
		searchbtn.click();
		return new SearchResultPage();
	}
	

}
