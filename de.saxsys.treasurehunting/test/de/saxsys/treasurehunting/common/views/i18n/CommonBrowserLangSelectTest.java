package de.saxsys.treasurehunting.common.views.i18n;

import org.junit.Test;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import play.test.Helpers;

/**
 * This class provides Tests for language selection.
 * 
 * @author stefan.illgen
 */
public class CommonBrowserLangSelectTest {

	/**
	 * Test method for selecting the german language for browser Firefox (v17+).
	 */
	@Test
	public void langSelectDEFirefox() {
		Helpers.running(
				Helpers.testServer(3333,
						Helpers.fakeApplication(Helpers.inMemoryDatabase())),
				Helpers.FIREFOX, new SelectLangDECallback());
	}

	/**
	 * Test method for selecting the german language for browser Chrome/Chromium.
	 */
	@Test
	public void langSelectDEChrome() {
		System.setProperty("webdriver.chrome.driver",
				"d:/DEVEL/ide/chromedriver_win32_2.0/chromedriver.exe");
		Helpers.running(
				Helpers.testServer(3333,
						Helpers.fakeApplication(Helpers.inMemoryDatabase())),
				ChromeDriver.class, new SelectLangDECallback());
	}

	/**
	 * Test method for selecting the german language for browser IE.
	 */
	@Test
	public void langSelectDEIE() {
		Helpers.running(
				Helpers.testServer(3333,
						Helpers.fakeApplication(Helpers.inMemoryDatabase())),
				InternetExplorerDriver.class, new SelectLangDECallback());
	}
	
	/**
	 * Test method for selecting the english language for browser Firefox (v17+).
	 */
	@Test
	public void langSelectENFirefox() {
		Helpers.running(
				Helpers.testServer(3333,
						Helpers.fakeApplication(Helpers.inMemoryDatabase())),
				Helpers.FIREFOX, new SelectLangENCallback());
	}

	/**
	 * Test method for selecting the english language for browser Chrome/Chromium.
	 */
	@Test
	public void langSelectENChrome() {
		System.setProperty("webdriver.chrome.driver",
				"d:/DEVEL/ide/chromedriver_win32_2.0/chromedriver.exe");
		Helpers.running(
				Helpers.testServer(3333,
						Helpers.fakeApplication(Helpers.inMemoryDatabase())),
				ChromeDriver.class, new SelectLangENCallback());
	}

	/**
	 * Test method for selecting the english language for browser IE.
	 */
	@Test
	public void langSelectENIE() {
		Helpers.running(
				Helpers.testServer(3333,
						Helpers.fakeApplication(Helpers.inMemoryDatabase())),
				InternetExplorerDriver.class, new SelectLangENCallback());
	}
	
}
