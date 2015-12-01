package br.usp.poli.pcs.capstoneProject.handlers.getHandlers;

import spark.Request;
import spark.Response;
import java.util.Map;
public class HomePageHandler extends DefaultGetHandler {
	
	public HomePageHandler(Request request, Response response) {
		super(request, response);
		filePath = "home.ftl";
	}
	
	public Map<String, Object> process() {
		return null;
	}
	
	
}
