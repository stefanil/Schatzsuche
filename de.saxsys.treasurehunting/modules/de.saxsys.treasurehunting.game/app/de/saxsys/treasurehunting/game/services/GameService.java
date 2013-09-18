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
	 */
	public static int STATE_READY;
	
	/**
	 * 
	 */
	public static int STATE_ACTIVE;
	
	/**
	 * 
	 */
	public static int STATE_DICING;
	
	/**
	 * 
	 */
	public static int STATE_MOVING;
	
	/**
	 * 
	 */
	public static int STATE_PERFORMING;
	
	/**
	 * 
	 */
	public static int STATE_FINISHED;
	
	/**
	 * 
	 */
	public static int STATE_PAUSED;
	
	/**
	 * 
	 */
	public static Integer COUNTER_COLOR_RED = Integer.valueOf(0xff0000);
	
	/**
	 * 
	 */
	public static Integer COUNTER_COLOR_GREEN = Integer.valueOf(0xff00);
	
	/**
	 * 
	 */
	public static Integer COUNTER_COLOR_BLUE = Integer.valueOf(0xff);
	
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
