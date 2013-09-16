package de.saxsys.treasurehunting.game.controllers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import play.data.Form;
import play.data.validation.Constraints.Required;
import play.data.validation.ValidationError;
import play.i18n.Messages;
import play.mvc.Controller;
import play.mvc.Result;
import play.mvc.Security;
import de.saxsys.treasurehunting.common.controllers.Secured;
import de.saxsys.treasurehunting.common.services.UserService;
import de.saxsys.treasurehunting.game.views.html.index;

/**
 * This {@link Controller} implements the game actions.
 * 
 * @author stefan.illgen
 */
public class GameController extends Controller {
	
	public static class PlaygroundService {
		
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
	
	
	public static class SingleplayerGameConfiguration {

		/**
		 * The name of the game.
		 */
		public String gameName;

		/**
		 * The counters color as hexadezimal RGB int value.
		 */
		@Required
		public Integer counterColor = COUNTER_COLOR_GREEN;

		public static Integer COUNTER_COLOR_RED = Integer
				.valueOf(0xff0000);
		public static Integer COUNTER_COLOR_GREEN = Integer
				.valueOf(0xff00);
		public static Integer COUNTER_COLOR_BLUE = Integer.valueOf(0xff);
		
		public static Map<Integer, String> getCounterColors() {
			return new HashMap<Integer, String>() {
				private static final long serialVersionUID = -4984259332509141788L;
				{
					put(COUNTER_COLOR_RED, Messages.get(
							UserService.getSessionLanguage(session(), request()),
							"game.index.sp.conf.counterColor.red"));
					put(COUNTER_COLOR_GREEN, Messages.get(
							UserService.getSessionLanguage(session(), request()),
							"game.index.sp.conf.counterColor.green"));
					put(COUNTER_COLOR_BLUE, Messages.get(
							UserService.getSessionLanguage(session(), request()),
							"game.index.sp.conf.counterColor.blue"));
				}
			};
		}
		
		/**
		 * The name of the playground to be used for the single player game.
		 */
		@Required
		public String playgroundName = PlaygroundService.getAllPlaygroundNames().get(0);
		

		/**
		 * The validation method checks the following conditions.
		 * 
		 * <ul>
		 * <li>the trimmed name is greater than zero.</li>
		 * </ul>
		 * 
		 * @return The {@link Map} containing the keyed {@link ValidationError}
		 *         s.
		 */
		public Map<String, List<ValidationError>> validate() {

			Map<String, List<ValidationError>> result = new HashMap<String, List<ValidationError>>();

			// trimmed length must be greater 0
			if (gameName.trim().length() == 0) {
				List<ValidationError> errors = new ArrayList<ValidationError>();
				errors.add(new ValidationError("gameName", play.i18n.Messages
						.get(UserService.getSessionLanguage(session(),
								request()), "game.index.sp.conf.gameName.error")));
				result.put("gameName", errors);
			}

			return result;
		}
	}

	/**
	 * .
	 * 
	 * @return The {@link Result}.
	 */
	@Security.Authenticated(Secured.class)
	public static Result index() {
		return ok(index.render(Form.form(SingleplayerGameConfiguration.class)));
	}

	/**
	 * 
	 * @return
	 */
	@Security.Authenticated(Secured.class)
	public static Result configureSingleplayer() {

		Form<SingleplayerGameConfiguration> spConfForm = Form.form(
				SingleplayerGameConfiguration.class).bindFromRequest();

		if (spConfForm.hasErrors())
			return badRequest(index.render(spConfForm));

		// TODO stefan create single player game

		return redirect(de.saxsys.treasurehunting.game.controllers.routes.GameController
				.singleplayer());
	}

	/**
	 * .
	 * 
	 * @return The {@link Result}.
	 */
	@Security.Authenticated(Secured.class)
	public static Result singleplayer() {
		return TODO;
	}

	/**
	 * .
	 * 
	 * @return The {@link Result}.
	 */
	@Security.Authenticated(Secured.class)
	public static Result startSPGame() {
		return TODO;
	}

	/**
	 * .
	 * 
	 * @return The {@link Result}.
	 */
	@Security.Authenticated(Secured.class)
	public static Result visitorarena() {
		return TODO;
	}

	/**
	 * .
	 * 
	 * @return The {@link Result}.
	 */
	@Security.Authenticated(Secured.class)
	public static Result startVAGame() {
		return TODO;
	}
}
