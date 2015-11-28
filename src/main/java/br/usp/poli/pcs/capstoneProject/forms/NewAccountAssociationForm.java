package br.usp.poli.pcs.capstoneProject.forms;

import br.usp.poli.pcs.capstoneProject.forms.components.FormField;
import br.usp.poli.pcs.capstoneProject.forms.components.ForeignKeyField;
import br.usp.poli.pcs.capstoneProject.fieldValidators.BankForeignKeyValidator;
import br.usp.poli.pcs.capstoneProject.fieldValidators.BankAgencyValidator;
import br.usp.poli.pcs.capstoneProject.fieldValidators.BankAccountNumberValidator;
import br.usp.poli.pcs.capstoneProject.database.services.GetBanksService;

public class NewAccountAssociationForm extends NewBankAccountForm {
	public NewAccountAssociationForm() {
		super();
		formFields.add(new ForeignKeyField("bank-id", "Bank", new BankForeignKeyValidator(), generateOptions((new GetBanksService()).call())));
		formFields.add(new FormField("agency-number", "Agency Number", "text", new BankAgencyValidator()));
		formFields.add(new FormField("account-number", "Account Number", "text", new BankAccountNumberValidator()));
	}
}
