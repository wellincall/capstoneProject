package br.usp.poli.pcs.capstoneProject.handlers.postHandlers;

import spark.Request;
import spark.Response;

import java.util.Map;

import br.usp.poli.pcs.capstoneProject.forms.Form;
import br.usp.poli.pcs.capstoneProject.forms.AcceptTransferForm;
import br.usp.poli.pcs.capstoneProject.dataHandler.IDataHandlerService;
import br.usp.poli.pcs.capstoneProject.dataHandler.AcceptTransferDataHandler;

public class AcceptTransferHandler extends DefaultPostHandler {
	
	private IDataHandlerService dataHandler;
	
	public AcceptTransferHandler(Request request, Response response) {
		super(request, response);
		dataHandler = new AcceptTransferDataHandler();
	}
	
	public String process() {
		int userId = request.session().attribute("user-id");
		Form form = new AcceptTransferForm(userId);
		if (form.isValid(request)) {
			Map<String, Object> transferData = dataHandler.call(request);
			return "{has to be developed}";
		} else {
			return "{\"status\": 2, \"message\": \"It was not possible to accept the request transfer. You can't perform this action right now.\"}";
		}
	}

}
