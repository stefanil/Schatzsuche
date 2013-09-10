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
 * This entity encapsulates the user of the application.
 * 
 * @author stefan.illgen
 */
@Entity
public class User extends Model {

	private static final long serialVersionUID = 7161475759049877636L;
	
	/**
	 * The user name also defines its id.
	 */
	@Id
    @Constraints.Required
    @Formats.NonEmpty
	public String name;
	
}
