/**
 * 
 */
package de.saxsys.treasurehunting.game.services.singleplayer;

import java.util.List;

import de.saxsys.treasurehunting.common.models.actions.Action;
import de.saxsys.treasurehunting.common.models.game.Counter;
import de.saxsys.treasurehunting.common.models.game.Game;
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

			// create counter
			Counter counter = new Counter();
			counter.color = countercolor;
			counter.cards = 0;
			counter.user = UserService.findUser(username);

			// create game
			Game game = new Game();
			game.name = gamename;
			game.state = Game.STATE_READY;
			game.hMode = Game.H_MODE_SINGLEPLAYER;
			game.activeCounter = 0;
			game.counters.add(counter);
			game.playground = PlaygroundService.findPlayground(playgroundname);

			game.save();

			return game.id;

		} catch (Exception e) {
			throw new GameCreationException(e.getLocalizedMessage());
		}
	}

	// ##########################################################################

	// public static void join(final User user, play.mvc.WebSocket.In<JsonNode>
	// in,
	// play.mvc.WebSocket.Out<JsonNode> out) {
	//
	// // Send a Join message
	// String result = null;
	// // (String) Await.result(
	// // ask(gameActor, new Join(user, out), 1000),
	// // Duration.create(10, SECONDS));
	//
	// // Wenn der Zutritt genehmigt wurde, ...
	// if ("OK".equals(result)) {
	//
	// // Für jede empfangene Nachricht (Spielfelddaten) ...
	// in.onMessage(new Callback<JsonNode>() {
	// public void invoke(JsonNode event) throws Throwable {
	//
	// ObjectMapper mapper = new ObjectMapper();
	// Action action = mapper.readValue(event,
	// new TypeReference<Action>() {
	// });
	//
	// // Sende die Spielfelddaten an die Spielhalle.
	// gameActor.tell(action);
	// }
	// });
	//
	// // Wenn der Websocket geschlossen wird, ...
	// in.onClose(new Callback0() {
	// public void invoke() {
	//
	// // Sende eine Quit-Nachricht zum Entfernen des Nutzers aus
	// // der Map.
	// gameActor.tell(new Quit(user));
	//
	// }
	// });
	// }
	// }
	//
	// Map<User, WebSocket.Out<JsonNode>> members = new HashMap<User,
	// WebSocket.Out<JsonNode>>();
	// // Falsch weil es nicht einen statischen gameActor geben kann
	// static ActorRef gameActor = Akka.system().actorOf(
	// new Props(SinglePlayerGameService.class));
	//
	// @Override
	// public void onReceive(Object message) throws Exception {
	//
	// // Bei einem Beitrittsgesuch ...
	// if (message instanceof Join) {
	//
	// Join join = (Join) message;
	// if (members.containsKey(join.user)) {
	// // getSender().tell("This user is already used");
	// } else {
	// members.put(join.user, join.channel);
	// initializeGame();
	// }
	//
	// } else
	//
	// if (message instanceof Action) {
	// handleClientAction((Action)message);
	// } else
	//
	// // Beim Schließen des Websockets (z.B. infolge eines Routenwechsels) ..
	// if (message instanceof Quit) {
	// Quit quit = (Quit) message;
	// // .. entferne den Websocket aus der Map
	// members.remove(quit.user);
	// // ................................ Was passiert danach?
	// ......................
	// } else {
	// unhandled(message);
	// }
	// }

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

	private void initializeGame() {

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
