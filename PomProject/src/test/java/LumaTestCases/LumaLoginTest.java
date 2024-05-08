package LumaTestCases;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.logging.Logger;

import org.apache.logging.log4j.LogManager;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import LumaPages.LoginPage;
import Pages.BaseClass;

public class LumaLoginTest extends BaseClass  {
	
	

	
	public static  LoginPage lp;
	 

	@BeforeClass(alwaysRun=true)
	public void Setup()
	{
		MainRun();
	}
	
	@Test(priority=1)
	public void LoginTestR()
	{
		lp=new LoginPage();
		lp.ClickOnLoginBtn();
		lp.EnterEmail("ramagirirahul12@gmail.com");
		lp.EnterPassword("abc@1234");
		lp.ClickOnLoginBtn1();
		lp.ValidateLumaLogin("DISCOVER THE FINEST IN YOGA FASHION FROM LUMA");
		
	}
	@Test(priority=2)
	public void ValidateLogoutFuntionlity()
	{
		lp.ClickOnLogOutBtn();
		lp.VallidateLogout("LOGIN");
	}

	@Test(priority=3)
	public void LoginWithInvalidCred()
	{
	
	lp.ClickOnLoginBtn();
	lp.EnterEmail("ramagirirahul@gmail.com");
	lp.EnterPassword("abc@1234");
	lp.ClickOnLoginBtn1();
	lp.LoginWithInvalid("User name and password do not match");
	}
	
	
	@AfterClass
     public void TearDown()
     {
		CloseDriver();
     }
	

}
