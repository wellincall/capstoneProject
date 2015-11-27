package br.usp.poli.pcs.capstoneProject.forms;

import br.usp.poli.pcs.capstoneProject.forms.components.FormField;
import br.usp.poli.pcs.capstoneProject.fieldValidators.EmailValidator;
import br.usp.poli.pcs.capstoneProject.fieldValidators.PasswordValidator;

public class LoginForm extends Form	{
	public LoginForm() {
		super();
		formFields.add(new FormField("email", "E-mail", "email", new EmailValidator()));
		formFields.add(new FormField("password", "Password", "password", new PasswordValidator()));
	}
}
