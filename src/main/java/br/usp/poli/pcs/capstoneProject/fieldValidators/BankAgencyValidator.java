package br.usp.poli.pcs.capstoneProject.fieldValidators;

public class BankAgencyValidator implements IValidator{
	public boolean validates(String value) {
		return !value.isEmpty() && value.length() <= 6;
	}
}
