package com.caw.qa.testcases;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;

import com.caw.qa.base.TestBase;
import com.caw.qa.pages.CheckOutPage;
import com.caw.qa.pages.HomePage;
import com.caw.qa.pages.LocationsPage;
import com.caw.qa.pages.LoginPage;
import com.caw.qa.pages.MenuPage;
import com.caw.qa.util.TestUtil;

public class PlaceDeliveryOrderWithLoginUsers extends TestBase {

	TestUtil testUtil;
	LocationsPage locationPage;
	MenuPage menupage;
	HomePage homepage;
	CheckOutPage checkoutpage;
	LoginPage loginpage;
	String sheetName = "DeliveryOrderDetailsWithLoginUsers";
	
	public PlaceDeliveryOrderWithLoginUsers() {
		super();
	}
	@BeforeMethod
	public void setup() {

		intialization();
		testUtil = new TestUtil();
		menupage = new MenuPage();
		locationPage = new LocationsPage();
		homepage = new HomePage();
		checkoutpage = new CheckOutPage();
		loginpage = new LoginPage();
}
	@DataProvider
	public Object[][] getDeliveryOrderDetailsWithLoginUsers() {

		Object data[][] = TestUtil.getTestData(sheetName);
		System.out.println(data);
		return data;

	}
	


}
