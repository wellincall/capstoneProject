package br.usp.poli.pcs.capstoneProject.handlers.getHandlers;

import spark.Request;
import spark.Response;
import java.util.Map;
import java.util.HashMap;
import br.usp.poli.pcs.capstoneProject.forms.ForeignKeyField;
import br.usp.poli.pcs.capstoneProject.forms.Form;
import br.usp.poli.pcs.capstoneProject.forms.NewBankAccountForm;
import br.usp.poli.pcs.capstoneProject.databaseInterface.CapstoneConnection;
import br.usp.poli.pcs.capstoneProject.databaseImplementation.BankDAO;
import java.util.List;
import br.usp.poli.pcs.capstoneProject.models.Bank;

public class NewBankAccountHandler extends DefaultGetHandler {
	public NewBankAccountHandler(Request request, Response response) {
		super(request, response);
		filePath = "newBankAccount.ftl";
	}
	
	protected Map<String,Object> process() {
		CapstoneConnection db = new CapstoneConnection();
		BankDAO dao = new BankDAO();
		List<Bank> banks = dao.getBanks(db.getConnection());
		Form bankForm = new NewBankAccountForm(banks);
		Map<String, Object> form = new HashMap<String, Object>();
		form.put("ForeignKeyField", ForeignKeyField.class);
		form.put("formfields", bankForm.getFormFields());
		return form;
	}
}
