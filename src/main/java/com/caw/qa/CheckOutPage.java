package com.caw.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.caw.qa.base.TestBase;

/**
 * @author nikhilk
 *
 */

public class CheckOutPage extends TestBase {
	// checkout buttons
	@FindBy(xpath = "//*[@id=\"headerCartBtn\"]/span[2]")
	WebElement cartIcons;

	@FindBy(xpath = "//*[@id=\"panel-cart\"]/div/button[1]/span")
	WebElement CheckOutbtn;

	/// Delivery Form webelements starts here######################
	@FindBy(name = "firstName")
	WebElement firstName;

	@FindBy(name = "lastName")
	WebElement lastName;

	@FindBy(name = "email")
	WebElement email;

	@FindBy(name = "confirmEmail")
	WebElement confirmEmail;

	@FindBy(name = "phoneNo")
	WebElement phoneNo;

	@FindBy(xpath = "//*[@id=\"content\"]/app-checkout/section/div/div/div[2]/form[1]/div[1]/div[3]/div[6]/input")
	WebElement mobileNo;

	@FindBy(name = "faxNo")
	WebElement faxNo;

	@FindBy(name = "orderComment")
	WebElement additionalInstrcutions;
	/// payments options
	@FindBy(xpath = "//span[contains(text(),'Cash')]")
	WebElement cashBtn;

	@FindBy(xpath = "//span[contains(text(),'Credit Card')]")
	WebElement ccBtn;

	@FindBy(xpath = "//span[contains(text(),'Gift Card')]")
	WebElement giftCardBtn;

	@FindBy(id = "NormalOrderNowBtn")
	WebElement orderNowBtn;

	// #################Credit card window elements#######################
	@FindBy(xpath = "//*[@id=\"cardNum\"]")
	WebElement cardNumber;

	@FindBy(name = "expiryDate")
	WebElement expiryDate;

	@FindBy(name = "cvv")
	WebElement cvvNum;

	@FindBy(name = "firstName")
	WebElement fName;

	@FindBy(name = "lastName")
	WebElement lName;

	@FindBy(name = "zip")
	WebElement zipCode;

	@FindBy(name = "Submit")
	WebElement Submitbtn;

	// billing form webelements

	@FindBy(name = "billing_addressLine1")
	WebElement billingaddrs1;

	@FindBy(name = "billing_state")
	WebElement billingstate;

	@FindBy(name = "billing_city")
	WebElement billingcity;

	@FindBy(name = "billing_zipcode")
	WebElement billingzipcode;

	// Tip section webelements

	@FindBy(xpath = "//*[@id=\"tipModal\"]/div/div/button")
	WebElement tipContinuebtn;

	@FindBy(xpath = "//*[@id=\"panelDetailsSize\"]/div[1]/div[2]/label")
	WebElement yesbtn;

	@FindBy(xpath = "//*[@id=\"panelDetailsSize\"]/div[2]/table/tbody/tr[1]/td[1]/input")
	WebElement tenPercent;

	@FindBy(xpath = "//*[@id=\"panelDetailsSize\"]/div[2]/table/tbody/tr[2]/td[1]/input")
	WebElement fifteenPercent;

	@FindBy(xpath = "//*[@id=\"panelDetailsSize\"]/div[2]/table/tbody/tr[3]/td[1]/input")
	WebElement twentyPercent;

	@FindBy(xpath = "//*[@id=\"customTipRadio\"]")
	WebElement customAmount;

	@FindBy(xpath = "//*[@id=\"customTipAmount\"]")
	WebElement customTipAmountTextBox;

	@FindBy(xpath = "//h1[@class='mb-2']")
	WebElement thankYouScreenmsg;

	// Gift card window webelements

	@FindBy(name = "accountId")
	WebElement giftCardNumber;

	@FindBy(name = "pin")
	WebElement giftPin;

	@FindBy(xpath = "//*[@id=\"giftCardPaymentModal\"]/div/div/form/button")
	WebElement giftSubmitbtn;

	@FindBy(xpath = "//button[@class=\"utility-box-btn btn btn-secondary btn-submit\" ]")
	WebElement payNoworderNowbtn;

	public CheckOutPage() {

		PageFactory.initElements(driver, this);

	}
public void goToLocationsPage() {
	//driver.findElement(By.xpath("//a[contains(text(),'Locations')]")).click();
	driver.findElement(By.xpath("//*[@id=\"nav-main\"]/li[5]/a")).click();
}
	public void selectOrderNowBtn() {
		orderNowBtn.click();
	}

