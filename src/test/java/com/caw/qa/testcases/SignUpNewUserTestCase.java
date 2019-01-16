package com.caw.qa.testcases;


import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.caw.qa.base.TestBase;
import com.caw.qa.pages.LoginPage;
import com.caw.qa.pages.MenuPage;
import com.caw.qa.pages.SignUpPage;
import com.caw.qa.util.TestUtil;

public class SignUpNewUserTestCase extends TestBase {

	LoginPage loginpage;
	SignUpPage signup;
	MenuPage menupage;
	String SheetName = "SignupData";

	public SignUpNewUserTestCase() {

		super();

	}

	@BeforeMethod
	public void setup() {

		intialization();
		loginpage = new LoginPage();
		signup = new SignUpPage();

	}

	@DataProvider
	public Object[][] getSignUpData() {

		Object data[][] = TestUtil.getTestData(SheetName);
		return data;
	}

	@Test(dataProvider = "getSignUpData",enabled = false)
	public void signupWithNewUser(String fName, String lName, String adress1, String stateName, String cityName,
			String email1, String email2, String zipcode, String phnNum, String mobNum, String faxNo)
			throws InterruptedException {
		
		signup.goToSignupForm();
		
		signup.SignUpFunctionality(fName, lName, adress1, stateName, cityName, email1, email2, zipcode, phnNum, mobNum,
				faxNo);
		
		

	}
	

}
