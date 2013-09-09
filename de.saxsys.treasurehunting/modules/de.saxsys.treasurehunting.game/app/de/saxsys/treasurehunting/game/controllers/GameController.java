package de.saxsys.treasurehunting.game.controllers;

import play.mvc.Controller;
import play.mvc.Result;
import play.mvc.Security;
import de.saxsys.treasurehunting.common.controllers.Secured;
import de.saxsys.treasurehunting.game.views.html.*;

public class GameController extends Controller {
  
	@Security.Authenticated(Secured.class)
    public static Result index() {
        return TODO;
    }
  
	@Security.Authenticated(Secured.class)
    public static Result singleplayer() {
        return TODO;
    }
    
	@Security.Authenticated(Secured.class)
    public static Result startSPGame() {
        return TODO;
    }
    
	@Security.Authenticated(Secured.class)
    public static Result visitorarena() {
        return TODO;
    }
    
	@Security.Authenticated(Secured.class)
    public static Result startVAGame() {
        return TODO;
    }
}
