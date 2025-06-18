package com.myshop.testcases;

import org.junit.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.myshop.basepackage.BaseClass;
import com.myshop.dataprovider.DataProviders;
import com.myshop.pageobjects.Indexpage;
import com.myshop.pageobjects.SearchResultPage;
import com.myshop.utility.LogUtility;

public class SearchResultTestcase extends BaseClass{
	private Indexpage index;
	private SearchResultPage searchResultPage;
	
	@Parameters("browser")
	@BeforeMethod(groups = {"Smoke","Sanity","Regression"})
	public void setup(@Optional("Chrome") String browser) {
		launchApp(browser); 
	}
	
	@AfterMethod(groups = {"Smoke","Sanity","Regression"})
	public void tearDown() {
		getDriver().quit();
	}
	
	@Test(groups = "Smoke",dataProvider = "searchProduct", dataProviderClass = DataProviders.class)
	public void productAvailabilityTest(String productName) throws Throwable {
		LogUtility.startTestCase("productAvailabilityTest");
		index= new Indexpage();
		searchResultPage=index.searchproduct(productName);
		boolean result=searchResultPage.isproductavailable();
		Assert.assertTrue(result);
		LogUtility.endTestCase("productAvailabilityTest");
	}


}
