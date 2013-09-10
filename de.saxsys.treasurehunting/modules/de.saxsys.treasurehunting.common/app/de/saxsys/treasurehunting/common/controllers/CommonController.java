package de.saxsys.treasurehunting.common.controllers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import play.Logger;
import play.data.Form;
import play.data.validation.ValidationError;
import play.mvc.Controller;
import play.mvc.Result;
import de.saxsys.treasurehunting.common.models.User;
import de.saxsys.treasurehunting.common.services.UserService;
import de.saxsys.treasurehunting.common.views.html.index;

/**
 * 
 * @author stefan.illgen
 * 
 */
public class CommonController extends Controller {

	/**
	 * extra Login.class because that way the heavy User object will not waste
	 * memory
	 * 
	 * 
	 * @author stefan.illgen
	 * 
	 */
	public static class Login {

		public String username;

		public Map<String, List<ValidationError>> validate() {

			Map<String, List<ValidationError>> result = new HashMap<String, List<ValidationError>>();

			if (username.trim().length() < 5) {
				List<ValidationError> errors = new ArrayList<ValidationError>();
				errors.add(new ValidationError("username",
						play.i18n.Messages.get(UserService.getSessionLanguage(
								session(), request()),
								"common.index.login.username.error")));
				result.put("username", errors);
			}

			return result;
		}
	}

	/**
	 * 
	 * @return
	 */
	public static Result index() {
		return ok(index.render(
				UserService.getSessionLanguage(session(), request()),
				Form.form(Login.class)));
	}

	/**
	 * 
	 * @return
	 */
	public static Result authenticate() {

		Form<Login> loginForm = Form.form(Login.class).bindFromRequest();

		if (loginForm.hasErrors())
			return badRequest(index.render(
					UserService.getSessionLanguage(session(), request()),
					loginForm));

		String username = loginForm.data().get("username");

		User authUser = UserService.authenticate(session(), username);
		if (authUser == null) {
			Logger.error("User " + username
					+ " was not found and could not be created!");
			return internalServerError("User " + username
					+ " was not found and could not be created!");
		}

		return redirect("/game");
	}

	/**
	 * 
	 * @param lang
	 */
	public static Result setLang(String id, String from) {
		UserService.setSessionLang(session(), id);
		return redirect(from);
	}
}
