/**
 * 
 */
package de.saxsys.treasurehunting.common.models.playgrounds;

import org.junit.Test;

import com.avaje.ebean.Ebean;

import de.saxsys.treasurehunting.common.models.BaseYamlTest;
import de.saxsys.treasurehunting.common.models.playgrounds.Point;

/**
 * Test for testing basic insert / update / delete behavior.
 * 
 * @author stefan.illgen
 *
 */
public class PointTest extends BaseYamlTest {

	/**
	 * Tests the deletion of a {@link Point}.
	 */
	@Test
	public void testInsert() {
		Point point1 = Ebean.find(Point.class, 1);
		// TODO
	}
	
	/**
	 * Tests the update of a {@link Point}.
	 */
	@Test
	public void testUpdate() {
		Point point1 = Ebean.find(Point.class, 1);
		// TODO
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
