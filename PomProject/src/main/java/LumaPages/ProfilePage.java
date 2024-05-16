package LumaPages;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import Pages.BaseClass;

public class ProfilePage extends BaseClass {


	@FindBy(xpath="//ul[@class='nav navbar-nav navbar-right']/li/a[text()='Profile']")
	WebElement profileBtn;

	@FindBy(xpath="//div[@class='scf-user-info-card']/div/span")
	WebElement DPImageBtn;


	@FindBy(xpath="//span[text()='New Photo']")
	WebElement UplaodImaegeBtn;

	@FindBy(xpath="//button[@id='change-avatar-submit']")
	WebElement SaveDp;


	@FindBy(xpath="//button[@evt='click=toggleComposer']")
	WebElement EditprofileBtn;


	@FindBy(xpath="//button[@evt='click=update']/span")
	WebElement ClickOnSaveChangesBtn;


	@FindBy(xpath="//button[text()='Change Password']")
	WebElement ChangePasswordBtn;


	@FindBy(xpath="//input[@name='currentPwd']")
	WebElement CurrentPwdTextBox;

	@FindBy(xpath="//input[@name='newPwd']")
	WebElement newPwdTextBox;

	@FindBy(xpath="//input[@name='confirmPwd']")
	WebElement confirmPwdTextBox1;

	@FindBy(xpath="//button[@evt='click=changePassword']")
	WebElement SavePwdBtn;

	@FindBy(xpath="//select[@id='scf-gender-list']")
	WebElement GenderSelect;


	@FindBy(xpath="//input[@data-attrib='address']")
	WebElement Address;


	@FindBy(xpath="//input[@data-attrib='city_n_state']")
	WebElement CityState;
	
	@FindBy(xpath="//select[@id='scf-smartRendering-list']")
	WebElement Langtoshow;
	
	
	@FindBy(xpath="//input[@data-attrib='jobTitle']")
	WebElement EnterJobTitle;
	
	
	@FindBy(xpath="//textarea[@data-attrib='aboutMe']")
	WebElement EnterBioDetails;
	
	
	



	public ProfilePage()
	{
		PageFactory.initElements(driver, this);
	}

	public void ClickOnProfile()
	{
		WebElement profile=wait.until(ExpectedConditions.elementToBeClickable(profileBtn));
		profile.click();
	}
	public void ClickOnDPImage()
	{
		WebElement DP=wait.until(ExpectedConditions.elementToBeClickable(DPImageBtn));
		DP.click();
	}

	public void UpLoadProfilePic(String autoitfilepath) throws InterruptedException, IOException
	{
		WebElement upimage=wait.until(ExpectedConditions.elementToBeClickable(UplaodImaegeBtn));
		upimage.click();
		AutoIt(autoitfilepath);	

	}

	public void SaveImageBtn() throws IOException
	{
		WebElement save=wait.until(ExpectedConditions.visibilityOf(SaveDp));
		save.click();

	}

	public void ClickOnEditProfile()
	{
		EditprofileBtn.click();
	}


	public void ClickOnSaveChanges() 
	{
		WebElement ClickOnSaveChangesBtn1=wait.until(ExpectedConditions.visibilityOf(ClickOnSaveChangesBtn));
		Js();
		ClickOnSaveChangesBtn1.click();
		
	} 


	public void ScreenGenderEdit(String Gender)
	{
		WebElement GenderSelect1=wait.until(ExpectedConditions.visibilityOf(GenderSelect));
		Select Options=new Select(GenderSelect1);
		Options.selectByValue(Gender);
	}

	
	public void EnterCityState(String state)
	{
		WebElement CityState1=wait.until(ExpectedConditions.visibilityOf(CityState));
		CityState1.clear();
		CityState1.sendKeys(state);

	}


	public void EnterAddress(String address)
	{
		Address.clear();
		Address.sendKeys(address);
	}
	
	public void SelectLangtoshow(String Flag)
	{	
		Select Options=new Select(Langtoshow);
		Options.selectByValue(Flag);
	}
	public void EnterJobTitleData(String JobTitle)
	{
		EnterJobTitle.clear();
		EnterJobTitle.sendKeys(JobTitle);
	}

	public void EnterBioDetailsData(String BioData)
	{
		EnterBioDetails.clear();
		EnterBioDetails.sendKeys(BioData);
	}
	public void ClickChangePassword()
	{
		System.out.println("::::::::::::::::");

		WebElement ChangePasswordBtn1=wait.until(ExpectedConditions.elementToBeClickable(ChangePasswordBtn));

		ChangePasswordBtn1.click();
	}

	public void EnterCurrentPwd(String CurrentPwd)
	{
		WebElement CurrentPwdTextBox1=wait.until(ExpectedConditions.visibilityOf(CurrentPwdTextBox));
		CurrentPwdTextBox1.sendKeys(CurrentPwd);
	}

	public void EnterNewPwd(String NewPwd)
	{
		WebElement newPwdTextBox1=wait.until(ExpectedConditions.visibilityOf(newPwdTextBox));
		newPwdTextBox1.sendKeys(NewPwd);
	}

	public void ConfrimNewPwd(String ConfrmNewPwd)
	{
		WebElement confirmPwdTextBox2=wait.until(ExpectedConditions.visibilityOf(confirmPwdTextBox1));
		confirmPwdTextBox2.sendKeys(ConfrmNewPwd);
	}

	public void ClickOnSavePwd()
	{
		WebElement SavePwdBtn1=wait.until(ExpectedConditions.visibilityOf(SavePwdBtn));
		wait.until(ExpectedConditions.elementToBeClickable(SavePwdBtn1)).click();
		
			
		
	}



}
