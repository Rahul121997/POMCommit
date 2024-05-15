package LumaTestCases;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import org.testng.annotations.*;

import LumaPages.LoginPage;
import LumaPages.ShopByGender;
import LumaPages.ShopNowPage;
import Pages.BaseClass;
@Listeners(Listensers.MyListener.class)
public class CheckOutItems extends BaseClass {

	public static LumaLoginTest lp;
	public static ShopByGender cog;
	public static ShopNowPage sp;
	public static FileReader reader;
	public static Properties p;
	
	@BeforeClass(alwaysRun = true)
	public void Start() {
		MainRun();
	}

	@Test(priority = 1)
	public void ValidateAddCart() throws IOException {
		lp = new LumaLoginTest();
		lp.LoginTestR();
		p=new Properties();
		reader=new FileReader(AboutUsTestCase.path);
		sp = new ShopNowPage();
		p.load(reader);
		sp.ClickOnShopNowBtn();
		sp.ClickOnProduct1();
		sp.ClickOnAddtocart();
		sp.ValidateItemAddedInCart(p.getProperty("ValidateCartmsg"));
		
	}

	@Test(priority = 2)
	public void EnterCheckOutInfo() 
	{
		System.out.println("in methos EnterCheckOutInfo");
		sp.ClickOnCheckOutBtnLast();
		sp.ClickOnCheckOutBtnLast1();
		sp.EnterFname(p.getProperty("fname"));
		sp.EnterLname(p.getProperty("lname"));
		sp.EnterAddress1(p.getProperty("address1"));
		sp.EnterAddress2(p.getProperty("address1"));
		sp.EnterCity(p.getProperty("city"));
		sp.EnterNPA(p.getProperty("NPA"));
		sp.SelectCounty(p.getProperty("Country"));
		sp.EnterCardNumber(p.getProperty("CardNumber"));
		sp.EnterExpryDate(p.getProperty("Expiraydate"));
		sp.EnterCVV(p.getProperty("CVV"));
		sp.EnterPromoCode(p.getProperty("promocode"));
		sp.ClickonContinueBtn();
		sp.ClickOnPlaceOrderButton();
		sp.ValidateOrderPalced(p.getProperty("ordermsg"));
		
		

	}

	@Test(priority=3)
	public void ValidateRemoveFromCart()
	{ 
		cog=new ShopByGender();
		cog.ClickEquipMentBtn();
		cog.ClickEquipmentMainBtn(); 
		cog.ClickduffleBag();
		sp.ClickOnAddtocart(); 
		sp.ClickRemoveFromCartBtn();
		sp.ValidateRemovedFromCart(p.getProperty("emptycartmsg"));
	}



	@AfterClass public void TearDown()
	{ 
		CloseDriver();

	}



}
