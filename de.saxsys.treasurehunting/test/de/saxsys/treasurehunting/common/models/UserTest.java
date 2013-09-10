package de.saxsys.treasurehunting.common.models;

import org.junit.*;

import org.junit.Test;

import com.avaje.ebean.Ebean;

import de.saxsys.treasurehunting.common.models.User;
import de.saxsys.treasurehunting.models.BaseModelTest;

/**
 * This class tests the model class {@link User}.
 * 
 * @author stefan.illgen
 * 
 */
public class UserTest extends BaseModelTest {

	/**
	 * This operation tests the creation result for a {@link User} class given
	 * by conf/test-data.yml and initialized in {@link Global}.
	 */
	@Test
	public void testCreation() {
		User user = Ebean.find(User.class, "stefan");
		Assert.assertNotNull(user);
		Assert.assertEquals(user.name, "stefan");
	}

}
