package LumaPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import Pages.BaseClass;

public class Blogs extends BaseClass{
	

	@FindBy(linkText="Blog")
	WebElement BlogdBtn;

	@FindBy(xpath="//span[text()='Beginners Luck']")
	WebElement BlogsContent1;

	@FindBy(xpath="//span[text()='Warming Up']")
	WebElement BlogsContent2;

	@FindBy(xpath="//span[text()='Keep Moving']")
	WebElement BlogsContent3;
	
	@FindBy(xpath="//strong[contains(text(),'How to leverage your environment')]")
	WebElement textforblog1;
	
	
	@FindBy(xpath="//strong[contains(text(),'stretch yourself so you')]")
	WebElement textforblog2;
	
	@FindBy(xpath="//strong[contains(text(),'You do not need to')]")
	WebElement textforblog3;
	
	public Blogs()
	{
		PageFactory.initElements(driver, this);
	}
	
	public void ClickonBlogdBtn()
	{
		BlogdBtn.click();
	}
	
	public void ClickOnBlog1()
	{
		BlogsContent1.click();
	}
	
	public void ClickOnBlog2()
	{
		BlogsContent2.click();
	}
	
	public void ClickOnBlog3()
	{
		BlogsContent3.click();
	}
	public void ValidateBlog1(String Blog1Heading1)
	{
		

		WebElement textforblog11 = wait.until(ExpectedConditions.visibilityOf(textforblog1));
		String ExpectedBlogmsg=textforblog11.getText();
		Assert.assertEquals(ExpectedBlogmsg, Blog1Heading1.toUpperCase());
		
	}
	
	public void ValidateBlog2(String Blog1Heading2)
	{
		WebElement textforblog21 = wait.until(ExpectedConditions.visibilityOf(textforblog2));
		String ExpectedBlogmsg=textforblog21.getText();
		Assert.assertEquals(ExpectedBlogmsg, Blog1Heading2.toUpperCase());
		
	}
	
	public void ValidateBlog3(String Blog1Heading3)
	{
		WebElement textforblog31 = wait.until(ExpectedConditions.visibilityOf(textforblog3));
		String ExpectedBlogmsg=textforblog31.getText();
		Assert.assertEquals(ExpectedBlogmsg, Blog1Heading3.toUpperCase());
	}
	
	
	


}
