package com.caw.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.caw.qa.base.TestBase;

public class SignUpPage extends TestBase {
	@FindBy(xpath = "//a[contains(text(),'Need an account?')]")
	WebElement needAnAccountBtn;
	
	@FindBy(xpath="//a[contains(text(),'Have an account?')]")
    WebElement haveAnAccount;
	@FindBy(name = "firstName")
	WebElement firstName;

	@FindBy(name = "lastName")
	WebElement lastName;

	@FindBy(name = "addressLine1")
	WebElement adressLine1;

	@FindBy(name = "addressLine2")
	WebElement adressLine2;

	@FindBy(name = "country")
	WebElement countryNameDropDown;

	@FindBy(name = "stateName")
	WebElement stateNameDropDown;

	@FindBy(name = "cityName")
	WebElement cityNameField;

	@FindBy(name = "zipCode")
	WebElement zipCodeField;

	@FindBy(name = "email")
	WebElement emailField;

	@FindBy(name = "confirmEmail")
	WebElement confirmEmailField;

	@FindBy(name = "phoneNo")
	WebElement PhoneNumberField;

	@FindBy(name = "mobileNo")
	WebElement mobileNumberField;

	@FindBy(name = "faxNo")
	WebElement faxNumberField;

	@FindBy(xpath = "//*[@id=\"registrationForm\"]/div[2]/button/span[1]")
	WebElement sumbitbutton;

	@FindBy(xpath = "//*[@id=\"registrationForm\"]/div[2]/button")
	WebElement registrationButton;

	@FindBy(xpath = "//*[@id=\"registrationForm\"]/div[1]/div[1]")
	WebElement titleSignup;

	// Methods start from here

	public SignUpPage() {
		PageFactory.initElements(driver, this);
	}

	public void goToSignupForm() {
		driver.findElement(By.xpath("//a[contains(text(),'Login')]")).click();
		needAnAccountBtn.click();
	}

	public void SignUpFunctionality(String fName, String lName, String adress1, String stateName, String cityName,
			String email1, String email2, String zipcode, String phnNum, String mobNum, String faxNo) {
		firstName.sendKeys(fName);
		lastName.sendKeys(lName);

		adressLine1.sendKeys(adress1);

		// adressLine2.sendKeys(adress2);
		Select statedrpdwn = new Select(stateNameDropDown);
		statedrpdwn.selectByValue(stateName);
		cityNameField.sendKeys(cityName);
		emailField.sendKeys(email1);
		confirmEmailField.sendKeys(email2);
		zipCodeField.sendKeys(zipcode);
		PhoneNumberField.sendKeys(phnNum);
		mobileNumberField.sendKeys(mobNum);
		faxNumberField.sendKeys(faxNo);
		sumbitbutton.click();
	}

	public boolean signUpEnabled() {
		return registrationButton.isEnabled();
	}

	public String getTextMessage() {
		String message = titleSignup.getText();
		return message;

	}
}
