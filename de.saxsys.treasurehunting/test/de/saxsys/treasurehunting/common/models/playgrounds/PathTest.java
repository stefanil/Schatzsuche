/**
 * 
 */
package de.saxsys.treasurehunting.common.models.playgrounds;

import org.junit.Test;

import com.avaje.ebean.Ebean;

import de.saxsys.treasurehunting.common.models.BaseModelTest;

/**
 * Test for testing basic CRUD operations.
 * 
 * @author stefan.illgen
 */
public class PathTest extends BaseModelTest {

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
