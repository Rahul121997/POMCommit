package LumaPages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import com.aventstack.extentreports.Status;

import Pages.BaseClass;

public class AboutUsPage extends BaseClass {

	@FindBy(linkText="About Us")
	WebElement AboutUsBtn;

	@FindBy(xpath="//strong[contains(text(),'Before creating')]")
	WebElement ValidatedAboutUsText;


	@FindBy(xpath="//span[text()='Contact Luma']")
	WebElement ContactLumaBtn;

	@FindBy(xpath="//input[@placeholder='enter your full name']")
	WebElement EnterFullNameTxtBox;


	@FindBy(xpath="//input[@placeholder='enter your email']")
	WebElement EnterEmailTxtBox;

	@FindBy(xpath="//input[@placeholder='please enter your full phone number']")
	WebElement EnterPhoneNumberTxtBox;

	@FindBy(xpath="//textarea[@placeholder='please enter why you are contacting us']")
	WebElement EntercontactingTxtBox;

	@FindBy(xpath="//button[@id='form-button-26787124']")
	WebElement SubmitBtnLumaConatact;

	@FindBy(xpath="//span[text()='Customer Service']")
	WebElement CustomerServiceBtn;

	@FindBy(xpath="//h2[text()='Shipping and Delivery']")
	WebElement CustomerServicevalidationtext;

	@FindBy(xpath="//span[text()='Luma Privacy Policy']")
	WebElement LumaPrivacyPolicyBtn;

	@FindBy(xpath="//h2[text()='Luma Security']")
	WebElement LumaPrivacyPolicyvalidationtext;

	public AboutUsPage()
	{
		PageFactory.initElements(driver, this);
	}
	public void ClickOnAboutUs()
	{
		WebElement AboutUsBtn1=wait.until(ExpectedConditions.visibilityOf(AboutUsBtn));
		AboutUsBtn1.click();
	}
	public void ValidatedAboutUsTexts(String AcutalMsg)
	{
		WebElement ValidatedAboutUsText1=wait.until(ExpectedConditions.visibilityOf(ValidatedAboutUsText));
		String Expectedmsg=	ValidatedAboutUsText1.getText();
		Assert.assertEquals(Expectedmsg, AcutalMsg.toUpperCase());
	}
	public void ClickOnContacctLumaBtn()
	{
		WebElement ContacctLumaBtn1=wait.until(ExpectedConditions.visibilityOf(ContactLumaBtn));
		ContacctLumaBtn1.click();
	}
	public void EnterFullNameTxtBoxs(String FullName)
	{
		WebElement EnterFullNameTxtBox1=wait.until(ExpectedConditions.visibilityOf(EnterFullNameTxtBox));
		EnterFullNameTxtBox1.sendKeys(FullName);
	}
	public void EnterEmailBoxs(String Email)
	{
		WebElement EnterEmailTxtBox1=wait.until(ExpectedConditions.visibilityOf(EnterEmailTxtBox));
		EnterEmailTxtBox1.sendKeys(Email);
	}
	public void EnterPhoneNumverBoxs(String PhoneNumber)
	{
		WebElement EnterPhoneNumberTxtBox1=wait.until(ExpectedConditions.visibilityOf(EnterPhoneNumberTxtBox));
		EnterPhoneNumberTxtBox1.sendKeys(PhoneNumber);
	}
	public void EntercontactingTxtBoxs(String ConatctaReason)
	{
		WebElement EntercontactingTxtBox1=wait.until(ExpectedConditions.visibilityOf(EntercontactingTxtBox));
		EntercontactingTxtBox1.sendKeys(ConatctaReason);
	}
	public void ClickSubmitBtnLumaConatacts()
	{
		WebElement SubmitBtnLumaConatact1=wait.until(ExpectedConditions.visibilityOf(SubmitBtnLumaConatact));
		SubmitBtnLumaConatact1.click();
	}
	public void validateLumaServiceRequest(String AcutalMsg)
	{
		WebElement EnterFullNameTxtBox1=wait.until(ExpectedConditions.visibilityOf(EnterFullNameTxtBox));
		String expetcedmsg=EnterFullNameTxtBox1.getAttribute("placeholder");
		Assert.assertEquals(expetcedmsg, AcutalMsg);
	}
	public void ClickOnCustomerServiceBtn()
	{
		WebElement CustomerServiceBtn1=wait.until(ExpectedConditions.visibilityOf(CustomerServiceBtn));
		CustomerServiceBtn1.click();
	}
	public void ValidateCustomerServicevalidationtext(String AcutalMsg)
	{
		WebElement CustomerServicevalidationtext1=wait.until(ExpectedConditions.visibilityOf(CustomerServicevalidationtext));
		String ExpectedMsg=CustomerServicevalidationtext1.getText();
		Assert.assertEquals(ExpectedMsg, AcutalMsg);
	}
	public void ClickOnLumaPrivacyPolicyBtn()
	{
		WebElement LumaPrivacyPolicyBtn1=wait.until(ExpectedConditions.visibilityOf(LumaPrivacyPolicyBtn));
		LumaPrivacyPolicyBtn1.click();
	}
	public void ValidateLumaPrivacyPolicyvalidationtext(String AcutalMsg)
	{
		WebElement LumaPrivacyPolicyvalidationtext1=wait.until(ExpectedConditions.visibilityOf(LumaPrivacyPolicyvalidationtext));
		String ExpectedMsg=LumaPrivacyPolicyvalidationtext1.getText();
		Assert.assertEquals(ExpectedMsg, AcutalMsg);
	}

}
