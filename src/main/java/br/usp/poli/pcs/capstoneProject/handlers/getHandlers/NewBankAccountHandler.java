package br.usp.poli.pcs.capstoneProject.handlers.getHandlers;

import spark.Request;
import spark.Response;
import java.util.Map;
import java.util.HashMap;
import br.usp.poli.pcs.capstoneProject.forms.ForeignKeyField;
import br.usp.poli.pcs.capstoneProject.forms.Form;
import br.usp.poli.pcs.capstoneProject.forms.NewBankAccountForm;
import br.usp.poli.pcs.capstoneProject.database.implementations.BankDAO;
import br.usp.poli.pcs.capstoneProject.database.interfaces.CapstoneConnection;
import br.usp.poli.pcs.capstoneProject.database.services.GetBanksService;

import java.util.List;
import br.usp.poli.pcs.capstoneProject.models.Bank;

public class NewBankAccountHandler extends DefaultGetHandler {
	public NewBankAccountHandler(Request request, Response response) {
		super(request, response);
		filePath = "newBankAccount.ftl";
	}
	
	protected Map<String,Object> process() {
		Form bankForm = new NewBankAccountForm((new GetBanksService()).call());
		Map<String, Object> form = new HashMap<String, Object>();
		form.put("ForeignKeyField", ForeignKeyField.class);
		form.put("formfields", bankForm.getFormFields());
		return form;
	}
}