	public void makePaymentForGuestUsers(String paymentType, String cardNum, String expDate, String firstName, String lastName,
			String cvv, String zipcode, String giftcardNum, String giftPinNum, String billingadd1, String stateName,
			String cityb, String zip) {
		if (paymentType.equalsIgnoreCase("cash")) {
			orderNowBtn.click();
		} else if (paymentType.equalsIgnoreCase("credit")) {
			
			ccBtn.click();
		
			// enter billing details
			billingaddrs1.sendKeys(billingadd1);
			Select state = new Select(billingstate);
			state.selectByVisibleText(stateName);
			billingcity.sendKeys(cityb);
			billingzipcode.sendKeys(zip);
			payNoworderNowbtn.click();
			/// switch to credit card window & enter card details
			driver.switchTo().frame(0);

			cardNumber.sendKeys(cardNum);

			expiryDate.sendKeys(expDate);

			cvvNum.sendKeys(cvv);
			fName.sendKeys(firstName);
			lName.sendKeys(lastName);
			zipCode.sendKeys(zipcode);
			WebDriverWait wait = new WebDriverWait(driver, 30);
			wait.until(ExpectedConditions.elementToBeClickable(Submitbtn));
			Submitbtn.click();

		} else if (paymentType.equalsIgnoreCase("Gift")) {

			giftCardBtn.click();
			payNoworderNowbtn.click();
			giftCardNumber.sendKeys(giftcardNum);
			giftPin.sendKeys(giftPinNum);
			giftSubmitbtn.click();

		}
	}
	
	
	/**
	 * @param paymentType
	 * @param cardNum
	 * @param expDate
	 * @param firstName
	 * @param lastName
	 * @param cvv
	 * @param zipcode
	 * @param giftcardNum
	 * @param giftPinNum
	 */
	public void makePaymentForLoginUser(String paymentType, String cardNum, String expDate, String firstName, String lastName,
			String cvv, String zipcode, String giftcardNum, String giftPinNum) {
		if (paymentType.equalsIgnoreCase("cash")) {
			orderNowBtn.click();
		} else if (paymentType.equalsIgnoreCase("credit")) {
			
			ccBtn.click();
		    payNoworderNowbtn.click();
			/// switch to credit card window & enter card details
			driver.switchTo().frame(0);
            cardNumber.sendKeys(cardNum);
            expiryDate.sendKeys(expDate);
            cvvNum.sendKeys(cvv);
			fName.sendKeys(firstName);
			lName.sendKeys(lastName);
			zipCode.sendKeys(zipcode);
			WebDriverWait wait = new WebDriverWait(driver, 30);
			wait.until(ExpectedConditions.elementToBeClickable(Submitbtn));
			Submitbtn.click();

		} else if (paymentType.equalsIgnoreCase("Gift")) {

			giftCardBtn.click();
			payNoworderNowbtn.click();
			giftCardNumber.sendKeys(giftcardNum);
			giftPin.sendKeys(giftPinNum);
			giftSubmitbtn.click();

		}
	}


	public void fillCustomerAddress(String fname, String lname, String emailId, String cnfEmail, String phNo,
			String mobNo, String faxNum, String comment) {

		firstName.sendKeys(fname);
		lastName.sendKeys(lname);
		email.sendKeys(emailId);
		confirmEmail.sendKeys(cnfEmail);
		phoneNo.sendKeys(phNo);
		mobileNo.sendKeys(mobNo);
		faxNo.sendKeys(faxNum);
		additionalInstrcutions.sendKeys(comment);

	}

	public void selectPaymentType(String paymentType) {
		if (paymentType.equalsIgnoreCase("cash")) {
			cashBtn.click();
		} else if (paymentType.equalsIgnoreCase("credit")) {
			ccBtn.click();

		} else if (paymentType.equalsIgnoreCase("Gift")) {
			giftCardBtn.click();
		}

	}

	public void fillCreditCardDetials(String cardNum, String expDate, String firstName, String lastName, String cvv,
			String zipcode) throws InterruptedException {
		// cardDetails popup is having iFrame so used below command switchto() method to
		// navigate to cardetails pop
		driver.switchTo().frame(0);
        cardNumber.sendKeys(cardNum);
        expiryDate.sendKeys(expDate);
        cvvNum.sendKeys(cvv);
		fName.sendKeys(firstName);
		lName.sendKeys(lastName);
		zipCode.sendKeys(zipcode);
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.elementToBeClickable(Submitbtn));
		Submitbtn.click();

	}

	public void fillGiftCardDetails(String giftcardNum, String giftPinNum) {
		giftCardNumber.sendKeys(giftcardNum);
		giftPin.sendKeys(giftPinNum);
		giftSubmitbtn.click();

	}

	/**
	 * Below method is only used for credit card payment type to fill billing
	 * details.
	 */
	public void fillBillingDetails(String billingadd1, String stateName, String cityb, String zip) {
		billingaddrs1.sendKeys(billingadd1);
		Select state = new Select(billingstate);
		state.selectByVisibleText(stateName);
		billingcity.sendKeys(cityb);
		billingzipcode.sendKeys(zip);
	}

	public void doCheckOut() {

		cartIcons.click();
		CheckOutbtn.click();
	}

	public void orderNowbtn() {
		orderNowBtn.click();
	}

	/**
	 * @param amount
	 *            below method is used for the add Tip into any order Give amount
	 *            "No" for "NoTip" This accept three predefined value 10 %,15% ,20%
	 *            Respectively & also we can enter custom values any digit.
	 */
	public void selectTipAmount(String tipAmount) {

		if (tipAmount.equalsIgnoreCase("No")) {
			WebDriverWait wait = new WebDriverWait(driver, 30);
			wait.until(ExpectedConditions.elementToBeClickable(tipContinuebtn));
			tipContinuebtn.click();

		} else if (tipAmount.equalsIgnoreCase("10%")) {
			yesbtn.click();
			tenPercent.click();
			tipContinuebtn.click();

		} else if (tipAmount.equalsIgnoreCase("15%")) {
			yesbtn.click();
			fifteenPercent.click();
			tipContinuebtn.click();

		} else if (tipAmount.equalsIgnoreCase("20%")) {
			yesbtn.click();
			twentyPercent.click();
			tipContinuebtn.click();

		} else {
			yesbtn.click();
			customAmount.click();
			customTipAmountTextBox.clear();
			customTipAmountTextBox.sendKeys(tipAmount);
			tipContinuebtn.click();

		}

	}

	public String getThankYouMessage() {
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return thankYouScreenmsg.getText();
	}

}