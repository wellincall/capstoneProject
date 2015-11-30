package br.usp.poli.pcs.capstoneProject.handlers.postHandlers;

import spark.Request;
import spark.Response;

import java.util.List;

import br.usp.poli.pcs.capstoneProject.models.TransferIntention;
import br.usp.poli.pcs.capstoneProject.database.services.GetTransferIntentionsForRecipientService;
import br.usp.poli.pcs.capstoneProject.database.services.GetTransferIntentionsForSenderService;



public class ListTransferIntentionsHandler extends DefaultPostHandler {
	
	public ListTransferIntentionsHandler(Request request, Response response) {
		super(request, response);
	}
	
	public String process() {
		int userId = request.session().attribute("user-id");
		List<TransferIntention> recievedTransfers = (new GetTransferIntentionsForRecipientService()).call(userId);
		List<TransferIntention> sentTransfers = (new GetTransferIntentionsForSenderService()).call(userId);
		return "{"
				+ "status: 0, message: \"Transfers that you sent are present in sent field. Trasnfer that you recived are in recieved field\""
			+ "}";
	}
	
}
