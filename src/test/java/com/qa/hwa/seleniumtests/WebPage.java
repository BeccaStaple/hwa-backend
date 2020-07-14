package com.qa.hwa.seleniumtests;

import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.PageFactory;

public abstract class WebPage {
	
	public final String URL;
	private final RemoteWebDriver driver;

	public WebPage(RemoteWebDriver driver, String url) {
		this.URL = url;
		driver.get(URL);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public RemoteWebDriver getDriver() {
		return driver;
	}

}
