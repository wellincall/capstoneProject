package br.usp.poli.pcs.capstoneProject.forms;

import br.usp.poli.pcs.capstoneProject.forms.components.FormField;
import br.usp.poli.pcs.capstoneProject.fieldValidators.VerificationCodeValidator;

public class VerificationForm extends Form{
	public VerificationForm() {
		super();
		formFields.add(new FormField("verification-code", "Verification code", "text", new VerificationCodeValidator()));
	}
}
