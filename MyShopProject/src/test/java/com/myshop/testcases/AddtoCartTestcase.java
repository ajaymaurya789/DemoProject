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
import com.myshop.pageobjects.SearchResultPage;
import com.myshop.utility.LogUtility;

public class AddtoCartTestcase extends BaseClass {
	private Indexpage index;
	private SearchResultPage searchResultPage;
	private AddToCartPage addToCartPage;

	@Parameters("browser")
	@BeforeMethod(groups = {"Smoke","Sanity","Regression"})
	public void setup(@Optional("Chrome")String browser) {
		launchApp(browser); 
	}
	
	@AfterMethod(groups = {"Smoke","Sanity","Regression"})
	public void tearDown() {
		getDriver().quit();
	}
	
	@Test(groups = {"Regression","Sanity"}, dataProvider = "getProduct", dataProviderClass = DataProviders.class)
	public void addToCartTest(String productName, String qty, String size) throws Throwable {
		LogUtility.startTestCase("addToCartTest");
		index= new Indexpage();
		searchResultPage=index.searchproduct(productName);
		addToCartPage=searchResultPage.clickonproduct();
		addToCartPage.enterquantity(qty);
		addToCartPage.entersize(size);
		addToCartPage.validateaddtocart();
		boolean result=addToCartPage.validateaddtocart();
		Assert.assertTrue(result);
		LogUtility.endTestCase("addToCartTest");
		
	}

}
