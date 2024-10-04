package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class HomePage extends BasePage{

	public HomePage(WebDriver driver) {
		super(driver);
	}
	@FindBy(xpath = "//span[normalize-space()='My Account']")
	WebElement lnkMyAccount;
	@FindBy(xpath = "//a[normalize-space()='Register']")
	WebElement Register;
	
	@FindBy(linkText = "Login")
	WebElement linkLogin;
	public void ClickAccount()
	{
		lnkMyAccount.click();
	}
	public void clickRegister()
	{
		Register.click();
	}
	public void clickLogin()
	{
		linkLogin.click();
	}
	

}
