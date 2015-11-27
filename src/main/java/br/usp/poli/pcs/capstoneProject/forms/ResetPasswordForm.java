package br.usp.poli.pcs.capstoneProject.forms;

import br.usp.poli.pcs.capstoneProject.forms.components.FormField;
import br.usp.poli.pcs.capstoneProject.fieldValidators.PasswordValidator;

public class ResetPasswordForm extends Form {
	public ResetPasswordForm() {
		super();
		formFields.add(new FormField("current-password", "Current Password", "password", new PasswordValidator()));
		formFields.add(new FormField("ńew-password", "New Password", "password", new PasswordValidator()));
		formFields.add(new FormField("password-confirmation", "Password Confirmation", "password", new PasswordValidator()));
	}
}
