package LumaTestCases;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import LumaPages.AboutUsPage;
import Pages.BaseClass;

@Listeners(Listensers.MyListener.class)
public class AboutUsTestCase extends BaseClass {

	public static AboutUsPage aup;
	public static FileReader reader;
	public static Properties p;
	public static String path="./src/test/resources/Properties/testdata.properties";

	@BeforeClass
	public void Start()
	{
		MainRun();
	}

	@Test
	public void ValidateAbouts() throws IOException
	{
		p=new Properties();
		reader=new FileReader(path);
		p.load(reader);
		aup=new AboutUsPage();
		aup.ClickOnAboutUs();
		System.out.println(p.getProperty("AboutValidation"));
		aup.ValidatedAboutUsTexts(p.getProperty("AboutValidation"));
		
	}
	
	@Test
	public void ValidateContactLuma()
	{
		aup.ClickOnContacctLumaBtn();
		aup.EnterFullNameTxtBoxs(p.getProperty("username"));
		aup.EnterEmailBoxs(p.getProperty("eamil"));
		aup.EnterPhoneNumverBoxs(p.getProperty("phonenumber"));
		aup.EntercontactingTxtBoxs(p.getProperty("testmsg"));
		aup.ClickSubmitBtnLumaConatacts();
		aup.validateLumaServiceRequest(p.getProperty("testexplination"));
	}
	
	@Test
	public void ValidateCoustmerService()
	{
		aup.ClickOnAboutUs();
		aup.ClickOnCustomerServiceBtn();
		aup.ValidateCustomerServicevalidationtext(p.getProperty("coustemrvalidation"));
	}
	@Test
	public void ValidatePrivacyPolicy()
	{
		aup.ClickOnAboutUs();
		aup.ClickOnLumaPrivacyPolicyBtn();
		aup.ValidateLumaPrivacyPolicyvalidationtext(p.getProperty("lumaprivacy"));
	}
	
	@AfterClass
	public void TearDown()
	{
		CloseDriver();
	}


}
