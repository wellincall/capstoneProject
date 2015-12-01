package br.usp.poli.pcs.capstoneProject.handlers.postHandlers;

import spark.Request;
import spark.Response;
import br.usp.poli.pcs.capstoneProject.database.services.UserVerificationService;
import br.usp.poli.pcs.capstoneProject.forms.Form;
import br.usp.poli.pcs.capstoneProject.forms.VerificationForm;

public class VerifyAccountHandler extends DefaultPostHandler {
	
	public VerifyAccountHandler(Request request, Response response) {
		super(request, response);
	}

	public String process() {
		Form form = new VerificationForm();
		if (form.isValid(request)) {
			int userId = request.session().attribute("user-id");
			String verificationCode = request.queryParams("verification-code");
			if ((new UserVerificationService()).call(userId, verificationCode)) {
				return "{\"status\": 0, \"message\": \"Account verified successfully.\"}";
			} else {
				return "{\"status\": 1, \"message\": \"Invalid verification code.\"}";
			}
		} else {
			return "{\"status\": 2, \"message\": \"There were errors in data sent. It was not possible to validate information provided.\"}";
		}
	}
}
