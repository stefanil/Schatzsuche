/**
 * 
 */
package de.saxsys.treasurehunting.common.views.nav;

import org.junit.Test;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import play.test.*;

/**
 * This test class tests the navigation for different browsers.
 * 
 * @author stefan.illgen
 * 
 */
public class CommonBrowserNavigationTest {

	// Commented out due to unresolvable behaviour for Firefox (see devdoc)
	// /**
	// * Test method for running a successful login and the right presentation
	// of
	// * the username for browser Firefox (v17+).
	// *
	// *
	// */
	// @Test
	// public void navUsernameFirefox() {
	// Helpers.running(
	// Helpers.testServer(3333,
	// Helpers.fakeApplication()),
	// Helpers.FIREFOX, new NavUsernameCallbackComposite());
	// }

	/**
	 * Test method for running a successful login and the right presentation of
	 * the username for browser Chrome/Chromium.
	 */
	@Test
	public void navUsernameChrome() {
		System.setProperty("webdriver.chrome.driver",
				"test/de/saxsys/treasurehunting/webdrivers/chromedriver.exe");
		Helpers.running(Helpers.testServer(3333, Helpers.fakeApplication()),
				ChromeDriver.class, new NavUsernameCallbackComposite());
	}

	/**
	 * Test method for running a successful login for browser IE.
	 */
	@Test
	public void navUsernameIE() {
		Helpers.running(Helpers.testServer(3333, Helpers.fakeApplication()),
				InternetExplorerDriver.class,
				new NavUsernameCallbackComposite());
	}

	/**
	 * Test method for running a successful login and the right presentation of
	 * the activity state of the game navigation link, which must be active, for
	 * browser Firefox (v17+).
	 */
	@Test
	public void navGameFirefox() {
		Helpers.running(Helpers.testServer(3333, Helpers.fakeApplication()),
				Helpers.FIREFOX, new NavGameCallbackComposite());
	}

	/**
	 * Test method for running a successful login and the right presentation of
	 * the activity state of the game navigation link, which must be active, for
	 * browser Chrome/Chromium.
	 */
	@Test
	public void navGameChrome() {
		System.setProperty("webdriver.chrome.driver",
				"test/de/saxsys/treasurehunting/webdrivers/chromedriver.exe");
		Helpers.running(Helpers.testServer(3333, Helpers.fakeApplication()),
				ChromeDriver.class, new NavGameCallbackComposite());
	}

	/**
	 * Test method for running a successful login and the right presentation of
	 * the activity state of the game navigation link, which must be active, for
	 * browser IE.
	 */
	@Test
	public void navGameIE() {
		Helpers.running(Helpers.testServer(3333, Helpers.fakeApplication()),
				InternetExplorerDriver.class, new NavGameCallbackComposite());
	}

	/**
	 * Test method for running a successful login and the right presentation of
	 * the activity state of the admin navigation link, which must be active,
	 * for browser Chrome/Chromium.
	 */
	@Test
	public void navAdminFirefox() {
		Helpers.running(Helpers.testServer(3333, Helpers.fakeApplication()),
				Helpers.FIREFOX, new NavAdminCallbackComposite());
	}

	/**
	 * Test method for running a successful login and the right presentation of
	 * the activity state of the admin navigation link, which must be active,
	 * for browser Chrome/Chromium.
	 */
	@Test
	public void navAdminChrome() {
		System.setProperty("webdriver.chrome.driver",
				"test/de/saxsys/treasurehunting/webdrivers/chromedriver.exe");
		Helpers.running(Helpers.testServer(3333, Helpers.fakeApplication()),
				ChromeDriver.class, new NavAdminCallbackComposite());
	}
	
	/**
	 * Test method for running a successful login and the right presentation of
	 * the activity state of the admin navigation link, which must be active, for
	 * browser IE.
	 */
	@Test
	public void navAdminIE() {
		Helpers.running(Helpers.testServer(3333, Helpers.fakeApplication()),
				InternetExplorerDriver.class, new NavAdminCallbackComposite());
	}

}
