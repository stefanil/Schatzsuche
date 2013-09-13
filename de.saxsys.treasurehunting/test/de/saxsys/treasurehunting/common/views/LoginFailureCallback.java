/**
 * 
 */
package de.saxsys.treasurehunting.common.views;

import static org.fest.assertions.Assertions.assertThat;
import play.test.TestBrowser;
import de.saxsys.treasurehunting.views.callbacks.Callback;

/**
 * This callback implements a successful login procedure and may be reused for
 * composite test callbacks.
 * 
 * @author stefan.illgen
 */
public class LoginFailureCallback extends Callback {

	@Override
	public void invoke(TestBrowser browser) throws Throwable {

		browser.goTo("http://localhost:3333/");
		// select german language
		browser.click("#a-de");
		// fill the user name
		browser.fill("#username").with("  s");
		// submit the form
		browser.submit("#btn-start");
		// correct error message
		assertThat(browser.pageSource())
				.contains(
						play.i18n.Messages.get("common.index.login.username.error"));
	}

}
