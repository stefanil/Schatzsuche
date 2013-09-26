/**
 * 
 */
package de.saxsys.treasurehunting.game.services.singleplayer;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.codehaus.jackson.JsonFactory;
import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.JsonNode;
import org.codehaus.jackson.JsonParser;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;

import play.libs.Akka;
import play.libs.F.Callback;
import play.libs.F.Callback0;
import play.mvc.WebSocket;
import scala.concurrent.Await;
import scala.concurrent.duration.Duration;
import akka.actor.ActorRef;
import akka.actor.Props;
import akka.actor.UntypedActor;

import static akka.pattern.Patterns.ask;
import static java.util.concurrent.TimeUnit.*;

import com.avaje.ebean.Ebean;

import de.saxsys.treasurehunting.common.models.actions.Action;
import de.saxsys.treasurehunting.common.models.actions.ActionRequest;
import de.saxsys.treasurehunting.common.models.actions.ActionResponse;
import de.saxsys.treasurehunting.common.models.game.Counter;
import de.saxsys.treasurehunting.common.models.game.Game;
import de.saxsys.treasurehunting.common.models.playgrounds.Playground;
import de.saxsys.treasurehunting.common.services.UserService;
import de.saxsys.treasurehunting.game.services.GameHall;
import de.saxsys.treasurehunting.game.services.PlaygroundService;
import de.saxsys.treasurehunting.game.services.exceptions.GameCreationException;

/**
 * This class represents a game service for a single player game. It also
 * manages the web socket for the client.
 * 
 * @author stefan.illgen
 * 
 */
@SuppressWarnings("unused")
public class SinglePlayerGameHall extends GameHall {

	/**
	 * Creates the {@link Game} with {@link Game#hMode} for a single player.
	 * 
	 * @param username
	 *            The name of the user.
	 * @param gamename
	 *            The name of the game.
	 * @param countercolor
	 *            The color of the counter.
	 * @param playgroundname
	 *            The name of the playground.
	 * 
	 * @throws GameCreationException
	 *             Throws an {@link GameCreationException} in case of an error
	 *             while creating the {@link Game}.
	 * 
	 * @return The ID of the created {@link Game}.
	 */
	public static long createGame(String username, String gamename,
			int countercolor, String playgroundname)
			throws GameCreationException {

		// check preconditions
		if (username == null || username.trim().isEmpty())
			throw new GameCreationException(
					"Parameter username must not be null and must "
							+ "be a trimmed non empty String value.");
		if (gamename == null)
			throw new GameCreationException(
					"Parameter gamename must not be null and must "
							+ "be a trimmed non empty String value.");
		if (countercolor < 0 || countercolor > 0xffffff)
			throw new GameCreationException(
					"Integer value for countercolor must be in the "
							+ "range from 0 to 0xffffff.");
		if (playgroundname == null || playgroundname.trim().isEmpty())
			throw new GameCreationException(
					"Parameter playgroundname must not be null and "
							+ "must be a trimmed non empty String value.");

		// do it
		try {
			Playground playground = PlaygroundService
					.findPlayground(playgroundname);

			// create counter
			Counter counter = new Counter();
			counter.color = countercolor;
			counter.cards = 0;
			counter.user = UserService.findUser(username);
			counter.position = playground.startPoint;

			// create game
			Game game = new Game();
			game.name = gamename;
			game.state = Game.STATE_READY;
			game.hMode = Game.H_MODE_SINGLEPLAYER;
			game.activeCounter = 0;
			game.counters.add(counter);
			game.playground = playground;

			game.save();

			// caches as active game
			Props props = new Props(SinglePlayerGameHall.class);
			activeGames.put(game.id, Akka.system().actorOf(props));

			return game.id;

		} catch (Exception e) {
			throw new GameCreationException(e.getLocalizedMessage());
		}
	}

