package br.usp.poli.pcs.capstoneProject.server;

import static spark.Spark.*;
import spark.template.freemarker.FreeMarkerEngine;

import spark.ModelAndView;

import java.util.Map;
import java.util.HashMap;

import br.usp.poli.pcs.capstoneProject.database.CapstoneConnection;
import freemarker.cache.ClassTemplateLoader;
import freemarker.template.Configuration;

public class Server {
	public static void main(String[] args) {
		FreeMarkerEngine freeMarkerEngine = new FreeMarkerEngine();
		Configuration freeMarkerConfiguration = new Configuration();
		freeMarkerConfiguration.setTemplateLoader(new ClassTemplateLoader(Server.class, "/"));
		freeMarkerEngine.setConfiguration(freeMarkerConfiguration);
		get("/hello", (request, response) -> {
			return "it works";
		});
		
		get("/page", (request, response) -> {
			Map<String, Object> attributes = new HashMap<String, Object>();
			attributes.put("title", "First page! Hello dude");
			return freeMarkerEngine.render(new ModelAndView(attributes, "page.ftl"));			
		});
	}
}
