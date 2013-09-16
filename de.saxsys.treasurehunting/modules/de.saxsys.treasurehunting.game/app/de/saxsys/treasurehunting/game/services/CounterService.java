/**
 * 
 */
package de.saxsys.treasurehunting.game.services;

import play.db.ebean.Model;
import de.saxsys.treasurehunting.common.models.User;
import de.saxsys.treasurehunting.game.models.game.Counter;

/**
 * @author stefan.illgen
 *
 */
public abstract class CounterService {

	private static Model.Finder<String, Counter> find = new Model.Finder<String, Counter>(
			String.class, Counter.class);
	
	
	
}
