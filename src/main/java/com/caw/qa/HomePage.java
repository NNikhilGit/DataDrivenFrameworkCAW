package com.caw.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.caw.qa.base.TestBase;

/**
 * @author nikhilk
 *
 */
public class HomePage extends TestBase {
	@FindBy(xpath = "//ul[@id='nav-main-mobile']//a[@class='routes'][contains(text(),'Menu')]")
	WebElement menu;

	@FindBy(linkText = "//ul[@id='nav-main-mobile']//a[@class='routes'][contains(text(),'Offers')]")
	WebElement offers;

	@FindBy(linkText = "//ul[@id='nav-main-mobile']//a[@class='routes'][contains(text(),'Reviews')]")
	WebElement reviews;

	@FindBy(xpath = "//ul[@id='nav-main']//following::a[5]")
	WebElement Locations;

	@FindBy(xpath = "//ul[@id='nav-main-mobile']//a[@class='routes'][contains(text(),'Login')]")
	WebElement Login;

	// Methods createdFor Homepage

	public HomePage() {
		PageFactory.initElements(driver, this);
	}

	public void goToMenuPage() {
		menu.click();
	}

	public void goToOffersPage() {
		offers.click();
	}

	public void goToReviewsPage() {
		reviews.click();
	}

	public void goToLocationPage() {
		
		Locations.click();
    }
	
	

}
