package com.caw.qa.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.caw.qa.base.TestBase;
import com.caw.qa.pages.LoginPage;
import com.caw.qa.util.TestUtil;

/**
 * @author nikhilk
 *
 */
public class LoginPageTestcase extends TestBase {

	LoginPage loginPage;
	TestUtil testUtil;
	String sheetName = "SignupData";

	public LoginPageTestcase() {

		super();
	}

	@BeforeMethod
	public void setup() {

		intialization();
		testUtil = new TestUtil();
		loginPage = new LoginPage();

	}

	@DataProvider
	public Object[][] getLoginData() {

		Object data[][] = TestUtil.getTestData(sheetName);
		return data;

	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

	@Test
	public void getLoginPageTitle() {

		String tiltle = loginPage.getTitle();
		System.out.println(tiltle);

	}

	/**
	 * @param UserName
	 * @param Password
	 */
	@Test(dataProvider = "getLoginData")
	public void loginAsUser(String Password, String UserName) {

		loginPage.login(UserName, Password);

		// TestUtil.takeScreenshotAtEndOfTest();

	}

}
