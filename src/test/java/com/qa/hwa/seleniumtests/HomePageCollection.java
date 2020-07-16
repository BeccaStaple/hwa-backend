package com.qa.hwa.seleniumtests;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePageCollection extends WebPage {

	@FindBy(xpath = "/html/body/div[3]/div[2]/div[1]/div/form/input[1]")
	private WebElement collectionThemeInput;

	@FindBy(xpath = "/html/body/div[3]/div[2]/div[1]/div/form/input[2]")
	private WebElement collectionValueInput;

	@FindBy(xpath = "/html/body/div[3]/div[2]/div[1]/div/form/button")
	private WebElement submitCollectionBtn;

	@FindBy(xpath = "/html/body/div[2]/div/div[1]/h3")
	private WebElement success;

	@FindBy(xpath = "/html/body/div[2]/div/div[2]/button")
	private WebElement closeSuccess;
	
	

	@FindBy(xpath = "/html/body/div[3]/div[2]/div[2]/div/input")
	private WebElement collectionDeleteId;

	@FindBy(xpath = "/html/body/div[3]/div[2]/div[2]/div/button")
	private WebElement collectionDeleteBtn;
	
	

	@FindBy(id = "readAllCollections")
	private WebElement readCollections;
	
	@FindBy(xpath = "/html/body/div[3]/div[3]/div/table/tbody/td[1]")
	private WebElement readOutput;

	

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
		super(driver, "https://beccastaple.github.io/hwa-frontend/");
	}

	public String successReturn() {

		new WebDriverWait(getDriver(), 3);

		return success.getText().toLowerCase();
		
	}
	
	public void closeSuccess() {
		new WebDriverWait(getDriver(), 3).until(ExpectedConditions.elementToBeClickable(closeSuccess));
		closeSuccess.click();
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
		new WebDriverWait(getDriver(), 3).until(ExpectedConditions.visibilityOf(readOutput));
		return this.readOutput.getText();
	}

	public void updateCollection(String themeName, String valueAmount) {
		collectionIdInputUpdate.sendKeys("1");
		collectionUpdateBtn.click();

		new WebDriverWait(getDriver(), 3).until(ExpectedConditions.visibilityOf(themeInput));
		themeInput.sendKeys(themeName);
		colValueInput.sendKeys(valueAmount);
		updateModalBtn.click();
	}

	public void deleteCollection() {
		collectionDeleteId.sendKeys("1");
		collectionDeleteBtn.click();
	}

}
