package br.usp.poli.pcs.capstoneProject.handlers;

import java.util.Map;
import java.util.HashMap;
import spark.Request;
import spark.Response;
import br.usp.poli.pcs.capstoneProject.forms.NewBankForm;

public class NewBankHandler extends DefaultGetHandler {
	public NewBankHandler(Request request, Response response) {
		super(request, response);
		filePath = "newBank.ftl";
	}

	protected Map<String, Object> process() {
		Map<String, Object> form = new HashMap<String, Object>();
		form.put("formfields", (new NewBankForm()).getFormFields());
		return form;
	}

}
