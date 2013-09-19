/**
 * 
 */
package de.saxsys.treasurehunting.common.models.user;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import play.data.format.Formats;
import play.data.validation.Constraints;
import play.db.ebean.Model;
import de.saxsys.treasurehunting.common.models.game.Counter;

/**
 * This entity encapsulates the user of the application. Table name = "users",
 * because "user" is a reserved keyword in PostgreSQL.
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

	/**
	 * A user may play an arbitrary amount of games at the same time and
	 * therefore can have as many {@link Counter}s as he wants.
	 */
	@OneToMany(cascade=CascadeType.ALL)
	public List<Counter> counters;

}
