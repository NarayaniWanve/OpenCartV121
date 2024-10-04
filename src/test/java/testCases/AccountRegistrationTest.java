package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObject.AccountRegistrationPage;
import pageObject.HomePage;
import testBase.BaseClass;

public class AccountRegistrationTest extends BaseClass{
		@Test(groups = {"Regression","Master"})
	public void verify_account_Registration()
	{
			logger.info("**** Starting TC001_AccountRegistrationTest ****");
			try {
		HomePage hm = new HomePage(driver);
		hm.ClickAccount();
		logger.info("Clicked On MyAccount Link..");
		hm.clickRegister();
		logger.info("Clicked on Register Link");
		AccountRegistrationPage ap = new AccountRegistrationPage(driver);
		logger.info("Providing Customer Details");
		ap.setFirstName(randomestring().toUpperCase());
		ap.setLastName(randomestring().toUpperCase());
		ap.SetEmail(randomestring()+"@gmail.com");
		ap.SetPass(randomeAlphaNumeric());
		ap.agree();
		ap.news();
		ap.txtconti();
		logger.info("Validating expected message.");
		String confmsg = ap.getConfirmessage();
		Assert.assertEquals(confmsg, "Your Account Has Been Created!");

	}
		catch(Exception e)
		{
			logger.error("Test Failed");
			logger.debug("Debug logs");
			Assert.fail();			
		}
			logger.info("**** Finished TC001_AccountRegistrationTest ****");
}
}
