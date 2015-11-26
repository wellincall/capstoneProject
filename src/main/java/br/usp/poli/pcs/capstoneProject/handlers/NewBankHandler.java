package br.usp.poli.pcs.capstoneProject.handlers;

import java.util.Map;
import spark.Request;
import spark.Response;

public class NewBankHandler extends DefaultGetHandler {
	public NewBankHandler(Request request, Response response) {
		super(request, response);
		filePath = "newBank.ftl";
	}

	protected Map<String, Object> process() {
		
		return null;
	}

}
