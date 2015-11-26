package br.usp.poli.pcs.capstoneProject.handlers;

import spark.Request;
import spark.Response;

import br.usp.poli.pcs.capstoneProject.forms.NewUserForm;

public class RegisterUserHandler extends DefaultPostHandler {
	public RegisterUserHandler(Request request, Response response) {
		super(request, response);
	}
	public String process() {
		NewUserForm form = new NewUserForm();
		return form.isValid(request) ? "{form: \"valid\"}" : "{form: \"invalid\"}";
	}
}
