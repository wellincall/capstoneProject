package br.usp.poli.pcs.capstoneProject.handlers.postHandlers;

import br.usp.poli.pcs.capstoneProject.forms.Form;
import br.usp.poli.pcs.capstoneProject.forms.LoginForm;

import spark.Request;
import spark.Response;

public class AuthenticationHandler extends DefaultPostHandler {
	public AuthenticationHandler(Request request, Response response) {
		super(request, response);
	}
	
	public String process() {
		Form form = new LoginForm();
		if (form.isValid(request)) {
			return "{Must: \"authenticate\"}";
		} else {
			return "{Error: \"MotherFucker\"}";
		}
	}

}
