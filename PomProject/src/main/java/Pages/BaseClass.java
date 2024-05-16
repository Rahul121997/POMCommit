package Pages;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;
import java.util.Random;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.titusfortner.logging.SeleniumLogger;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import LumaPages.LoginPage;
import LumaPages.ShopNowPage;

public class BaseClass {

	public static WebDriver driver;
	public static Robot robot;
	public static LoginPage lp;
	public static WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(15));
	public static XSSFWorkbook book;
	public static FileInputStream stream;
	public static Actions act;
	public static Logger log = LogManager.getLogger();
	public static String scrdate;
	public static Properties p=new Properties();  ;



	public static void MainRun()
	{
		ChromeOptions options=new ChromeOptions();
		options.setAcceptInsecureCerts(true);
		log.info("Opening Chrome Browser");
		driver = new ChromeDriver(options); 
		
		log.info("redirecting to luma website");
		driver.get("https://luma.enablementadobe.com/");
		
		log.info("maximize  Chrome Browser window");
		driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));	
		lp=new LoginPage();
		
		log.info("click on  alert pop notification");
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
		act.moveToElement(element).clickAndHold(element).build().perform();
	}

	public String RandomNum(String Uniq)
	{
		Random random = new Random();
		int randomNumber = random.nextInt(1000);
		String str=randomNumber+Uniq;
		return str;
	}

	public void Js()
	{
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0, -250)");
	}

	public static String TakeScreenShot() throws IOException
	{
		Date date=new Date();
		System.out.println(date);
		String scrdate=date.toString().replace(":","_").replace(" ","_");
		String screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BASE64);
		return screenshotFile;
		
	}

	public void CloseDriver()
	{
		log.info("closing driver instance");
		if (driver != null) 
		{
			driver.quit();	
		}


	}
}
