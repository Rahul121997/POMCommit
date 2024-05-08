package RoughPkg;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

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
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import LumaPages.LoginPage;
import LumaPages.LumaCreateAccountPages;
import LumaTestCases.LumaLoginTest;

public class Tests {
	public static FileInputStream stream;
	public static XSSFWorkbook book;
	public static XSSFSheet sheet;
	public static XSSFRow row;
	public static XSSFCell cell;
	
	@Test
	public static void DataDriven() throws InvalidFormatException, IOException
	{
		File file=new File("C:\\Users\\Rahul\\eclipse-workspace\\PomProject\\src\\test\\resources\\TestData\\TestData.xlsx");
		
		System.out.println(file.exists());
		stream=new FileInputStream(file);
		book=new XSSFWorkbook(stream);
		sheet=book.getSheet("Login Data");
		int rowcount=sheet.getPhysicalNumberOfRows();
		int colcount=sheet.getRow(0).getLastCellNum();
		System.out.println(rowcount);
		System.out.println(colcount);
		
		String[][] logindata=new String[rowcount-1][colcount];
		for(int i=1;i<rowcount-1;i++)
		{
			for(int j=0;j<colcount;j++)
			{
				logindata[i][j]=sheet.getRow(i).getCell(j).getStringCellValue();
			}	
		}
		System.out.println(logindata[1][0]);
		
		

		
	}
	

}
