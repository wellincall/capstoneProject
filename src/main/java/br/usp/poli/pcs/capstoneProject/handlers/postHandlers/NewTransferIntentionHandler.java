package br.usp.poli.pcs.capstoneProject.handlers.postHandlers;

import spark.Request;
import spark.Response;

import br.usp.poli.pcs.capstoneProject.forms.Form;
import br.usp.poli.pcs.capstoneProject.forms.NewTransferIntentionForm;
import br.usp.poli.pcs.capstoneProject.database.services.CreateTransferIntentionService;
import br.usp.poli.pcs.capstoneProject.dataHandler.IDataHandlerService;
import br.usp.poli.pcs.capstoneProject.dataHandler.NewTransferIntentionDataHandler;

import java.util.Map;


public class NewTransferIntentionHandler extends DefaultPostHandler {
	
	private IDataHandlerService dataHandler;
	
	public NewTransferIntentionHandler(Request request, Response response) {
		super(request, response);
		dataHandler = new NewTransferIntentionDataHandler();
	}
	
	public String process() {
		int userId = request.session().attribute("user-id");
		Form form = new NewTransferIntentionForm(userId);
		if (form.isValid(request)) {
			Map<String, Object> transferDetails = dataHandler.call(request);
			if ((new CreateTransferIntentionService()).call(transferDetails) != null) {
				return "{status: 0, message: \"Transfer intention successfully created. It will be sent to the bank as soon as recipient approves it\"}";
			} else {
				return "{status: 1, message: \"An error occurred while processing your request. Please, try again\"}";
			}
		} else {
			return "{status: 2, message: \"Missing information or invalid data provided.\"}";
		}
	}
}
