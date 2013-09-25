/**
 * 
 */
package de.saxsys.treasurehunting.game.services.singleplayer;

import org.codehaus.jackson.JsonNode;

import play.mvc.WebSocket;
import de.saxsys.treasurehunting.common.models.game.Counter;

/**
 * Represents a {@link Join} to the game hall.
 * 
 * @author stefan.illgen
 * 
 */
public class Join {

	final Long counterID;
	final WebSocket.Out<JsonNode> out;
	final Long gameid;

	/**
	 * Constructor.
	 * 
	 * @param counterID
	 *            The {@link Counter}s ID.
	 * @param out
	 *            The web socket out channel.
	 */
	public Join(Long gameid, Long counterID, WebSocket.Out<JsonNode> out) {
		this.gameid = gameid;
		this.counterID = counterID;
		this.out = out;
	}
}
