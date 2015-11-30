package br.usp.poli.pcs.capstoneProject.handlers.postHandlers;

import spark.Request;
import spark.Response;

import br.usp.poli.pcs.capstoneProject.database.services.RemoveUserAccountService;

public class RemoveUserAccountHandler extends DefaultPostHandler {
	
	public RemoveUserAccountHandler(Request request, Response response) {
		super(request, response);
	}
	
	public String process() {
		if (request.queryParams("account-id") != null) {
			int accountId = Integer.valueOf(String.valueOf(request.queryParams("account-id")));
			if ((new RemoveUserAccountService()).call(request.session().attribute("user-id"), accountId)) {
				return "{\"status\": 0, \"message\": \"Account successfully removed from your profile\"}";
			} else {
				return "{\"status\": 1, \"message\": \"You provided invalid information or account was removed from your profile previously\"}";
			}
		} else {
			return "{\"status\": 2, \"message\": \"Missing information to remove account from your profile\"}";
		}
	}
	
}
