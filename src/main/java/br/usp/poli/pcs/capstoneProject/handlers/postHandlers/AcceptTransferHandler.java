package br.usp.poli.pcs.capstoneProject.handlers.postHandlers;

import spark.Request;
import spark.Response;
import br.usp.poli.pcs.capstoneProject.forms.Form;
import br.usp.poli.pcs.capstoneProject.forms.AcceptTransferForm;

public class AcceptTransferHandler extends DefaultPostHandler {
		
	public AcceptTransferHandler(Request request, Response response) {
		super(request, response);
	}
	
	public String process() {
		int userId = request.session().attribute("user-id");
		Form form = new AcceptTransferForm(userId);
		if (form.isValid(request)) {
			return "{has to be developed}";
		} else {
			return "{\"status\": 2, \"message\": \"It was not possible to accept the request transfer. You can't perform this action right now.\"}";
		}
	}

}
