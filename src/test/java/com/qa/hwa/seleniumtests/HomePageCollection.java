package com.qa.hwa.seleniumtests;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePageCollection extends WebPage {

	@FindBy(xpath = "/html/body/div[2]/div[2]/div[1]/div/form/input[1]")
	private WebElement collectionThemeInput;

	@FindBy(xpath = "/html/body/div[2]/div[2]/div[1]/div/form/input[2]")
	private WebElement collectionValueInput;

	@FindBy(xpath = "/html/body/div[2]/div[2]/div[1]/div/form/button")
	private WebElement submitCollectionBtn;

	@FindBy(xpath = "/html/body/div[2]/div/div[1]/h3")
	private WebElement success;

	@FindBy(xpath = "/html/body/div[2]/div/div[2]/button")
	private WebElement closeSuccess;

	@FindBy(xpath = "/html/body/div[2]/div[2]/div[2]/div/input")
	private WebElement collectionDeleteId;

	@FindBy(xpath = "/html/body/div[2]/div[2]/div[2]/div/button")
	private WebElement collectionDeleteBtn;

	@FindBy(id = "readAllCollections")
	private WebElement readCollections;

	@FindBy(xpath = "/html/body/div[2]/div[3]/div/table/tbody/td[2]")
	private WebElement theCollection;

	@FindBy(id = "collectionIdUpdate")
	private WebElement collectionIdInputUpdate;

	@FindBy(id = "openUpdateModal")
	private WebElement collectionUpdateBtn;

	@FindBy(xpath = "/html/body/div[3]/div[4]/div/div[2]/input[1]")
	private WebElement themeInput;

	@FindBy(xpath = "/html/body/div[3]/div[4]/div/div[2]/input[2]")
	private WebElement colValueInput;

	@FindBy(xpath = "/html/body/div[3]/div[4]/div/div[2]/div[2]/button[1]")
	private WebElement updateModalBtn;
	
	@FindBy(xpath = "/html/body/div[3]/div[3]/div/table/tbody/td[2]")
	private WebElement seeUpdateCollection;

	public HomePageCollection(RemoteWebDriver driver) {
		super(driver, "file:///C:/Users/rebec/Desktop/eclipse-work-bench/000-Project/index.html");
	}

	public String successReturn() {
		new FluentWait<WebDriver>(getDriver()).withTimeout(Duration.ofSeconds(5)).pollingEvery(Duration.ofMillis(500))
				.ignoring(Exception.class).until(ExpectedConditions.visibilityOf(closeSuccess));

		return success.getText().toLowerCase();
		closeSuccess.click();
	}
	
	public String readContents() {
		return seeUpdateCollection.getText();
	}

	public void createCollection(String collectionName, String collectionValue) {
		collectionThemeInput.sendKeys(collectionName);
		collectionValueInput.sendKeys(collectionValue);
		submitCollectionBtn.click();
	}

	public void readCollections() {
		readCollections.click();
	}

	public String readReturn() {
		return this.readCollections.getText();
	}

	public void updateCollection(String themeName, String valueAmount) {
		collectionIdInputUpdate.sendKeys("1");
		collectionUpdateBtn.click();

		new FluentWait<WebDriver>(getDriver()).withTimeout(Duration.ofSeconds(5)).pollingEvery(Duration.ofMillis(500))
				.ignoring(Exception.class).until(ExpectedConditions.visibilityOf(themeInput));

		themeInput.sendKeys(themeName);
		colValueInput.sendKeys(valueAmount);
		updateModalBtn.click();
	}

	public void deleteCollection() {
		collectionDeleteId.sendKeys("1");
		collectionDeleteBtn.click();
	}

}
