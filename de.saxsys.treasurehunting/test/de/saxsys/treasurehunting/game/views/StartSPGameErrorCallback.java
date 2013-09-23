/**
 * 
 */
package de.saxsys.treasurehunting.game.views;

import static org.fest.assertions.Assertions.assertThat;
import play.i18n.Lang;
import play.i18n.Messages;
import play.test.TestBrowser;
import de.saxsys.treasurehunting.views.callbacks.Callback;

/**
 * @author stefan.illgen
 */
public class StartSPGameErrorCallback extends Callback {

	@Override
	public void invoke(TestBrowser browser) throws Throwable {
		browser.fill("#gameName").with("  ");
		browser.click("#btn-startSPGame");
		assertThat(browser.text("#help-gameName").get(0)).isEqualTo(
				Messages.get(Lang.forCode("de"),
						"game.index.sp.conf.gameName.error"));
	}

}
