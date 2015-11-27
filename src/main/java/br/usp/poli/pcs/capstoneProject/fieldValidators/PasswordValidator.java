package br.usp.poli.pcs.capstoneProject.fieldValidators;

public class PasswordValidator implements IValidator{
	private static String PASSWORD_REGEX = "^\\d{4,}$";
	public boolean validates(String value) {
		return value.length() >= 4 && value.matches(PASSWORD_REGEX);
	}
}
