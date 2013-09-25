/**
 * 
 */
package de.saxsys.treasurehunting.game.services;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.codehaus.jackson.JsonNode;

import play.mvc.WebSocket;
import akka.actor.ActorRef;

import com.avaje.ebean.Ebean;

import de.saxsys.treasurehunting.common.models.actions.Action;
import de.saxsys.treasurehunting.common.models.game.Counter;
import de.saxsys.treasurehunting.common.models.game.Game;

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
public abstract class GameHall {

	/**
	 * This static {@link Map} caches instances of active games on the server.
	 * It's key represents the game id. It's value identifies the
	 * {@link ActorRef}, which corresponds to the {@link Game}.
	 */
	protected static Map<Long, ActorRef> activeGames = new HashMap<Long, ActorRef>();

	/**
	 * This non-static {@link Map} caches all instances of {@link Counter}
	 * participating in the game. Each {@link Counter} is related to it's
	 * {@link WebSocket} out channel.
	 */
	protected Map<Long, WebSocket.Out<JsonNode>> members = new HashMap<Long, WebSocket.Out<JsonNode>>();

	/**
	 * Checker for identifying active games via its ID.
	 * 
	 * @param id
	 *            The ID of the game.
	 * @return Return true, if this is an active game, and otherwise false.
	 */
	public static boolean isActiveGame(long id) {
		Game game = findGame(id);
		return activeGames.containsKey(id) && game != null
				&& game.state != Game.STATE_READY;
	}

	/**
	 * Returns the {@link Game} identified by its ID.
	 * 
	 * @param id
	 *            The ID of the game.
	 * @return Returns the {@link Game} identified by its ID or null if the
	 *         {@link Game} wasn't found.
	 */
	protected static Game findGame(long id) {
		return Ebean.find(Game.class, id);
	}

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
