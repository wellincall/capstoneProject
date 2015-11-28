package br.usp.poli.pcs.capstoneProject.handlers.getHandlers;

import spark.Request;
import spark.Response;
import java.util.Map;
import java.util.HashMap;

public class ImportContactsDisplayHandler extends DefaultGetHandler {
	
	public ImportContactsDisplayHandler(Request request, Response response) {
		super(request, response);
		filePath = "importContacts.ftl";
	}
	
	public Map<String, Object> process() {
		Map<String, Object> contactsForm = new HashMap<String, Object>();
		
		return contactsForm;
	}
	
}
