package br.usp.poli.pcs.capstoneProject.fieldValidators;

public class PasswordValidator implements IValidator{
	public boolean validates(String value) {
		return value.length() >= 4;
	}
}