	/**
	 * .
	 * 
	 * @param gameid
	 * 
	 * @param username
	 * @param in
	 * @param out
	 */
	public static void join(Long gameid, final String username,
			WebSocket.In<JsonNode> in, WebSocket.Out<JsonNode> out) {

		try {
            final Game game = Ebean.find(Game.class, gameid);
            // create initial response action
            ActionResponse response = new ActionResponse();
            response.initializer = Action.TYPE_INITIALIZE_GAME;                
            response.data = new Object[] {
                   game.playground,
                   game.counters.get(0)
            };
            response.followers = new ArrayList<Action>() {
                   private static final long serialVersionUID = 1L;
                   {
                         add(Ebean.find(Action.class, 1));
                          add(Ebean.find(Action.class, 2));
                   }
            };

            // map it to Json
            ObjectMapper mapper = new ObjectMapper();
            String sResult = mapper.writeValueAsString(response);
            JsonFactory factory = new JsonFactory();
            JsonParser jp = factory.createJsonParser(sResult);
            JsonNode actualObj = mapper.readTree(jp);

            // send it via web socket
            out.write(actualObj);

     } catch (JsonGenerationException e) {
            e.printStackTrace();
     } catch (JsonMappingException e) {
            e.printStackTrace();
     } catch (IOException e) {
            e.printStackTrace();
     }

	}

	// Map<User, WebSocket.Out<JsonNode>> members = new HashMap<User,
	// WebSocket.Out<JsonNode>>();
	// // Falsch weil es nicht einen statischen gameActor geben kann
	// static ActorRef gameActor = Akka.system().actorOf(
	// new Props(SinglePlayerGameService.class));
	//
	@Override
	public void onReceive(Object message) throws Exception {

		// Bei einem Beitrittsgesuch ...
		if (message instanceof Join) {

			Join join = (Join) message;
			
			if (isActiveGame(join.gameid)) {

				// TODO

			} else {
				
				// TODO check members
				
//				if (members.containsKey(join.user)) {
//					// getSender().tell("This user is already used");
//				} else {
					
				members.put(join.counterID, join.out);
					
				// if this is not an active game
				ActionRequest actionRequest = new ActionRequest();
				actionRequest.initializer = Action.TYPE_INITIALIZE_GAME;
				actionRequest.data = new Object[] { 
						join.gameid, join.out
				};

				// initialize the game
				initializeGame(actionRequest);
				
//				}
			}
			
			

		} else

		if (message instanceof Action) {
			handleClientAction((Action) message);
		} else

		// Beim Schließen des Websockets (z.B. infolge eines Routenwechsels) ..
		if (message instanceof Quit) {
			Quit quit = (Quit) message;
			// .. entferne den Websocket aus der Map
			members.remove(quit.user);
			// ................................ Was passiert danach?

		} else {
			unhandled(message);
		}
	}

	// ##########################################################################

	@Override
	public List<Action> handleClientAction(Action action) {

		// switch(action.TYPE){
		//
		// case Action.TYPE_STARTGAME:
		// startGame();
		// break;
		//
		// case Action.TYPE_FINISHGAME:
		// finishGame();
		// break;
		//
		// }

		return null;
	}

	private static void initializeGame(ActionRequest actionRequest) {

		final Game game = findGame((Long) actionRequest.data[0]);

		// create initial response action
		ActionResponse response = new ActionResponse();
		response.initializer = Action.TYPE_INITIALIZE_GAME;
		response.data = new Object[] { game.playground, game.counters.get(0) };
		response.followers = new ArrayList<Action>() {
			private static final long serialVersionUID = 1L;
			{
				add(Ebean.find(Action.class, 1));
				add(Ebean.find(Action.class, 2));
			}
		};

		try {
			// map it to Json
			ObjectMapper mapper = new ObjectMapper();
			String sResult = mapper.writeValueAsString(actionRequest);
			JsonFactory factory = new JsonFactory();
			JsonParser jp = factory.createJsonParser(sResult);
			JsonNode actualObj = mapper.readTree(jp);

			// send it via web socket
			((WebSocket.Out<JsonNode>) actionRequest.data[1]).write(actualObj);

		} catch (JsonGenerationException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void reinitializeGame() {

	}

	private void startGame() {

	}

	private void finishGame() {

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
