/**
 * 
 */
package de.saxsys.treasurehunting.common.models.actions;

import javax.persistence.Entity;
import javax.persistence.Id;

import play.data.validation.Constraints.Required;
import play.db.ebean.Model;

/**
 * An {@link Action} represent an action, which is identified by a
 * {@link #heading}, an {@link #info} and a {@link #button} text.
 * 
 * @author stefan.illgen
 */
@Entity
public class Action extends Model {

	private static final long serialVersionUID = 7792547412100770281L;
	
	/**
	 * Type of {@link Action} identifying the initialization of a game.
	 */
	public static final int TYPE_INITIALIZE_GAME = 0;
	
	/**
	 * Type of {@link Action} identifying the start of a game.
	 */
	public static final int TYPE_START_GAME = 1;
	
	/**
	 * Type of {@link Action} identifying the finish of a game.
	 */
	public static final int TYPE_FINSIH_GAME = 2;

	/**
	 * Internal ID.
	 */
	@Id
	public long id;

	/**
	 * The heading of the {@link Action}.
	 */
	@Required
	public String heading;

	/**
	 * The info text of the {@link Action}.
	 */
	@Required
	public String info;

	/**
	 * The label of the button to confirm the {@link Action}.
	 */
	@Required
	public String button;
}
