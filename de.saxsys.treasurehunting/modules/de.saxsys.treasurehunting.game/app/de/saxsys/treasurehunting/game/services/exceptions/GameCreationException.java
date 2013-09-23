/**
 * 
 */
package de.saxsys.treasurehunting.game.services.exceptions;

import de.saxsys.treasurehunting.common.models.game.Game;

/**
 * An Exception which is thrown during the creation process for the {@link Game}
 * .
 * 
 * @author stefan.illgen
 * 
 */
public class GameCreationException extends Exception {

	private static final long serialVersionUID = 4999775602368682437L;

	/**
	 * Default Constructor taking a localized message.
	 * 
	 * @param localizedMessage
	 *            The localized message to show.
	 */
	public GameCreationException(String localizedMessage) {
		super(localizedMessage);
	}

}
