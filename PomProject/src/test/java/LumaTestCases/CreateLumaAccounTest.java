package LumaTestCases;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import LumaPages.LoginPage;
import LumaPages.LumaCreateAccountPages;
import Pages.BaseClass;

public class CreateLumaAccounTest extends BaseClass {
	
	public static LumaCreateAccountPages pg;
		

	@BeforeClass
	public void setup()
	{
		MainRun();
	}

	@Test(priority=1)
	public void CreateAccounTest() 
	{
		
		pg=new LumaCreateAccountPages();	
		pg.ClickOnLoginBtn();
		pg.ClickonCreateAccount();
		pg.EnterFIRSTNAME("Rahul");
		pg.EnterLASTNAME("Ramagiri");
		pg.EnterEMAIL("@gmail.com");
		pg.EnterPASSWORD("abc@1234");
		pg.EnterCONFIRMPASSWORD("abc@1234");
		pg.ClickSignupBtn();
		pg.ValidateCreateAccount("here");		
	}	
	
	@Test(priority=2)
	public void ValidateCreateAccountWithEmail()
	{
		pg.ClickOnLoginBtn();
		pg.ClickonCreateAccount();
		pg.EnterFIRSTNAME("Rahul");
		pg.EnterLASTNAME("Ramagiri");
		pg.EnterUsedSameEMAIL("ramagirirahul12@gmail.com");
		pg.EnterPASSWORD("abc@1234");
		pg.EnterCONFIRMPASSWORD("abc@1234");
		pg.ClickSignupBtn();
		pg.ValidateExistingUser("That username already exists");
	}

	@AfterClass
	public void TearDown()
	{
		CloseDriver();
	}



}
