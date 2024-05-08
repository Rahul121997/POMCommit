package Pages;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Random;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.titusfortner.logging.SeleniumLogger;

import LumaPages.LoginPage;
import LumaPages.ShopNowPage;

public class BaseClass {

	public static WebDriver driver;
	public static Robot robot;
    public static ShopNowPage sp;
    public static LoginPage lp;
	public static WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(15));
	public static XSSFWorkbook book;
	public static FileInputStream stream;
	public static Actions act;
	private static Logger log = LogManager.getLogger(BaseClass.class);

	
	
	public static ExtentReports extent;
	public static ExtentSparkReporter spark;

	public static void MainRun()
	{
		log.info("test");
		driver = new ChromeDriver(); 
		
		
		driver.get("https://luma.enablementadobe.com/");
		
		
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));	
		lp=new LoginPage();
		
		lp.ClickOnAlertPopUp();
		
		

	}
	public static void Rb(String path) throws AWTException, InterruptedException
	{

		robot =new Robot();
		StringSelection ss = new StringSelection(path);
		System.out.println(path);
		System.out.println(ss);
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);
		
		robot.keyPress(KeyEvent.VK_CONTROL);
		Thread.sleep(1000);
		robot.keyPress(KeyEvent.VK_V);
		Thread.sleep(1000);
		robot.keyRelease(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_CONTROL);
		
        // Press Enter to confirm the file upload

		robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);
        
        Thread.sleep(10000);
        
	}
	public void AutoIt(String pathofExe) throws IOException, InterruptedException
	{
		//used auto it here to upload profile pic
		Runtime.getRuntime().exec(pathofExe);
		Thread.sleep(5000);
		
	}
	
	public void ActionssClick(WebElement element)
	{
		act=new Actions(driver);
		act.moveToElement(element).click().build().perform();
	}
	public void ActionsHover(WebElement element)
	{
		act.moveToElement(element).build().perform();
	}
	
	public String RandomNum(String Uniq)
	{
		 Random random = new Random();
	     int randomNumber = random.nextInt(1000);
	     String str=randomNumber+Uniq;
		 return str;
	}
	public void EnterCheckOutDetails()
	{   sp=new ShopNowPage();
	    sp.ClickOnCheckOutBtnLast();
		sp.ClickOnCheckOutBtnLast1();
		sp.EnterFname("rahul");
		sp.EnterLname("ramagiri");
		sp.EnterAddress1("gachibowli");
		sp.EnterAddress2("Hyderabad");
		sp.EnterCity("Hyderabad");
		sp.EnterNPA("Rahul,9182899023,Gachibowli");
		sp.SelectCounty("CH");
		sp.EnterCardNumber("788829920020002");
		sp.EnterExpryDate("02/29");
		sp.EnterCVV("982");
		sp.EnterPromoCode("CE0011");
		sp.ClickonContinueBtn();
		sp.ClickOnPlaceOrderButton();
		sp.ValidateOrderPalced("Order No.");
	}
	public void Js()
	{
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0, -250)");
	}
	public void ReportsPass()
	{
		spark = new ExtentSparkReporter("target/Spark.html");
		extent = new ExtentReports();
		extent.attachReporter(spark);
		extent.createTest("test01")
		.log(Status.PASS, "hello");
		extent.flush();
	}
	public void CloseDriver()
	{
		driver.close();
	}
	
	public void ReportsFail()
	{
		spark = new ExtentSparkReporter("target/Spark.html");
		extent = new ExtentReports();
		extent.attachReporter(spark);
		extent.createTest("test01")
		.log(Status.FAIL, "hello");
		extent.flush();
	}
	
	
	

}
