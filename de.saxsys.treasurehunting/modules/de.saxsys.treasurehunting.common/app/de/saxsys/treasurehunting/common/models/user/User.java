/**
 * 
 */
package de.saxsys.treasurehunting.common.models.user;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import play.data.format.Formats;
import play.data.validation.Constraints;
import play.db.ebean.Model;

/**
 * This entity encapsulates the user of the application.
 * Table name = "users", because "user" is a reserved keyword in PostgreSQL.
 * 
 * @author stefan.illgen
 */
@Entity
@Table(name = "users")
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
