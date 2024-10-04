package testCases;


import org.testng.Assert;
import org.testng.annotations.Test;

import pageObject.HomePage;
import pageObject.LoginPage;
import pageObject.MyAccountPage;
import testBase.BaseClass;

public class LoginTest extends BaseClass{
	@Test(groups = {"Sanity","Master"})
	public void verify_login()
	{
		logger.info("**** Starting Login Test ****");
		try {
		HomePage hp = new HomePage(driver);
		hp.ClickAccount();
		hp.clickLogin();
		
		LoginPage lp = new LoginPage(driver);
		lp.setEmail(p.getProperty("email"));
		lp.setPassword(p.getProperty("password"));
		lp.ClickLogin();
		
		//MyAccount
		MyAccountPage ap = new MyAccountPage(driver);
		boolean targetPage = ap.isMyAccountPageExists();
		Assert.assertEquals(targetPage,true,"Login Failed");
	    Assert.assertTrue(targetPage);
	    logger.info("**** Finished LoginTest ****");
	    }
		catch(Exception e)
		{
			
		}
	

}
}