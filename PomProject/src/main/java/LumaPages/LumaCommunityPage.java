package LumaPages;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;


import Pages.BaseClass;

public class LumaCommunityPage extends BaseClass{
	
	
	

	@FindBy(xpath="(//a[text()='Community'])[1]")
	WebElement CommunityBtn;	
	
	@FindBy(xpath="//a[text()='My Account']")
	WebElement Myaccount;	
	
	
	public LumaCommunityPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	public void ClickOnToCommunityTab()
	{
		WebElement CommunityBtn1=wait.until(ExpectedConditions.elementToBeClickable(CommunityBtn));
		CommunityBtn1.click();
	}	
	public String ReturCurrent()
	{
		String url=driver.getCurrentUrl();
		return url;
	}
	public void ClickMyAccount()
	{
		WebElement Myaccount1=wait.until(ExpectedConditions.elementToBeClickable(Myaccount));
		Myaccount1.click();
	}
	

	

}
