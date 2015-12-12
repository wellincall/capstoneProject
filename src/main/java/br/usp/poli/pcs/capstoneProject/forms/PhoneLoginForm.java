package br.usp.poli.pcs.capstoneProject.forms;

import br.usp.poli.pcs.capstoneProject.fieldValidators.PasswordValidator;
import br.usp.poli.pcs.capstoneProject.fieldValidators.PhoneNumberValidator;
import br.usp.poli.pcs.capstoneProject.forms.components.FormField;

public class PhoneLoginForm extends Form {
	public PhoneLoginForm() {
		super();
		formFields.add(new FormField("phone-number", "Phone Number", "text", new PhoneNumberValidator()));
		formFields.add(new FormField("password", "Password", "password", new PasswordValidator()));
	}
	
}
