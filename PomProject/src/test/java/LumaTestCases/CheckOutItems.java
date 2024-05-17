package LumaTestCases;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import org.testng.Assert;
import org.testng.annotations.*;

import LumaPages.LoginPage;
import LumaPages.ShopByGender;
import LumaPages.ShopNowPage;
import Pages.BaseClass;
@Listeners(Listensers.MyListener.class)
public class CheckOutItems extends BaseClass {

	private LumaLoginTest lp;
	private ShopByGender cog;
	private ShopNowPage sp;
	private FileReader reader;
	private  Properties p;

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
		sp=new ShopNowPage();
		p.load(reader);
		log.info("click on shop now button");
		sp.ClickOnShopNowBtn();
		log.info("click on ClickOnProduct1");

		sp.ClickOnProduct1();
		log.info("click on add to cart button");

		sp.ClickOnAddtocart();
		log.info("validate item in add to cart section");

		sp.ValidateItemAddedInCart(p.getProperty("ValidateCartmsg"));


	}
	
	@Test(priority = 2)
	public void ValidateCheckOutButton()
	{
		
		log.info("click on checkout button in add to cart section");

		sp.ClickOnCheckOutBtnLast();
		log.info("click on checkout button in check out section section");

		sp.ClickOnCheckOutBtnLast1();
		
		Assert.assertEquals(p.getProperty("checkouturl"),driver.getCurrentUrl());
		log.info(driver.getCurrentUrl());

	}

	@Test(priority = 3)
	public void EnterCheckOutInfo() 
	{


		log.info("enter frist name :"+p.getProperty("fname"));
		sp.EnterFname(p.getProperty("fname"));

		log.info("enter last name:"+p.getProperty("lname"));
		sp.EnterLname(p.getProperty("lname"));

		log.info("enter address1:"+p.getProperty("address1"));
		sp.EnterAddress1(p.getProperty("address1"));

		log.info("enter address2:"+p.getProperty("address2"));
		sp.EnterAddress2(p.getProperty("address2"));

		log.info("enter city name:"+p.getProperty("city"));
		sp.EnterCity(p.getProperty("city"));

		log.info("enter NPA :"+p.getProperty("NPA"));
		sp.EnterNPA(p.getProperty("NPA"));

		log.info("enter Country name:"+p.getProperty("Country"));
		sp.SelectCounty(p.getProperty("Country"));

		log.info("enter CardNumber "+p.getProperty("CardNumber"));
		sp.EnterCardNumber(p.getProperty("CardNumber"));


		log.info("enter Expiraydate:"+p.getProperty("Expiraydate"));
		sp.EnterExpryDate(p.getProperty("Expiraydate"));

		log.info("enter CVV :"+p.getProperty("CVV"));
		sp.EnterCVV(p.getProperty("CVV"));
		log.info("enter promocode:"+p.getProperty("promocode"));
		sp.EnterPromoCode(p.getProperty("promocode"));

		log.info("click on  Continue Button ");
		sp.ClickonContinueBtn();

		log.info("click on  Place Order Button");
		sp.ClickOnPlaceOrderButton();


		log.info("validate on  Place Order placed");
		sp.ValidateOrderPalced(p.getProperty("ordermsg"));



	}

	@Test(priority=4)
	public void ValidateRemoveFromCart()
	{ 
		cog=new ShopByGender();
		log.info("click on equipment section");
		cog.ClickEquipMentBtn();
		log.info("click on main equipment");
		cog.ClickEquipmentMainBtn(); 
		log.info("click on  equipment product 1");
		cog.ClickduffleBag();
		log.info("click on add to cart button");
		sp.ClickOnAddtocart(); 
		log.info("click on remove button in add to cart sectoion");
		sp.ClickRemoveFromCartBtn();
		log.info("validate remove from cart section");
		sp.ValidateRemovedFromCart(p.getProperty("emptycartmsg"));
	}

	@AfterClass 
	public void TearDown()
	{ 
		CloseDriver();

	}



}
