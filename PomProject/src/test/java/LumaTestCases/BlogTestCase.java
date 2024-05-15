package LumaTestCases;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import LumaPages.Blogs;
import Pages.BaseClass;
@Listeners(Listensers.MyListener.class)
public class BlogTestCase extends BaseClass {
	public static Blogs bl;
	public static FileReader reader;
	public static Properties p;
	public static Logger log  = LogManager.getLogger(BlogTestCase.class);



	@BeforeClass(alwaysRun=true)
	public void Start()
	{
		MainRun();
	}
	
	@Test(priority=1)
	public void ValidateBlog1() throws IOException
	{	
		
		p=new Properties();
		reader=new FileReader(AboutUsTestCase.path);
		p.load(reader);
		bl=new Blogs();
		log.debug("Clicking on blog button");
		bl.ClickonBlogdBtn();
		log.debug("Clicking on blog1 button");
		bl.ClickOnBlog1();
		log.debug("validating on blog1 debug");
		bl.ValidateBlog1(p.getProperty("blog1msg"));
		
	}
	
	@Test(priority=2)
	public void ValidateBlog2()
	{
		log.debug("Clicking on blog button");

		bl.ClickonBlogdBtn();
		log.debug("Clicking on blog2 button");

		bl.ClickOnBlog2();
		log.debug("validating on blog2 debug");

		bl.ValidateBlog2(p.getProperty("blog2msg"));
		
		
	}
	
	@Test(priority=3)
	public void ValidateBlog3()
	{
		log.debug("Clicking on blog button");

		bl.ClickonBlogdBtn();
		log.debug("Clicking on blog3 button");

		bl.ClickOnBlog3();
		log.debug("validating on blog3 debug");

		bl.ValidateBlog3(p.getProperty("blog3msg"));
		
	}
	
	@AfterClass
	public void TearDown()
	{
		log.debug("closing driver instance");
		CloseDriver();
	}

}
