package com.myshop.testcases;

import java.util.HashMap;

import org.junit.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.myshop.basepackage.BaseClass;
import com.myshop.dataprovider.DataProviders;
import com.myshop.pageobjects.AccountCreationPage;
import com.myshop.pageobjects.Homepage;
import com.myshop.pageobjects.Indexpage;
import com.myshop.pageobjects.Loginpage;
import com.myshop.utility.LogUtility;

public class AccountCreationTestcase extends BaseClass{
	private Indexpage indexPage;
	private Loginpage loginPage;
	private AccountCreationPage acountCreationPage;
	private Homepage homePage;
	
	@Parameters("browser")
	@BeforeMethod(groups = {"Smoke","Sanity","Regression"})
	public void setup(String browser) {
		launchApp(browser); 
	}
	
	@AfterMethod(groups = {"Smoke","Sanity","Regression"})
	public void tearDown() {
		getDriver().quit();
	}
	
	@Test(groups = "Sanity",dataProvider = "email", dataProviderClass = DataProviders.class)
	public void verifyCreateAccountPageTest(String email) throws Throwable {
		LogUtility.startTestCase("verifyCreateAccountPageTest");
		indexPage= new Indexpage();
		loginPage=indexPage.ClickonSignin();
		acountCreationPage=loginPage.CreateNewAcc(email);
		boolean result=acountCreationPage.validateAcountCreatePage();
		Assert.assertTrue(result);
		LogUtility.endTestCase("verifyCreateAccountPageTest");
	}
	
	@Test(groups = "Regression",dataProvider = "newAcountDetailsData",dataProviderClass = DataProviders.class)
	public void createAccountTest(HashMap<String,String> hashMapValue) throws Throwable {
		LogUtility.startTestCase("createAccountTest");
		indexPage= new Indexpage();
		loginPage=indexPage.ClickonSignin();
		acountCreationPage=loginPage.CreateNewAcc(hashMapValue.get("Email"));
		acountCreationPage.createAccount(
				hashMapValue.get("Gender"),
				hashMapValue.get("FirstName"),
				hashMapValue.get("LastName"),
				hashMapValue.get("SetPassword"),
				hashMapValue.get("Day"),
				hashMapValue.get("Month"),
				hashMapValue.get("Year"),
				hashMapValue.get("Company"),
				hashMapValue.get("Address"),
				hashMapValue.get("City"),
				hashMapValue.get("State"),
				hashMapValue.get("Zipcode"),
				hashMapValue.get("Country"),
				hashMapValue.get("MobilePhone"));
		homePage=acountCreationPage.validateRegistration();
		Assert.assertEquals("http://automationpractice.com/index.php?controller=my-account", homePage.getCurrURL());
		LogUtility.endTestCase("createAccountTest");
	}

}

