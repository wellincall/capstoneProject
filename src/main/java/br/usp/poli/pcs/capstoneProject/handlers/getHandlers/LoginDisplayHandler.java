package br.usp.poli.pcs.capstoneProject.handlers.getHandlers;

import spark.Request;
import spark.Response;
import java.util.Map;
import java.util.HashMap;

import br.usp.poli.pcs.capstoneProject.forms.LoginForm;

public class LoginDisplayHandler extends DefaultGetHandler{
	
	public LoginDisplayHandler(Request request, Response response) {
		super(request, response);
		filePath = "loginPage.ftl";
	}
	
	public Map<String, Object> process() {
		Map<String, Object> form = new HashMap<String, Object>();
		form.put("formfields", (new LoginForm()).getFormFields());
		return form;
	}
}
