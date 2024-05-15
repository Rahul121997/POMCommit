package RoughPkg;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.Set;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import LumaPages.LoginPage;
import LumaPages.LumaCreateAccountPages;
import LumaTestCases.LumaLoginTest;
import Pages.BaseClass;

public class Tests extends BaseClass {


	@BeforeClass
	public void Start()
	{
		MainRun();
	}


	
	public void SicoLogin() throws InterruptedException
	{
		System.out.println(driver.getWindowHandle());
		String parent=driver.getWindowHandle();
		lp.ClickOnLoginBtn();
		Set<String>window=	driver.getWindowHandles();
		for(String windows:window)
		{
			System.out.println(driver.getWindowHandle());
			if(!windows.equals(parent))
			{
				String Acuatl=driver.switchTo().window(windows).getCurrentUrl();
				Assert.assertEquals(Acuatl,"https://www.facebook.com/");
				driver.switchTo().window(windows).close();
			}
		}

	}


}




