package de.saxsys.treasurehunting.game.controllers;

import play.mvc.Controller;
import play.mvc.Result;
import play.mvc.Security;
import de.saxsys.treasurehunting.common.controllers.Secured;
import de.saxsys.treasurehunting.game.views.html.*;

/**
 * This {@link Controller} implements the game actions.
 * 
 * @author stefan.illgen
 */
public class GameController extends Controller {
  
	/**
	 * .
	 * @return
	 */
	@Security.Authenticated(Secured.class)
    public static Result index() {
        return TODO;
    }
  
	/**
	 * .
	 * @return
	 */
	@Security.Authenticated(Secured.class)
    public static Result singleplayer() {
        return TODO;
    }
    
	/**
	 * .
	 * @return
	 */
	@Security.Authenticated(Secured.class)
    public static Result startSPGame() {
        return TODO;
    }
    
	/**
	 * .
	 * @return
	 */
	@Security.Authenticated(Secured.class)
    public static Result visitorarena() {
        return TODO;
    }
    
	/**
	 * .
	 * @return
	 */
	@Security.Authenticated(Secured.class)
    public static Result startVAGame() {
        return TODO;
    }
}
