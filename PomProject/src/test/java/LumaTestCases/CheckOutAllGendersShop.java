package LumaTestCases;

import java.io.IOException;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import LumaPages.ShopByGender;
import LumaPages.ShopNowPage;
import Pages.BaseClass;
@Listeners(Listensers.MyListener.class)
public class CheckOutAllGendersShop extends BaseClass{

	static ShopByGender spg;
	static LumaLoginTest lg;
	ShopNowPage sps;
	static CheckOutItems cot;

	@BeforeClass(alwaysRun=true)
	public void Start()
	{
		MainRun();
	}

	@Test(priority=1)
	public void CheckOutWomenItems() throws IOException
	{  
		cot=new CheckOutItems();
		lg=new LumaLoginTest();
		lg.LoginTestR();
		sps =new ShopNowPage();
		spg =new ShopByGender();
		log.info("click on women shopping section");
		spg.ClcikWomenShoppingBtn();
		log.info("click on women main shopping section");
		spg.ClickMainWomenShpBtn();
		log.info("click on women product1");
		spg.ClcikWomenPrd1();
		/*
		 * log.info("click on product size");
		 * 
		 * spg.ClcikPrdctSize();
		 */
		log.info("click on add to cart button");
		sps.ClickOnAddtocart();
		log.info("click on checkout button in add to cart section");

		sps.ClickOnCheckOutBtnLast();
		log.info("click on checkout button in check out section section");

		sps.ClickOnCheckOutBtnLast1();

		log.info("Enter Shipping details");
		cot.EnterCheckOutInfo();
		log.info("click on back to home button");

		spg.BackToHomes();





	}

	@Test(priority=2)
	public void CheckOutMensItems()
	{
		log.info("click on men shopping section");
		spg.ClickmenShoppingbtn();

		log.info("click on men main shopping section");
		spg.ClickOnMainmenShp();

		log.info("click on men tops section");
		spg.ClickOnTopsBtn();

		log.info("click on men tops produt1 ");
		spg.ClcikMenPrd1();

		log.info("click on add to cart button");
		sps.ClickOnAddtocart();

		sps.ClickOnCheckOutBtnLast();
		log.info("click on checkout button in check out section section");

		sps.ClickOnCheckOutBtnLast1();

		log.info("Enter Shipping details");
		cot.EnterCheckOutInfo();
		log.info("click on back to home button");

		spg.BackToHomes();




	}

	@Test(priority=3)
	public void CheckoutMensItemsBottom()
	{
		log.info("click on men shopping section");
		spg.ClickmenShoppingbtn();
		log.info("click on men main shopping section");

		spg.ClickOnMainmenShp();
		log.info("click on men bottoms section");


		spg.ClickonBtmsBtn();
		log.info("click on men bottom produt1 ");


		spg.ClickOnBottomsPrd1();
		log.info("click on add to cart button");

		sps.ClickOnAddtocart();
		log.info("Enter Shipping details");
		sps.ClickOnCheckOutBtnLast();
		log.info("click on checkout button in check out section section");

		sps.ClickOnCheckOutBtnLast1();

		log.info("Enter Shipping details");

		cot.EnterCheckOutInfo();
		log.info("click on back to home button");

		spg.BackToHomes();
	}

	@Test(priority=4)
	public void CheckOutEquipmentsItems()
	{

		log.info("click on EquipMent shopping section");

		spg.ClickEquipMentBtn();
		log.info("click on EquipMent main shopping section");

		spg.ClickEquipmentMainBtn();
		log.info("click on EquipMent produt1 ");
		spg.ClickduffleBag();
		log.info("click on add to cart button");

		sps.ClickOnAddtocart();

		sps.ClickOnCheckOutBtnLast();
		log.info("click on checkout button in check out section section");

		sps.ClickOnCheckOutBtnLast1();
		log.info("Enter Shipping details");


		cot.EnterCheckOutInfo();
		log.info("click on back to home button");

		spg.BackToHomes();
	}



	@AfterClass
	public void TearDown()
	{
		CloseDriver();
	}



}
