package br.usp.poli.pcs.capstoneProject.handlers.getHandlers;

import java.util.Map;
import java.util.HashMap;

import spark.Request;
import spark.Response;

import br.usp.poli.pcs.capstoneProject.database.services.GetUserByIdService;;

public class AllowLogoutHandler extends DefaultGetHandler {
	public AllowLogoutHandler(Request request, Response response) {
		super(request, response);
		filePath = "allowLogout.ftl";
	}
	
	public Map<String, Object> process() {
		Map<String, Object> objects = new HashMap<String, Object>();
		objects.put("user", (new GetUserByIdService()).call(request.session().attribute("user-id")));
		return objects;
	}
}
