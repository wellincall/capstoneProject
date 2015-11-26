package br.usp.poli.pcs.capstoneProject.handlers;

import java.util.Map;
import java.util.HashMap;
import spark.Request;
import spark.Response;
import br.usp.poli.pcs.capstoneProject.forms.NewUserForm;

public class NewUserHandler extends DefaultGetHandler {
	
	public NewUserHandler(Request request, Response response) {
		super(request, response);
		filePath = "newUser.ftl";
	}
	
	protected Map<String, Object> process() {
		Map<String, Object> attributes = new HashMap<String, Object>();
		attributes.put("formfields", (new NewUserForm()).getFormFields());
		return attributes;
	}
	
}
