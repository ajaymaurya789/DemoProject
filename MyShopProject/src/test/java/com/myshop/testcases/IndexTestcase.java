package com.myshop.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.myshop.basepackage.BaseClass;
import org.testng.Assert;

import com.myshop.pageobjects.Indexpage;
import com.myshop.utility.LogUtility;
public class IndexTestcase extends BaseClass{
private Indexpage indexPage;
    
	@Parameters("browser")
	@BeforeMethod(groups = {"Smoke","Sanity","Regression"})
	public void setup(@Optional("Chrome") String browser) {
		launchApp(browser); 
	}
	
	@AfterMethod(groups = {"Smoke","Sanity","Regression"})
	public void tearDown() {
		getDriver().quit();
	}
	
	@Test(groups = "Smoke")
	public void verifyLogo() throws Throwable {
		LogUtility.startTestCase("verifyLogo");
		indexPage= new Indexpage();
		boolean result =indexPage.validatelogo();
		Assert.assertTrue(result);
		LogUtility.endTestCase("verifyLogo");
	}
	
	@Test(groups = "Smoke")
	public void verifyTitle() {
		LogUtility.startTestCase("verifyTitle");
		String actTitle=indexPage.validatetitle();
		Assert.assertEquals(actTitle, "My Shop");
		LogUtility.endTestCase("verifyTitle");
	}


}
