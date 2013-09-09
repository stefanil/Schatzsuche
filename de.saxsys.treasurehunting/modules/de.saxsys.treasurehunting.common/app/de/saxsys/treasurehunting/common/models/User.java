/**
 * 
 */
package de.saxsys.treasurehunting.common.models;

import javax.persistence.Entity;
import javax.persistence.Id;

import play.data.format.Formats;
import play.data.validation.Constraints;
import play.db.ebean.Model;

/**
 * @author stefan.illgen
 *
 */
@Entity
//@Table(name = "user")
public class User extends Model {

	private static final long serialVersionUID = 7161475759049877636L;
	
	/**
	 * 
	 */
	@Id
    @Constraints.Required
    @Formats.NonEmpty
	public String name;
	
}
