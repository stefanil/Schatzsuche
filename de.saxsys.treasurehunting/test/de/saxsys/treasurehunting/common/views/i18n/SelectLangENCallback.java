/**
 * 
 */
package de.saxsys.treasurehunting.common.views.i18n;

import static org.fest.assertions.Assertions.assertThat;

import play.i18n.Lang;
import play.i18n.Messages;
import play.test.TestBrowser;
import de.saxsys.treasurehunting.views.callbacks.Callback;

/**
 * This class provides a {@link Callback} for testing the english language
 * selection.
 * 
 * @author stefan.illgen
 */
public class SelectLangENCallback extends Callback {

	/**
	 * This operation checks the language selection on the start page.
	 */
	@Override
	public void invoke(TestBrowser browser) throws Throwable {
		browser.goTo("http://localhost:3333/");
		// select german language
		browser.click("#a-en");
		// assert
		assertThat(browser.text("#div-lbl-lang")).contains(
				Messages.get(Lang.forCode("en"), "common.lang.label"));
	}

}
