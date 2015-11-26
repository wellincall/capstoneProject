package br.usp.poli.pcs.capstoneProject.fieldValidators;

public class TextFieldValidator implements IValidator {
	public boolean validates(String value) {
		return !value.isEmpty() && value.length() > 3;
	}
}
