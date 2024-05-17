package LumaTestCases;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import LumaPages.LumaCommunityPage;
import Pages.BaseClass;

public class LumaCommunityTest extends BaseClass{

	private  FileReader reader;
	private  Properties p;
	private LumaCommunityPage lcp;
	LumaLoginTest lpgd;

	@BeforeClass(alwaysRun=true)
	public void Start() throws IOException
	{
		lpgd=new LumaLoginTest();
		MainRun();
		lpgd.LoginTestR();
	}

	@Test(priority=1)
	public void ValidateCommunityButton() throws IOException 
	{
		p=new Properties();
		reader=new FileReader(AboutUsTestCase.path);
		p.load(reader);
		lcp=new LumaCommunityPage();
		log.info("click on community section");
		lcp.ClickOnToCommunityTab();
		String acutalurel=lcp.ReturCurrent();
		System.out.println(acutalurel);
		System.out.println(p.getProperty("communityurl"));
		log.info("validate community section url");
		Assert.assertEquals(acutalurel,p.getProperty("communityurl"));
	}

	@Test(priority=2)
	public void ValidateMyaccountBtn()
	{	log.info("click on my account section");
		lcp.ClickMyAccount();
		String acutalurel=lcp.ReturCurrent();
		System.out.println(p.getProperty("communityurl"+"::::::::"));
		log.info("validate my account section url");
		Assert.assertEquals(acutalurel,p.getProperty("accounturl"));
	}

	@AfterClass
	public void TearDown()
	{

		CloseDriver();
	}




}
