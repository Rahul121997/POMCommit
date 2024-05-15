package LumaPages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import Pages.BaseClass;

public class LumaCreateAccountPages extends BaseClass{


	@FindBy(xpath="//ul[@class='nav navbar-nav navbar-right']/li/a[contains(@href,'community/signin.html')]")
	WebElement LoginBtn;

	@FindBy(xpath="//a[text()='new account']")
	WebElement CreateAccountLink;

	@FindBy(xpath="//input[@name='fname']")
	WebElement FIRSTNAME;

	@FindBy(xpath="//input[@name='lname']")
	WebElement LASTNAME;

	@FindBy(xpath="//input[@name='email']")
	WebElement EMAIL;


	@FindBy(xpath="//input[@name='password']")
	WebElement PASSWORD;


	@FindBy(xpath="//input[@placeholder='Confirm Password']")
	WebElement CONFIRMPASSWORD;


	@FindBy(xpath="//button[text()='Sign Up']")
	WebElement SigSignUpBtn;


	@FindBy(xpath="//a[text()='here']")
	WebElement RegisterationScuuess;
	
	@FindBy(xpath="//div[text()='That username already exists']")
	WebElement AlreadyUserAlert;
	
	public LumaCreateAccountPages() {
		PageFactory.initElements(driver, this);
	}

	
	public void ClickOnLoginBtn()
	{
		WebElement LoginBtn1 = wait.until(ExpectedConditions.visibilityOf(LoginBtn));
		LoginBtn1.click();
	}

	
	public void ClickonCreateAccount()
	{

		CreateAccountLink.click();
	}

	
	public void EnterFIRSTNAME(String username)
	{

		String AlwaysnewUserName=RandomNum(username);
		System.out.println(AlwaysnewUserName);
		FIRSTNAME.sendKeys(AlwaysnewUserName);
	}

	
	public void EnterLASTNAME(String Fname)
	{
		String AlwaysnewName=RandomNum(Fname);
		System.out.println(AlwaysnewName);
		LASTNAME.sendKeys(AlwaysnewName);
	}

	
	public void EnterEMAIL(String email)
	{

		String Alwaynew=RandomNum(email);
		System.out.println(Alwaynew);
		EMAIL.sendKeys(Alwaynew);
	}
	
	public void EnterUsedSameEMAIL(String email)
	{
		EMAIL.sendKeys(email);
	}

	public void EnterPASSWORD(String Password)
	{
        
		PASSWORD.sendKeys(Password);
	}

	
	public void EnterCONFIRMPASSWORD(String CPassword)
	{

		CONFIRMPASSWORD.sendKeys(CPassword);
	}

	
	public void ClickSignupBtn()
	{
		SigSignUpBtn.click();

	}

	public void ValidateCreateAccount(String AcutalMsg)
	{
		
		WebElement element = wait.until(ExpectedConditions.visibilityOf(RegisterationScuuess));
		String ExpectedMsg = element.getText();
		System.out.println(ExpectedMsg);
		Assert.assertEquals(ExpectedMsg, AcutalMsg);
	}
	
	public void ValidateExistingUser(String alertmsg)
	{
		WebElement element = wait.until(ExpectedConditions.visibilityOf(AlreadyUserAlert));
		String ExpectedMsg = element.getText();
		System.out.println(ExpectedMsg);
		Assert.assertEquals(ExpectedMsg, alertmsg);
		
	}

}
