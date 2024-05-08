package LumaPages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import Pages.BaseClass;

public class LumaCommunityPage extends BaseClass{
	
	@FindBy(linkText="Community")
	WebElement CommunityBtn;	
	
	
	@FindBy(linkText="Files")
	WebElement FileBtn;
	
	
	@FindBy(xpath="//button[@id='dropdownMenu1']")
	WebElement CreateNewBtn;
	
	
	@FindBy(xpath="//a[text()='Add file']")
	WebElement ClickOnAddfileBtn;
	
	
	@FindBy(xpath="//input[@id='scf-file-upload-form-fileupload']")
	WebElement ChooseFileBtn;
	
	@FindBy(xpath="//textarea[@id='scf-document-create-message']")
	WebElement FileDescription;
	
	@FindBy(xpath="//div[@class='scf scf-modal-dialog']/div/div/following-sibling::div/button[text()='OK']")
	WebElement OKFileBtn;
	
	public LumaCommunityPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	
	
	public void HoverToCommunityTab()
	{
		WebElement CommunityBtn1=wait.until(ExpectedConditions.elementToBeClickable(CommunityBtn));
		CommunityBtn1.click();
		//ActionsHover(CommunityBtn1);
	}	
	
	public void ClickOnFilesBtn()
	{
		WebElement FileBtn1= wait.until(ExpectedConditions.visibilityOf(FileBtn));
		ActionssClick(FileBtn1);
	}
	public void ClickOnCreateNewBtn()
	{
		WebElement CreateNewBtn1= wait.until(ExpectedConditions.visibilityOf(CreateNewBtn));
		CreateNewBtn1.click();
	}
	public void ChooseFileBtn(String Filepath) throws IOException, InterruptedException
	{
		WebElement ChooseFileBtn1= wait.until(ExpectedConditions.visibilityOf(ChooseFileBtn));
		ChooseFileBtn1.click();
		
		AutoIt(Filepath);
	}
	public void EnterFileDescription(String FileDescriptionText)
	{
		WebElement FileDescription1= wait.until(ExpectedConditions.visibilityOf(FileDescription));
		FileDescription1.sendKeys("FileDescriptionText");
	}
	public void ClickonOKFileBtn1()
	{
		WebElement OKFileBtn1= wait.until(ExpectedConditions.visibilityOf(OKFileBtn));
		OKFileBtn1.click();
	}

	

}
