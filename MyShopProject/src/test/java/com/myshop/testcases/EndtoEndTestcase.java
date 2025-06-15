package com.myshop.testcases;

import org.junit.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.myshop.basepackage.BaseClass;
import com.myshop.dataprovider.DataProviders;
import com.myshop.pageobjects.AddToCartPage;
import com.myshop.pageobjects.AddressPage;
import com.myshop.pageobjects.Indexpage;
import com.myshop.pageobjects.Loginpage;
import com.myshop.pageobjects.OrderConfirmationPage;
import com.myshop.pageobjects.OrderPage;
import com.myshop.pageobjects.OrderSummaryPage;
import com.myshop.pageobjects.PaymentPage;
import com.myshop.pageobjects.SearchResultPage;
import com.myshop.pageobjects.ShippingPage;
import com.myshop.utility.LogUtility;

public class EndtoEndTestcase extends BaseClass {
	private Indexpage index;
	private SearchResultPage searchResultPage;
	private AddToCartPage addToCartPage;
	private OrderPage orderPage;
	private Loginpage loginPage;
	private AddressPage addressPage;
	private ShippingPage shippingPage;
	private PaymentPage paymentPage;
	private OrderSummaryPage orderSummary;
	private OrderConfirmationPage orderConfirmationPage;

	@Parameters("browser")
	@BeforeMethod(groups = {"Smoke","Sanity","Regression"})
	public void setup(String browser) {
		launchApp(browser); 
	}
	
	@AfterMethod(groups = {"Smoke","Sanity","Regression"})
	public void tearDown() {
		getDriver().quit();
	}
	
	@Test(groups = "Regression",dataProvider = "getProduct", dataProviderClass = DataProviders.class)
	public void endToEndTest(String productName, String qty, String size) throws Throwable {
		LogUtility.startTestCase("endToEndTest");
		index= new Indexpage();
		searchResultPage=index.searchproduct(productName);
		addToCartPage=searchResultPage.clickonproduct();
		addToCartPage.enterquantity(qty);
		addToCartPage.entersize(size);
		addToCartPage.validateaddtocart();
		orderPage=addToCartPage.proceedtocheckout();
		loginPage=orderPage.clickOnCheckOut();
		addressPage=loginPage.login(prop.getProperty("username"), prop.getProperty("password"),addressPage);
		shippingPage=addressPage.clickOnCheckOut();
		shippingPage.checkTheTerms();
		paymentPage=shippingPage.clickOnProceedToCheckOut();
		orderSummary=paymentPage.clickOnPaymentMethod();
		orderConfirmationPage=orderSummary.clickOnconfirmOrderBtn();
		String actualMessage=orderConfirmationPage.validateConfirmMessage();
		String expectedMsg="Your order on My Store is complete.";
		Assert.assertEquals(actualMessage, expectedMsg);
		LogUtility.endTestCase("endToEndTest");
	}


}
