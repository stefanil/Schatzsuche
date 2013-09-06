/**
 * 
 */
package de.saxsys.treasurehunting.common.models;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import play.data.format.Formats;
import play.data.validation.Constraints;

/**
 * @author stefan.illgen
 *
 */
@Entity
@Table(name = "users")
public class User {

	@Id
    @Constraints.Required
    @Formats.NonEmpty
	public String name;
	
}
