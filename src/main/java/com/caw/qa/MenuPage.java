package com.caw.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.caw.qa.base.TestBase;

/**
 * @author nikhilk
 *
 */
public class MenuPage extends TestBase {
	@FindBy(xpath = "//*[@id=\"nav-main-mobile\"]/li[2]/a")
	WebElement menu;

	@FindBy(xpath = "//*[@id=\"cartDetailsForm\"]/input")
	WebElement addToOrderBtn;

	@FindBy(xpath = "//*[@id=\"headerCartBtn\"]/span[2]")
	WebElement cartIcon;

	@FindBy(xpath = "//*[@id=\"panel-cart\"]/div/button[1]/span")
	WebElement goToCheckOutbtn;

	public MenuPage() {

		PageFactory.initElements(driver, this);
	}

	public void selectItemAndModifiers(String menuname, String itemname, String addonName, String optionName)
			throws InterruptedException {

		driver.findElement(By.xpath("//a[contains(text(),'" + menuname + "')]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//h6[contains(text(),'" + itemname + "')]//following::button[1]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//span[contains(text(),'" + addonName + "')]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//span[contains(text(),'" + optionName + "')]")).click();

		addToOrderBtn.click();

	}

}
