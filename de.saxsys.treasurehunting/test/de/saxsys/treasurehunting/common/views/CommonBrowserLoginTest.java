/**
 * 
 */
package de.saxsys.treasurehunting.common.views;


import org.junit.Test;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import play.test.*;

/**
 * This test class tests the login process for different browsers.
 * 
 * @author stefan.illgen
 * 
 */
public class CommonBrowserLoginTest {

	/**
	 * Test method for running a successful login for browser Firefox (v17+).
	 */
	@Test
	public void loginSuccessFirefox() {
		Helpers.running(
				Helpers.testServer(3333,
						Helpers.fakeApplication()),
				Helpers.FIREFOX, new LoginSuccessCallback());
	}

	/**
	 * Test method for running a successful login for browser Chrome/Chromium.
	 */
	@Test
	public void loginSuccessChrome() {
		System.setProperty("webdriver.chrome.driver",
				"d:/DEVEL/ide/chromedriver_win32_2.0/chromedriver.exe");
		Helpers.running(
				Helpers.testServer(3333,
						Helpers.fakeApplication()),
				ChromeDriver.class, new LoginSuccessCallback());
	}

	/**
	 * Test method for running a successful login for browser IE.
	 */
	@Test
	public void loginSuccessIE() {
		Helpers.running(
				Helpers.testServer(3333,
						Helpers.fakeApplication()),
				InternetExplorerDriver.class, new LoginSuccessCallback());
	}
	
	/**
	 * Test method for running a error prone login for browser Firefox (v17+).
	 */
	@Test
	public void loginFailureFirefox() {
		Helpers.running(
				Helpers.testServer(3333,
						Helpers.fakeApplication()),
				Helpers.FIREFOX, new LoginFailureCallback());
	}

	/**
	 * Test method for running a error prone login for browser Chrome/Chromium.
	 */
	@Test
	public void loginFailureChrome() {
		System.setProperty("webdriver.chrome.driver",
				"d:/DEVEL/ide/chromedriver_win32_2.0/chromedriver.exe");
		Helpers.running(
				Helpers.testServer(3333,
						Helpers.fakeApplication()),
				ChromeDriver.class, new LoginFailureCallback());
	}

	/**
	 * Test method for running a error prone login for browser IE.
	 */
	@Test
	public void loginFailureIE() {
		Helpers.running(
				Helpers.testServer(3333,
						Helpers.fakeApplication()),
				InternetExplorerDriver.class, new LoginFailureCallback());
	}

}
