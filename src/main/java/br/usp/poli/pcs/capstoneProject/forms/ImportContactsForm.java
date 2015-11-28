package br.usp.poli.pcs.capstoneProject.forms;

import br.usp.poli.pcs.capstoneProject.fieldValidators.PhoneNumberValidator;
import br.usp.poli.pcs.capstoneProject.forms.components.FormField;

public class ImportContactsForm extends Form {
	public ImportContactsForm() {
		super();
		formFields.add(new FormField("phone-number", "Phone Number", "text", new PhoneNumberValidator()));
	}
}
