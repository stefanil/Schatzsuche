/**
 * 
 */
package de.saxsys.treasurehunting.game.services.singleplayer;

import java.util.List;

import de.saxsys.treasurehunting.common.models.actions.Action;
import de.saxsys.treasurehunting.game.services.GameService;

/**
 * TODO.
 * 
 * @author stefan.illgen
 *
 */
public class SinglePlayerGameService extends GameService {

	/**
	 * TODO.
	 */
	public static int H_MODE_SINGLEPLAYER;
	
	public long gameID;
	
	@Override
	public void initializeGame() {
		// TODO Auto-generated method stub

	}
	
	@Override
	public List<Action> handleClientAction(Action action) {
		// TODO Auto-generated method stub
		return null;
	}	
	
	private void startGame() {
	
	}
	
	private void cancelGame() {
	
	}
	
	private void pauseGame() {
	
	}
	
	private void restartGame() {
	
	}
	
	private void resumeGame() {
	
	}

}
