package br.usp.poli.pcs.capstoneProject.handlers.getHandlers;

import spark.Request;
import spark.Response;
import java.util.Map;



public class AskAccountsHandler extends DefaultGetHandler {
	
	public AskAccountsHandler(Request request, Response response) {
		super(request, response);
		filePath = "askAccounts.ftl";
	}
	
	public Map<String, Object> process() {
		return null;
	}
	
}
