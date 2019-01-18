package com.caw.qa.pages;

import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import org.openqa.selenium.support.ui.Select;

import com.caw.qa.base.TestBase;

/**
 * @author nikhilk
 *
 */
public class LocationsPage extends TestBase {

	@FindBy(xpath = "//*[@id=\"nav-main\"]/li[5]/a")
	WebElement Locations;

	@FindBy(xpath = "//*[@id=\"chooseDeliveryTimeModal\"]/div/div/form/button")
	WebElement continueButton;

	@FindBy(xpath = "//input[@id='now']")
	WebElement nowRadioButton;

	// input[@id='now']
	@FindBy(xpath = "//input[@id='later']")
	WebElement laterRadioButton;

	@FindBy(xpath = "//*[@id=\"chooseDeliveryTimeModal\"]/div/div/form/div[1]/button/i")
	WebElement CloseButton;

	/// delivery form Webelements
	@FindBy(name = "addressLine1")
	WebElement AdressLine1;

	@FindBy(name = "addressLine2")
	WebElement AdressLine2;

	@FindBy(name = "country")
	WebElement Countrydropdown;

	@FindBy(name = "stateName")
	WebElement StateNamedropdown;

	@FindBy(name = "cityName")
	WebElement CityNamefield;

	@FindBy(name = "zipCode")
	WebElement zipCode;

	@FindBy(xpath = "//div[@class='col-md-12 col-sm-12']/following::button[1]")
	WebElement deliveryFormContinueButton;
	// other buttons
	@FindBy(xpath = "//select[@class='form-control']")
	WebElement selectStatedrpdwn;

	@FindBy(xpath = "//strong[contains(text(),'Change Location')]")
	WebElement ChangeLocationButton;

	@FindBy(xpath = "//*[@id=\"changeServiceType\"]/div/div/div[3]/button[2]")
	WebElement cnfrmYesButton;

	@FindBy(xpath = "//*[@id=\"changeServiceType\"]/div/div/div[3]/button[1]")
	WebElement cnfrmNoButton;

	public LocationsPage() {

		PageFactory.initElements(driver, this);

	}
      //select ASAP & later PickUp orders.
	public void selectPickupOrder(String locationName, String orderType) {
		if (orderType.equalsIgnoreCase("Now")) {
			driver.findElement(By.xpath("//h4[contains(text(),'" + locationName + "')]//following::button[1]")).click();
			continueButton.click();
		} else if (orderType.equalsIgnoreCase("Later")) {
			driver.findElement(By.xpath("//h4[contains(text(),'" + locationName + "')]/following::button[1]")).click();
			laterRadioButton.click();
			continueButton.click();
		}
	}

	// Select ASAP Delivery order
	public void selectAsapDeliveryOrder(String locationname) {

		driver.findElement(By.xpath("//h4[contains(text(),'" + locationname + "')]/following::button[2]")).click();
		continueButton.click();

	}

	// Select Future Delivery order
	public void selectFutureDeliveryOrder(String locationname) {

		driver.findElement(By.xpath("//h4[contains(text(),'" + locationname + "')]/following::button[2]")).click();
		laterRadioButton.click();
		continueButton.click();

	}
//Fill delivery address method
	public void fillDeliveryAddrees(String locationname, String addr1, String addr2, String city, String state,
			String custZip) {
		driver.findElement(By.xpath("//h4[contains(text(),'" + locationname + "')]/following::button[2]")).click();
		AdressLine1.sendKeys(addr1);
		AdressLine2.sendKeys(addr2);
		Select stateDrpDwn = new Select(StateNamedropdown);
		stateDrpDwn.selectByVisibleText(state);
		CityNamefield.sendKeys(city);
		zipCode.sendKeys(custZip);
		deliveryFormContinueButton.click();

	}

	public void changeLocation() {
		ChangeLocationButton.click();
		cnfrmYesButton.click();

	}
	


	public String checkSocialLink(String locName, String linkName) {
		if (linkName.equalsIgnoreCase("Facebook")) {
			driver.findElement(By.xpath("//h4[contains(text(),'" + locName + "')]//following::a[1]")).click();
		} else if (linkName.equalsIgnoreCase("google+")) {
			driver.findElement(By.xpath("//h4[contains(text(),'" + locName + "')]//following::a[2]")).click();
		} else if (linkName.equalsIgnoreCase("twitter")) {
			driver.findElement(By.xpath("//h4[contains(text(),'" + locName + "')]//following::a[3]")).click();
		} else if (linkName.equalsIgnoreCase("youtube")) {
			driver.findElement(By.xpath("//h4[contains(text(),'" + locName + "')]//following::a[4]")).click();
		} else if (linkName.equalsIgnoreCase("Yelp")) {
			driver.findElement(By.xpath("//h4[contains(text(),'" + locName + "')]//following::a[4]")).click();
		} else if (linkName.equalsIgnoreCase("Instagram")) {
			driver.findElement(By.xpath("//h4[contains(text(),'" + locName + "')]//following::a[4]")).click();
		}
		List<String> browserTabs = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(browserTabs.get(1));
		String Pagetitle = driver.getTitle();
		driver.close();
		driver.switchTo().window(browserTabs.get(0));
		return Pagetitle;
	}

}
