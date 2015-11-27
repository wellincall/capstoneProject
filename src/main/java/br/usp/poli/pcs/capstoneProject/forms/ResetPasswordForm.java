package br.usp.poli.pcs.capstoneProject.forms;

import br.usp.poli.pcs.capstoneProject.forms.components.FormField;
import br.usp.poli.pcs.capstoneProject.fieldValidators.PasswordValidator;

public class ResetPasswordForm extends Form {
	public ResetPasswordForm() {
		super();
		formFields.add(new FormField("password", "Current Password", "password", new PasswordValidator()));
		formFields.add(new FormField("new-password", "New Password", "password", new PasswordValidator()));
		formFields.add(new FormField("password-confirmation", "Password Confirmation", "password", new PasswordValidator()));
	}
}
