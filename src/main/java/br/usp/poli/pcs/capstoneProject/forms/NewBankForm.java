package br.usp.poli.pcs.capstoneProject.forms;

import br.usp.poli.pcs.capstoneProject.fieldValidators.TextFieldValidator;

public class NewBankForm extends Form{
	public NewBankForm() {
		super();
		formFields.add(new FormField("name", "Name", "text", new TextFieldValidator()));
	}
}
