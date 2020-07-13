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

public class CrudCollectionTest {

	private RemoteWebDriver driver;

	// TODO add reports

	@Before
	public void init() {
		ChromeOptions opts = new ChromeOptions();
		opts.setHeadless(true);
		this.driver = new ChromeDriver(opts);
		this.driver.manage().window().maximize();
	}

	@Test
	public void testCreateCollection() {
		final String collectionName = "sellenium";
		final String collectionValue = "23.99";

		HomePageCollection home = new HomePageCollection(driver);

		home.createCollection(collectionName, collectionValue);
		
		String result = home.successReturn();
		
		assertTrue(result.contains("success"));

	}

	@Test
	public void testReadCollections() {
		HomePageCollection home = new HomePageCollection(driver);

		home.readCollections();

		assertFalse(home.readReturn().contains(""));
	}
	
	@Test
	public void testUpdateCollection() {
		HomePageCollection home = new HomePageCollection(driver);
		String themeName = "testing update";
		String valueAmount = "23.24";
		home.updateCollection(themeName, valueAmount);
		
		home.readCollections();
		
		String result = home.readContents();
		
		assertEquals(themeName, result);
	}
	
	@Test
	public void testDeleteCollection() {
		HomePageCollection home = new HomePageCollection(driver);
		
		home.deleteCollection();
		
		String result = home.successReturn();
		
		assertTrue(result.contains("success"));
	}

	@After
	public void tearDown() {
		this.driver.quit();
	}

}
