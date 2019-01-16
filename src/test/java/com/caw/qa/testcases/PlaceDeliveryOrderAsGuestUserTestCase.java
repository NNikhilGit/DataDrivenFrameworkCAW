package com.caw.qa.testcases;

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

public class PlaceDeliveryOrderAsGuestUserTestCase extends TestBase {

	TestUtil testUtil;
	LocationsPage locationPage;
	MenuPage menupage;
	HomePage homepage;
	CheckOutPage checkoutpage;
	LoginPage loginpage;
	String sheetName = "DeliveryOrderDetails";

	public PlaceDeliveryOrderAsGuestUserTestCase() {

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
	public Object[][] getDeliveryOrderDetails() {

		Object data[][] = TestUtil.getTestData(sheetName);
		System.out.println(data);
		return data;

	}

	@Test(dataProvider = "getDeliveryOrderDetails", enabled = true)
	public void placeDeliveryOrderAsAGuestUser(String locationname, String addr1, String addr2, String city,
			String state, String custZip, String orderType, String menuname, String itemname, String addonName,
			String optionName, String tipAmount, String fname, String lname, String emailId, String cnfEmail,
			String phNo, String mobNo, String faxNum, String comment, String paymentType, String cardNum,
			String expDate, String firstName, String lastName, String cvv, String zipcode, String giftcardNum,
			String giftPinNum, String billingadd1, String stateName, String cityb, String zip)
			throws InterruptedException {
		checkoutpage.goToLocationsPage();
		locationPage.fillDeliveryAddrees(locationname, addr1, addr2, city, state, custZip);
		menupage.selectItemAndModifiers(menuname, itemname, addonName, optionName);
		checkoutpage.doCheckOut();
		checkoutpage.selectTipAmount(tipAmount);
		checkoutpage.fillCustomerAddress(fname, lname, emailId, cnfEmail, phNo, mobNo, faxNum, comment);
		checkoutpage.makePaymentForGuestUsers(paymentType, cardNum, expDate, firstName, lastName, cvv, zipcode,
				giftcardNum, giftPinNum, billingadd1, stateName, cityb, zip);

	}

}
