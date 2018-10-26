package com.caw.qa.testcases;


import org.openqa.selenium.By;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.caw.qa.base.TestBase;
import com.caw.qa.pages.LocationsPage;
import com.caw.qa.pages.LoginPage;
import com.caw.qa.pages.ReviewPage;
import com.caw.qa.util.TestUtil;

public class SanityTestcases extends TestBase{
   LoginPage loginPage;
   ReviewPage reviewPage;
   LocationsPage locationpage;
   
	public SanityTestcases() {
		super();
	}
	@DataProvider
	public Object[][] getReviewTestData(){
		Object data[][] = TestUtil.getTestData("ReviewData");
		return data;
	}
	@BeforeMethod
	public void setup() {
		intialization();
		loginPage=new LoginPage();
		reviewPage=new ReviewPage();
		locationpage=new LocationsPage();
	}
	
	@Test(enabled=true,dataProvider="getReviewTestData")
	public void writeReview(String reviewText,String stars ) throws InterruptedException {
		loginPage.login(prop.getProperty("userName"), prop.getProperty("password"));
		reviewPage.writeReview(reviewText, stars);
		
	}
	public void addItemintoCart() {
		
	}
//	@AfterMethod
//	public void tearDown() {
//		driver.quit();
//	}
}
