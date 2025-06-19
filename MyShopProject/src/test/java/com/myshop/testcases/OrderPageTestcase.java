package com.myshop.testcases;

import org.junit.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.myshop.basepackage.BaseClass;
import com.myshop.dataprovider.DataProviders;
import com.myshop.pageobjects.AddToCartPage;
import com.myshop.pageobjects.Indexpage;
import com.myshop.pageobjects.OrderPage;
import com.myshop.pageobjects.SearchResultPage;
import com.myshop.utility.LogUtility;

public class OrderPageTestcase extends BaseClass {
	private Indexpage index;
	private SearchResultPage searchResultPage;
	private AddToCartPage addToCartPage;
	private OrderPage orderPage;

	@Parameters("browser")
	@BeforeMethod(groups = {"Smoke","Sanity","Regression"})
	public void setup(@Optional("Chrome") String browser) {
		launchApp(browser); 
	}
	
	@AfterMethod(groups = {"Smoke","Sanity","Regression"})
	public void tearDown() {
		getDriver().quit();
	}
	
	@Test(groups = "Regression",dataProvider = "getProduct", dataProviderClass = DataProviders.class)
	public void verifyTotalPrice(String productName, String qty, String size) throws Throwable {
		LogUtility.startTestCase("verifyTotalPrice");
		index= new Indexpage();
		searchResultPage=index.searchproduct(productName);
		addToCartPage=searchResultPage.clickonproduct();
		addToCartPage.enterquantity(qty);
		addToCartPage.entersize(size);
		addToCartPage.addtocart();
		addToCartPage.validateaddtocart();
		orderPage=addToCartPage.proceedtocheckout();
		Double unitPrice=orderPage.getUnitPrice();
		Double totalPrice=orderPage.getTotalPrice();
		Double totalExpectedPrice=(unitPrice*(Double.parseDouble(qty)))+7;
		Assert.assertEquals(totalPrice, totalExpectedPrice);
		LogUtility.endTestCase("verifyTotalPrice");
	}

}
