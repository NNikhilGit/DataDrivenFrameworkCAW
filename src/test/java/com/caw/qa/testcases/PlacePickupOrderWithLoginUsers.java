package com.caw.qa.testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
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

public class PlacePickupOrderWithLoginUsers extends TestBase {
	TestUtil testUtil;
	MenuPage menupage;
	LocationsPage locationPage;
	HomePage homepage;
	CheckOutPage checkoutpage;
	LoginPage loginpage;
	String sheetName = "PickupOrderWithLoginUsers";

	public PlacePickupOrderWithLoginUsers() {
		super();
	}

	@DataProvider
	public Object[][] getPickupWithLoginData() {
		Object data[][] = TestUtil.getTestData(sheetName);
		System.out.println(data);
		return data;
	}

	@BeforeMethod
	public void launchBrowser() {
		intialization();
		testUtil = new TestUtil();
		menupage = new MenuPage();
		locationPage = new LocationsPage();
		homepage = new HomePage();
		checkoutpage = new CheckOutPage();
		loginpage = new LoginPage();
	}

	@Test(dataProvider = "getPickupWithLoginData")
	public void placePickUpOrderWithLoginUsers(String uname, String pwd, String locationName, String orderType,
			String menuname, String itemname, String addonName, String optionName, String tipAmount, String paymentType,
			String cardNum, String expDate, String firstName, String lastName, String cvv, String zipcode,
			String giftcardNum, String giftPinNum) throws InterruptedException {

		loginpage.login(uname, pwd);
		WebDriverWait wait=new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"nav-main\"]/li[5]/a")));
		//Thread.sleep(2000);
		checkoutpage.goToLocationsPage();
		locationPage.selectPickupOrder(locationName, orderType);
		menupage.selectItemAndModifiers(menuname, itemname, addonName, optionName);
		checkoutpage.doCheckOut();
		checkoutpage.selectTipAmount(tipAmount);
		checkoutpage.makePaymentForLoginUser(paymentType, cardNum, expDate, firstName, lastName, cvv, zipcode,
				giftcardNum, giftPinNum);

	}
}
