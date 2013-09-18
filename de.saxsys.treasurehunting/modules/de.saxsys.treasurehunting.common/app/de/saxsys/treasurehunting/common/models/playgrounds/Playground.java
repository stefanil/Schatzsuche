package de.saxsys.treasurehunting.common.models.playgrounds;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import play.db.ebean.Model;

import com.avaje.ebean.Ebean;

/**
 * TODO.
 * 
 * Playground stellt das gesamte Spielfeld dar. Auf dem Spielfeld befinden sich die Pfade auf denen sich der Spieler bewegt.
 * 
 * @author justus.markert
 *
 */
@Entity
public class Playground extends Model {

	private static final long serialVersionUID = -4414282978639082476L;

	/**
	 * TODO.
	 * 
	 * Name des Spielfelds
	 */
	@Id
	public String name;
	
	/**
	 * TODO.
	 * 
	 * Die zum Spielfeld gehörenden Pfade
	 */
    @ManyToMany(cascade=CascadeType.ALL)
	public List<Path> paths = new ArrayList<Path>();

	/**
	 * TODO.
	 * 
	 * Standard C'tor
	 */
	public Playground(String name) {

		this.name = name;
	}
	
	/**
	 * TODO.
	 * 
	 * Füge dem Spielfeld einen Path hinzu
	 * 
	 * @param path
	 */
	public void addPath(Path path) {

		this.paths.add(path);
	}
	
	/**
	 * TODO.
	 * 
	 * Füge dem Spielfeld einen Path hinzu
	 * 
	 * @param path
	 */
	public void deletePath(Path path) {

		this.paths.remove(path);
	}

	/**
	 * TODO.
	 * 
	 * Finde Spielfeld anhand des Namens
	 * 
	 * @param name
	 * @return
	 */
	public static Playground findByName(String name) {

		return Ebean.find(Playground.class).fetch("paths").fetch("paths.fromPoint").fetch("paths.toPoint").where().eq("name", name).findUnique();
	}

	/**
	 * TODO.
	 * 
	 * Finde alle Spielfelder
	 * 
	 * @param name
	 * @return
	 */
	public static List<Playground> findByAllLazy() {

		return Ebean.find(Playground.class).findList();
	}	

	/**
	 * TODO.
	 * 
	 * @param path
	 */
	public void createPath(Path path) {
		path.save();
	}

}
