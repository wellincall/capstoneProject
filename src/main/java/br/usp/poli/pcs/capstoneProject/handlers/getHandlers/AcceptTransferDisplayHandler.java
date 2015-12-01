package br.usp.poli.pcs.capstoneProject.handlers.getHandlers;

import spark.Request;
import spark.Response;
import br.usp.poli.pcs.capstoneProject.forms.AcceptTransferForm;

import java.util.Map;
import java.util.HashMap;

public class AcceptTransferDisplayHandler extends DefaultGetHandler {
	
	public AcceptTransferDisplayHandler(Request request, Response response) {
		super(request, response);
		filePath = "acceptTransfer.ftl";
	}
	
	public Map<String, Object> process() {
		Map<String, Object> objects = new HashMap<String, Object>();
		int userId = Integer.valueOf(String.valueOf(request.session().attribute("user-id")));
		objects.put("formfields", (new AcceptTransferForm(userId)).getFormFields());
		return objects;
	}
}
