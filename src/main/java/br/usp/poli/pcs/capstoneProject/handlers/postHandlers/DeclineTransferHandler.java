package br.usp.poli.pcs.capstoneProject.handlers.postHandlers;

import spark.Request;
import spark.Response;
import br.usp.poli.pcs.capstoneProject.database.services.DeclineTransferService;


public class DeclineTransferHandler extends DefaultPostHandler {
	
	public DeclineTransferHandler(Request request, Response response) {
		super(request, response);
	}
	
	public String process() {
		int userId = request.session().attribute("user-id");
		int transferId = Integer.valueOf(String.valueOf(request.queryParams("transfer-id")));
		if ((new DeclineTransferService()).call(transferId, userId)) {
			return "{\"status\": 0, \"message\": \"Transfer intention successfully declined.\"}";
		} else {
			return "{\"status\": 2, \"message\": \"It was not possible to declinethe requested transfer. You can't perform this action right now.\"}";
		}
	}
	
}
