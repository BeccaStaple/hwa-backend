package com.qa.hwa.seleniumtests;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;

public class HomePageCollection extends WebPage {
	
	@FindBy(xpath = "/html/body/div[2]/div[2]/div[1]/div/form/input[1]")
	private WebElement collectionThemeInput;
	
	@FindBy(xpath = "/html/body/div[2]/div[2]/div[1]/div/form/input[2]")
	private WebElement collectionValueInput;
	
	@FindBy(xpath = "/html/body/div[2]/div[2]/div[1]/div/form/button")
	private WebElement submitCollectionBtn;
	
	
	@FindBy(xpath = "/html/body/div[2]/div[2]/div[2]/div/input")
	private WebElement collectionDeleteId;
	
	@FindBy(xpath = "/html/body/div[2]/div[2]/div[2]/div/button")
	private WebElement collectionDeleteBtn;
	
	
	@FindBy(id = "readAllCollections")
	private WebElement readCollections;
	
	
	@FindBy(id = "collectionIdUpdate")
	private WebElement collectionIdInputUpdate;
	
	@FindBy(id = "openUpdateModal")
	private WebElement collectionUpdateBtn;
	

	public HomePageCollection(RemoteWebDriver driver) {
		super(driver, "file:///C:/Users/rebec/Desktop/eclipse-work-bench/000-Project/index.html");
	}
	
	public void createCollection() {
		collectionThemeInput.sendKeys("create test collection");
		collectionValueInput.sendKeys("23.99");
		submitCollectionBtn.click();
	}
	
	public void readCollections() {
		readCollections.click();
	}
	
	public void updateCollection() {
		collectionIdInputUpdate.sendKeys("1");
		collectionUpdateBtn.click();
		//TODO add wait for inputs to put in and add inputs
	}
	
	public void deleteCollection() {
		collectionDeleteId.sendKeys("1");
		collectionDeleteBtn.click();
		
		//TODO add wait for alert to pop up that collection has been deleted
	}
	

}
