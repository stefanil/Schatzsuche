/**
 * 
 */
package de.saxsys.treasurehunting.common.views.nav;

import de.saxsys.treasurehunting.common.views.LoginSuccessCallback;
import de.saxsys.treasurehunting.views.callbacks.CompositeCallback;

/**
 * This {@link CompositeCallback} aggregates.
 * 
 * <ul>
 * 	<li>{@link LoginSuccessCallback}</li>
 * 	<li>{@link NavAdminCallback}</li>
 * </ul>
 * 
 * @author stefan.illgen
 *
 */
public class NavAdminCallbackComposite extends CompositeCallback {

	/**
	 * Constructor used for aggregation.
	 */
	public NavAdminCallbackComposite() {
		addCallback(new LoginSuccessCallback());
		addCallback(new NavAdminCallback());
	}

}
