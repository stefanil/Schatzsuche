/**
 * 
 */
package de.saxsys.treasurehunting.game.models.game;

import javax.persistence.Id;

import play.data.validation.Constraints.Required;
import play.db.ebean.Model;

/**
 * @author stefan.illgen
 *
 */
public class Counter extends Model {	
	
	@Id
	long id;
	
	@Required
	public String name; 
	
	@Required
	public Integer color;
	
}
