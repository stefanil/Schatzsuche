/**
 * 
 */
package de.saxsys.treasurehunting.common.models.playgrounds;

import org.junit.Test;

import com.avaje.ebean.Ebean;

import de.saxsys.treasurehunting.common.models.BaseYamlTest;
import de.saxsys.treasurehunting.common.models.playgrounds.Point;

/**
 * Test for testing basic CRUD operations.
 * 
 * @author stefan.illgen
 *
 */
public class PointTest extends BaseYamlTest {

	/**
	 * Tests creation.
	 */
	@Test
	public void testCreate() {
		
	}
	
	/**
	 * Tests read.
	 */
	@Test
	public void testRead() {
		
	}

	/**
	 * Tests update.
	 */
	@Test
	public void testUpdate() {
		
	}
	
	/**
	 * Tests the deletion of a {@link Point}.
	 */
	@Test
	public void testDelete() {
		Point point1 = Ebean.find(Point.class, 1);
		// only necessary before deletion with CascadeStyle.PERSIST
//		point1.deleteManyToManyAssociations("actions");
		point1.delete();
	}

}
