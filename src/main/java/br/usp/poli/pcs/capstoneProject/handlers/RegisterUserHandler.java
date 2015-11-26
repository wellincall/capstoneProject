package br.usp.poli.pcs.capstoneProject.handlers;

import spark.Request;
import spark.Response;

public class RegisterUserHandler extends DefaultPostHandler {
	public RegisterUserHandler(Request request, Response response) {
		super(request, response);
	}
	public String process() {
		return "{return: \"This should be returned\"}";
	}
}
