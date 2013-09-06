package de.saxsys.treasurehunting.common.controllers;

import play.i18n.Lang;
import play.mvc.Controller;
import play.mvc.Result;
import de.saxsys.treasurehunting.common.views.html.index;

/**
 * 
 * @author stefan.illgen
 *
 */
public class CommonController extends Controller {
  
	/**
	 * 
	 * @return
	 */
    public static Result index() {
        return ok(index.render());
    }
    
    /**
     * 
     * @return
     */
    public static Result authenticate() {
    	return redirect("/game");
    }
    
    /**
     * 
     * @param lang
     */
    public void setLang(Lang lang) {
		
	}
  
}
