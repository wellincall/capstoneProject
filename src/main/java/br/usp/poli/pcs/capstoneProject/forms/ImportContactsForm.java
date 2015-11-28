package br.usp.poli.pcs.capstoneProject.forms;

import spark.Request;
import br.usp.poli.pcs.capstoneProject.fieldValidators.PhoneNumberValidator;
import br.usp.poli.pcs.capstoneProject.forms.components.FormField;

public class ImportContactsForm extends Form {
	public ImportContactsForm() {
		super();
		formFields.add(new FormField("phone-number[]", "Phone Number", "text", new PhoneNumberValidator()));
	}
	
	public boolean isValid(Request request) {
		boolean isValid = true;
		System.out.println(request.queryParamsValues("phone-number"));
		return isValid;
	}
}
