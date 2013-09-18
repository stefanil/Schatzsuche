/**
 * 
 */
package de.saxsys.treasurehunting.common.models.game;

import javax.persistence.Entity;
import javax.persistence.Id;

import play.data.validation.Constraints.Required;
import play.db.ebean.Model;

/**
 * TODO.
 * 
 * @author stefan.illgen
 *
 */
@Entity
public class Counter extends Model {

	private static final long serialVersionUID = 8369627631260566579L;

	/**
	 * TODO.
	 */
	@Id
	long id;
	
	/**
	 * TODO.
	 */
	@Required
	public int color;
	
	/**
	 * TODO.
	 */
	@Required
	public int cards;
}
