package de.saxsys.treasurehunting.admin.controllers;

import play.mvc.Controller;
import play.mvc.Result;
import play.mvc.Security;
import de.saxsys.treasurehunting.common.controllers.Secured;

/**
 * This {@link Controller} implements the administration actions.
 * 
 * @author stefan.illgen
 */
public class AdminController extends Controller {
  
	/**
	 * The start page for the administration module.
	 * 
	 * @return
	 */
	@Security.Authenticated(Secured.class)
    public static Result index() {
        return TODO;
    }
  
}
