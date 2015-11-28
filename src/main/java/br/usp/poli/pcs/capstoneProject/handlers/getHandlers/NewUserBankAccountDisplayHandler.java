package br.usp.poli.pcs.capstoneProject.handlers.getHandlers;

import spark.Request;
import spark.Response;
import java.util.Map;
import java.util.HashMap;
import br.usp.poli.pcs.capstoneProject.forms.NewAccountAssociationForm;
import br.usp.poli.pcs.capstoneProject.forms.components.ForeignKeyField;

public class NewUserBankAccountDisplayHandler extends DefaultGetHandler {
	
	public NewUserBankAccountDisplayHandler(Request request, Response response) {
		super(request, response);
		filePath = "newUserBankAccount.ftl";
	}
	
	public Map<String, Object> process() {
		Map<String, Object> form = new HashMap<String, Object>();
		form.put("formfields", (new NewAccountAssociationForm()).getFormFields());
		form.put("ForeignKeyField", ForeignKeyField.class);
		return form;
	}
		
}
