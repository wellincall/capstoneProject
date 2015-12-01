package br.usp.poli.pcs.capstoneProject.handlers.postHandlers;

import spark.Request;
import spark.Response;

import br.usp.poli.pcs.capstoneProject.database.services.VoidTransferIntentionService;

public class VoidTransferHandler extends DefaultPostHandler {
	
	public VoidTransferHandler(Request request, Response response) {
		super(request, response);
	}
	
	public String process() {
		int userId = request.session().attribute("user-id");
		int transferId = Integer.valueOf(String.valueOf(request.queryParams("transfer-id")));
		if ((new VoidTransferIntentionService()).call(transferId, userId)) {
			return "{\"status\": 0, \"message\": \"Transfer intention successfully voided.\"}";
		} else {
			return "{\"status\": 2, \"message\": \"It was not possible to void the requested transfer. You can't perform this action right now.\"}";
		}		
	}
	
}
