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

public class logintestcase extends BaseClass{
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
	@Test(groups = {"Smoke","Sanity"},dataProvider = "credentials", dataProviderClass = DataProviders.class)
	public void loginTest(String uname, String pswd) throws Throwable {
		LogUtility.startTestCase("loginTest");
		indexPage= new Indexpage();
		LogUtility.info("user is going to click on SignIn");
		loginPage=indexPage.ClickonSignin();
		LogUtility.info("Enter Username and Password");
	    //homePage=loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		homePage=loginPage.login(uname,pswd,homePage);
	    String actualURL=homePage.getCurrURL();
	    System.out.println(homePage.getCurrURL());
	    String expectedURL="http://www.automationpractice.pl/index.php?controller=authentication";
	    LogUtility.info("Verifying if user is able to login");
	    Assert.assertEquals(actualURL, expectedURL);
	    LogUtility.info("Login is Sucess");
	    LogUtility.endTestCase("loginTest");
	}


}
