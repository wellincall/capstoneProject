package br.usp.poli.pcs.capstoneProject.handlers.getHandlers;

import spark.Request;
import spark.Response;
import br.usp.poli.pcs.capstoneProject.forms.NewTransferIntentionForm;
import br.usp.poli.pcs.capstoneProject.forms.components.ForeignKeyField;
import java.util.Map;
import java.util.HashMap;

public class NewTransferDisplayHandler extends DefaultGetHandler {
	public NewTransferDisplayHandler(Request request, Response response) {
		super(request, response);
		filePath = "newTransferIntention.ftl";
	}
	
	public Map<String, Object> process() {
		Map<String, Object> objects = new HashMap<String, Object>();
		objects.put("formfields", (new NewTransferIntentionForm(request.session().attribute("user-id")).getFormFields()));
		objects.put("ForeignKeyField", ForeignKeyField.class);
		return objects;
	}
}
