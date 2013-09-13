/**
 * 
 */
package de.saxsys.treasurehunting.common.views.nav;

import static org.fest.assertions.Assertions.assertThat;

import play.test.TestBrowser;
import de.saxsys.treasurehunting.views.callbacks.Callback;

/**
 * This test callback checks the activity state for {@link WebElement}
 * containing the link (a) given by CSS selector <code>#a-nav-game</code>, which
 * must be active (<code>class="active"</code>), and for {@link WebElement}
 * containing the link (a) given by CSS selector <code>#a-nav-admin</code>,
 * which must be non-active (<code>class=""</code>).
 * 
 * @author stefan.illgen
 * 
 */
public class NavAdminCallback extends Callback {

	@Override
	public void invoke(TestBrowser browser) throws Throwable {

		assertThat(browser.url()).isEqualTo("http://localhost:3333/game");
		browser.click("#a-nav-admin");
		assertThat(browser.url()).isEqualTo("http://localhost:3333/admin");

		String cssClassGame = browser.find("#li-nav-game").get(0)
				.getAttribute("class");
		String cssClassAdmin = browser.find("#li-nav-admin").get(0)
				.getAttribute("class");

		assertThat(cssClassGame).isEqualTo("");
		assertThat(cssClassAdmin).isEqualTo("active");
	}

}
