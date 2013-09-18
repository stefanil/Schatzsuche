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
public class Game extends Model {

	private static final long serialVersionUID = 3767961911878891102L;

	/**
	 * TODO.
	 */
	@Id
	long id;
	
	/**
	 * TODO.
	 */
	@Required
	public String name;
	
	/**
	 * TODO.
	 */
	@Required
	public int state;
	
	/**
	 * TODO.
	 */
	@Required
	public int hMode;
	
	/**
	 * TODO.
	 */
	public int activeCounter;
}
