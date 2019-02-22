package com.caw.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
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

	public void selectItemAndModifiers(String menuname, String itemname, String addonName1,String addonName2, String optionName1,
			String optionName2, String optionName3, String optionName4, String optionName5, String optionName6,
			String sizeName) throws InterruptedException {

		driver.findElement(By.xpath("//a[contains(text(),'" + menuname + "')]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//h6[contains(text(),'" + itemname + "')]//following::button[1]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//span[contains(text(),'" + sizeName + "')]")).click();

		if ((addonName1 != null && !addonName1.equals("")) || (addonName2 != null && !addonName2.equals(""))){

			driver.findElement(By.xpath("//span[contains(text(),'" + addonName1 + "')]")).click();
			Thread.sleep(2000);
			
			

			if (optionName1 != null && !optionName1.equals("")) {
				driver.findElement(By.xpath("//span[contains(text(),'" + optionName1 + "')]")).click();
			}

			if (optionName2 != null && !optionName2.equals("")) {
				driver.findElement(By.xpath("//span[contains(text(),'" + optionName2 + "')]")).click();
			}

			if (optionName3 != null && !optionName3.equals("")) {
				driver.findElement(By.xpath("//span[contains(text(),'" + optionName3 + "')]")).click();
			}

			if (optionName4 != null && !optionName4.equals("")) {
				driver.findElement(By.xpath("//span[contains(text(),'" + optionName4 + "')]")).click();
			}

			if (optionName5 != null && !optionName5.equals("")) {
				driver.findElement(By.xpath("//span[contains(text(),'" + optionName5 + "')]")).click();
			}

			if (optionName6 != null && !optionName6.equals("")) {
				driver.findElement(By.xpath("//span[contains(text(),'" + optionName6 + "')]")).click();
			}

			addToOrderBtn.click();
			
			
			JavascriptExecutor js = (JavascriptExecutor) driver;

			js.executeScript("alert('item added successfully')");

		}

	}

	public void selectPizzaTypeModidiers() {

	}
}
