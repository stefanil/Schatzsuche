/**
 * 
 */
package de.saxsys.treasurehunting.common.services;

import java.util.List;

import play.Logger;
import play.api.i18n.Lang;
import play.db.ebean.Model;
import play.mvc.Http.Request;
import play.mvc.Http.Session;

import com.avaje.ebean.ExpressionList;

import de.saxsys.treasurehunting.common.models.User;

/**
 * This service class provides an implementation for: 
 * 
 * <ul>
 * 	<li>managing the {@link User} model</li>
 * 	<li>managing authentication</li>
 * </ul>
 * 
 * 
 * @author stefan.illgen
 */
public class UserService {

	private static Model.Finder<String, User> find = new Model.Finder<String, User>(
			String.class, User.class);

	/**
	 * Creates an anonymous user if the user with the given user name does not
	 * yet exist.
	 * 
	 * @return
	 */
	public static User createAnonymousUser(String username) {

		User user = new User();
		user.name = username;
		user.save();
		
		Logger.info("User "+user.name+" was added to the authenticated users.");

		return user;
	}

	/**
	 * Returns the language configured with the given {@link Session}. If there
	 * is no language configured, the first language matching an application
	 * supported and browser accepted language is returned. If there is no match
	 * found, the first application supported language is returned.
	 * 
	 * @param request
	 * @return
	 */
	public static Lang getSessionLanguage(Session session, Request request) {

		// session language
		String sLang = session.get("lang");
		if (sLang != null)
			return play.i18n.Lang.forCode(sLang).underlyingLang;

		// matching application supported and browser accepted language
		if (sLang == null) {
			String sSupportedLangs = play.Play.application().configuration()
					.getString("application.langs");
			List<play.i18n.Lang> acceptedLangs = request.acceptLanguages();
			for (play.i18n.Lang acceptedLang : acceptedLangs) {
				for (String sSupportedLang : sSupportedLangs.split(",")) {
					if (acceptedLang.code().compareTo(sSupportedLang) == 0)
						return acceptedLang.underlyingLang;
				}
			}
		}

		// no matching between supported and accepted languages found: return
		// firstly configured language
		return Lang.defaultLang();
	}

	/**
	 * Sets the session specific language.
	 * 
	 * @param lang
	 */
	public static void setSessionLang(Session session, String id) {
		session.put("lang", id);
	}

	/**
	 * Authenticates and returns an instance of {@link User} for the case the
	 * user is already registered.
	 * 
	 * If the user isn't registered yet this operation will dynamically create
	 * an anonymous user identified by parameter username.
	 * 
	 * @param username
	 * @return
	 */
	public static User authenticate(Session session, String username) {

		User authUser = findUser(username);

		// if the user is not regisitered
		if (authUser == null)
			// dynamically create an anonymous user
			authUser = UserService.createAnonymousUser(username);

		// register user id with session
		session.put("username", authUser.name);

		return authUser;
	}

	/**
	 * This Operation returns the currently authenticated {@link User}.
	 * 
	 * @param session
	 * @return
	 */
	public static User getAuthUser(Session session) {
		return findUser(session.get("username"));
	}

	/**
	 * Finds the user identified by its user id.
	 * 
	 * @param username
	 * @return
	 */
	public static User findUser(String username) {
		if (username != null && find.where() != null) {
			ExpressionList<User> ul = find.where().eq("name", username);
			return ul.findUnique();
		} else
			return null;
	}
}
