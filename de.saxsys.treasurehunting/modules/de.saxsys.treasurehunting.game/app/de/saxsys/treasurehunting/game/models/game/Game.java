/**
 * 
 */
package de.saxsys.treasurehunting.game.models.game;

import javax.persistence.Entity;
import javax.persistence.Id;

import play.db.ebean.Model;

/**
 * @author stefan.illgen
 *
 */
@Entity
public class Game extends Model {

	@Id
	public Long id;
	
	public String name;

}
