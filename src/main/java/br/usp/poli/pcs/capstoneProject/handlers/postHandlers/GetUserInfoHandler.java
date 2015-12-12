package br.usp.poli.pcs.capstoneProject.handlers.postHandlers;

import spark.Request;
import spark.Response;

import br.usp.poli.pcs.capstoneProject.models.User;
import br.usp.poli.pcs.capstoneProject.database.services.GetUserByIdService;
import br.usp.poli.pcs.capstoneProject.jsonHelpers.UserToJson;

public class GetUserInfoHandler extends DefaultPostHandler { 
	public GetUserInfoHandler(Request request, Response response) {
		super(request, response);
	}

	public String process() {
		int userId = request.session().attribute("user-id");
		User user = (new GetUserByIdService()).call(userId);
		return (new UserToJson()).call(user);
	}
}
