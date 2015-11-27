package br.usp.poli.pcs.capstoneProject.forms;

import br.usp.poli.pcs.capstoneProject.fieldValidators.*;
import br.usp.poli.pcs.capstoneProject.forms.components.FormField;

public class NewUserForm extends Form {
	public NewUserForm() {
		super();
		formFields.add(new FormField("name", "Name", "text", new TextFieldValidator()));
		formFields.add(new FormField("phone-number", "Phone Number", "text", new PhoneNumberValidator()));
		formFields.add(new FormField("cpf", "CPF", "text", new CPFValidator()));
		formFields.add(new FormField("email", "E-mail", "email", new EmailValidator()));
		formFields.add(new FormField("birthday-date", "Birthday Date", "text", new DateValidator()));
		formFields.add(new FormField("password", "Password", "password", new PasswordValidator()));
	}
}
