package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import Utilities.DataProviders;
import pageObject.HomePage;
import pageObject.LoginPage;
import pageObject.MyAccountPage;
import testBase.BaseClass;

/*Data is valid - login success - test pass - logout
Data is valid -- login failed - test fail

Data is invalid -- login success - test fail - logout
Data is invalid -- login failed - test pass*/
public class LoginDDT extends BaseClass{
	@Test(dataProvider = "LoginData",dataProviderClass = DataProviders.class,groups = "datadriven")
	public void verifyLoginDDT(String email,String pwd,String exp) {
		try {
		logger.info("***** Starting Test ****");
	HomePage hp = new HomePage(driver);
	hp.ClickAccount();
	hp.clickLogin();
	
	LoginPage lp = new LoginPage(driver);
	lp.setEmail(email);
	lp.setPassword(pwd);
	lp.ClickLogin();
	
	//MyAccount
	MyAccountPage ap = new MyAccountPage(driver);
	boolean targetPage = ap.isMyAccountPageExists();
	
	if(exp.equalsIgnoreCase("Valid"))
	{
		if(targetPage == true)
		{
			Assert.assertTrue(true);
			ap.ClickLogout();
		}
		else {
			Assert.assertTrue(false);
		}
	}
	if(exp.equalsIgnoreCase("Invalid"))
	{
		if(targetPage==true)
		{
			ap.ClickLogout();
			Assert.assertTrue(false);
		}
		else {
			Assert.assertTrue(true);
		}
	}
	logger.info("**** Finished Test Execution ****");
	}
		catch(Exception e)
		{
			Assert.fail();
		}
}
}
