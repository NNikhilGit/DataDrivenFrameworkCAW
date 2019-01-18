package com.caw.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.caw.qa.base.TestBase;

public class LoginPage extends TestBase {
	// PageFactory
	@FindBy(xpath = "//*[@id=\"nav-main\"]/li[6]/a")
	WebElement loginbutton;

	@FindBy(name = "userName")
	WebElement userName;

	@FindBy(name = "password")
	WebElement passwordField;

	@FindBy(xpath = "//*[@id=\"content\"]/app-login/section/div/div/div/form/div[2]/button")
	WebElement submit;

	@FindBy(xpath = "//*[@id=\"header-mobile\"]/div[2]/a/img")
	WebElement logo;

	@FindBy(xpath = "//*[@id=\"content\"]/app-login/section/div/div/div/form/div[1]/div[2]/a")
	WebElement signUp;

	@FindBy(xpath = "//*[@id=\"content\"]/app-login/section/div/div/div/form/div[1]/div[5]/a")
	WebElement forgotPassword;

	public LoginPage() {

		PageFactory.initElements(driver, this);

	}

	public String getTitle() {
		return driver.getTitle();
	}

	public boolean getLogo() {

		return logo.isDisplayed();

	}

	public void login(String uname, String pwd) {

		loginbutton.click();

		userName.sendKeys(uname);

		passwordField.sendKeys(pwd);

		submit.click();

	}
	
	public SignUpPage CreateNewAccount() {
		signUp.click();
		return new SignUpPage();
	}
	public void clickonLoginButon() {
		loginbutton.click();
	}

}
