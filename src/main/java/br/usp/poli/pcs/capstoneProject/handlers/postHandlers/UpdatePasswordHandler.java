package br.usp.poli.pcs.capstoneProject.handlers.postHandlers;

import spark.Request;
import spark.Response;
import br.usp.poli.pcs.capstoneProject.forms.Form;
import br.usp.poli.pcs.capstoneProject.forms.ResetPasswordForm;


public class UpdatePasswordHandler extends DefaultPostHandler {
	
	public UpdatePasswordHandler(Request request, Response response) {
		super(request, response);
	}

	public String process() {
		Form form = new ResetPasswordForm();
		if (form.isValid(request)) {
			return "{aehoo: true}";
		} else {
			return "{status: 2, message: \"Missing information or invalid data to update password\"}";
		}
	}

}
