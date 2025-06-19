package com.myshop.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.myshop.basepackage.BaseClass;

public class AccountCreationPage extends BaseClass {
	

	
	@FindBy(xpath = "//h1[@class='page-heading']")
	private WebElement formTitle;
	
	@FindBy(id = "id_gender1")
	private WebElement mr;
	
	@FindBy(id = "id_gender2")
	private WebElement mrs;

	@FindBy(name = "customer_firstname")
	private WebElement firstName;

	@FindBy(name = "customer_lastname")
	private WebElement lastName;

	@FindBy(name = "passwd")
	private WebElement passWord;

	@FindBy(name = "days")
	private WebElement days;

	@FindBy(name = "months")
	private WebElement months;

	@FindBy(name = "years")
	private WebElement years;

	//@FindBy(name = "firstname")
	//private WebElement customerNirstName;

	//@FindBy(name = "lastname")
	//private WebElement customerLastName;

	//@FindBy(name = "company")
	//private WebElement companyName;

	//@FindBy(name = "address1")
	//private WebElement address;

	//@FindBy(name = "city")
	//private WebElement city;

	//@FindBy(name = "id_state")
	//private WebElement state;

	//@FindBy(name = "postcode")
	//private WebElement postCode;

	//@FindBy(name = "id_country")
	//private WebElement country;

	//@FindBy(name = "phone")
	//private WebElement phone;

	//@FindBy(name = "phone_mobile")
	//private WebElement mobile;

	//@FindBy(name = "alias")
	//private WebElement ref;


	@FindBy(name = "submitAccount")
	private WebElement registerBtn;
	
	public AccountCreationPage() {
		PageFactory.initElements(getDriver(), this);
	}
	
	public void createAccount(String gender,String fName, 
			String lName, 
			String pswd, 
			String day, 
			String month, 
			String year) {
		//String comPany,
		//String addr, 
		//String cityString, 
		//String stateName, 
		//String zip, 
		//String countryName,
		//String mobilePhone) throws Throwable {
		
		if(gender.equalsIgnoreCase("Mr")) {
			mr.click();
		} else {
			mrs.click();
		}
		
		firstName.sendKeys(fName);
		lastName.sendKeys(lName);	
		passWord.sendKeys(pswd);
		Select s = new Select(days);
		s.selectByValue(day);
		Select s1 = new Select(months);
		s1.selectByValue(month);
		Select s2 = new Select(years);
		s2.selectByValue(year);
		//companyName.sendKeys(comPany);
		//address.sendKeys(addr);
		//city.sendKeys(cityString);
		//Select s3 = new Select(state);
		//s3.selectByVisibleText(stateName);
		//postCode.sendKeys(zip);
		//mobile.sendKeys(mobilePhone);
		//Select s4 = new Select(country);
		//s4.selectByVisibleText(countryName);
	}
	
	public Homepage validateRegistration() throws Throwable {
		registerBtn.click();
		return new Homepage();
	}
	
	public boolean validateAcountCreatePage() throws Throwable {
		 return formTitle.isDisplayed();
	}
}
