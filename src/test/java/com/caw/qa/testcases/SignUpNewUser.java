package com.caw.qa.testcases;
import org.openqa.selenium.By;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.caw.qa.base.TestBase;
import com.caw.qa.pages.LoginPage;
import com.caw.qa.pages.MenuPage;
import com.caw.qa.pages.SignUpPage;

public class SignUpNewUser extends TestBase {
	
	LoginPage loginpage;
	SignUpPage signup;
	MenuPage menupage;
	String menuname="Bruschetta";
	public SignUpNewUser() {
		
		super();
		
	}
	@BeforeMethod
	public void setup() {
		
		intialization();
		loginpage=new LoginPage();
		signup=new SignUpPage();
	
	}
	
	@Test
	public void signupWithNewUser() throws InterruptedException {
		
		driver.findElement(By.xpath("//*[@id=\"nav-main\"]/li[2]/a")).click();
       driver.findElement(By.xpath("//h6[contains(text(),'"+menuname+"')]/following::button[1]")).click();
	}
	
	
}
