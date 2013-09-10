import java.util.LinkedHashMap;
import java.util.List;

import com.avaje.ebean.Ebean;

import play.Application;
import play.GlobalSettings;
import play.Logger;
import play.libs.Yaml;

/**
 * This class configures the following global settings for this project:
 * 
 * <ul>
 * <li>loading initial or test data depending on the application mode test or
 * non-test (dev, prod)</li>
 * </ul>
 * 
 * @author stefan.illgen
 * 
 */
public class Global extends GlobalSettings {

	@Override
	@SuppressWarnings("unchecked")
	public void onStart(Application app) {

		/*
		 * If the application is not in test mode (run (prod) or debug (dev))
		 * load model by conf/initial-data.yml.
		 */
		if (!app.isTest()) {
			Logger.info("Loading YAML test data from conf/initial-data.yml.");
			LinkedHashMap<String, List<Object>> map = (LinkedHashMap<String, List<Object>>) Yaml
					.load("initial-data.yml");
			Ebean.save(map.get("user"));
		}

		/*
		 * If the application is in test mode load model by conf/test-data.yml.
		 */
		if (app.isTest()) {
			Logger.info("Loading YAML test data from conf/test-data.yml.");
			LinkedHashMap<String, List<Object>> map = (LinkedHashMap<String, List<Object>>) Yaml
					.load("test-data.yml");
			Ebean.save(map.get("user"));
		}
	}

}
