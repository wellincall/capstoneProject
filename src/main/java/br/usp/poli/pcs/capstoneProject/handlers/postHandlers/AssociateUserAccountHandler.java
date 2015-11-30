package br.usp.poli.pcs.capstoneProject.handlers.postHandlers;

import spark.Request;
import spark.Response;
import java.util.Map;
import br.usp.poli.pcs.capstoneProject.forms.Form;
import br.usp.poli.pcs.capstoneProject.forms.NewAccountAssociationForm;
import br.usp.poli.pcs.capstoneProject.database.services.BankAccountValidatorService;
import br.usp.poli.pcs.capstoneProject.database.services.AssociateAccountService;
import br.usp.poli.pcs.capstoneProject.dataHandler.IDataHandlerService;
import br.usp.poli.pcs.capstoneProject.dataHandler.AssociateBankAccountHandlerService;

public class AssociateUserAccountHandler extends DefaultPostHandler {
	
	private IDataHandlerService dataHandler;
	
	public AssociateUserAccountHandler(Request request, Response response) {
		super(request, response);
		dataHandler = new AssociateBankAccountHandlerService();
	}
	
	public String process() {
		Form form = new NewAccountAssociationForm();
		if (form.isValid(request)) {
			Map<String, Object> accountInformation = dataHandler.call(request);
			if ((new BankAccountValidatorService()).call(accountInformation)) {
				if ( (new AssociateAccountService()).call(accountInformation) != null) {
					return "{\"status\": 0, \"message\": \"Bank account was sucessfully associated to your profile\"}";
				} else {
					return "{\"status\": 1, \"message\": \"Bank account is already associated to your profile\"}";
				}
			} else {
				return "{\"status\": 3, \"message\": \"Information provided does not relate to any account\"}";
			}
		} else {
			return "{\"status\": 2, \"message\": \"Missing information or data provided is invalid\"}";
		}
	}
	
}
