/**
 * 
 */
package de.saxsys.treasurehunting.common.models.actions;

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
public class Action extends Model {

	private static final long serialVersionUID = 7792547412100770281L;

	/**
	 * TODO.
	 */
	@Id
	long id;
	
	/**
	 * TODO.
	 */
	@Required
	public String heading;
	
	/**
	 * TODO.
	 */
	@Required
	public String info;
	
	/**
	 * TODO.
	 */
	@Required
	public String button;
}
