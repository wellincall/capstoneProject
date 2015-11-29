package br.usp.poli.pcs.capstoneProject.handlers.postHandlers;

import spark.Request;
import spark.Response;

public class RemoveUserAccountHandler extends DefaultPostHandler {
	
	public RemoveUserAccountHandler(Request request, Response response) {
		super(request, response);
	}
	
	public String process() {
		if (request.queryParams("account-id") != null) {
			return "{detected}";
		} else {
			return "{status: 2, message: \"Missing information to remove account from your profile\"}";
		}
	}
	
}
