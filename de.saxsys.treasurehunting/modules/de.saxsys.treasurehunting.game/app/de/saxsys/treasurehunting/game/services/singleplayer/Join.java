/**
 * 
 */
package de.saxsys.treasurehunting.game.services.singleplayer;

import org.codehaus.jackson.JsonNode;

import play.mvc.WebSocket;
import de.saxsys.treasurehunting.common.models.user.User;

/**
 * Join the game hall.
 * 
 * @author stefan.illgen
 * 
 */
public class Join {

	final User user;
	final WebSocket.Out<JsonNode> channel;

	/**
	 * Constructor.
	 * 
	 * @param user The user.
	 * @param channel The websocket out channel.
	 */
	public Join(User user, WebSocket.Out<JsonNode> channel) {
		this.user = user;
		this.channel = channel;
	}
}
