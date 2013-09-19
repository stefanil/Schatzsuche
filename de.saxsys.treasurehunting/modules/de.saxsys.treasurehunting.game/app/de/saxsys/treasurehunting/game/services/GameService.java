/**
 * 
 */
package de.saxsys.treasurehunting.game.services;

import java.util.List;

import de.saxsys.treasurehunting.common.models.actions.Action;

/**
 * TODO.
 * 
 * @author stefan.illgen
 *
 */
public abstract class GameService {
	
	/**
	 * 
	 * @param action
	 * @return
	 */
	public abstract List<Action>  handleClientAction(Action action);
	
	/**
	 * 
	 */
	public abstract void initializeGame();
	
}
