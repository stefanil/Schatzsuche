/**
 * 
 */
package de.saxsys.treasurehunting.common.models.game;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import play.data.validation.Constraints.Required;
import play.db.ebean.Model;
import de.saxsys.treasurehunting.common.models.playgrounds.Playground;

/**
 * A {@link Game} represents exactly one game with an arbitrary horizontal game
 * mode. It encapsulated the state of the game and enables it to be persisted.
 * 
 * @author stefan.illgen
 */
@Entity
public class Game extends Model {

	private static final long serialVersionUID = 3767961911878891102L;
	
	/**
	 * Game state ready.
	 */
	public static int STATE_READY = 0;
	
	/**
	 * Game state active.
	 */
	public static int STATE_ACTIVE = 1;
	
	/**
	 * Game state dicing (sub state of active).
	 */
	public static int STATE_DICING = 10;
	
	/**
	 * Game state moving (sub state of active).
	 */
	public static int STATE_MOVING = 11;
	
	/**
	 * Game state moving (sub state of active).
	 */
	public static int STATE_PERFORMING = 12;
	
	/**
	 * Game state finished.
	 */
	public static int STATE_FINISHED = 2;
	
	/**
	 * Game state paused.
	 */
	public static int STATE_PAUSED = 3;
	
	/**
	 * Horizontal (stand alone) game mode for single player games.
	 */
	public static int H_MODE_SINGLEPLAYER = 0;

	/**
	 * Internal ID.
	 */
	@Id
	long id;

	/**
	 * The name of the {@link Game}.
	 */
	@Required
	public String name;

	/**
	 * The state of the {@link Game}.
	 */
	@Required
	public int state;

	/**
	 * The horizontal mode flag of the {@link Game}.
	 */
	@Required
	public int hMode;

	/**
	 * The flag indicating the active counter in the queue of counters.
	 */
	public int activeCounter;

	/**
	 * The queue of counters which is traversed in a round trip manner.
	 */
	@OneToMany(cascade=CascadeType.PERSIST)
	public List<Counter> counters;

	/**
	 * The {@link Playground} the {@link Game} is related to.
	 */
	@ManyToOne
	public Playground playground;
}
