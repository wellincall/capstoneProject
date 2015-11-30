package br.usp.poli.pcs.capstoneProject.handlers.postHandlers;

import spark.Response;
import spark.Request;

import java.util.Map;

import br.usp.poli.pcs.capstoneProject.dataHandler.IDataHandlerService;
import br.usp.poli.pcs.capstoneProject.dataHandler.RegisterBankAccountHandlerService;
import br.usp.poli.pcs.capstoneProject.database.implementations.BankAccountDAO;
import br.usp.poli.pcs.capstoneProject.database.interfaces.CapstoneConnection;
import br.usp.poli.pcs.capstoneProject.database.interfaces.IBankAccount;
import br.usp.poli.pcs.capstoneProject.database.services.GetBanksService;
import br.usp.poli.pcs.capstoneProject.forms.Form;
import br.usp.poli.pcs.capstoneProject.forms.NewBankAccountForm;
import br.usp.poli.pcs.capstoneProject.models.BankAccount;

public class RegisterBankAccountHandler extends DefaultPostHandler {
	public RegisterBankAccountHandler(Request request, Response response) {
		super(request, response);
	}
	
	public String process() {
		Form form = new NewBankAccountForm((new GetBanksService()).call());
		if (form.isValid(request)) {
			BankAccount account = persistBankAccount();
			if (account != null) {
				return "{\"status\": 0, \"message\": \"Bank account successfully registered\" }";
			} else {
				return "{\"status\": 1, \"message\":  \"Account already registered. Please confirm provided data and try again.\"}";
			}
		} else {
			return "{\"status\": 2, \"message\": \"Missing information or invalid information when trying to register bank account\"}";
		}
	}
	private BankAccount persistBankAccount() {
		CapstoneConnection db = new CapstoneConnection();
		IDataHandlerService dataHandler = new RegisterBankAccountHandlerService();
		Map<String, Object> accountInformation = dataHandler.call(request);
		IBankAccount dao = new BankAccountDAO();
		return dao.createBankAccount(db.getConnection(), accountInformation);
	}
}
