package br.usp.poli.pcs.capstoneProject.handlers.getHandlers;

import spark.Request;
import spark.Response;
import java.util.Map;
import java.util.HashMap;
import br.usp.poli.pcs.capstoneProject.database.services.GetUserAccountsService;

public class ListUserAccountsHandler extends DefaultGetHandler {
	public ListUserAccountsHandler(Request request, Response response) {
		super(request, response);
		filePath = "listUserAccounts.ftl";
	}
	
	public Map<String, Object> process() {
		Map<String, Object> objects = new HashMap<String, Object>();
		objects.put("accounts", (new GetUserAccountsService()).call(request.session().attribute("user-id")));
		return objects;
	}
}
