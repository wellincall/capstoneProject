package br.usp.poli.pcs.capstoneProject.fieldValidators;

public class EmailValidator implements IValidator{
	static String EMAIL_REGEX = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
	public boolean validates(String value) {
		return value.matches(EMAIL_REGEX);
	}
}
