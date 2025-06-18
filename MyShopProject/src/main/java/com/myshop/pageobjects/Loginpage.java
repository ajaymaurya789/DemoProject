package com.myshop.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.myshop.basepackage.BaseClass;

public class Loginpage extends BaseClass {
	@FindBy(id="email") WebElement Username;
	@FindBy(id="passwd") WebElement Password;
	@FindBy(id="SubmitLogin") WebElement SigninButton;
	@FindBy(id="email_create") WebElement EmailforNewAcc;
	@FindBy(id="SubmitCreate") WebElement CreateNewAccbtn;
	
	public Loginpage(){
		PageFactory.initElements(getDriver(), this);
	}
	public Homepage login(String uname, String pass, Homepage homepage) {
		Username.sendKeys(uname);
		Password.sendKeys(pass);
		SigninButton.click();
		homepage = new Homepage();
		return homepage;
	}
	

	
	public AddressPage login(String uname, String pass, AddressPage addresspage) {
		Username.sendKeys(uname);
		Password.sendKeys(pass);
		SigninButton.click();
		addresspage=new AddressPage();
		return addresspage;
	}
	public AccountCreationPage CreateNewAcc(String newemail) {
		EmailforNewAcc.sendKeys(newemail);
		return new AccountCreationPage();
		
	}

}
