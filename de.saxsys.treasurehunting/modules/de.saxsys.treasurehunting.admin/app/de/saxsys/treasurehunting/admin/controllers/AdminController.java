package de.saxsys.treasurehunting.admin.controllers;

import play.*;
import play.mvc.*;

import de.saxsys.treasurehunting.admin.views.html.*;

public class AdminController extends Controller {
  
    public static Result index() {
        return ok(index.render("Administration Module"));
    }
  
}
