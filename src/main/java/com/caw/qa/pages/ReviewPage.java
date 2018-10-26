package com.caw.qa.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.caw.qa.base.TestBase;

public class ReviewPage extends TestBase {

	@FindBy(xpath = "//*[@id=\"nav-main\"]/li[4]/a")
	WebElement reviewsButton;

	@FindBy(xpath = "//*[@id=\"content\"]/app-reviews/div[1]/div/div/div/h1")
	WebElement tileOfPage;

	@FindBy(xpath = "//span[contains(text(),'Write a review')]")
	WebElement writeReviewButton;

	@FindBy(xpath = "//*[@id=\"content\"]/app-reviews/section/div[2]/div/div/h2")
	WebElement reviewPageText;

	@FindBy(name = "//*[@id=\"reviewModal\"]/div/div/div[1]/h4")
	WebElement WriteReviewBoxTitle;

	//textarea[@class='form-control ng-pristine ng-invalid ng-touched']
	@FindBy(xpath = "//*[@id=\"reviewModal\"]/div/div/div[2]/form/div[1]/textarea")
	WebElement textBoxToWriteReview;

	@FindBy(xpath = "//*[@id=\"reviewModal\"]/div/div/div[2]/form/div[1]/validation-messages/div")
	WebElement errorMessgaeforReviewBox;

	@FindBy(xpath = "//div[@class='rate rate-lg rating mb-2 addRating']//child::i[1]")
	WebElement oneStar;

	@FindBy(xpath = "//div[@class='rate rate-lg rating mb-2 addRating']//child::i[2]")
	WebElement twoStars;

	@FindBy(xpath = "//div[@class='rate rate-lg rating mb-2 addRating']//child::i[3]")
	WebElement threeStars;

	@FindBy(xpath = "//div[@class='rate rate-lg rating mb-2 addRating']//child::i[4]")
	WebElement fourStars;

	@FindBy(xpath = "//div[@class='rate rate-lg rating mb-2 addRating']//child::i[5]")
	WebElement fiveStars;

	@FindBy(xpath = "//div[@class='text-center form-group']//child::button")
	WebElement addReviewButton;

	@FindBy(xpath = "//*[@id=\"reviewModal\"]/div/div/div[1]/button/i")
	WebElement closeWriteReviewPopUp;

	public ReviewPage() {

		PageFactory.initElements(driver, this);

	}

	/// Methods start from here

	public String getTitle() {
		return tileOfPage.getText();
	}

	public String botoomPageText() {
		return reviewPageText.getText();
	}

	public void writeReview(String reviewText, String stars) throws InterruptedException {
	
		
		reviewsButton.click();
		WebDriverWait wait=new WebDriverWait(driver,20);
		wait.until(ExpectedConditions.elementToBeClickable(writeReviewButton));
		writeReviewButton.click();
		textBoxToWriteReview.sendKeys(reviewText);
		if (stars.equalsIgnoreCase("one")) {
			oneStar.click();
		} else if (stars.equalsIgnoreCase("two")) {
			twoStars.click();
		} else if (stars.equalsIgnoreCase("three")) {
			threeStars.click();
		} else if (stars.equalsIgnoreCase("four")) {
			fourStars.click();
		} else if(stars.equalsIgnoreCase("five")){
			fiveStars.click();
		}
		addReviewButton.click();
	}
	
	
}
