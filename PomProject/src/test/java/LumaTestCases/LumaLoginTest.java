package LumaTestCases;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.logging.Logger;

import org.apache.logging.log4j.LogManager;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import LumaPages.LoginPage;
import Pages.BaseClass;
@Listeners(Listensers.MyListener.class)
public class LumaLoginTest extends BaseClass  {
	
	

	
	private static  LoginPage lp;
	private static FileReader reader;
	private static Properties p;


	@BeforeClass(alwaysRun=true)
	public void Setup()
	{
		MainRun();
	}
	
	@Test(priority=1)
	public void LoginTestR() throws IOException
	{
		p=new Properties();
		reader=new FileReader(AboutUsTestCase.path);
		p.load(reader);
		lp=new LoginPage();
		log.info("click on login button");
		lp.ClickOnLoginBtn();
		log.info("enter username email :"+p.getProperty("usedemail"));
		lp.EnterEmail(p.getProperty("usedemail"));
		log.info("enter user password :"+p.getProperty("pwd"));
		lp.EnterPassword(p.getProperty("pwd"));
		log.info("click on login button");
		lp.ClickOnLoginBtn1();
		log.info("validate luma login");
		lp.ValidateLumaLogin(p.getProperty("loginvalidation"));
		
	}
	@Test(priority=2)
	public void ValidateLogoutFuntionlity()
	{
		log.info("click on logOut button");
		lp.ClickOnLogOutBtn();
		log.info("validate luma logout");
		lp.VallidateLogout(p.getProperty("validatelogout"));
	}

	@Test(priority=3)
	public void LoginWithInvalidCred()
	{
		log.info("click on logOut button");
	lp.ClickOnLoginBtn();
	log.info("enter username invalid email :"+p.getProperty("invalidemail"));
	lp.EnterEmail(p.getProperty("invalidemail"));
	log.info("enter user password :"+p.getProperty("pwd"));

	lp.EnterPassword(p.getProperty("pwd"));
	log.info("click on login button");

	lp.ClickOnLoginBtn1();
	log.info("validate login with invalid email");

	lp.LoginWithInvalid(p.getProperty("validateinvalid"));
	}
	
	@Test(priority=4)
	public void Login_With_FaceBook()
	{
		//test cases to check failed in reports using listeners
		log.info("click on logOut button");
		lp.ClickOnLoginBtn();
		log.info("click on login facebook button");
		lp.Cliick_Sign_inWithFacebook(p.getProperty("facebook"));

	}
	
	@Test(priority=5)
	public void Login_With_Twitter()
	{
		log.info("click on logOut button");
		lp.ClickOnLoginBtn();
		//test cases to check failed test cases in reports using listeners
		log.info("click on login twitter button");
		lp.Clikc_Sign_inWithTwitter(p.getProperty("twitter"));
	}
	
	@AfterClass
     public void TearDown()
     {
		CloseDriver();
     }
	

}
