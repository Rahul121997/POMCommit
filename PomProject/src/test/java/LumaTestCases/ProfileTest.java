package LumaTestCases;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import LumaPages.ProfilePage;
import Pages.BaseClass;
@Listeners(Listensers.MyListener.class)
public class ProfileTest extends BaseClass {

	private  ProfilePage pc;
	private  FileReader reader;
	private  Properties p;
	private  LumaLoginTest lp;
	@BeforeClass(alwaysRun=true)
	public void Start()
	{

		MainRun();
	}


	@Test(priority=1)
	public void ValidateProfilePicUpdate() throws AWTException, InterruptedException, IOException 
	{
		p=new Properties();
		reader=new FileReader(AboutUsTestCase.path);
		p.load(reader);
		lp=new LumaLoginTest();
		pc=new ProfilePage();
		lp.LoginTestR();
		log.info("click on profile pic icon");
		pc.ClickOnProfile();
		log.info("click on Display picture image");
		pc.ClickOnDPImage();
		log.info("uploading image through autoIT ");
		pc.UpLoadProfilePic(p.getProperty("autoitsfilepath"));
		log.info("click on save image button");
		pc.SaveImageBtn();
	}

	@Test(priority=2)
	public void validateEditProfileSettings()
	{
		log.info("click on edit profile button");
		pc.ClickOnEditProfile();
		log.info("edit gender"+p.getProperty("gender"));
		pc.ScreenGenderEdit(p.getProperty("gender"));
		log.info("edit address"+p.getProperty("address1"));
		pc.EnterAddress(p.getProperty("address1"));
		log.info("edit  state name ");
		pc.EnterCityState(p.getProperty("state"));
		log.info("change Select Lang to show to ON state "+p.getProperty("flag"));
		pc.SelectLangtoshow(p.getProperty("flag"));
		log.info("Enter Bio Details Data "+p.getProperty("NPA"));
		pc.EnterBioDetailsData(p.getProperty("NPA"));
		log.info("Enter job role "+p.getProperty("jobrole"));
		pc.EnterJobTitleData(p.getProperty("jobrole"));
		log.info("click on save changes button");
		pc.ClickOnSaveChanges();
	}


	@Test(priority=3,retryAnalyzer=Listensers.RetryFailTest.class,dependsOnMethods={"ValidateProfilePicUpdate","ValidateProfilePicUpdate"})
	public void ValidateChangePassoword() 
	{
		log.info("click on edit change password button");
		pc.ClickChangePassword(); 

		log.info("enter current password");
		pc.EnterCurrentPwd(p.getProperty("pwd"));

		log.info("enter  new password");
		pc.EnterNewPwd(p.getProperty("updatepwd")); 

		log.info("enter new confrim  password");
		pc.ConfrimNewPwd(p.getProperty("updatepwd"));

		log.info("click on  save  password button");
		pc.ClickOnSavePwd(); 
	}

	@AfterClass public void TearDown() 
	{
		CloseDriver();

	}


}
