package br.usp.poli.pcs.capstoneProject.forms;

import br.usp.poli.pcs.capstoneProject.forms.components.FormField;

public class DeleteBankAccountForm extends Form {
	public DeleteBankAccountForm() {
		super();
		formFields.add(new FormField("account-id", "", "hidden", null));
	}

}
