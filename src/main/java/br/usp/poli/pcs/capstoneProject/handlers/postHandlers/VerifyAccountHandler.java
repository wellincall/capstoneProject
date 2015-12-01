package br.usp.poli.pcs.capstoneProject.handlers.postHandlers;

import br.usp.poli.pcs.capstoneProject.database.services.UserVerificationService;
import spark.Request;
import spark.Response;

public class VerifyAccountHandler extends DefaultPostHandler {
	
	public VerifyAccountHandler(Request request, Response response) {
		super(request, response);
	}

	public String process() {
		return "";
	}
}
