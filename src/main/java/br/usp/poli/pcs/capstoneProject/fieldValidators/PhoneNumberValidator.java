package br.usp.poli.pcs.capstoneProject.fieldValidators;

public class PhoneNumberValidator implements IValidator {
	static String PHONE_NUMBER_REGEX = "^(\\+)(55)(\\()\\d{2}(\\))\\d{8,9}$";
	public boolean validates(String value) {
		return value.matches(PHONE_NUMBER_REGEX);
	}
}