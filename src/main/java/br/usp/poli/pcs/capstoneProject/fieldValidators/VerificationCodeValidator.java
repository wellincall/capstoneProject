package br.usp.poli.pcs.capstoneProject.fieldValidators;

public class VerificationCodeValidator implements IValidator {
	public boolean validates(String value) {
		return !value.isEmpty() && value.length() == 6;
	}
}
