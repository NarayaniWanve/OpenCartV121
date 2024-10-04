package pageObject;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AccountRegistrationPage extends BasePage{

	public AccountRegistrationPage(WebDriver driver) {
		super(driver);
	}
    //Locators
	@FindBy(xpath = "//input[@id='input-firstname']")
	WebElement txtfirst;
    @FindBy(xpath="//input[@id='input-lastname']")
    WebElement txtlast;
	@FindBy(xpath = "//input[@id='input-email']")
	WebElement txtemail;
	@FindBy(xpath = "//input[@id='input-password']")
	WebElement txtpass;
	@FindBy(xpath = "//input[@id='input-confirm']")
	WebElement txtConfirmPassword;
	@FindBy(xpath = "//input[@id='input-newsletter']")
	WebElement txtnews;
	@FindBy(xpath = "//input[@name='agree']")
	WebElement txtagree;
	@FindBy(xpath = "//button[normalize-space()='Continue']")
	WebElement txtcontinu;
	@FindBy(xpath = "//h1[normalize-space()='Your Account Has Been Created!']")
	WebElement txtmsgConfirmation;
	
	//Action Methods
	public void setFirstName(String fname)
	{
		txtfirst.sendKeys(fname);
	}
	public void setLastName(String lname)
	{
		txtlast.sendKeys(lname);
	}
	public void SetEmail(String email)
	{
		txtemail.sendKeys(email);
	}
	public void SetPass(String pass)
	{
		txtpass.sendKeys(pass);
	}
	public void setConfirmPassword(String pwd)
	{
		txtConfirmPassword.sendKeys(pwd);  

	}
	public void news()
	{
		txtnews.click();
	}
	public void agree()
	{
		 JavascriptExecutor js = (JavascriptExecutor) driver;
		    js.executeScript("arguments[0].scrollIntoView(true);", txtagree);
		 WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	     wait.until(ExpectedConditions.elementToBeClickable(txtagree));  // Wait until the checkbox is clickable
	     txtagree.click();
		
	}
	public void txtconti()
	{
		txtcontinu.click();
	}
	public String getConfirmessage()
	{
		try {
			return (txtmsgConfirmation.getText());
		}
		catch(Exception e)
		{
			return(e.getMessage());
		}
	}
	

}
