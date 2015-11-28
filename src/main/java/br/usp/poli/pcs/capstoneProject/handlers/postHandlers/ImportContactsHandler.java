package br.usp.poli.pcs.capstoneProject.handlers.postHandlers;

import spark.Request;
import spark.Response;

import br.usp.poli.pcs.capstoneProject.forms.Form;
import br.usp.poli.pcs.capstoneProject.forms.ImportContactsForm;

public class ImportContactsHandler extends DefaultPostHandler {
	public ImportContactsHandler(Request request, Response response) {
		super(request, response);
	}
	
	public String process() {
		Form contactsForm = new ImportContactsForm();
		if (contactsForm.isValid(request)) {
			return "{status: \"will be fixed\"}"; 
		} else {
			return "{status: 2, message: \"Some of the provided numbers are not valid. Please, double check and submit them again\"}"; 
		}
	}
}
