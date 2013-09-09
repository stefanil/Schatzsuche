package de.saxsys.treasurehunting.admin.controllers;

import play.mvc.Controller;
import play.mvc.Result;
import play.mvc.Security;
import de.saxsys.treasurehunting.common.controllers.Secured;

public class AdminController extends Controller {
  
	@Security.Authenticated(Secured.class)
    public static Result index() {
        return TODO;
    }
  
}
