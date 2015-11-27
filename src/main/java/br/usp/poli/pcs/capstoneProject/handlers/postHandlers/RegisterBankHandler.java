package br.usp.poli.pcs.capstoneProject.handlers.postHandlers;

import spark.Request;
import spark.Response;
import java.util.Map;

import br.usp.poli.pcs.capstoneProject.forms.Form;
import br.usp.poli.pcs.capstoneProject.forms.NewBankForm;
import br.usp.poli.pcs.capstoneProject.databaseInterface.CapstoneConnection;
import br.usp.poli.pcs.capstoneProject.dataHandler.IDataHandlerService;
import br.usp.poli.pcs.capstoneProject.databaseInterface.IBank;
import br.usp.poli.pcs.capstoneProject.models.Bank;
import br.usp.poli.pcs.capstoneProject.databaseImplementation.BankDAO;
import br.usp.poli.pcs.capstoneProject.dataHandler.RegisterBankDataHandlerService;

public class RegisterBankHandler extends DefaultPostHandler {
	public RegisterBankHandler(Request request, Response response) {
		super(request, response);
	}
	
	public String process() {
		Form form = new NewBankForm();
		if (form.isValid(request)) {
			persistBank();
			return "{Success: \"Check DB\"}";
		} else {
			return "{Error: \"MotherFucker\"}";
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
