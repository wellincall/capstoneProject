package br.usp.poli.pcs.capstoneProject.handlers.getHandlers;

import spark.Request;
import spark.Response;
import java.util.Map;
import java.util.HashMap;

import br.usp.poli.pcs.capstoneProject.database.services.GetTransferIntentionsForRecipientService;
import br.usp.poli.pcs.capstoneProject.database.services.GetTransferIntentionsForSenderService;


public class MenuTransferIntentionsDisplayHandler extends DefaultGetHandler {

	public MenuTransferIntentionsDisplayHandler(Request request, Response response) {
		super(request, response);
		filePath = "menuTransferIntentions.ftl";
	}
	
	public Map<String, Object> process() {
		int userId = request.session().attribute("user-id");
		Map<String, Object> transferIntentions = new HashMap<String, Object>();
		transferIntentions.put("recieved", (new GetTransferIntentionsForRecipientService()).call(userId));
		transferIntentions.put("sent", (new GetTransferIntentionsForSenderService()).call(userId));
		return transferIntentions;
	}
	
	
	
}
