package br.usp.poli.pcs.capstoneProject.forms;

import spark.Request;
import br.usp.poli.pcs.capstoneProject.fieldValidators.PhoneNumberValidator;
import br.usp.poli.pcs.capstoneProject.forms.components.FormField;
import br.usp.poli.pcs.capstoneProject.fieldValidators.IValidator;

public class ImportContactsForm extends Form {
	
	private IValidator validator;
	
	public ImportContactsForm() {
		super();
		formFields.add(new FormField("phone-number[]", "Phone Number", "text", new PhoneNumberValidator()));
		validator = new PhoneNumberValidator();
	}
	
	public boolean isValid(Request request) {
		return true;
	}
}
