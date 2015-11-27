package br.usp.poli.pcs.capstoneProject.handlers.postHandlers;

import spark.Request;
import spark.Response;
import java.util.Map;

import br.usp.poli.pcs.capstoneProject.forms.Form;
import br.usp.poli.pcs.capstoneProject.forms.NewBankForm;
import br.usp.poli.pcs.capstoneProject.dataHandler.IDataHandlerService;
import br.usp.poli.pcs.capstoneProject.models.Bank;
import br.usp.poli.pcs.capstoneProject.dataHandler.RegisterBankDataHandlerService;
import br.usp.poli.pcs.capstoneProject.database.implementations.BankDAO;
import br.usp.poli.pcs.capstoneProject.database.interfaces.CapstoneConnection;
import br.usp.poli.pcs.capstoneProject.database.interfaces.IBank;

public class RegisterBankHandler extends DefaultPostHandler {
	public RegisterBankHandler(Request request, Response response) {
		super(request, response);
	}
	
	public String process() {
		Form form = new NewBankForm();
		if (form.isValid(request)) {
			Bank bank = persistBank();
			if (bank != null) {
				return "{status: 0, message: \"Bank sucessfully registered\"}";
			} else {
				return "{status: 1, message: \"Bank already registered\"}";
			}
		} else {
			return "{status: 2, message: \"Missing information or invalid data when trying to register bank\"}";
		}
	}
	
	private Bank persistBank() {
		CapstoneConnection db = new CapstoneConnection();
		IDataHandlerService dataHandler = new RegisterBankDataHandlerService();
		Map<String, Object> bankInformation = dataHandler.call(request);
		IBank dao = new BankDAO();
		return dao.createBank(db.getConnection(), bankInformation);
	}

}
