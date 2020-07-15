package com.qa.hwa.seleniumtests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

public class CrudStampTest {

	private RemoteWebDriver driver;

	@Before
	public void init() {
		ChromeOptions opts = new ChromeOptions();
		// opts.setHeadless(true);
		this.driver = new ChromeDriver(opts);
		this.driver.manage().window().maximize();
	}

	@Test
	public void createStampTest() {
		final String stampName = "testing selenium";
		final String stampValue = "29.99";
		final String yearMade = "2020";
		final String collectionid = "1";
		HomePageStamp home = new HomePageStamp(driver);

		home.createStamp(stampName, stampValue, yearMade, collectionid);

		String result = home.successReturn();

		assertTrue(result.contains("success"));
	}

	@Test
	public void readTest() {
		HomePageStamp home = new HomePageStamp(driver);

		home.readStamps();

		assertFalse(home.readContents().contains(""));

	}

	@Test
	public void testUpdate() {
		final String stampId = "1";
		final String nameUpdate = "update test stamp";
		final String valueUpdate = "2.01";
		final String yearUpdate = "2001";
		final String colUpdate = "2";
		HomePageStamp home = new HomePageStamp(driver);

		home.updateStamp(stampId, nameUpdate, valueUpdate, yearUpdate, colUpdate);

		String result = home.readContents();

		assertEquals(nameUpdate, result);
	}

	@Test
	public void testDelete() {
		final String stampId = "1";
		HomePageStamp home = new HomePageStamp(driver);
		
		home.deleteStamp(stampId);
		
		String result = home.successReturn();
		
		assertTrue(result.contains("success"));
	}

	@After
	public void tearDown() {
		this.driver.quit();
	}

}
