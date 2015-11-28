package br.usp.poli.pcs.capstoneProject.handlers.postHandlers;

import spark.Request;
import spark.Response;

import br.usp.poli.pcs.capstoneProject.database.interfaces.CapstoneConnection;
import br.usp.poli.pcs.capstoneProject.database.interfaces.IUserBankAccount;
import br.usp.poli.pcs.capstoneProject.forms.Form;
import br.usp.poli.pcs.capstoneProject.forms.NewAccountAssociationForm;

public class AssociateUserAccountHandler extends DefaultPostHandler {
	
	public AssociateUserAccountHandler(Request request, Response response) {
		super(request, response);
	}
	
	public String process() {
		Form form = new NewAccountAssociationForm();
		if (form.isValid(request)) {
			return "{status: \"Need to improve it\"}";
		} else {
			return "{status: 2, message: \"Missing information or data provided is invalid\"}";
		}
	}
	
}
