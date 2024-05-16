package LumaTestCases;

import java.io.IOException;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import LumaPages.LumaCommunityPage;
import Pages.BaseClass;

public class LumaCommunityTest extends BaseClass{


	public LumaCommunityPage lcp;

	@BeforeClass
	public void Start()
	{
		MainRun();
	}


	public void CommunityFileUpload() throws IOException, InterruptedException
	{

		lcp=new LumaCommunityPage();
		lcp.HoverToCommunityTab();

		lcp.ClickOnFilesBtn();
		lcp.ClickOnCreateNewBtn();
		lcp.ChooseFileBtn("C:\\Users\\Rahul\\Documents\\NewFileUpload.exe");
		lcp.EnterFileDescription("ForTestPurpose"); lcp.ClickonOKFileBtn1(); 		 	
	}

	@BeforeClass
	public void TearDown()
	{
		CloseDriver();
	}

}
