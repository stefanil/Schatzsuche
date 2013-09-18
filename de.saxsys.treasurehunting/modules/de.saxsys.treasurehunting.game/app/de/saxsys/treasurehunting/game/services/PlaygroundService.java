/**
 * 
 */
package de.saxsys.treasurehunting.game.services;

import java.util.ArrayList;
import java.util.List;

/**
 * This class provides the logic for managing playgrounds, paths and points.
 * 
 * @author stefan.illgen
 *
 */
public abstract class PlaygroundService {

	/**
	 * Returns a list of all playground names.
	 * 
	 * @return Returns a list of all playground names.
	 */
	public static List<String> getAllPlaygroundNames() {
		return new ArrayList<String>(){
			private static final long serialVersionUID = -3717111435695650045L;
		{
			add("Playground 1");
			add("Playground 2");
			add("Playground 3");
		}};
	}
	
}
