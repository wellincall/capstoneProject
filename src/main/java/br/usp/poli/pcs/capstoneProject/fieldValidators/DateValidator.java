package br.usp.poli.pcs.capstoneProject.fieldValidators;

public class DateValidator implements IValidator {
	static String DATE_REGEX = "^[0-9]{2}/[0-9]{2}/[0-9]{4}$";
	public boolean validates(String value) {
		return value.matches(DATE_REGEX) && isValidDate(value);
	}
	
	private boolean isValidDate(String value) {
		return Integer.valueOf(value.substring(0, 2)) <= 31 && 
				Integer.valueOf(value.substring(3, 5)) <= 12;
	}
}
