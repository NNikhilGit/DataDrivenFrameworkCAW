package com.caw.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.caw.qa.base.TestBase;

public class LocationsPage extends TestBase {
	
	@FindBy(xpath="//*[@id=\"nav-main\"]/li[5]/a")
	WebElement Locations;

	@FindBy(xpath="//*[@id=\"chooseDeliveryTimeModal\"]/div/div/form/button")
	WebElement continueButton;
	
	@FindBy(xpath="//input[@id='now']")
	WebElement nowRadioButton;
	
	//input[@id='now']
    @FindBy(xpath="//input[@id='later']")
	WebElement laterRadioButton;
	
    @FindBy(xpath="//*[@id=\"chooseDeliveryTimeModal\"]/div/div/form/div[1]/button/i")
	WebElement CloseButton;
	
	@FindBy(xpath="//strong[contains(text(),'Change Location')]")
	WebElement ChangeLocationButton;
	
    @FindBy(name="addressLine1")
	WebElement AdressLine1;
	
	@FindBy(name="addressLine2")
	WebElement AdressLine2;
	
	@FindBy(name="country")
	WebElement Countrydropdown;
	
	@FindBy(name="stateName")
	WebElement StateNamedropdown;
	
	@FindBy(name="cityName")
	WebElement CityNamefield;
	
	@FindBy(name="zipCode")
	WebElement zipCode;
	
	@FindBy(xpath="//select[@class='form-control']")
	WebElement selectStatedrpdwn;
	 
	@FindBy(xpath="//div[@class='col-md-12 col-sm-12']/following::button[1]")
	WebElement deliveryFormContinueButton;
	
    public LocationsPage() {
		PageFactory.initElements(driver, this);
	}
    
	public void selectAsapPickupOrderType() {
	
		continueButton.click();

	}

	public void selectFutrePickupOrderType() {
		
		laterRadioButton.click();
		continueButton.click();
	}

	public void selectDeliveryOrderType() {
//		LocationsButton.click();
//		OrderDeliveryButton.click();

	}
	

	public void fillDeliveryAddrees(String addr1, String addr2,String city,String state,String zip) {
		
		AdressLine1.sendKeys(addr1);
		AdressLine2.sendKeys(addr2);
	    Select stateDrpDwn=new Select(StateNamedropdown);
		stateDrpDwn.selectByVisibleText(state);
		CityNamefield.sendKeys(city);
		zipCode.sendKeys(zip);
        deliveryFormContinueButton.click();
        
	}
	
	public void selectorderType(String orderType) {
		if (orderType.equalsIgnoreCase("Now")) {
			WebDriverWait wait=new WebDriverWait(driver,20);
			wait.until(ExpectedConditions.visibilityOf(continueButton));
			continueButton.click();
			
		} else if (orderType.equalsIgnoreCase("Later")) {
			WebDriverWait wait=new WebDriverWait(driver,20);
			wait.until(ExpectedConditions.visibilityOf(laterRadioButton));
			laterRadioButton.click();
			continueButton.click();
		} else {
			System.out.println("Please enter ordetype");
		}
	}

	
	
}

