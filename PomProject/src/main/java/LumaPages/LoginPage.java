package LumaPages;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import Pages.BaseClass;

public class LoginPage extends BaseClass{






	@FindBy(xpath="//*[@id='top']/div[1]/div/ul[2]/li[2]/a")
	WebElement LoginBtn;

	@FindBy(xpath="//input[@name='j_username']")
	WebElement Email;

	@FindBy(xpath="//input[@name='j_password']")
	WebElement Password;

	@FindBy(xpath="//button[text()='Login']")
	WebElement LoginBtn1;


	@FindBy(xpath="//h2[contains(text(), 'Discover the')]")
	WebElement LoginConfirmationMsg;

	@FindBy(xpath="//a[text()='Log out']")
	WebElement LogoutBtn;

	@FindBy(xpath="//div[normalize-space(text())='User name and password do not match']")
	WebElement InvaliUserdAlert;


	@FindBy(xpath="//button[text()=\"That's ok\"]")
	WebElement PopBtn;

	@FindBy(xpath="//span[text()='Login with Twitter']")
	WebElement Sign_inWithTwitterBtn;



	@FindBy(xpath="//span[text()='Login with Facebook']")
	WebElement Sign_inWithFacebook;


	public LoginPage() {
		// Call the parent constructor to initialize WebDriver
		PageFactory.initElements(driver, this);
	}


	public void ClickOnLoginBtn()
	{
		WebElement LoginBtn2 = wait.until(ExpectedConditions.visibilityOf(LoginBtn));
		LoginBtn2.click();
	}


	public void EnterEmail(String email)
	{
		WebElement element = wait.until(ExpectedConditions.visibilityOf(Email));
		element.sendKeys(email);
	}

	public void EnterPassword(String password)
	{
		Password.sendKeys(password);
	}


	public void ClickOnLoginBtn1()
	{
		LoginBtn1.click();
	}

	public void ValidateLumaLogin(String AcutalMsg)
	{
		WebElement element = wait.until(ExpectedConditions.visibilityOf(LoginConfirmationMsg));
		String ExpectedMsg=element.getText();
		System.out.println(ExpectedMsg);
		Assert.assertEquals(AcutalMsg, ExpectedMsg);
	}


	public void ClickOnLogOutBtn()
	{
		LogoutBtn.click();
	}

	public void VallidateLogout(String logoutmsg)
	{

		WebElement element = wait.until(ExpectedConditions.visibilityOf(LoginBtn));
		String ExpectedMsg=element.getText();
		System.out.println(ExpectedMsg);
		Assert.assertEquals(logoutmsg, ExpectedMsg);
	}

	public void LoginWithInvalid(String invaliuserdAlert)
	{
		WebElement element = wait.until(ExpectedConditions.visibilityOf(InvaliUserdAlert));
		String ExpectedMsg=element.getText();
		System.out.println(ExpectedMsg);

		Assert.assertEquals(invaliuserdAlert, ExpectedMsg);
	}
	public void ClickOnAlertPopUp()
	{
		WebElement PopBtn1 = wait.until(ExpectedConditions.visibilityOf(PopBtn));
		PopBtn1.click();
	}

	public void Cliick_Sign_inWithFacebook(String ExpectedUrl) {
		String parent = driver.getWindowHandle();
		WebElement Sign_inWithFacebook1 = wait.until(ExpectedConditions.elementToBeClickable(Sign_inWithFacebook));
		Sign_inWithFacebook1.click();
		Set<String> windows = driver.getWindowHandles();

		for (String window : windows) {
			if (!window.equals(parent)) {
				//driver.switchTo().window(window);
				//String actual = driver.getCurrentUrl();
				driver.switchTo().window(window).close();
				//Assert.assertEquals(actual, ExpectedUrl);
				break;
			}
		}

		// Switch back to the parent window
		driver.switchTo().window(parent);
	}

	public void Clikc_Sign_inWithTwitter(String ExpectedUrl) {
		String parent = driver.getWindowHandle();
		System.out.println("twitter");

		WebElement Sign_inWithTwitterBtn1 = wait.until(ExpectedConditions.elementToBeClickable(Sign_inWithTwitterBtn));
		Sign_inWithTwitterBtn1.click();
		Set<String> windows = driver.getWindowHandles();

		for (String window : windows) {
			if (!window.equals(parent)) {
				driver.switchTo().window(window);
				String actual = driver.getCurrentUrl();
				Assert.assertEquals(actual, ExpectedUrl);
				driver.close();
				break; // Exit the loop after handling the Twitter window
			}
		}

		// Switch back to the parent window
		driver.switchTo().window(parent);
	}




}
