package br.usp.poli.pcs.capstoneProject.handlers.getHandlers;

import spark.Request;
import spark.Response;

import java.util.Map;
import java.util.HashMap;

import br.usp.poli.pcs.capstoneProject.forms.ResetPasswordForm;

public class NewPasswordDisplayHandler extends DefaultGetHandler {
	public NewPasswordDisplayHandler(Request request, Response response) {
		super(request, response);
		filePath = "newPassword.ftl";
	}
	
	public Map<String, Object> process() {
		Map<String, Object> form = new HashMap<String, Object>();
		form.put("formfields", (new ResetPasswordForm()).getFormFields());
		return form;
	}
	
}
