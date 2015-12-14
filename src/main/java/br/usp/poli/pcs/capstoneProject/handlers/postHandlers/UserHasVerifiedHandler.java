package br.usp.poli.pcs.capstoneProject.handlers.postHandlers;

import br.usp.poli.pcs.capstoneProject.models.User;
import br.usp.poli.pcs.capstoneProject.database.services.GetUserByIdService;

import spark.Request;
import spark.Response;


public class UserHasVerifiedHandler extends DefaultPostHandler {
	public UserHasVerifiedHandler(Request request, Response response) {
		super(request, response);
	}
	
	public String process() {
		int userId = request.session().attribute("user-id");
		User user = (new GetUserByIdService()).call(userId);
		return "{\"status\": 0, \"hasVerified\": "+user.isVerified()+"}";
		
	}
	
}
