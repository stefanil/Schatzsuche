/**
 * 
 */
package de.saxsys.treasurehunting.game.services;

import java.util.List;

import de.saxsys.treasurehunting.common.models.actions.Action;

/**
 * This class represents an abstract game service for managing arbitrary typed
 * games. It has one central method for handling client actions
 * {@link #handleClientAction(Action)}, which is abstract. Concrete classes must
 * implement it, to define the transitions for the game states for each games
 * modes.
 * 
 * @author stefan.illgen
 * 
 */
public abstract class GameHall{

	/**
	 * This is the central method for handling client actions. Concrete classes
	 * must implement it, to define the transitions for the game states for each
	 * games modes.
	 * 
	 * @param action
	 *            The action received from the client.
	 * @return Returns a {@link List} of {@link Action}, which follows up the
	 *         parameterized {@link Action}.
	 */
	public abstract List<Action> handleClientAction(Action action);

}
