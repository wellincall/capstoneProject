package br.usp.poli.pcs.capstoneProject.handlers.postHandlers;

import spark.Response;
import spark.Request;

import java.util.Map;

import br.usp.poli.pcs.capstoneProject.dataHandler.IDataHandlerService;
import br.usp.poli.pcs.capstoneProject.dataHandler.RegisterBankAccountHandlerService;
import br.usp.poli.pcs.capstoneProject.databaseImplementation.BankAccountDAO;
import br.usp.poli.pcs.capstoneProject.databaseInterface.CapstoneConnection;
import br.usp.poli.pcs.capstoneProject.databaseInterface.IBankAccount;
import br.usp.poli.pcs.capstoneProject.forms.Form;
import br.usp.poli.pcs.capstoneProject.forms.NewBankAccountForm;
import br.usp.poli.pcs.capstoneProject.helpers.GetBanksService;
import br.usp.poli.pcs.capstoneProject.models.BankAccount;

public class RegisterBankAccountHandler extends DefaultPostHandler {
	public RegisterBankAccountHandler(Request request, Response response) {
		super(request, response);
	}
	
	public String process() {
		Form form = new NewBankAccountForm((new GetBanksService()).call());
		if (form.isValid(request)) {
			persistBankAccount();
			return "{Success: \"Check dB\" }";
		} else {
			return "{Error: \"Motherfocker\"}";
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
