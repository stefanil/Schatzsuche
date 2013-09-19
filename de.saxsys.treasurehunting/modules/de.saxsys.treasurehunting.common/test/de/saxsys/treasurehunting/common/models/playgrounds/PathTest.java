/**
 * 
 */
package de.saxsys.treasurehunting.common.models.playgrounds;

import org.junit.Test;

import com.avaje.ebean.Ebean;

import de.saxsys.treasurehunting.common.models.BaseYamlTest;

/**
 * Test for testing basic insert / update / delete behavior for {@link Path}.
 * 
 * @author stefan.illgen
 */
public class PathTest extends BaseYamlTest {

	/**
	 * Tests the deletion of a {@link Path}.
	 */
	@Test
	public void testInsert() {
		Path path1 = Ebean.find(Path.class, 1);
		// TODO
	}

	/**
	 * Tests the update of a {@link Path}.
	 */
	@Test
	public void testUpdate() {
		Path path1 = Ebean.find(Path.class, 1);
		// TODO
	}

	/**
	 * Tests the deletion of a {@link Path}.
	 */
	@Test
	public void testDelete() {
		
//		Playground pgBig = Ebean.find(Playground.class, "Big Playground");
		Path path1 = Ebean.find(Path.class, 1);
//		pgBig.deleteManyToManyAssociations("paths");
		Playground pgBig = Ebean.find(Playground.class, "Big Playground");
		path1.delete();
	}

}
