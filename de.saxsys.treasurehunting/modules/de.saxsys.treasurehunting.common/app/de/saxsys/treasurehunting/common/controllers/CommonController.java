package de.saxsys.treasurehunting.common.controllers;

import play.*;
import play.mvc.*;
import de.saxsys.treasurehunting.common.views.html.*;

import views.html.*;

public class CommonController extends Controller {
  
    public static Result index() {
        return ok(index.render("Common Module"));
    }
  
}
