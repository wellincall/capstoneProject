package br.usp.poli.pcs.capstoneProject.handlers.getHandlers;

import spark.Request;
import spark.Response;

import java.util.Map;
import java.util.HashMap;

import br.usp.poli.pcs.capstoneProject.forms.VerificationForm;

public class VerifyAccountDisplayHandler extends DefaultGetHandler {
	
	public VerifyAccountDisplayHandler(Request request, Response response) {
		super(request, response);
		filePath = "verifyAccount.ftl";
	}
	
	public Map<String, Object> process() {
		Map<String, Object> form = new HashMap<String, Object>();
		form.put("formfields", (new VerificationForm()).getFormFields());
		return form;
	}
}
