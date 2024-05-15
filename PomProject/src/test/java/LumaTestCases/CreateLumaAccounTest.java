package LumaTestCases;
import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import LumaPages.LoginPage;
import LumaPages.LumaCreateAccountPages;
import Pages.BaseClass;
@Listeners(Listensers.MyListener.class)
public class CreateLumaAccounTest extends BaseClass {
	
	public static LumaCreateAccountPages pg;
	public static FileReader reader;
	public static Properties p;


	@BeforeClass
	public void setup()
	{
		MainRun();
	}

	@Test(priority=1)
	public void CreateAccounTest() throws IOException 
	{
		
		p=new Properties();
		reader=new FileReader(AboutUsTestCase.path);
		p.load(reader);
		pg=new LumaCreateAccountPages();	
		pg.ClickOnLoginBtn();
		pg.ClickonCreateAccount();
		pg.EnterFIRSTNAME(p.getProperty("fname"));
		pg.EnterLASTNAME(p.getProperty("lname"));
		pg.EnterEMAIL(p.getProperty("email"));
		pg.EnterPASSWORD(p.getProperty("pwd"));
		pg.EnterCONFIRMPASSWORD(p.getProperty("cpwd"));
		pg.ClickSignupBtn();
		pg.ValidateCreateAccount(p.getProperty("createaccountvalidationtext"));		
	}	
	
	@Test(priority=2)
	public void ValidateCreateAccountWithEmail()
	{
		pg.ClickOnLoginBtn();
		pg.ClickonCreateAccount();
		pg.EnterFIRSTNAME(p.getProperty("fname"));
		pg.EnterLASTNAME(p.getProperty("lname"));
		pg.EnterUsedSameEMAIL(p.getProperty("usedemail"));
		pg.EnterPASSWORD(p.getProperty("pwd"));
		pg.EnterCONFIRMPASSWORD(p.getProperty("cpwd"));
		pg.ClickSignupBtn();
		pg.ValidateExistingUser(p.getProperty("alertmsg"));
	}

	@AfterClass
	public void TearDown()
	{
		CloseDriver();
	}



}
