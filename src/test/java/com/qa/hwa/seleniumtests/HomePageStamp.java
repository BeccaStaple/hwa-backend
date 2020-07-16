package com.qa.hwa.seleniumtests;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePageStamp extends WebPage{
	
	@FindBy(xpath = "/html/body/div[4]/div[2]/div[1]/div/form/input[1]")
	private WebElement stampNameInput;
	
	@FindBy(xpath = "/html/body/div[4]/div[2]/div[1]/div/form/input[2]")
	private WebElement stampValueInput;
	
	@FindBy(xpath = "/html/body/div[4]/div[2]/div[1]/div/form/input[3]")
	private WebElement stampYearMadeInput;
	
	@FindBy(xpath = "/html/body/div[4]/div[2]/div[1]/div/form/input[4]")
	private WebElement collectionIdInput;
	
	@FindBy(xpath = "/html/body/div[4]/div[2]/div[1]/div/form/button")
	private WebElement submitCreateBtn;
	
	
	
	@FindBy(xpath = "/html/body/div[4]/div[2]/div[2]/div/input")
	private WebElement deleteIDInput;
	
	@FindBy(xpath = "/html/body/div[4]/div[2]/div[2]/div/button")
	private WebElement deleteStampBtn;
	
	
	@FindBy(xpath = "/html/body/div[4]/div[2]/div[3]/div/button")
	private WebElement readAllBtn;
	
	@FindBy(xpath = "/html/body/div[4]/div[3]/div/table/tbody/td[1]")
	private WebElement readOutput;
	
	
	@FindBy(xpath = "/html/body/div[4]/div[2]/div[4]/div/input")
	private WebElement updateIDInput;
	
	@FindBy(xpath = "/html/body/div[4]/div[2]/div[4]/div/button")
	private WebElement updateStampBtn;
	
	@FindBy(xpath  ="/html/body/div[4]/div[4]/div/div[2]/input[1]")
	private WebElement updateNameInput;
	
	@FindBy(xpath = "/html/body/div[4]/div[4]/div/div[2]/input[2]")
	private WebElement updateValueInput;
	
	@FindBy(xpath = "/html/body/div[4]/div[4]/div/div[2]/input[3]")
	private WebElement updateYearInput;
	
	@FindBy(xpath = "/html/body/div[4]/div[4]/div/div[2]/input[4]")
	private WebElement updateCollectionInput;
	
	@FindBy(xpath = "/html/body/div[4]/div[4]/div/div[2]/div/button[1]")
	private WebElement sendUpdateBtn;
	
	@FindBy(xpath = "/html/body/div[2]/div/div[1]/h3")
	private WebElement success;
	
	@FindBy(xpath = "/html/body/div[2]/div/div[2]/button")
	private WebElement closeSuccessBtn;
	

	public HomePageStamp(RemoteWebDriver driver) {
		super(driver, "https://beccastaple.github.io/hwa-frontend/");
	}
	
	
	public String successReturn() {

		new WebDriverWait(getDriver(), 5);

		return success.getText().toLowerCase();
		
	}
	
	public void closeSuccess() {
		new WebDriverWait(getDriver(), 3).until(ExpectedConditions.elementToBeClickable(closeSuccessBtn));
		closeSuccessBtn.click();
	}
	
	
	public void createStamp(String stampName, String stampValue, String yearMade, String collectionid) {
		stampNameInput.sendKeys(stampName);
		stampValueInput.sendKeys(stampValue);
		stampYearMadeInput.sendKeys(yearMade);
		collectionIdInput.sendKeys(collectionid);
		
		submitCreateBtn.click();
	}
	
	public void readStamps() throws InterruptedException {
		readAllBtn.click();
	}
	
	public String readContents() {
		new WebDriverWait(getDriver(), 5).until(ExpectedConditions.visibilityOf(readOutput));
		return readOutput.getText();
	}
	
	public void deleteStamp(String stampId) {
		deleteIDInput.sendKeys(stampId);
		deleteStampBtn.click();
	}
	
	public void updateStamp(String stampId, String nameUpdate, String valueUpdate, String yearUpdate, String colUpdate) {
		updateIDInput.sendKeys(stampId);
		updateStampBtn.click();
		
		new WebDriverWait(getDriver(), 5);

		updateNameInput.sendKeys(nameUpdate);
		updateValueInput.sendKeys(valueUpdate);
		updateYearInput.sendKeys(yearUpdate);
		updateCollectionInput.sendKeys(colUpdate);
		
		sendUpdateBtn.click();
	}
	
	

}
