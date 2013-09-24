/**
 * 
 */
package de.saxsys.treasurehunting.common.models.game;

import org.junit.Test;

import de.saxsys.treasurehunting.common.models.BaseModelTest;

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
		// will not work, because counter must be deleted also (or use CascadeType.ALL)
//		List<Game> allGames = Ebean.find(Game.class).findList();
//		for(Game game1 : allGames){
//			if(game1.name.compareTo("Spiel 1")==0){
//				game1.delete();
//				break;
//			}
//		}
	}
	
}
