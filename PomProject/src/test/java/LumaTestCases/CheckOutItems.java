package LumaTestCases;

import org.testng.annotations.*;

import LumaPages.LoginPage;
import LumaPages.ShopByGender;
import LumaPages.ShopNowPage;
import Pages.BaseClass;


public class CheckOutItems extends BaseClass{


	public static   LumaLoginTest lp;
	public static ShopByGender cog;
	

	@BeforeClass(alwaysRun =true)
	public void Start()
	{
		MainRun();
	}
	
	@Test
	public void ValidateAddCart()
	{
		sp=new ShopNowPage();
		lp=new LumaLoginTest();
		lp.LoginTestR();
		sp.ClickOnShopNowBtn();
		sp.ClickOnProduct1();
		sp.ClickOnAddtocart();
		sp.ValidateItemAddedInCart("SUB-TOTAL: $12.00");
	}
		
	@Test
	public void ValidateOrderPlaceMent()
	{   
		EnterCheckOutDetails();
		cog=new ShopByGender();
		cog.BackToHomes();
	}
	
	@Test
	public void ValidateRemoveFromCart()
	{
		
		cog.ClickEquipMentBtn();
		cog.ClickEquipmentMainBtn();
		cog.ClickduffleBag();
		sp.ClickOnAddtocart();
		sp.ClickRemoveFromCartBtn();
		sp.ValidateRemovedFromCart("The cart is empty.");	
		
	}
	
	@AfterClass
	public void TearDown()
	{
		CloseDriver();
		
	}

	

}
