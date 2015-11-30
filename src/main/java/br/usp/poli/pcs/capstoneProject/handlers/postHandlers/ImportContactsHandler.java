package br.usp.poli.pcs.capstoneProject.handlers.postHandlers;

import spark.Request;
import spark.Response;
import java.util.List;
import br.usp.poli.pcs.capstoneProject.models.User;

import br.usp.poli.pcs.capstoneProject.forms.Form;
import br.usp.poli.pcs.capstoneProject.forms.ImportContactsForm;
import br.usp.poli.pcs.capstoneProject.database.services.ImportContactsService;
import br.usp.poli.pcs.capstoneProject.jsonHelpers.ContactsListToJson;

public class ImportContactsHandler extends DefaultPostHandler {
	public ImportContactsHandler(Request request, Response response) {
		super(request, response);
	}
	
	public String process() {
		Form contactsForm = new ImportContactsForm();
		if (contactsForm.isValid(request)) {
			List<User> users = (new ImportContactsService()).call(request.queryParamsValues("phone-number[]"));
			return "{\"status\": 0, \"message\": \"Registered users are given in contacts field\", \"contacts\": "+(new ContactsListToJson()).call(users)+"}"; 
		} else {
			return "{\"status\": 2, \"message\": \"Some of the provided numbers are not valid. Please, double check and submit them again\"}"; 
		}
	}
}
