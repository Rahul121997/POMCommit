package LumaTestCases;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import LumaPages.ShopByGender;
import LumaPages.ShopNowPage;
import Pages.BaseClass;

public class CheckOutAllGendersShop extends BaseClass{

	public static ShopByGender spg;
	public static LumaLoginTest lg;
	public static ShopNowPage sp;
	

	@BeforeClass(alwaysRun=true)
	public void Start()
	{
		MainRun();
	}

	@Test(priority=1)
	public void CheckOutWomenItems()
	{
		lg=new LumaLoginTest();
		lg.LoginTestR();
		sp =new ShopNowPage();
		spg =new ShopByGender();
		spg.ClcikWomenShoppingBtn();
		spg.ClickMainWomenShpBtn();
		spg.ClcikWomenPrd1();
		spg.ClcikPrdctSize();
		sp.ClickOnAddtocart();
		EnterCheckOutDetails();
		spg.BackToHomes();
 
	}
	
	@Test(priority=2)
	public void CheckOutMensItems()
	{
		spg.ClickmenShoppingbtn();
		spg.ClickOnMainmenShp();
		spg.ClickOnTopsBtn();
		spg.ClcikMenPrd1();
		sp.ClickOnAddtocart();
		EnterCheckOutDetails();
		spg.BackToHomes();
	}
	
	@Test(priority=3)
	public void CheckoutMensItemsBottom()
	{
		spg.ClickmenShoppingbtn();
		spg.ClickOnMainmenShp();
		spg.ClickonBtmsBtn();
		spg.ClickOnBottomsPrd1();
		sp.ClickOnAddtocart();
		EnterCheckOutDetails();
		spg.BackToHomes();
	}
	
	@Test(priority=4)
	public void CheckOutEquipmentsItems()
	{
		System.out.println("test 0333333333");
		spg.ClickEquipMentBtn();
		spg.ClickEquipmentMainBtn();
		spg.ClickduffleBag();
		sp.ClickOnAddtocart();
		EnterCheckOutDetails();
		spg.BackToHomes();
	}
	
	
	
	@AfterClass
	public void TearDown()
	{
		CloseDriver();
	}



}
