package LumaTestCases;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.IOException;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import LumaPages.ProfilePage;
import Pages.BaseClass;
@Listeners(Listensers.MyListener.class)
public class ProfileTest extends BaseClass {

	public static ProfilePage pc;

	public static LumaLoginTest lp;
	@BeforeClass(alwaysRun=true)
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
		log.info("click on profile pic icon");
		pc.ClickOnProfile();
		log.info("click on Display picture image");
		pc.ClickOnDPImage();
		log.info("uploading image through autoIT ");
		pc.UpLoadProfilePic("C:\\Users\\Rahul\\Documents\\Fileipload.exe");
		log.info("click on save image button");
		pc.SaveImageBtn();
	}

	@Test(priority=2)
	public void validateEditProfileSettings()
	{
		log.info("click on edit profile button");
		pc.ClickOnEditProfile();
		log.info("edit gender");
		pc.ScreenGenderEdit("male");
		log.info("edit address");
		pc.EnterAddress("Gachibowli");
		log.info("edit  state name ");
		pc.EnterCityState("Telegana");
		log.info("change Select Lang to show to ON state");
		pc.SelectLangtoshow("on");
		log.info("Enter Bio Details Data");
		pc.EnterBioDetailsData("Rahul,AGE:26,DOB:12/12/1997");
		log.info("Enter job role");
		pc.EnterJobTitleData("QA Engineer");
		log.info("click on save changes button");
		pc.ClickOnSaveChanges();
	}


	@Test(priority=3) public void ValidateChangePassoword() 
	{
		log.info("click on edit change password button");
		pc.ClickChangePassword(); 
		
		log.info("enter current password");
		pc.EnterCurrentPwd("abc@12345");
		
		log.info("enter current new password");
		pc.EnterNewPwd("abc@123456"); 
		
		log.info("enter confrim  password");
		pc.ConfrimNewPwd("abc@123456");
		
		log.info("click on  save  password button");
		pc.ClickOnSavePwd(); 
	}


	@AfterClass 
	public void TearDown() 
	{ 
		CloseDriver();

	}


}
