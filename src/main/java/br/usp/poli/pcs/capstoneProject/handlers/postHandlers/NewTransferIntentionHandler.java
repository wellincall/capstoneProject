package br.usp.poli.pcs.capstoneProject.handlers.postHandlers;

import spark.Request;
import spark.Response;

import br.usp.poli.pcs.capstoneProject.forms.Form;
import br.usp.poli.pcs.capstoneProject.forms.NewTransferIntentionForm;


public class NewTransferIntentionHandler extends DefaultPostHandler {
	
	public NewTransferIntentionHandler(Request request, Response response) {
		super(request, response);
	}
	
	public String process() {
		int userId = request.session().attribute("user-id");
		Form form = new NewTransferIntentionForm(userId);
		if (form.isValid(request)) {
			return "DATA VALID";
		} else {
			return "{status: 2, message: \"Missing information or invalid data provided.\"}";
		}
	}
}
