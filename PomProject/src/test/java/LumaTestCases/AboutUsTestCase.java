package LumaTestCases;

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


	@BeforeClass
	public void Start()
	{
		MainRun();
	}

	@Test
	public void ValidateAbouts()
	{
		aup=new AboutUsPage();
		aup.ClickOnAboutUs();
		aup.ValidatedAboutUsTexts("Before creating Luma, pro trainer Erin Renny helped world-class athletes reach peak fitness");
		ReportsPass();
	}
	
	@Test
	public void ValidateContactLuma()
	{
		aup.ClickOnContacctLumaBtn();
		aup.EnterFullNameTxtBoxs("Rahul Ramgairi");
		aup.EnterEmailBoxs("ramagirirahul@gmail.com");
		aup.EnterPhoneNumverBoxs("9182890771");
		aup.EntercontactingTxtBoxs("This is for testing purpose");
		aup.ClickSubmitBtnLumaConatacts();
		aup.validateLumaServiceRequest("enter your full name");
		ReportsPass();
	}
	
	@Test
	public void ValidateCoustmerService()
	{
		aup.ClickOnAboutUs();
		aup.ClickOnCustomerServiceBtn();
		aup.ValidateCustomerServicevalidationtext("Shipping and Delivery");
		ReportsPass();
	}
	@Test
	public void ValidatePrivacyPolicy()
	{
		aup.ClickOnAboutUs();
		aup.ClickOnLumaPrivacyPolicyBtn();
		aup.ValidateLumaPrivacyPolicyvalidationtext("Luma Security");
		ReportsPass();
		
	}
	
	@AfterClass
	public void TearDown()
	{
		CloseDriver();
	}


}
