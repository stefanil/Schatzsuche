/**
 * 
 */
package de.saxsys.treasurehunting.common.controllers;

import play.mvc.Http.Context;
import play.mvc.Result;
import play.mvc.Security;

/**
 * This class defines the session stored user id ({@link #getUsername(Context)})
 * and it defines what happens in case of an unauthorized access to a controller
 * action ({@link #onUnauthorized(Context)}).
 * 
 * @author stefan.illgen
 */
public class Secured extends Security.Authenticator {

	@Override
	public String getUsername(Context ctx) {
		return ctx.session().get("username");
	}

	@Override
	public Result onUnauthorized(Context ctx) {
		return redirect(routes.CommonController.index());
	}

}
