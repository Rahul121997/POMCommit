package LumaTestCases;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.IOException;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import LumaPages.ProfilePage;
import Pages.BaseClass;

public class ProfileTest extends BaseClass {

	public static ProfilePage pc;

	public static LumaLoginTest lp;
	@BeforeClass
	public void Start()
	{

		MainRun();
	}


	@Test(priority=1)
	public void ValidateProfilePicUpdate() throws AWTException, InterruptedException, IOException 
	{
		lp=new LumaLoginTest();
		pc=new ProfilePage();
		lp.LoginTestR();
		pc.ClickOnProfile();
		pc.ClickOnDPImage();
		pc.UpLoadProfilePic("C:\\Users\\Rahul\\Documents\\Fileipload.exe");
		pc.SaveImageBtn();
	}
	
	@Test(priority=2)
	public void validateEditProfileSettings()
	{
		pc.ClickOnEditProfile();
		pc.ScreenGenderEdit("male");
		pc.EnterAddress("Gachibowli");
		pc.EnterCityState("Telegana");
		pc.SelectLangtoshow("on");
		pc.EnterBioDetailsData("Rahul,AGE:26,DOB:12/12/1997");
		pc.EnterJobTitleData("QA Engineer");
		pc.ClickOnSaveChanges();
	}
	
	
	  @Test(priority=3) public void ValidateChangePassoword() {
	  pc.ClickChangePassword(); pc.EnterCurrentPwd("abc@12345");
	  pc.EnterNewPwd("abc@123456"); pc.ConfrimNewPwd("abc@123456");
	  pc.ClickOnSavePwd(); }
	 
	
	  @AfterClass 
	  public void TearDown() 
	  { 
		  CloseDriver();
	  
	  }
	 
	 
}
