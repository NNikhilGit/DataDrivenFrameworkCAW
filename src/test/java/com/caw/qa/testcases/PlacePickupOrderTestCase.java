package com.caw.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.caw.qa.base.TestBase;
import com.caw.qa.pages.CheckOutPage;
import com.caw.qa.pages.HomePage;
import com.caw.qa.pages.LocationsPage;
import com.caw.qa.pages.LoginPage;
import com.caw.qa.pages.MenuPage;
import com.caw.qa.util.TestUtil;

/**
 * @author nikhilk
 *
 */
public class PlacePickupOrderTestCase extends TestBase {

	TestUtil testUtil;
	LocationsPage locationPage;
	MenuPage menupage;
	HomePage homepage;
	CheckOutPage checkoutpage;
	LoginPage loginpage;
	String sheetName = "PickupOrderDetails";

	public PlacePickupOrderTestCase() {

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
	public Object[][] getPickupOrderDetails() {

		Object data[][] = TestUtil.getTestData(sheetName);
		System.out.println(data);
		return data;

	}

	@Test(dataProvider = "getPickupOrderDetails", enabled = true)
	public void placePickupOrderAsGuestUserWithGiftCard(String locationName, String orderType, String menuname,
			String itemname, String sizeName, String addonName, String optionName1, String optionName2,
			String optionName3, String optionName4, String optionName5, String optionName6, String tipAmount,
			String fname, String lname, String emailId, String cnfEmail, String phNo, String mobNo, String faxNo,
			String comment, String paymentType, String cardNum, String expDate, String firstName, String lastName,
			String cvv, String zipcode, String giftcardNum, String giftPinNum, String billingadd1, String stateName,
			String cityb, String zipc) throws InterruptedException {
		checkoutpage.goToLocationsPage();
		locationPage.selectPickupOrder(locationName, orderType);
		menupage.selectItemAndModifiers(menuname, itemname, sizeName, addonName, optionName1, optionName2, optionName3,
				optionName4, optionName5, optionName6);
		checkoutpage.doCheckOut();
		checkoutpage.selectTipAmount(tipAmount);
		checkoutpage.fillCustomerAddress(fname, lname, emailId, cnfEmail, phNo, mobNo, faxNo, comment);
		checkoutpage.makePaymentForGuestUsers(paymentType, cardNum, expDate, firstName, lastName, cvv, zipcode,
				giftcardNum, giftPinNum, billingadd1, stateName, cityb, zipc);

	}

	@Test(enabled = false)
	public void placeorderByLoginUser() throws InterruptedException {

		loginpage.login("nikhil.kale@bnt-soft.com", "password");

	}

	@Test(enabled = false)
	public void checkSocialLinks() {

		homepage.goToLocationPage();
		String titleofLink = locationPage.checkSocialLink("RolyPoly Aundh", "Instagram");
		System.out.println(titleofLink);
		Assert.assertEquals(titleofLink, "Login • Instagram");

	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
