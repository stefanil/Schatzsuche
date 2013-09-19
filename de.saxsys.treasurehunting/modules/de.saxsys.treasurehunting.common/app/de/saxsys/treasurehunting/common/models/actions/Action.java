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
	 * Internal ID.
	 */
	@Id
	long id;

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
