package com.myshop.testcases;


import org.junit.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.myshop.basepackage.BaseClass;
import com.myshop.dataprovider.DataProviders;
import com.myshop.pageobjects.Homepage;
import com.myshop.pageobjects.Indexpage;
import com.myshop.pageobjects.Loginpage;
import com.myshop.utility.LogUtility;

public class Homepagetestcase extends BaseClass{

	private Indexpage indexPage;
	private Loginpage loginPage;
	private Homepage homePage;

	@Parameters("browser")
	@BeforeMethod(groups = {"Smoke","Sanity","Regression"})
	public void setup(@Optional("Chrome") String browser) {
		launchApp(browser); 
	}
	
	@AfterMethod(groups = {"Smoke","Sanity","Regression"})
	public void tearDown() {
		getDriver().quit();
	}

	
	@Test(groups = "Smoke",dataProvider = "credentials", dataProviderClass = DataProviders.class)
	public void orderHistoryandDetailsTest(String uname, String pswd) {
		LogUtility.startTestCase("orderHistoryandDetailsTest");
		indexPage= new Indexpage();
		loginPage=indexPage.ClickonSignin();
		homePage=loginPage.login(uname,pswd,homePage);
		boolean result=homePage.validateorderhistory();
		Assert.assertTrue(result);
		LogUtility.endTestCase("orderHistoryandDetailsTest");
	}
}
