package LumaTestCases;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import LumaPages.Blogs;
import Pages.BaseClass;

public class BlogTestCase extends BaseClass {
	
	public static  Blogs bl;
	
	@BeforeClass(alwaysRun=true)
	public void Start()
	{
		MainRun();
	}
	
	@Test(priority=1)
	public void ValidateBlog1()
	{
		bl=new Blogs();
		bl.ClickonBlogdBtn();
		bl.ClickOnBlog1();
		bl.ValidateBlog1("HOW TO LEVERAGE YOUR ENVIRONMENT TO EASE BEGINNERS ACHES AND PAINS");
		
	}
	
	@Test(priority=2)
	public void ValidateBlog2()
	{
		bl.ClickonBlogdBtn();

		bl.ClickOnBlog2();
		bl.ValidateBlog2("stretch yourself so you can stretch your limits !!");
		driver.navigate().back();
		
	}
	
	@Test(priority=3)
	public void ValidateBlog3()
	{
		bl.ClickonBlogdBtn();

		bl.ClickOnBlog3();
		bl.ValidateBlog3("YOU DO NOT NEED TO JUST STAND THERE TO BE DOING IT.");
		driver.navigate().back();
	}
	
	@AfterClass
	public void TearDown()
	{
		CloseDriver();
	}

}
