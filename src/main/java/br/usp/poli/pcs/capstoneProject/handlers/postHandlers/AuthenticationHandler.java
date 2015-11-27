package br.usp.poli.pcs.capstoneProject.handlers.postHandlers;

import br.usp.poli.pcs.capstoneProject.forms.Form;
import br.usp.poli.pcs.capstoneProject.forms.LoginForm;
import br.usp.poli.pcs.capstoneProject.database.services.AuthenticationService;
import br.usp.poli.pcs.capstoneProject.database.services.GetUserService;
import br.usp.poli.pcs.capstoneProject.models.User;


import spark.Request;
import spark.Response;

import java.util.Map;
import java.util.HashMap;


public class AuthenticationHandler extends DefaultPostHandler {
	public AuthenticationHandler(Request request, Response response) {
		super(request, response);
	}
	
	public String process() {
		Form form = new LoginForm();
		if (form.isValid(request)) {
			if ((new AuthenticationService()).call(request)) {
				request.session(true);
				User user = (new GetUserService()).call(getUserFields());
				request.session().attribute("user-id", user.getId());
				return "{Status: \"User authenticated\"}";
			} else {
				return "{Status: \"Invalid credentials\"}";

			}
		} else {
			return "{Status: \"Missing information to try authenticating\"}";
		}
	}
	
	private Map<String, Object> getUserFields() {
		Map<String, Object> userInformation = new HashMap<String, Object>();
		userInformation.put("email", request.queryParams("email"));
		userInformation.put("phone-number", request.queryParams("phone-number"));
		return userInformation;
	}

}
