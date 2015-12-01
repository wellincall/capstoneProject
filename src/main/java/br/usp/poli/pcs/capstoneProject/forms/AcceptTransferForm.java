package br.usp.poli.pcs.capstoneProject.forms;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import spark.Request;

import br.usp.poli.pcs.capstoneProject.database.services.GetUserAccountsService;
import br.usp.poli.pcs.capstoneProject.fieldValidators.UserBankAccountForeignKeyValidator;
import br.usp.poli.pcs.capstoneProject.forms.components.FormField;
import br.usp.poli.pcs.capstoneProject.forms.components.ForeignKeyField;
import br.usp.poli.pcs.capstoneProject.models.UserBankAccount;

public class AcceptTransferForm extends FormWithForeignKey {
	
	public AcceptTransferForm(int userId) {
		super();
		formFields.add(new ForeignKeyField("recipient-account-id", "Deposit amount in: ", new UserBankAccountForeignKeyValidator(), generateOptionsForBankAccount(userId)));
	}
	
	public boolean isValid(Request request) {
		boolean isValid = true;
		int userId = Integer.valueOf(String.valueOf(request.session().attribute("user-id")));
		for (FormField field : getFormFields()) {
			if (request.queryParams(field.getFormFieldId()) == null) {
				isValid = false;
			} else {
				UserBankAccountForeignKeyValidator validator = new UserBankAccountForeignKeyValidator();
				int accountId = Integer.valueOf(String.valueOf(request.queryParams(field.getFormFieldId())));
				isValid = validator.validates(accountId, userId);
			}
		}
		return isValid;
	}
	
	private Map<String, String> generateOptionsForBankAccount(int userId) {
		Map<String, String> options = new HashMap<String, String>();
		List<UserBankAccount> accounts = (new GetUserAccountsService()).call(userId);
		for (UserBankAccount account : accounts) {
			options.put(String.valueOf(account.getId()), account.getAccountToken());
		}
		return options;
	}
	
}
