package br.usp.poli.pcs.capstoneProject.forms;

import br.usp.poli.pcs.capstoneProject.forms.components.ForeignKeyField;
import br.usp.poli.pcs.capstoneProject.forms.components.FormField;
import br.usp.poli.pcs.capstoneProject.fieldValidators.UserForeignKeyValidator;
import br.usp.poli.pcs.capstoneProject.fieldValidators.UserBankAccountForeignKeyValidator;
import br.usp.poli.pcs.capstoneProject.fieldValidators.AmountValidator;
import br.usp.poli.pcs.capstoneProject.database.services.GetUserAccountsService;
import br.usp.poli.pcs.capstoneProject.database.services.GetUsersService;
import java.util.Map;
import java.util.HashMap;
import java.util.List;
import br.usp.poli.pcs.capstoneProject.models.User;
import br.usp.poli.pcs.capstoneProject.models.UserBankAccount;
import spark.Request;

public class NewTransferIntentionForm extends FormWithForeignKey {

	public NewTransferIntentionForm(int userId) {
		super();
		formFields.add(new ForeignKeyField("recipient-id", "Recipient", new UserForeignKeyValidator(), generateOptionsForUser()));
		formFields.add(new ForeignKeyField("sender-account-id", "Remove amount from", new UserBankAccountForeignKeyValidator(), generateOptionsForBankAccount(userId)));
		formFields.add(new FormField("amount", "Amount", "text", new AmountValidator()));
	}
	
	public boolean isValid(Request request) {
		boolean isValid = true;
		for (FormField formField : formFields) {
			if (formField instanceof ForeignKeyField && formField.getFormFieldId().equals("recipient-id")) {
				int foreignKeyValue = Integer.valueOf(request.queryParams(formField.getFormFieldId()));
				if (!((ForeignKeyField) formField).validates(foreignKeyValue)) {
					isValid = false;
				}
			} else if(formField instanceof ForeignKeyField && formField.getFormFieldId().equals("sender-account-id")) {
				int foreignKeyValue;
				if (request.queryParams(formField.getFormFieldId()) != null ) {
					foreignKeyValue = Integer.valueOf(request.queryParams(formField.getFormFieldId()));
				} else {
					foreignKeyValue = -1;
				}
				int userId = request.session().attribute("user-id");
				if (!(new UserBankAccountForeignKeyValidator()).validates(foreignKeyValue, userId)) {
					isValid = false;
				}
			} else {
				String paramInRequest = request.queryParams(formField.getFormFieldId());
				if (paramInRequest == null || !formField.validates(paramInRequest)) {
					isValid = false;
				}
			}
			
		}
		return isValid;
	}
	
	
	private Map<String, String> generateOptionsForUser() {
		Map<String, String> options = new HashMap<String, String>();
		List<User> users = (new GetUsersService()).call();
		for (User user : users) {
			options.put(String.valueOf(user.getId()), user.getPhoneNumber() +" "+ user.getName());
		}
		return options;
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
