/**
 * 
 */
package de.saxsys.treasurehunting.game.services.singleplayer;

import org.codehaus.jackson.JsonNode;

import play.mvc.WebSocket;
import de.saxsys.treasurehunting.common.models.user.User;

/**
 * Zutritt zur Spielhalle.
 * 
 * @author stefan.illgen
 * 
 */
public class Join {

	final User user;
	final WebSocket.Out<JsonNode> channel;

	public Join(User user, WebSocket.Out<JsonNode> channel) {
		this.user = user;
		this.channel = channel;
	}
}
