package com.myshop.testcases;


import org.junit.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.myshop.basepackage.BaseClass;
import com.myshop.pageobjects.Indexpage;
import com.myshop.utility.LogUtility;

public class Homepagetestcase extends BaseClass{
private Indexpage indexPage;
    
	
	@BeforeMethod(groups = {"Smoke","Sanity","Regression"})
	public void setup(String browser) {
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
		boolean result=indexPage.validatelogo();
		Assert.assertTrue(result);
		LogUtility.endTestCase("verifyLogo");
	}
	
	@Test(groups = "Smoke")
	public void verifyTitle() {
		LogUtility.startTestCase("verifyTitle");
		String actTitle=indexPage.validatetitle();
		Assert.assertEquals(actTitle, "My Store1");
		LogUtility.endTestCase("verifyTitle");
	}

	
}
