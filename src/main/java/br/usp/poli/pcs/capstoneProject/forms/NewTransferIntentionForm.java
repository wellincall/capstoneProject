package br.usp.poli.pcs.capstoneProject.forms;

import br.usp.poli.pcs.capstoneProject.forms.components.ForeignKeyField;
import br.usp.poli.pcs.capstoneProject.fieldValidators.UserForeignKeyValidator;
import br.usp.poli.pcs.capstoneProject.fieldValidators.UserBankAccountForeignKeyValidator;
import br.usp.poli.pcs.capstoneProject.database.services.GetUserAccountsService;
import java.util.Map;
import java.util.HashMap;

public class NewTransferIntentionForm extends FormWithForeignKey {

	public NewTransferIntentionForm(int userId) {
		super();
		formFields.add(new ForeignKeyField("recipient-id", "Recipient", new UserForeignKeyValidator(), generateOptionsForUser()));
	}
	
	
	private Map<String, String> generateOptionsForUser() {
		return null;
	}
}
