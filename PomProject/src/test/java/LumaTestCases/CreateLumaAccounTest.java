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
		log.info("click on login button");
		pg.ClickOnLoginBtn();
		
		log.info("click on create account button");
		pg.ClickonCreateAccount();
		
		log.info("enter frist name :"+p.getProperty("fname"));
		pg.EnterFIRSTNAME(p.getProperty("fname"));
		
		log.info("enter last name :"+p.getProperty("lname"));
		pg.EnterLASTNAME(p.getProperty("lname"));
		
		
		log.info("enter email :"+p.getProperty("email"));
		pg.EnterEMAIL(p.getProperty("email"));
		
		
		log.info("enter passowrd :"+p.getProperty("pwd"));
		pg.EnterPASSWORD(p.getProperty("pwd"));
		
		log.info("enter Confrim passowrd :"+p.getProperty("cpwd"));
		pg.EnterCONFIRMPASSWORD(p.getProperty("cpwd"));
		
		log.info("click on Sign Up Button");
		pg.ClickSignupBtn();
		
		log.info("Validate create account ");
		pg.ValidateCreateAccount(p.getProperty("createaccountvalidationtext"));		
	}	
	
	@Test(priority=2)
	public void ValidateCreateAccountWithEmail()
	{
		log.info("click on login button");
		pg.ClickOnLoginBtn();
		
		log.info("click on create account button");
		pg.ClickonCreateAccount();
		
		log.info("enter frist name :"+p.getProperty("fname"));
		pg.EnterFIRSTNAME(p.getProperty("fname"));
		
		log.info("enter last name :"+p.getProperty("lname"));
		pg.EnterLASTNAME(p.getProperty("lname"));
		
		log.info("enter email :"+p.getProperty("email"));
		pg.EnterUsedSameEMAIL(p.getProperty("usedemail"));
		
		log.info("enter passowrd :"+p.getProperty("pwd"));
		pg.EnterPASSWORD(p.getProperty("pwd"));
		
		log.info("enter Confrim passowrd :"+p.getProperty("cpwd"));
		pg.EnterCONFIRMPASSWORD(p.getProperty("cpwd"));
		
		log.info("click on Sign Up Button");
		pg.ClickSignupBtn();
		
		log.info("Validate ExistingUser");
		pg.ValidateExistingUser(p.getProperty("alertmsg"));
	}

	@AfterClass
	public void TearDown()
	{
		CloseDriver();
	}



}
