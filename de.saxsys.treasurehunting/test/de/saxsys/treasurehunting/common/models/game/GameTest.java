/**
 * 
 */
package de.saxsys.treasurehunting.common.models.game;

import static org.fest.assertions.Assertions.assertThat;

import org.junit.Test;

import de.saxsys.treasurehunting.common.models.BaseModelTest;
import de.saxsys.treasurehunting.common.models.playgrounds.Playground;
import de.saxsys.treasurehunting.common.services.UserService;
import de.saxsys.treasurehunting.game.services.PlaygroundService;
import de.saxsys.treasurehunting.game.services.singleplayer.SinglePlayerGameHall;

/**
 * Test for testing basic CRUD operations.
 * 
 * @author stefan.illgen
 * 
 */
public class GameTest extends BaseModelTest {

	/**
	 * Tests creation.
	 */
	@Test
	public void testCreate() {
		Playground playground = PlaygroundService
				.findPlayground("Big Playground");

		// create counter
		Counter counter = new Counter();
		counter.color = 0xff0000;
		counter.cards = 0;
		counter.user = UserService.findUser("stefan");
		counter.position = playground.startPoint;

		// create game
		Game game = new Game();
		game.name = "Spiel 1";
		game.state = Game.STATE_READY;
		game.hMode = Game.H_MODE_SINGLEPLAYER;
		game.activeCounter = 0;
		game.counters.add(counter);
		game.playground = playground;

		game.save();

		assertThat(SinglePlayerGameHall.findGameName(game.id)).isEqualTo(
				"Spiel 1");
		assertThat(SinglePlayerGameHall.findCounterColor(counter.id)).isEqualTo(
				0xff0000);
	}

	/**
	 * Tests read.
	 */
	@Test
	public void testRead() {

	}

	/**
	 * Tests update.
	 */
	@Test
	public void testUpdate() {

	}

	/**
	 * Tests deletion.
	 */
	@Test
	public void testDelete() {
		// will not work, because counter must be deleted also (or use
		// CascadeType.ALL)
		// List<Game> allGames = Ebean.find(Game.class).findList();
		// for(Game game1 : allGames){
		// if(game1.name.compareTo("Spiel 1")==0){
		// game1.delete();
		// break;
		// }
		// }
	}

}
